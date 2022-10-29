package districtCourt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Citizen {
    private String name;
    private String address;
    private int age;

    public Citizen(String name) {
        this.name = name;
    }

    enum Role {ACCUSER, DEFENDANT, WITNESS}

    static Map<Role, ArrayList<Citizen>> citizens = new HashMap<>();

    abstract void addToList();

    void addLawyer(Lawyer lawyer) {
    }

    public String getName() {
        return name;
    }
}
