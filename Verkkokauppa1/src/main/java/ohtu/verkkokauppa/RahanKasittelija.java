
package ohtu.verkkokauppa;

public interface RahanKasittelija {

    boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa);
    
}
