import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RestaurantRating {
    private double rating;

    public RestaurantRating(double rating) {
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }
}

public class Restaurant {
    public static void main(String[] args) {
        List<RestaurantRating> ratings = new ArrayList<>();
        ratings.add(new RestaurantRating(4.5));
        ratings.add(new RestaurantRating(7.8));
        ratings.add(new RestaurantRating(6.2));
        ratings.add(new RestaurantRating(3.5));
        ratings.add(new RestaurantRating(9.1));
        ratings.add(new RestaurantRating(2.9));
        ratings.add(new RestaurantRating(8.4));

        int[] ratingRanges = {1, 5, 6, 10}; // Define rating ranges

        Map<String, Integer> countByRange = new HashMap<>();
        Map<String, Double> totalRatingByRange = new HashMap<>();

        // Initialize count and total rating for each range
        for (int i = 0; i < ratingRanges.length - 1; i++) {
            String range = ratingRanges[i] + "-" + ratingRanges[i + 1];
            countByRange.put(range, 0);
            totalRatingByRange.put(range, 0.0);
        }

        // Count restaurants within each range and accumulate ratings
        for (RestaurantRating rating : ratings) {
            double score = rating.getRating();
            for (int i = 0; i < ratingRanges.length - 1; i++) {
                if (score >= ratingRanges[i] && score <= ratingRanges[i + 1]) {
                    String range = ratingRanges[i] + "-" + ratingRanges[i + 1];
                    countByRange.put(range, countByRange.get(range) + 1);
                    totalRatingByRange.put(range, totalRatingByRange.get(range) + score);
                    break;
                }
            }
        }

        // Calculate average rating for each range and print results
        System.out.println("Number of restaurants rated within specific ranges and their average ratings:");
        for (String range : countByRange.keySet()) {
            int count = countByRange.get(range);
            double totalRating = totalRatingByRange.get(range);
            double averageRating = count == 0 ? 0 : totalRating / count;
            System.out.println(range + ": " + count + " restaurants, Average rating: " + averageRating);
        }
    }
}