package ohtu;

import javax.swing.JTextField;

class Erotus implements Komento {
    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int arvoAlussa;
    private int arvo;

    public Erotus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.syotekentta = syotekentta;
        this.tuloskentta = tuloskentta;
    }

    @Override
    public void suorita() {
        arvoAlussa = sovellus.tulos();
        arvo = Integer.parseInt(syotekentta.getText());
        sovellus.miinus(arvo);
        syotekentta.setText("");
        tuloskentta.setText(""+sovellus.tulos());
    }

    @Override
    public void peru() {
        sovellus.asetaLuku(arvoAlussa);
        syotekentta.setText("");
        tuloskentta.setText(""+sovellus.tulos());
    }
    
}
