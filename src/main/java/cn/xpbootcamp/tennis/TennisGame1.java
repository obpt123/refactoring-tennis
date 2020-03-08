package cn.xpbootcamp.tennis;

public class TennisGame1 implements TennisGame {

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
            return getLowerScore("");
        }
    }

    private String getLowerScore(String score) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1)
                tempScore = m_score1;
            else {
                score += "-";
                tempScore = m_score2;
            }
            switch (tempScore) {
            case 0:
                score += "Love";
                break;
            case 1:
                score += "Fifteen";
                break;
            case 2:
                score += "Thirty";
                break;
            case 3:
                score += "Forty";
                break;
            }
        }
        return score;
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
        String score;
        switch (m_score1) {
        case 0:
            score = "Love-All";
            break;
        case 1:
            score = "Fifteen-All";
            break;
        case 2:
            score = "Thirty-All";
            break;
        default:
            score = "Deuce";
            break;

        }
        return score;
    }
}