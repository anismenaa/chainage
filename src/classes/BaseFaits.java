package classes;

import java.util.ArrayList;
import java.util.List;

public class BaseFaits {
    // une list de fait (String)
    private List<String> faits = new ArrayList<String>();

    public BaseFaits(){

    }
    //getter

    public List<String> getFait() {
        return faits;
    }

    //setter
    public void setFait(List<String> faits) {
        this.faits = faits;
    }
}
