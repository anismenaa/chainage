package classes;

import java.util.ArrayList;
import java.util.List;

public class BaseRegles {
    // une liste de regles
    private List<Regle> regles = new ArrayList<Regle>();

    public BaseRegles(){

    }

    //getter
    public List<Regle> getRegles(){
        return this.regles;
    }

    //Setter
    public void setRegles(List<Regle> regles){
        this.regles = regles;
    }

    public void addRegle(Regle regle){
        this.getRegles().add(regle);
    }
}
