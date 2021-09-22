import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbDiscover;
import info.movito.themoviedbapi.model.Discover;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RankedRating extends API {

    public static List<MovieDb> rankedList = new ArrayList<>();

    public static void fetchRankedMovies(){
        //adds api to request
        TmdbDiscover discoverRankedMovies = new TmdbApi(API_KEY).getDiscover();
        //create discover object and add params for api request
        Discover discoverRanked = new Discover();
        discoverRanked.sortBy("vote_average.desc");
        discoverRanked.language("en");
        discoverRanked.includeAdult(false);
        discoverRanked.voteCountGte(500);

        int n = 1;
        while(n < 11) {
            discoverRanked.page(n);
            MovieResultsPage RankedMovies = discoverRankedMovies.getDiscover(discoverRanked);
            List<MovieDb> tempList = RankedMovies.getResults();
            for(MovieDb movie: tempList){
                rankedList.add(movie);
            }
            n++;
        }

    }

    public static void displayRankedRating(){
        int n = 1;
        for(MovieDb movie: rankedList){
            System.out.println("____________________________________________________________");
            System.out.println(n + " " + movie.getTitle());
            System.out.println("````````````````````````````````````````````````````````````");
            n++;
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("- Enter number next to movie to see more detail.");
        System.out.println("- Enter 1111 to go back to the main menu.");
        System.out.println("- Enter 00 to exit the program.");
        System.out.println("============================================================");
        System.out.println("Selection => ");
        Navagation.movieSelectionNav(rankedList, "Rating");

    }






}
