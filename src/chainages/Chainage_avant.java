package chainages;

import classes.Initialisation;
import classes.Regle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Chainage_avant {
    private Initialisation init;
    private String but;
    private List<Regle> reglesResultat = new ArrayList<Regle>();

    public Chainage_avant(Initialisation init, String but){
        this.init = init;
        this.but = but;
    }

    public void start(){
        boolean trouv = false; // si le but est atteint
        boolean nochange = false;

        if (this.butExist(this.getBut())){
            while (!trouv && !nochange){
            int initSizeBf = this.getInit().getbF().getFait().size();
                for (Regle r : this.getInit().getbR().getRegles()){
                    if (!r.getDesactive()){
                        int nb_c = r.getNb_conditions();
                        int cpt = 0;
                        for (String c: r.getCondition_list()){
                            if (this.conditionExist(c)){ cpt++; }
                        }
                        // si les conditions de cette regle existent dans la Bf
                        if (cpt == nb_c){
                            this.getReglesResultat().add(r);
                            for (int i =0 ; i<r.getFait_resultant().size(); i++){
                                this.getInit().getbF().getFait().add(r.getFait_resultant().get(i));
                            }
                            r.setDesactive(true);
                            int l=0;
                            while(l<r.getFait_resultant().size()){
                                if (r.getFait_resultant().get(l).equals(this.getBut())) {
                                    trouv = true;
                                }
                                l++;
                            }

                            break;
                        }
                    }
                }
                if (initSizeBf == this.getInit().getbF().getFait().size())  {nochange=true;
                    System.out.println(nochange);}
            }
        }
        if (!trouv) {
            System.out.println("systeme break");
        }


    }

    //getters
    public Initialisation getInit() {
        return init;
    }

    public String getBut() {
        return but;
    }

    //verifier si la condition est dans la listes des fait resultants
    public boolean butExist(String but){
        boolean exist = false;
        int i=0;
        while (i < this.init.getNb_regles()){
            for(int j = 0 ; j<this.getInit().getbR().getRegles().get(i).getFait_resultant().size(); j++){
                if (this.getInit().getbR().getRegles().get(i).getFait_resultant().get(j).equals(but)){
                    exist=true;
                }
            }
            i++;
        }
        return exist;
    }

    public boolean conditionExist(String condition){
        boolean exist = false;
        int i = 0;
        while (i < this.getInit().getbF().getFait().size()){
            if (this.getInit().getbF().getFait().get(i).equals(condition)){
                exist = true;
            }
            i++;
        }
        return exist;
    }

    public boolean all_desactive(){
        boolean done = true;
        for (Regle r: this.getInit().getbR().getRegles()){
            if (!r.getDesactive()){
                done = false;
            }
        }
        return done;
    }

    public List<Regle> getReglesResultat() {
        return this.reglesResultat;
    }
}
