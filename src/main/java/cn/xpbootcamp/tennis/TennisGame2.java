package cn.xpbootcamp.tennis;

public class TennisGame2 implements TennisGame {
    private static final String[] LOWER_NAMES = new String[] { "Love", "Fifteen", "Thirty", "Forty" };

    private int player1Point = 0;
    private int player2Point = 0;

    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String player) {
        if (player.equals(player1Name))
            player1Point++;
        else
            player2Point++;
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
        return LOWER_NAMES[player1Point] + "-All";
    }

    private String buildLowerCompareText() {
        return LOWER_NAMES[player1Point] + "-" + LOWER_NAMES[player2Point];
    }

    private String buildAdvantageText() {
        String playerName = player1Point > player2Point ? player1Name : player2Name;
        return "Advantage " + playerName;
    }

    private String buildWinText() {
        String playerName = player1Point > player2Point ? player1Name : player2Name;
        return "Win for " + playerName;
    }

    private boolean isLowerEquals() {
        return player1Point == player2Point && player1Point < 3;
    }

    private boolean isDeuce() {
        return player1Point == player2Point && player1Point >= 3;
    }

    private boolean isLowerCompare() {
        return player1Point != player2Point && Math.max(player1Point, player2Point) < 4;
    }

    private boolean isAdvantage() {
        return player1Point != player2Point && Math.min(player1Point, player2Point) >= 3;
    }

    private boolean isWin() {
        return Math.max(player1Point, player2Point) >= 4 && Math.abs(player1Point - player2Point) >= 2;
    }

}