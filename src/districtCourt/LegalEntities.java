package districtCourt;

public abstract class LegalEntities {
    private String name;
    protected int experience;
    protected int caseQuantity;

    LegalEntities(String name) {
        this.name = name;
    }

    public String askQuestion(Citizen citizen) {
        return this.getName() + " asked а question to " + citizen.getName();
    }

    public void writeAnswer() {
    }

    public int getCaseQuantity() {
        return caseQuantity;
    }

    public void addCaseToQuantity() {
        caseQuantity++;
    }

    public String getName() {
        return name;
    }

    protected abstract void addToList();
}
