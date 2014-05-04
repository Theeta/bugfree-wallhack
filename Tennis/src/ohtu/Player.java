
package ohtu;

public class Player {
    private final String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public int getScore() {
        return this.score;
    }

    public String getScoreAsText() {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
        }
        return "impossible";
    }

    public String getName() {
        return this.name;
    }

    public void wonPoint() {
        this.score++;
    }

}
