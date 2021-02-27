import chainages.Chainage_avant;
import classes.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // here we check chainage avant
        Initialisation init = new Initialisation(9,2,"regles.txt");

        /*init.start();

        */

        init.start1();
        Chainage_avant chainage_avant = new Chainage_avant(init,"h");
        chainage_avant.start();

        for (Regle r: chainage_avant.getReglesResultat()){
            System.out.println("* "+r.getNom_regle());
        }
        // here we check chainage arriere

    }
}
