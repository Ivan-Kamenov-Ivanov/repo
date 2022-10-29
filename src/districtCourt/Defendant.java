package districtCourt;

import java.util.ArrayList;
import java.util.List;

public class Defendant extends Citizen {

    private List<Lawyer> lawyers;

    Defendant(String name) {
        super(name);
        lawyers = new ArrayList<>();
        Citizen.citizens.computeIfAbsent(Role.DEFENDANT, k -> new ArrayList<>());
        this.addToList();
    }

    @Override
    void addToList() {
        Citizen.citizens.get(Role.DEFENDANT).add(this);
    }

    @Override
    void addLawyer(Lawyer lawyer) {
        lawyers.add(lawyer);
    }

    public List<Lawyer> getLawyers() {
        return lawyers;
    }
}
