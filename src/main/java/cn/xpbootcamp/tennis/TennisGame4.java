package cn.xpbootcamp.tennis;

public class TennisGame4 implements TennisGame {

    private static final String[] LOWER_NAMES = new String[] { "Love", "Fifteen", "Thirty", "Forty" };

    private final String player1Name;
    private final String player2Name;
    private int score1 = 0;
    private int score2 = 0;

    public TennisGame4(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    @Override
    public void wonPoint(String playerName) {
        if (player1Name.equals(playerName)) {
            score1++;
        } else {
            score2++;
        }
    }

    @Override
    public String getScore() {
        if (isWin()) {
            return buildWinText();
        }
        if (isDeuce()) {
            return buildDeuceText();
        }
        if (isAdvantage()) {
            return buildAdvantageText();
        }
        if (isLowerEquals()) {
            return buildLowerEqualsText();
        }
        return buildLowerText();
    }

    private boolean isWin() {
        return Math.max(score1, score2) >= 4 && Math.abs(score1 - score2) >= 2;
    }

    private String buildWinText() {
        return String.format("Win for %s", score1 > score2 ? player1Name : player2Name);
    }

    private boolean isDeuce() {
        return Math.min(score1, score2) >= 3 && score1 == score2;
    }

    private String buildDeuceText() {
        return "Deuce";
    }

    private boolean isAdvantage() {
        return Math.min(score1, score2) >= 3 && Math.abs(score1 - score2) == 1;
    }

    private String buildAdvantageText() {
        return String.format("Advantage %s", score1 > score2 ? player1Name : player2Name);
    }

    private boolean isLowerEquals() {
        return Math.max(score1, score2) < 3 && score1 == score2;
    }

    private String buildLowerEqualsText() {
        return String.format("%s-All", LOWER_NAMES[score1]);
    }

    private String buildLowerText() {
        return String.format("%s-%s", LOWER_NAMES[score1], LOWER_NAMES[score2]);
    }
}