package districtCourt;

import java.util.ArrayList;
import java.util.List;

public class Accuser extends Citizen {

    private List<Lawyer> lawyers = new ArrayList<>();

    Accuser(String name) {
        super(name);
        Citizen.citizens.computeIfAbsent(Role.ACCUSER, k -> new ArrayList<>());
        this.addToList();
    }

    @Override
    void addToList() {
        Citizen.citizens.get(Role.ACCUSER).add(this);
    }

    @Override
    void addLawyer(Lawyer lawyer) {
        lawyers.add(lawyer);
    }

    List<Lawyer> getLawyers() {
        return lawyers;
    }
}
