/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

/**
 *
 * @author juhakoivu
 */
public class Tennis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TennisGame game = new TennisGame("player1", "player2");

        System.out.println(game.getScore());

        game.wonPoint("player1");
        System.out.println(game.getScore());

        game.wonPoint("player1");
        System.out.println(game.getScore());

        game.wonPoint("player2");
        System.out.println(game.getScore());

        game.wonPoint("player1");
        System.out.println(game.getScore());
        
        game.wonPoint("player2");
        System.out.println(game.getScore());
        
        game.wonPoint("player2");
        System.out.println(game.getScore());

        game.wonPoint("player1");
        System.out.println(game.getScore());
        
        game.wonPoint("player2");
        System.out.println(game.getScore());
        
        game.wonPoint("player2");
        System.out.println(game.getScore());
        
        game.wonPoint("player1");
        System.out.println(game.getScore());
        
        game.wonPoint("player2");
        System.out.println(game.getScore());
        
        game.wonPoint("player1");
        System.out.println(game.getScore());
        
        game.wonPoint("player1");
        System.out.println(game.getScore());
        
        game.wonPoint("player1");
        System.out.println(game.getScore());
    }
    
}
