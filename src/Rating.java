import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Movie {
    private String category;
    private double rating;

    public Movie(String category, double rating) {
        this.category = category;
        this.rating = rating;
    }

    public String getCategory() {
        return category;
    }

    public double getRating() {
        return rating;
    }
}

public class Rating {
    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("PG", 4.5));
        movies.add(new Movie("PG-13", 3.8));
        movies.add(new Movie("R", 4.2));
        movies.add(new Movie("PG", 4.1));
        movies.add(new Movie("PG-13", 3.9));
        movies.add(new Movie("R", 4.5));
        movies.add(new Movie("PG", 3.7));

        Map<String, Integer> movieCounts = new HashMap<>();
        Map<String, Double> totalRatings = new HashMap<>();

        for (Movie movie : movies) {
            String category = movie.getCategory();
            double rating = movie.getRating();

            movieCounts.put(category, movieCounts.getOrDefault(category, 0) + 1);
            totalRatings.put(category, totalRatings.getOrDefault(category, 0.0) + rating);
        }

        System.out.println("Number of movies rated in each category:");
        for (String category : movieCounts.keySet()) {
            System.out.println(category + ": " + movieCounts.get(category));
        }

        System.out.println("\nAverage rating for each category:");
        for (String category : totalRatings.keySet()) {
            double averageRating = totalRatings.get(category) / movieCounts.get(category);
            System.out.println(category + ": " + averageRating);
        }
    }
}