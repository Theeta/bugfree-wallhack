package ohtu.intjoukkosovellus;

public class IntJoukko {

    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] lukutaulukko;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(5, 5);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, 5);
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IllegalArgumentException("Kapasitteetti ei voi olla negatiivinen");
        }
        if (kasvatuskoko < 0) {
            throw new IllegalArgumentException("Kasvatuskoko ei voi olla negatiivinen");
        }
        lukutaulukko = new int[kapasiteetti];
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;

    }

    public boolean lisaa(int luku) {

        if (kuuluu(luku)) {
            return false;
        }
        kasvataTaulukkoaTarvittaessa();
        lukutaulukko[alkioidenLkm] = luku;
        alkioidenLkm++;
        return true;
    }

    private void kasvataTaulukkoaTarvittaessa() {
        if (alkioidenLkm + 1 == lukutaulukko.length) {
            int[] vanhaTaulukko = lukutaulukko;
            lukutaulukko = new int[alkioidenLkm + kasvatuskoko];
            System.arraycopy(vanhaTaulukko, 0, lukutaulukko, 0, vanhaTaulukko.length);
        }
    }

    public boolean kuuluu(int luku) {
        return (etsiLukuTaulukosta(luku) != -1);
    }

    public boolean poista(int luku) {
        int indeksi = etsiLukuTaulukosta(luku);
        if (indeksi == -1) {
            return false;
        }
        poistaIndeksiTaulukosta(indeksi);
        return true;
    }

    private void poistaIndeksiTaulukosta(int indeksi) {
        for (int i = indeksi; i < alkioidenLkm - 1; i++) {
            lukutaulukko[i] = lukutaulukko[i + 1];
        }
        alkioidenLkm--;
    }

    private int etsiLukuTaulukosta(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == lukutaulukko[i]) {
                return i;
            }
        }
        return -1;
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        String palautus = "{";
        for (int i = 0; i < alkioidenLkm; i++) {
            palautus += lukutaulukko[i];
            if (i < alkioidenLkm -1){
                palautus += ", ";
            }
        }
        return palautus + "}";
    }

    public int[] toIntArray() {
        int[] palautus = new int[alkioidenLkm];
        System.arraycopy(lukutaulukko, 0, palautus, 0, palautus.length);
        return palautus;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko palautus = new IntJoukko();
        lisaaTaulukkoJoukkoon(a.toIntArray(), palautus);
        lisaaTaulukkoJoukkoon(b.toIntArray(), palautus);
        return palautus;
    }

    private static void lisaaTaulukkoJoukkoon(int[] taulukko, IntJoukko palautus) {
        for (int i = 0; i < taulukko.length; i++) {
            palautus.lisaa(taulukko[i]);
        }
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko palautus = new IntJoukko();
        int[] aTaulukko = a.toIntArray();
        for (int i = 0; i < aTaulukko.length; i++) {
            if (b.kuuluu(aTaulukko[i])) {
                palautus.lisaa(aTaulukko[i]);
            }
        }
        return palautus;
    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko palautus = new IntJoukko();
        int[] aTaulukko = a.toIntArray();
        for (int i = 0; i < aTaulukko.length; i++) {
            if (!b.kuuluu(aTaulukko[i])) {
                palautus.lisaa(aTaulukko[i]);
            }
        }
        return palautus;
    }
}
