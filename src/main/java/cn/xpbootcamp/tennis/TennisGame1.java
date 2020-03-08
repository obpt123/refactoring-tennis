package cn.xpbootcamp.tennis;

public class TennisGame1 implements TennisGame {

    private static final String[] LOWER_SCORE_NAMES = new String[] { "Love", "Fifteen", "Thirty", "Forty" };

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)) {
            m_score1++;
        } else {
            m_score2++;
        }
    }

    public String getScore() {
        if (m_score1 == m_score2) {
            return getEqualScore();
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            return getHigherScore();
        } else {
            return getLowerScore();
        }
    }

    private String getLowerScore() {
        return String.format("%s-%s", LOWER_SCORE_NAMES[m_score1], LOWER_SCORE_NAMES[m_score2]);
    }

    private String getHigherScore() {
        String displayName = m_score1 > m_score2 ? player1Name : player2Name;
        if (Math.abs(m_score1 - m_score2) == 1) {
            return String.format("Advantage %s", displayName);
        } else {
            return String.format("Win for %s", displayName);
        }
    }

    private String getEqualScore() {
        if (m_score1 >= 3) {
            return "Deuce";
        } else {
            return String.format("%s-All", LOWER_SCORE_NAMES[m_score1]);
        }
    }
}