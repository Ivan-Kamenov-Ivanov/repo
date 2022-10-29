package districtCourt;

import java.util.ArrayList;

public class Judge extends LegalEntities {

    private static final int minExperience = 5; //years

    Judge(String name) {
        super(name);
        experience = minExperience;
        DistrictCourt.legalEntitiesList.computeIfAbsent(DistrictCourt.Position.JUDGE, k -> new ArrayList<>());
        this.addToList();
    }

    @Override
    protected void addToList() {
        DistrictCourt.legalEntitiesList.get(DistrictCourt.Position.JUDGE).add(this);
    }
}
