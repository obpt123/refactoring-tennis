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
        String temp;
        if (score1 < 4 && score2 < 4 && !(score1 + score2 == 6)) {
            temp = LOWER_NAMES[score1];
            return (score1 == score2) ? temp + "-All" : temp + "-" + LOWER_NAMES[score2];
        } else {
            if (score1 == score2)
                return "Deuce";
            temp = score1 > score2 ? player1 : player2;
            return ((score1 - score2) * (score1 - score2) == 1) ? "Advantage " + temp : "Win for " + temp;
        }
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.score1 += 1;
        else
            this.score2 += 1;
    }

}