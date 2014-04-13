package ohtu;

public class Submission {
    private String student_number;
    private String week;
    private int hours;
    private boolean a1;
    private boolean a2;
    private boolean a3;
    private boolean a4;
    private boolean a5;
    private boolean a6;
    private boolean a7;
    private boolean a8;
    private boolean a9;
    private boolean a10;
    private boolean a11;
    private boolean a12;
    private boolean a13;
    private boolean a14;
    private boolean a15;
    private boolean a16;
    private boolean a17;
    private boolean a18;
    private boolean a19;
    private boolean a20;
    private boolean a21;

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    public int getHours() {
        return hours;
    }
    
    private String tehdytTehtavat(){
        String palautus = "";
        if (a1) palautus += "1 ";
        if (a2) palautus += "2 ";
        if (a3) palautus += "3 ";
        if (a4) palautus += "4 ";
        if (a5) palautus += "5 ";
        if (a6) palautus += "6 ";
        if (a7) palautus += "7 ";
        if (a8) palautus += "8 ";
        if (a9) palautus += "9 ";
        if (a10) palautus += "10 ";
        if (a11) palautus += "11 ";
        if (a12) palautus += "12 ";
        if (a13) palautus += "13 ";
        if (a14) palautus += "14 ";
        if (a15) palautus += "15 ";
        if (a16) palautus += "16 ";
        if (a17) palautus += "17 ";
        if (a18) palautus += "18 ";
        if (a19) palautus += "19 ";
        if (a20) palautus += "20 ";
        if (a21) palautus += "21 ";
        
        return palautus;
    }
    
    public int tehtaviaYhteensa(){
        int yhteensa = 0;
        if (a1) yhteensa += 1;
        if (a2) yhteensa += 1;
        if (a3) yhteensa += 1;
        if (a4) yhteensa += 1;
        if (a5) yhteensa += 1;
        if (a6) yhteensa += 1;
        if (a7) yhteensa += 1;
        if (a8) yhteensa += 1;
        if (a9) yhteensa += 1;
        if (a10) yhteensa += 1;
        if (a11) yhteensa += 1;
        if (a12) yhteensa += 1;
        if (a13) yhteensa += 1;
        if (a14) yhteensa += 1;
        if (a15) yhteensa += 1;
        if (a16) yhteensa += 1;
        if (a17) yhteensa += 1;
        if (a18) yhteensa += 1;
        if (a19) yhteensa += 1;
        if (a20) yhteensa += 1;
        if (a21) yhteensa += 1;
        return yhteensa;
    }

    @Override
    public String toString() {
        return "viikko " + week + ": tehtyjä tehtäviä yhteensä: " + tehtaviaYhteensa() + ", aikaa kului " + hours
            + " tuntia, tehdyt tehtävät: " + tehdytTehtavat();
    }
    
}