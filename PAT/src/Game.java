/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ACER
 */
public class Game {
    private int gameId;
    private String gameName;
    private int developer;
    private String description;
    private int version;
    
    Game(int id, String name, int dev, String description,  int vers) {
        // dev adds a game, version is 0
        gameName = name; // change these values
        developer = dev; // to add to the db
        version = vers;
        gameId = id;
        developer = dev;
    }
    
    Game(String name, int dev, String description) {
        // dev adds a game, version is 0
        gameName = name; // change these values
        developer = dev; // to add to the db
        version = 0;
    }
    
    public void approveGame(String gameName) {
        // admin approves of a game o the version bumps to 1
    }
    
    public void buyGame(String gameName) {
        // user buys the game
        // only when it has a veriwson higher than 0
        // and isn't alreay owned by a user.
    }
}
