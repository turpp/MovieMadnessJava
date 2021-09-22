import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbDiscover;
import info.movito.themoviedbapi.model.Discover;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.Scanner;

public class RankedPopularity extends API {

    public static List<MovieDb> popularMovieList = new ArrayList<>();


    public static void fetchMostPopularMovies () {
        //List of 200 movies sorted my popularity descending
        List<MovieDb> popularList = new ArrayList<>();

        //adds api to request
        TmdbDiscover discoverMovies = new TmdbApi(API_KEY).getDiscover();
        //create discover object and add params for api request
        Discover discoverPopular = new Discover();
//        discoverPopular.page(1);
        discoverPopular.sortBy("popularity.desc");
        discoverPopular.language("en");
        discoverPopular.includeAdult(false);
        //sends request to api and gets results and makes an ArrayList of results

//        make a while loop to get 200 movies from search
        int n = 1;
        while(n < 11) {
            discoverPopular.page(n);
            MovieResultsPage popularMovies = discoverMovies.getDiscover(discoverPopular);
            List<MovieDb> tempList = popularMovies.getResults();
            for(MovieDb movie: tempList){
                popularList.add(movie);
            }
            n++;
        }

        popularMovieList = popularList;

    }

    public static void displayPopularMovies(){
        int n = 1;
        for(MovieDb movie: popularMovieList){
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
        Navagation.movieSelectionNav(popularMovieList, "Popular");
    }


}
