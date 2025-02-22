/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.*;
import java.io.*;
import java.util.logging.*;

/**
 * Class that reads file input
 * @author ACER
 */
public class TextFiles {
    private static ArrayList<User> userArray = new ArrayList<>();
    private static ArrayList<Game> gamesArray = new ArrayList<>();

    TextFiles() {
        this.read();
    }
    
    /**
     * Rereads the text files.
     * @return
     */
    public final void read() {
        try {
            Scanner users = new Scanner(new File("User.txt"));
            Scanner games = new Scanner(new File("Games.txt"));
            int lineNum = -1;
            while (users.hasNextLine()) {
                lineNum++;
                String user = users.nextLine();
                if (lineNum == 0) continue;
                String[] args = user.split(",");
                userArray.add(
                        args.length > 5 ? new User(
                                args[0], 
                                Integer.parseInt(args[1]), 
                                Integer.parseInt(args[2]), 
                                Integer.parseInt(args[3]),
                                args[4],
                                args[5]
                        ) : new User(
                                args[0], 
                                Integer.parseInt(args[1]), 
                                Integer.parseInt(args[2]), 
                                Integer.parseInt(args[3]),
                                args[4]
                        )
                );
            }
            users.close();
            lineNum = -1;
            while (games.hasNextLine()) {
                lineNum++;
                String game = games.nextLine();
                if (lineNum == 0) continue;
                String[] args = game.split(",");
                gamesArray.add(
                        new Game(
                                Integer.parseInt(args[0]),
                                args[1],
                                Integer.parseInt(args[2]),
                                args[3],
                                Integer.parseInt(args[4])
                        )
                );
            }
            games.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TextFiles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    public static ArrayList<Game> getGames() {
        return gamesArray; // Implement file reading logic for Games
    }

    public static ArrayList<Game> findGames(int version) {
        return new ArrayList<>(); // Implement filtering logic
    }

    public static Game findOneGame(int id) {
        return null; // Implement search by ID
    }

    public ArrayList<User> getUsers() {
        return userArray; // Implement file reading logic for Users
    }

    public ArrayList<User> findUsers(UserPermission userPermission) {
        return new ArrayList<>(); // Implement filtering logic
    }

    public User findOneUser(int id) {
        return null; // Implement search by ID
    }
}
