package districtCourt;

import java.util.ArrayList;

public class Lawyer extends LegalEntities {

    private static final int minCaseQuantity = 10;

    Lawyer(String name) {
        super(name);
        caseQuantity = minCaseQuantity;
        DistrictCourt.legalEntitiesList.computeIfAbsent(DistrictCourt.Position.LAWYER, k -> new ArrayList<>());
        this.addToList();
    }

    @Override
    protected void addToList() {
        DistrictCourt.legalEntitiesList.get(DistrictCourt.Position.LAWYER).add(this);
    }
}
