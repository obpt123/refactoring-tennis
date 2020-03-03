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

    public String getScore() {
        if (isWin()) {
            return P1point > P2point ? formatPlayer1("Win for %s") : formatPlayer2("Win for %s");
        }
        if (isAdvantage()) {
            return P1point > P2point ? formatPlayer1("Advantage %s") : formatPlayer2("Advantage %s");
        }
        if (isLowerCompare()) {
            return LOWER_NAMES[P1point] + "-" + LOWER_NAMES[P2point];
        }
        if (isDeuce()) {
            return "Deuce";
        }
        if (isLowerEquals()) {
            return LOWER_NAMES[P1point] + "-All";
        }
        throw new RuntimeException("Never occured");
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

    public void wonPoint(String player) {
        if (player == this.player1Name)
            P1point++;
        else
            P2point++;
    }

    private String formatPlayer1(String fmt) {
        return String.format(fmt, player1Name);
    }

    private String formatPlayer2(String fmt) {
        return String.format(fmt, player2Name);
    }

}