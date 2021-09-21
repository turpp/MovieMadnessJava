import java.util.Scanner;

public class Navagation {
    static Scanner scan = new Scanner(System.in);

    public static void mainMenuNav(){
        int userInput = scan.nextInt();
        switch (userInput){
            case 1:
                if(RankedPopularity.popularMovieList.size() > 0){
                    RankedPopularity.displayPopularMovies();
                } else {
                    RankedPopularity.fetchMostPopularMovies();
                    RankedPopularity.displayPopularMovies();
                }
            case 2:
                //add logic to fetch genre and display genre
                Genre.displayGenres();
            case 3:
                if(RankedRating.rankedList.size() > 0){
                    RankedRating.displayRankedRating();
                } else {
                    RankedRating.fetchRankedMovies();
                    RankedRating.displayRankedRating();
                }
            case 00:
                break;
        }
    }

}
