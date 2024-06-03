import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Movie {
    public int id;
    public String title;
    public String genre;
    public List<String> actors;
    public String director;
    public Movie(int id, String title, String genre, List<String> actors, String director) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.actors = actors;
        this.director = director;

    }
}