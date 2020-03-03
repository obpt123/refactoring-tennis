package cn.xpbootcamp.tennis;

public class TennisGame1 implements TennisGame {
    private static final String[] LOWER_NAMES = new String[] { "Love", "Fifteen", "Thirty", "Forty" };

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == player1Name)
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        if (m_score1 == m_score2) {
            return getEqualsScore();
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            return getHigherScore();
        } else {
            return getLowerScore();
        }
    }

    private String getLowerScore() {
        String score = "";
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1)
                tempScore = m_score1;
            else {
                score += "-";
                tempScore = m_score2;
            }
            score += LOWER_NAMES[tempScore];
        }
        return score;
    }

    private String getHigherScore() {
        String level = Math.abs(m_score1 - m_score2) == 1 ? "Advantage " : "Win for ";
        String playerName = m_score1 > m_score2 ? player1Name : player2Name;
        return level + playerName;
    }

    private String getEqualsScore() {
        return m_score1 > 2 ? "Deuce" : LOWER_NAMES[m_score1] + "-All";
    }
    
}