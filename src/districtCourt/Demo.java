package districtCourt;

import java.io.IOException;

public class Demo {

    public static void main(String[] args) throws IOException {


        Lawyer ivan = new Lawyer("Ivan");
        Lawyer pesho = new Lawyer("Pesho");
        Lawyer gosho = new Lawyer("Gosho");
        Lawyer lenche = new Lawyer("Lenche");
        Lawyer vanche = new Lawyer("Vanche");

        Judge nehodim = new Judge("Nehodim");
        Judge stoimen = new Judge("Stoimen");
        Judge unufri = new Judge("Unufri");

        Prosecutor pancho = new Prosecutor("Pancho");
        Prosecutor venko = new Prosecutor("Venco");

        Juryman joro = new Juryman("Joro");
        Juryman mitko = new Juryman("mitko");
        Juryman petq = new Juryman("Petq");
        Juryman mimi = new Juryman("Mimi");
        Juryman fifi = new Juryman("Fifi");
        Juryman kuku = new Juryman("Kuku");
        Juryman pipi = new Juryman("Pipi");
        Juryman shushi = new Juryman("Shushi");
        Juryman lala = new Juryman("Lala");
        Juryman mara = new Juryman("Mara");

        Accuser asen = new Accuser("Asen");
        Accuser stanimir = new Accuser("Stanimir");
        Accuser ilian = new Accuser("Ilian");
        Accuser tania = new Accuser("Tania");
        Accuser kremena = new Accuser("Kremena");

        Defendant dara = new Defendant("Dara");
        Defendant miro = new Defendant("Miro");
        Defendant vladi = new Defendant("Vladi");
        Defendant boris = new Defendant("Boris");
        Defendant poli = new Defendant("Poli");

        Witness silvi = new Witness("Silvi");
        Witness sonia = new Witness("Sonia");
        Witness anji = new Witness("Anji");
        Witness qvka = new Witness("Qvka");
        Witness vanka = new Witness("Vanka");
        Witness petar = new Witness("Petar");
        Witness katia = new Witness("Katia");
        Witness maia = new Witness("Maia");
        Witness mira = new Witness("Mira");
        Witness staiko = new Witness("Staiko");

        System.out.println(DistrictCourt.getVelikoTarnovoInstance().getName());
        CivilCase civilCase = new CivilCase();
        CriminalCase criminalCase = new CriminalCase();
        DistrictCourt.getVelikoTarnovoInstance().addCase(civilCase);
        DistrictCourt.getVelikoTarnovoInstance().addCase(criminalCase);

        civilCase.conduct();
        criminalCase.conduct();

    }
}
