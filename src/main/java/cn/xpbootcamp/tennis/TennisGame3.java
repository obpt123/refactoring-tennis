package cn.xpbootcamp.tennis;

public class TennisGame3 implements TennisGame {

    static final String[] LOWER_NAMES = new String[] { "Love", "Fifteen", "Thirty", "Forty" };

    private int score2;
    private int score1;
    private String player1;
    private String player2;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1 = player1Name;
        this.player2 = player2Name;
    }

    public String getScore() {
        if (Math.max(score1, score2) < 4 && !(score1 + score2 == 6)) {
            return (score1 == score2) ? LOWER_NAMES[score1] + "-All" : LOWER_NAMES[score1] + "-" + LOWER_NAMES[score2];
        } else if (score1 == score2) {
            return "Deuce";
        } else {
            String name = score1 > score2 ? player1 : player2;
            return Math.abs(score1 - score2) == 1 ? "Advantage " + name : "Win for " + name;
        }
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.player1))
            this.score1 += 1;
        else
            this.score2 += 1;
    }

}