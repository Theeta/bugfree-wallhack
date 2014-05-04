package ohtu;

public class TennisGame {

    private final Player player1;
    private final Player player2;

    public TennisGame(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.player1.getName())) {
            player1.wonPoint();
        } else {
            player2.wonPoint();
        }
    }

    public String getScore() {
        if (player1.getScore() == player2.getScore()) {
            return evenScore();
        } else if (player1.getScore() >= 4 || player2.getScore() >= 4) {
            return scoreMoreThanFour();
        } else {
            return player1.getScoreAsText() + "-" + player2.getScoreAsText();
        }
    }

    private String evenScore() {
        if (player1.getScore() < 4) {
            return player1.getScoreAsText() + "-All";
        } else {
            return "Deuce";
        }
    }

    private String scoreMoreThanFour() {
        int minusResult = player1.getScore() - player2.getScore();
        if (minusResult == 1) {
            return "Advantage " + player1.getName();
        } else if (minusResult == -1) {
            return "Advantage " + player2.getName();
        } else if (minusResult >= 2) {
            return "Win for " + player1.getName();
        } else {
            return "Win for " + player2.getName();
        }
    }
}
