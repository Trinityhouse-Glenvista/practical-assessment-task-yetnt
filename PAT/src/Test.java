

/**
 *
 * @author ACER
 */
public class Test {

    public static void main(String args[]) {
        TextFiles files = new TextFiles();

        User user = files.findUser(u -> "feefee".equals(u.name));
        Game game = files.findGame(g -> g.name.equals("Scratch"));
        
        if (user == null) {
            user = files.add(new User("feefee", 20, 0, "jncsdjkkncid"));
        }
        if (game == null) {
            game = files.add(new Game("Scratch", user.id, "Random text Game ong"));
        }
        
        files.save();

    }
}
