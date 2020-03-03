package cn.xpbootcamp.tennis;

public class TennisGame2 implements TennisGame {
    private static final String[] LOWER_NAMES = new String[] { "Love", "Fifteen", "Thirty", "Forty" };

    public int P1point = 0;
    public int P2point = 0;

    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String player) {
        if (player.equals(player1Name))
            P1point++;
        else
            P2point++;
    }

    public String getScore() {
        if (isWin()) {
            return buildWinText();
        }
        if (isAdvantage()) {
            return buildAdvantageText();
        }
        if (isLowerCompare()) {
            return buildLowerCompareText();
        }
        if (isDeuce()) {
            return buildDeuceText();
        }
        if (isLowerEquals()) {
            return buildLowerEqualsText();
        }
        throw new RuntimeException("Never occured");
    }

    private String buildDeuceText() {
        return "Deuce";
    }

    private String buildLowerEqualsText() {
        return LOWER_NAMES[P1point] + "-All";
    }

    private String buildLowerCompareText() {
        return LOWER_NAMES[P1point] + "-" + LOWER_NAMES[P2point];
    }

    private String buildAdvantageText() {
        String playerName = P1point > P2point ? player1Name : player2Name;
        return "Advantage " + playerName;
    }

    private String buildWinText() {
        String playerName = P1point > P2point ? player1Name : player2Name;
        return "Win for " + playerName;
    }

    private boolean isLowerEquals() {
        return P1point == P2point && P1point < 3;
    }

    private boolean isDeuce() {
        return P1point == P2point && P1point >= 3;
    }

    private boolean isLowerCompare() {
        return P1point != P2point && Math.max(P1point, P2point) < 4;
    }

    private boolean isAdvantage() {
        return P1point != P2point && Math.min(P1point, P2point) >= 3;
    }

    private boolean isWin() {
        return Math.max(P1point, P2point) >= 4 && Math.abs(P1point - P2point) >= 2;
    }

}