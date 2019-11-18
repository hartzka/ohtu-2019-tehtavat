package ohtu;

enum PlayerName {
    PLAYER1, PLAYER2;
}

public class TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private PlayerName player1Name;
    private PlayerName player2Name;

    public TennisGame(PlayerName player1Name, PlayerName player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(PlayerName playerName) {
        if (playerName == PlayerName.PLAYER1) {
            m_score1++;
        } else if (playerName == PlayerName.PLAYER2) {
            m_score2++;
        }
    }

    public String getScore() {
        if (m_score1 == m_score2) {
            return getScoreWhenEqual();
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            return getScoreWhenAdvOrWin();
        } else {
            return getScoreOtherwise();
        }
    }

    public static void main(String[] args) {
        TennisGame game = new TennisGame(PlayerName.PLAYER1, PlayerName.PLAYER2);

        System.out.println(game.getScore());

        game.wonPoint(PlayerName.PLAYER1);
        System.out.println(game.getScore());

        game.wonPoint(PlayerName.PLAYER1);
        System.out.println(game.getScore());

        game.wonPoint(PlayerName.PLAYER2);
        System.out.println(game.getScore());

        game.wonPoint(PlayerName.PLAYER2);
        System.out.println(game.getScore());

        game.wonPoint(PlayerName.PLAYER1);
        System.out.println(game.getScore());
        
        game.wonPoint(PlayerName.PLAYER2);
        System.out.println(game.getScore());
        
        game.wonPoint(PlayerName.PLAYER1);
        System.out.println(game.getScore());
        
        game.wonPoint(PlayerName.PLAYER2);
        System.out.println(game.getScore());
        
        game.wonPoint(PlayerName.PLAYER1);
        System.out.println(game.getScore());
        
        game.wonPoint(PlayerName.PLAYER2);
        System.out.println(game.getScore());
        
        game.wonPoint(PlayerName.PLAYER2);
        System.out.println(game.getScore());
        
        game.wonPoint(PlayerName.PLAYER1);
        System.out.println(game.getScore());
        
        game.wonPoint(PlayerName.PLAYER2);
        System.out.println(game.getScore());
        
        game.wonPoint(PlayerName.PLAYER2);
        System.out.println(game.getScore());
    }

    private String getScoreWhenEqual() {
        String score = "";
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
            case 3:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
        return score;
    }

    private String getScoreWhenAdvOrWin() {
        String score = "";
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1) {
            score = "Advantage player1";
        } else if (minusResult == -1) {
            score = "Advantage player2";
        } else if (minusResult >= 2) {
            score = "Win for player1";
        } else {
            score = "Win for player2";
        }
        return score;
    }

    private String getScoreOtherwise() {
        int tempScore = 0;
        String score = "";
        for (int i = 1; i <= 2; i++) {
            if (i == 1) {
                tempScore = m_score1;
            } else {
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

}
