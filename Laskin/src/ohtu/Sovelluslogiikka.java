package ohtu;

public class Sovelluslogiikka {
 
    private int tulos;
    
    public void asetaLuku(int luku){
        this.tulos = luku;
    }
 
    public void plus(int luku) {
        tulos += luku;
    }
     
    public void miinus(int luku) {
        tulos -= luku;
    }
 
    public void nollaa() {
        tulos = 0;
    }
 
    public int tulos() {
        return tulos;
    }
}