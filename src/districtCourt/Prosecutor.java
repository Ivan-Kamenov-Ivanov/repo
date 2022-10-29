package districtCourt;

import java.util.ArrayList;

public class Prosecutor extends LegalEntities {

    private static final int minExperience = 10;

    Prosecutor(String name) {
        super(name);
        experience = minExperience;
        DistrictCourt.legalEntitiesList.computeIfAbsent(DistrictCourt.Position.PROSECUTOR, k -> new ArrayList<>());
        this.addToList();
    }

    @Override
    protected void addToList() {
        DistrictCourt.legalEntitiesList.get(DistrictCourt.Position.PROSECUTOR).add(this);
    }
}
