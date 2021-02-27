package classes;

import java.io.*;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Initialisation {
    // on initialise la base de regles et la base de faits ( on aura besoin du nbRegles et nbFaits)
    private String filename;
    private int nb_regles;
    private int nb_faits;
    private BaseRegles bR = new BaseRegles(); //la base de regles
    private BaseFaits bF = new BaseFaits(); //la base de faits

    public Initialisation(int nb_regles, int nb_faits, String filename){
        this.nb_regles = nb_regles;
        this.nb_faits = nb_faits;
        this.filename = filename;
    }

    public void start1() throws IOException {
        System.out.println("***************** INITIALISATION DE BASE DE REGLES ***************\n");
        FileInputStream reglesData = new FileInputStream(this.getFilename());
        InputStreamReader lect = new InputStreamReader(reglesData);
        BufferedReader buff=new BufferedReader(lect);


        // on recupere la ligne
        for (int i=0 ; i<this.nb_regles; i++){
            Regle newRegle = new Regle();
            String regle_Lu = buff.readLine().replaceAll("\\s+","");
            List<String> regle_decoupe1 = Arrays.asList(regle_Lu.split(":"));
            //on recupere le nom de la regle
            newRegle.setNom_regle(regle_decoupe1.get(0));
            System.out.println(newRegle.getNom_regle());
            List<String> regle_decoupe2 = Arrays.asList(regle_decoupe1.get(1).split(","));
            //on recupere la SI et alors
            String si_statement = regle_decoupe2.get(0);
            List<String> premisses = Arrays.asList(si_statement.split("et"));
            newRegle.setNb_conditions(premisses.size());
            for (int j = 0 ; j<premisses.size(); j++){
                if (j==0){
                    newRegle.getCondition_list().add(premisses.get(j).substring(2));
                }else {
                    newRegle.getCondition_list().add(premisses.get(j));
                }
            }
            System.out.println(newRegle.getCondition_list());

            String alors_statement = regle_decoupe2.get(1);
            List<String> faits_result = Arrays.asList(alors_statement.split("et"));
            for (int j = 0 ; j<faits_result.size(); j++){
                if (j==0){
                    newRegle.getFait_resultant().add(faits_result.get(j).substring(5));
                }else {
                    newRegle.getFait_resultant().add(faits_result.get(j));
                }
            }
            System.out.println(newRegle.getFait_resultant());
            newRegle.setDesactive(false);
            bR.addRegle(newRegle);
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("***************** INITIALISATION DE BASE DE fait ***************\n");
        //on initialise la base de faits
        for (int i=1; i<=this.nb_faits; i++){
            System.out.print("le fait "+i+" : ");
            bF.getFait().add(sc.next());
        }
        sc.close();

 /*
	 console
*/
    }
    public void start(){
        Scanner sc = new Scanner(System.in);
        //on initialise la base de regles
        System.out.println("***************** INITIALISATION DE BASE DE REGLES ***************\n");
        for (int i=1; i<=this.nb_regles; i++){
            Regle newRegle = new Regle();
            System.out.print("* la règle "+i+" : \n");
            System.out.print("- le nombre de condition : "); // on introduit le nombre de condition
            newRegle.setNb_conditions(sc.nextInt());
            for (int k=1; k<=newRegle.getNb_conditions(); k++){
                System.out.print("-- condition "+k+" : ");
                newRegle.getCondition_list().add(sc.next());
            }
            System.out.print("- le nombre de faits resultants : ");
            newRegle.setNb_resultantes(sc.nextInt());
            for (int k=1; k<=newRegle.getNb_resultantes(); k++){
                System.out.print("-- resultante "+k+" : ");
                newRegle.getFait_resultant().add(sc.next());
            }
            newRegle.setDesactive(false);
            bR.addRegle(newRegle); //on ajoute la regle à la base de regles
            //ajout de conditions
        }

        System.out.println("***************** INITIALISATION DE BASE DE fait ***************\n");
        //on initialise la base de faits
        for (int j=1; j<=this.nb_faits; j++){
            System.out.print("le fait "+j+" : ");
            bF.getFait().add(sc.next());
        }
        sc.close();
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getNb_regles() {
        return nb_regles;
    }

    public int getNb_faits() {
        return nb_faits;
    }

    public BaseRegles getbR() {
        return bR;
    }

    public BaseFaits getbF() {
        return bF;
    }
}
