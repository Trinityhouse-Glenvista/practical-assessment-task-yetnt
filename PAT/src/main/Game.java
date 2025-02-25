package main;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * The Game class represents a game in the system with attributes such as game
 * ID,
 * name, developer, description, and version. It provides constructors for
 * initializing
 * game objects either from existing data or for newly created games. The class
 * also
 * includes methods to approve a game, delete a game, and convert the game
 * object to
 * a string representation suitable for saving to a text file.
 */
public class Game {
    public int id;
    public String name;
    public int developer;
    public String description;
    public int version;

    /**
     * Constructs a new Game object with the specified parameters.
     *
     * @param id          the unique identifier for the game
     * @param gameName    the name of the game
     * @param dev         the developer identifier
     * @param description the description of the game
     * @param vers        the version number of the game
     */
    Game(int id, String gameName, int dev, String description, int vers) {
        // This is the constructor used by TextFiles to init existing games.
        this.name = gameName; // change these values
        this.developer = dev; // to add to the db
        this.version = vers;
        this.id = id;
        this.description = description;
    }

    /**
     * Constructs a new Game instance with the specified name, developer, and
     * description.
     *
     * @param gameName    the name of the game
     * @param dev         the developer ID of the game
     * @param description a brief description of the game
     */
    Game(String gameName, int dev, String description) {
        // consturctor used to add a new game instance.
        this.name = gameName; // change these values
        this.developer = dev; // to add to the db
        this.version = 0;
        this.description = description;
    }

    public void approveGame() {
        // admin approves of a game o the version bumps to 1
    }

    public void deleteSelf() {
        // deletes game.
    }

    /**
     * Converts the game object to a string formatted for saving to a text file.
     * The format of the string is: gameId,name,developer,description,version
     *
     * @return A string representation of the game object formatted for a text file.
     */
    public String toTextFileString() {
        return Integer.toString(this.id)
                + "," + this.name
                + "," + Integer.toString(this.developer)
                + "," + this.description
                + "," + Integer.toString(this.version);
    }
}
