import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Recommendation {
    public static void main(String[] args) {
        String[] actors1 = {"Tim Robbins", "Morgan Freeman"};
        Movie movie1 = new Movie(1, "The Shawshank Redemption", "Drama", List.of(actors1), "Frank Darabont");
        String[] actors2 = {"Christian Bale", "Heath Ledger"};
        Movie movie2 = new Movie(2, "The Dark Knight", "Action", List.of(actors2), "Christopher Nolan");
        String[] actors3 = {"Leonardo DiCaprio", "Joseph Gordon-Levitt"};
        Movie movie3 = new Movie(3, "Inception", "Sci-Fi", List.of(actors3), "Christopher Nolan");
        String[] actors4 = {"Marlon Brando", "Al Pacino"};
        Movie movie4 = new Movie(4, "The Godfather", "Crime", List.of(actors4), "Francis Ford Coppola");

        TreeMap<Integer, Movie> movies = new TreeMap<>();
        movies.put(movie1.id, movie1);
        movies.put(movie2.id, movie2);
        movies.put(movie3.id, movie3);
        movies.put(movie4.id, movie4);

        User user1 = new User(1, "John Doe");
        User user2 = new User(2, "Johanna Woe");
        TreeMap<Integer, User> users = new TreeMap<>();
        users.put(user1.id, user1);
        users.put(user2.id, user2);
        Recommendation recommendation = new Recommendation();
        recommendation.addMovie(movie1);
        recommendation.addMovie(movie2);
        recommendation.addMovie(movie3);
        recommendation.addMovie(movie4);

        recommendation.addUser(user1);
        recommendation.addUser(user2);

        List<Movie> recommendedMovies = recommendation.recommendMovies(1, 2);

    }

    TreeMap<Integer, Movie> movies;
    TreeMap<Integer, User> users;

    public Recommendation() {
        this.movies = new TreeMap<>();
        this.users = new TreeMap<>();
    }

    public void addMovie(Movie movie) {
        movies.put(movie.id, movie);
    }

    public void addUser(User user) {
        users.put(user.id, user);
    }

//         Рекомендации должны быть отсортированы по релевантности (количеству совпадений с критериями) в порядке убывания???
//        maxRecommendation самых релевантных рекомендаций. - не сделано

    public List<Movie> recommendMovies(int userId, int maxRecommendations) {
        User user = users.get(userId);
        if (user == null) {
            System.out.println("Пользователь не найден");
            return new ArrayList<>();
        }
        List<Movie> recommendations = new ArrayList<>();
        for (Integer watchedMovieId : user.watchedMovies) {
            Movie watchedMovie = movies.get(watchedMovieId);
            for (Movie movie : movies.values()) {
                if (!recommendations.contains(movie)) {
                    int count = 0;
//                    прибавлять count++ в случае каждого совпадения
//                     if (movie.genre.equals(watchedMovie.genre)){
//                        count++;
//                    }
//                    if(movie.actors.contains(watchedMovie.actors)){
//                        count++;
//                    }if(movie.director.equals(watchedMovie.director))
//                        count++;
//                        recommendations.add(movie);
                    if (movie.genre.equals(watchedMovie.genre)
                            || movie.actors.contains(watchedMovie.actors)
                            || movie.director.equals(watchedMovie.director))
                        recommendations.add(movie);
                }
            }
        }
        return recommendations;
    }
}


