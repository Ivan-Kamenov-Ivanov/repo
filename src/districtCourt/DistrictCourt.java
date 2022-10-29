package districtCourt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistrictCourt {

    private static DistrictCourt velikoTarnovo = new DistrictCourt();
    private static final String name = "VELIKO_TARNOVO";

    String address;

    enum Position {LAWYER, JUDGE, PROSECUTOR, JURYMAN;}

    static Map<Position, ArrayList<LegalEntities>> legalEntitiesList = new HashMap<>();
    List<Case> casesList = new ArrayList<>();

    public void addCase(Case newCase) {
        if (!casesList.contains(newCase)) {
            casesList.add(newCase);
        }
    }

    public Map<Position, ArrayList<LegalEntities>> getLegalEntitiesList() {
        return legalEntitiesList;
    }

    public static DistrictCourt getVelikoTarnovoInstance() {
        return velikoTarnovo;
    }

    public String getName() {
        return name;
    }
}
