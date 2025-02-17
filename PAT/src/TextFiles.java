/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
     *
     * @return
     */
    public final void read() {
        try {
            Scanner users = new Scanner(new File("User.txt"));
            int lineNum = -1;
            while (users.hasNextLine()) {
                lineNum++;
                String user = users.nextLine();
                if (lineNum == 0) continue;
                System.out.println(user);
                String[] args = user.split(",");
                userArray.add(
                        new User(
                                args[0], 
                                Integer.parseInt(args[1]), 
                                Integer.parseInt(args[2]), 
                                Integer.parseInt(args[3])
                        )
                );
            }
            users.close();
            lineNum = -1;
            
//            Scanner games = new Scanner(new File("Games.txt"));
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TextFiles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static class Games {

        public static ArrayList<Game> get() {
            return new ArrayList<>(); // Implement file reading logic for Games
        }

        public static ArrayList<Game> find(UserPermission userPermission) {
            return new ArrayList<>(); // Implement filtering logic
        }

        public static Game findOne(int id) {
            return null; // Implement search by ID
        }
    }

    public static class Users {
        public static ArrayList<User> get() {
            return userArray; // Implement file reading logic for Users
        }

        public static ArrayList<User> find(UserPermission userPermission) {
            return new ArrayList<>(); // Implement filtering logic
        }

        public static User findOne(int id) {
            return null; // Implement search by ID
        }
    }
}
