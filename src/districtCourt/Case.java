package districtCourt;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Case {
    Judge judge;
    Accuser accuser;
    Prosecutor prosecutor;
    Defendant defendant;
    List<Juryman> jurymen = new ArrayList<>();
    List<Witness> witnesses = new ArrayList<>();
    static int counter = 1;

    static Object getRandomObj(List list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    static int getRandomInt(int[] ints) {
        int random = new Random().nextInt(ints.length);
        return ints[random];
    }

    void nominateJudge() {
        judge = (Judge) Case.getRandomObj(DistrictCourt.legalEntitiesList.get(DistrictCourt.Position.JUDGE));
    }

    void nominateDefendant() {
        defendant = (Defendant) Case.getRandomObj(Citizen.citizens.get(Citizen.Role.DEFENDANT));
    }

    void addWitness() {
        witnesses.add((Witness) Case.getRandomObj(Citizen.citizens.get(Citizen.Role.WITNESS)));
    }

    String makeDecision() {
        int[] ints = {-1, 1};
        int count = 0;
        for (Juryman j : jurymen) {
            count = count + Case.getRandomInt(ints);
        }
        String decision;
        if (count > 0) {
            decision = "Not guilty!";
        } else if (count < 0) {
            decision = "Guilty!";
        } else {
            decision = "No decision!";
        }
        return decision;
    }

    static int judgment() {
        int[] ints = {3, 4, 5, 6, 7, 8, 9, 10};
        return getRandomInt(ints);
    }

    abstract void nominateLawyers();

    abstract void nominateJuryman();

    abstract String proceedQuestions();

    abstract void addCaseToAllLegalEntities();

    abstract void writeChronologyOnFile() throws IOException;

    abstract void conduct() throws IOException;
}
