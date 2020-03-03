package cn.xpbootcamp.tennis;

public class TennisGame2 implements TennisGame {
    private static final String[] LOWER_NAMES = new String[] { "Love", "Fifteen", "Thirty", "Forty" };

    public int P1point = 0;
    public int P2point = 0;

    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String score = "";
        if (P1point == P2point && P1point < 4) {
            if (P1point != 3)
                score = LOWER_NAMES[P1point] + "-All";
        }
        if (P1point == P2point && P1point >= 3)
            score = "Deuce";

        if (P1point > 0 && P1point <= 3 && P2point == 0) {
            P1res = LOWER_NAMES[P1point];
            P2res = LOWER_NAMES[0];
            score = P1res + "-" + P2res;
        }
        if (P2point > 0 && P2point <= 3 && P1point == 0) {
            P2res = LOWER_NAMES[P2point];
            P1res = LOWER_NAMES[0];
            score = P1res + "-" + P2res;
        }

        if (P1point > P2point && P1point < 4) {
            if (P1point == 2 || P1point == 3)
                P1res = LOWER_NAMES[P1point];

            if (P2point == 1 || P2point == 2)
                P2res = LOWER_NAMES[P2point];

            score = P1res + "-" + P2res;
        }
        if (P2point > P1point && P2point < 4) {
            if (P2point == 2 || P2point == 3)
                P2res = LOWER_NAMES[P2point];

            if (P1point == 1 || P1point == 2)
                P1res = LOWER_NAMES[P1point];

            score = P1res + "-" + P2res;
        }

        if (P1point != P2point && Math.min(P1point,P2point) >= 3) {
            score = P1point > P2point ? formatPlayer1("Advantage %s"): formatPlayer2("Advantage %s");
        }
        
        if (Math.max(P1point, P2point) >= 4 && Math.abs(P1point - P2point) >= 2) {
            score = P1point > P2point ? formatPlayer1("Win for %s") : formatPlayer2("Win for %s");
        }

        return score;
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