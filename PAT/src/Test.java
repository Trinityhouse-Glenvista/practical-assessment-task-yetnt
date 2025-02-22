

/**
 *
 * @author ACER
 */
public class Test {

    public static void main(String args[]) {
        TextFiles files = new TextFiles();

        User user = files.findUser(u -> "Nikhil".equals(u.name));

        user.age--;
        
        files.save();

    }
}
