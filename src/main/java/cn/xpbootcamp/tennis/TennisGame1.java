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
        String score ="";
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
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1)
            return formatPlayer1("Advantage %s");
        else if (minusResult == -1)
            return formatPlayer2("Advantage %s");
        else if (minusResult >= 2)
            return formatPlayer1("Win for %s");
        else
            return formatPlayer2("Win for %s");
    }

    private String getEqualsScore() {
        switch (m_score1) {
        case 0:
            return "Love-All";
        case 1:
            return "Fifteen-All";
        case 2:
            return "Thirty-All";
        default:
            return "Deuce";
        }
    }

    private String formatPlayer1(String fmt) {
        return String.format(fmt, this.player1Name);
    }

    private String formatPlayer2(String fmt) {
        return String.format(fmt, this.player2Name);
    }
}