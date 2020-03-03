package cn.xpbootcamp.tennis;

public class TennisGame1 implements TennisGame {
    private static final String[] LOWER_NAMES = new String[] { "Love", "Fifteen", "Thirty", "Forty" };

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == player1Name)
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {
        if (player1Score == player2Score) {
            return getEqualsScore();
        } else if (Math.max(player1Score, player2Score) >= 4) {
            return getHigherScore();
        } else {
            return getLowerScore();
        }
    }

    private String getLowerScore() {
        return LOWER_NAMES[player1Score] + "-" + LOWER_NAMES[player2Score];
    }

    private String getHigherScore() {
        String level = Math.abs(player1Score - player2Score) == 1 ? "Advantage " : "Win for ";
        String playerName = player1Score > player2Score ? player1Name : player2Name;
        return level + playerName;
    }

    private String getEqualsScore() {
        return player1Score > 2 ? "Deuce" : LOWER_NAMES[player1Score] + "-All";
    }

}