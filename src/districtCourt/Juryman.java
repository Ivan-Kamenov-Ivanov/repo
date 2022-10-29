package districtCourt;

import java.util.ArrayList;

public class Juryman extends LegalEntities {

    Juryman(String name) {
        super(name);
        DistrictCourt.legalEntitiesList.computeIfAbsent(DistrictCourt.Position.JURYMAN, k -> new ArrayList<>());
        this.addToList();
    }

    @Override
    protected void addToList() {
        DistrictCourt.legalEntitiesList.get(DistrictCourt.Position.JURYMAN).add(this);
    }
}
