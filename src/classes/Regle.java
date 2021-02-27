package classes;

import java.util.ArrayList;
import java.util.List;

public class Regle {
    // une regle contiendra des condition et un fait resultant et un attribut de desactivation
    private int nb_conditions;
    private int nb_resultantes;
    private String nom_regle;
    private List<String> condition_list = new ArrayList<String>();
    private List<String> fait_resultant = new ArrayList<String>();
    private Boolean desactive;

    public Regle(){

    }

    //getters
    public List<String> getCondition_list() {
        return condition_list;
    }

    public List<String> getFait_resultant() {
        return fait_resultant;
    }

    public void setFait_resultant(List<String> fait_resultant) {
        this.fait_resultant = fait_resultant;
    }

    public Boolean getDesactive() {
        return desactive;
    }

    public int getNb_conditions() {
        return nb_conditions;
    }

    public void setNb_conditions(int nb_conditions) {
        this.nb_conditions = nb_conditions;
    }

    public void setCondition_list(List<String> condition_list) {
        this.condition_list = condition_list;
    }


    public void setDesactive(Boolean desactive) {
        this.desactive = desactive;
    }

    public int getNb_resultantes() {
        return nb_resultantes;
    }

    public void setNb_resultantes(int nb_resultantes) {
        this.nb_resultantes = nb_resultantes;
    }

    public String getNom_regle() {
        return nom_regle;
    }

    public void setNom_regle(String nom_regle) {
        this.nom_regle = nom_regle;
    }
}
