import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class User {
    public int id;
    public String name;
    public List<Integer> watchedMovies;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.watchedMovies = new ArrayList<>();

    }
}
