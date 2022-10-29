package districtCourt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CriminalCase extends Case {

    @Override
    String proceedQuestions() {
        String questions = "";
        for (int i = 0; i < 5; i++) {
            questions += "Prosecutor " + prosecutor.askQuestion(defendant).concat("\n");
        }
        for (Witness w : witnesses) {
            for (int i = 0; i < 5; i++) {
                questions += "Prosecutor " + prosecutor.askQuestion(w).concat("\n");
            }
        }
        return questions;
    }

    void nominateProsecutor() {
        prosecutor = (Prosecutor) Case.getRandomObj(DistrictCourt.legalEntitiesList.get(DistrictCourt.Position.PROSECUTOR));
    }

    @Override
    void nominateLawyers() {
        Lawyer defLawyer = (Lawyer) Case.getRandomObj(DistrictCourt.legalEntitiesList.get(DistrictCourt.Position.LAWYER));
        defendant.addLawyer(defLawyer);
    }

    @Override
    void nominateJuryman() {
        for (int i = 0; i < 10; i++) {
            jurymen.add((Juryman) Case.getRandomObj(DistrictCourt.legalEntitiesList.get(DistrictCourt.Position.JURYMAN)));
        }
    }

    @Override
    void addCaseToAllLegalEntities() {
        judge.addCaseToQuantity();
        for (Lawyer dL : defendant.getLawyers()) {
            dL.addCaseToQuantity();
        }
        prosecutor.addCaseToQuantity();

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

        writer.write("Prosecutor: " + prosecutor.getName() + "\n");
        writer.write("Defendant: " + defendant.getName() + "\n\n");
        writer.write("Legal entities: \n");
        writer.write("Judge " + judge.getName() + "\n");

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

    @Override
    void conduct() throws IOException {

        nominateProsecutor();
        nominateDefendant();
        nominateLawyers();
        addWitness();
        nominateJudge();
        nominateJuryman();
        addCaseToAllLegalEntities();

        writeChronologyOnFile();
    }
}
