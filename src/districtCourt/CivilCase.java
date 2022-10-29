package districtCourt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CivilCase extends Case {

    void nominateAccuser() {
        accuser = (Accuser) Case.getRandomObj(Citizen.citizens.get(Citizen.Role.ACCUSER));
    }

    void nominateLawyers() {
        Lawyer accLawyer = (Lawyer) Case.getRandomObj(DistrictCourt.legalEntitiesList.get(DistrictCourt.Position.LAWYER));
        Lawyer defLawyer = (Lawyer) Case.getRandomObj(DistrictCourt.legalEntitiesList.get(DistrictCourt.Position.LAWYER));
        accuser.addLawyer(accLawyer);
        defendant.addLawyer(defLawyer);
    }

    @Override
    void nominateJuryman() {
        for (int i = 0; i < 3; i++) {
            jurymen.add((Juryman) Case.getRandomObj(DistrictCourt.legalEntitiesList.get(DistrictCourt.Position.JURYMAN)));
        }
    }

    @Override
    String proceedQuestions() {
        String questions = "";
        for (Lawyer l : accuser.getLawyers()) {
            for (int i = 0; i < 3; i++) {
                questions += "Lawyer " + l.askQuestion(defendant).concat("\n");
            }
        }
        for (Lawyer l : accuser.getLawyers()) {
            for (Witness w : witnesses) {
                for (int i = 0; i < 2; i++) {
                    questions += "Lawyer " + l.askQuestion(w).concat("\n");
                }
            }
        }
        return questions;
    }

    @Override
    void addCaseToAllLegalEntities() {
        judge.addCaseToQuantity();
        for (Lawyer dL : defendant.getLawyers()) {
            dL.addCaseToQuantity();
        }
        for (Lawyer aL : accuser.getLawyers()) {
            aL.addCaseToQuantity();
        }
        for (Juryman j : jurymen) {
            j.addCaseToQuantity();
        }
    }

    @Override
    void writeChronologyOnFile() throws IOException {
        String pathname = "Case" + counter + "chronology.txt";
        counter++;
        File chronology = new File(pathname);
        if (!chronology.exists()) {
            try {
                chronology.createNewFile();
            } catch (IOException e) {
                System.out.println("File not found!");
            }
        }
        FileWriter writer = new FileWriter(chronology);

        writer.write("Accuser: " + accuser.getName() + "\n");
        writer.write("Defendant: " + defendant.getName() + "\n\n");
        writer.write("Legal entities: \n");
        writer.write("Judge " + judge.getName() + "\n");
        for (Lawyer l : accuser.getLawyers()) {
            writer.write("Accuser's lawyer " + l.getName() + "\n");
        }
        for (Lawyer l : defendant.getLawyers()) {
            writer.write("Defendant's lawyer " + l.getName() + "\n\n");
        }
        for (Juryman j : jurymen) {
            writer.write("Juryman " + j.getName() + "\n");
        }
        writer.write("\n");
        writer.write(proceedQuestions());

        String decision = makeDecision();
        writer.write("Decision: " + decision + "\n");
        int judgment = judgment();
        if (decision.equals("Guilty!")) {
            writer.write(judgment + " years in jail.");
        }
        writer.close();
    }

    void conduct() throws IOException {

        nominateAccuser();
        nominateDefendant();
        addWitness();
        nominateLawyers();
        nominateJudge();
        nominateJuryman();
        addCaseToAllLegalEntities();

        writeChronologyOnFile();
    }
}
