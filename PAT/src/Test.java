
import java.util.*;


/**
 *
 * @author ACER
 */
public class Test {

    public static void main(String args[]) {
        TextFiles files = new TextFiles();

        ArrayList<User> users = files.getUsers();
        ArrayList<Game> games = files.getGames();

        ArrayList<Integer> ownd = users.get(10).ownedGames;
        for (int i : ownd.stream().mapToInt(Integer::intValue).toArray()) {
            System.out.println(i);
        }

    }
}
