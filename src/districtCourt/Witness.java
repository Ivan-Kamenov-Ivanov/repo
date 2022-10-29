package districtCourt;

import java.util.ArrayList;

public class Witness extends Citizen {

    Witness(String name) {
        super(name);

        Citizen.citizens.computeIfAbsent(Role.WITNESS, k -> new ArrayList<>());
        this.addToList();
    }

    @Override
    void addToList() {
        Citizen.citizens.get(Role.WITNESS).add(this);
    }
}
