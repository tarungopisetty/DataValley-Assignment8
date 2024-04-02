import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BookReview {
    private int rating;

    public BookReview(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }
}

public class BookReviews {
    public static void main(String[] args) {
        List<BookReview> reviews = new ArrayList<>();
        reviews.add(new BookReview(4));
        reviews.add(new BookReview(8));
        reviews.add(new BookReview(6));
        reviews.add(new BookReview(3));
        reviews.add(new BookReview(9));
        reviews.add(new BookReview(2));
        reviews.add(new BookReview(7));

        int[] ratingRanges = {1, 5, 6, 10}; // Define rating ranges
        Map<String, Integer> countByRatingRange = new HashMap<>();
        countByRatingRange.put("1-5 stars", 0);
        countByRatingRange.put("6-10 stars", 0);

        int positiveCount = 0;
        int neutralCount = 0;
        int negativeCount = 0;

        for (BookReview review : reviews) {
            int rating = review.getRating();

            // Categorize based on rating ranges
            if (rating >= ratingRanges[0] && rating <= ratingRanges[1]) {
                countByRatingRange.put("1-5 stars", countByRatingRange.get("1-5 stars") + 1);
            } else if (rating >= ratingRanges[2] && rating <= ratingRanges[3]) {
                countByRatingRange.put("6-10 stars", countByRatingRange.get("6-10 stars") + 1);
            }

            // Categorize as positive, neutral, or negative based on rating
            if (rating >= 7) {
                positiveCount++;
            } else if (rating >= 4) {
                neutralCount++;
            } else {
                negativeCount++;
            }
        }

        System.out.println("Number of books reviewed within specified rating ranges:");
        for (String range : countByRatingRange.keySet()) {
            System.out.println(range + ": " + countByRatingRange.get(range));
        }

        System.out.println("\nCount of books with positive, neutral, and negative reviews:");
        System.out.println("Positive: " + positiveCount);
        System.out.println("Neutral: " + neutralCount);
        System.out.println("Negative: " + negativeCount);
    }
}