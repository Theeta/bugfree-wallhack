

package ohtu.verkkokauppa;

import java.util.ArrayList;

public interface Kirjanpitaja {

    ArrayList<String> getTapahtumat();

    void lisaaTapahtuma(String tapahtuma);
    
}
