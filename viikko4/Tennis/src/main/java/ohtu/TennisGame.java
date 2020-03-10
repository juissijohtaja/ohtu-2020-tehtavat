package ohtu;

public class TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;
    private final String player1Name;
    private final String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) {
            player1Score += 1;
        } else {
            player2Score += 1;
        }
    }
    
    public String getScore() {
        if (player1Score == player2Score) {
            return stringifyEvenScore();   
        } else if (player1Score >= 4 || player2Score >= 4) {
            return stringifyAdvantageScore();
        }
        return stringifyNormalScore();
    }
    
    private String stringifyNormalScore() {
        return stringifyNormalPoints(player1Score) + "-" + stringifyNormalPoints(player2Score);
    }
    
    private String stringifyNormalPoints(int playerScore) {
        switch(playerScore) {
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "Love";
        }
    }
    
    private String stringifyEvenScore() {
        switch (player1Score) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return "Forty-All";
            default:
                return "Deuce";    
        }
    }
    
    private String stringifyAdvantageScore() {
        int scoreDifference = player1Score-player2Score;
        if (scoreDifference == 1) {
            return "Advantage " + player1Name;
        } else if (scoreDifference == -1) {
            return "Advantage " + player2Name;
        } else if (scoreDifference >= 2) {
            return "Win for " + player1Name;
        } else {
            return "Win for " + player2Name;
        }
    }
      
}