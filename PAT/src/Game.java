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
    public String name;
    public int developer;
    private String description;
    public int version;

    Game(int id, String gameName, int dev, String description, int vers) {
        this.name = gameName; // change these values
        this.developer = dev; // to add to the db
        this.version = vers;
        this.gameId = id;
        this.developer = dev;
    }

    Game(String gameName, int dev, String description) {
        // dev adds a game, version is 0
        this.name = gameName; // change these values
        this.developer = dev; // to add to the db
        this.version = 0;
    }

    public void approveGame() {
        // admin approves of a game o the version bumps to 1
    }

    public void deleteSelf() {
        // deletes game.
    }
    
    public String toTextFileString() {
        return Integer.toString(this.gameId)
                + "," + this.name
                + "," + Integer.toString(this.developer)
                + "," + this.description
                + "," + Integer.toString(this.version);
    }
}
