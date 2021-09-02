
import info.movito.themoviedbapi.TmdbDiscover;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.TmdbApi;

import info.movito.themoviedbapi.model.Discover;
import info.movito.themoviedbapi.model.MovieDb;

import info.movito.themoviedbapi.model.core.MovieResultsPage;


import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.net.URL;
import java.net.URLConnection;
import java.util.*;


public class MovieDataFetch extends API {

    public static void main (String[] args) throws Exception {

//        fetchMovieData();
//        convertToObj("hi");
    }

    public static String fetchMovieData () throws Exception {
        URL tmdb = new URL("https://api.themoviedb.org/3/discover/movie?api_key=356630208dd743ca0f8ab6dcc24b36c6&language=en-US&region=us&sort_by=vote_count.desc&include_adult=true&include_video=false&page=#{n}&with_genres=28%7C35%7C53%7C10749%7C18%7C12%7C27%7C878");
        URLConnection apiFetch = tmdb.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                apiFetch.getInputStream()));
        String inputLine = in.readLine();
        in.close();

        return inputLine;

    }

    HashMap<String, String> movieObj = new HashMap<String, String>();

    public void convertToObj(String fetchResults) {


//        TmdbMovies movies = new TmdbApi(API_KEY).getMovies();
//        MovieDb movie = movies.getMovie(5353, "en");
//        MovieResultsPage movie2 = movies.getSimilarMovies(5353, "en",1);
//        List<MovieDb> movieList = movie2.getResults();
//        MovieDb movieAntz = movieList.get(0);


        TmdbDiscover discoverMovies = new TmdbApi(API_KEY).getDiscover();
        Discover discoverGenres = new Discover();
        discoverGenres.withGenres("28");
//        System.out.println(discoverGenres.getParams());
        MovieResultsPage listOfMovies = discoverMovies.getDiscover(discoverGenres);
//        System.out.println(listOfMovies);


        List<MovieDb> actionGenre = listOfMovies.getResults();
        MovieDb firstActionMovie = actionGenre.get(0);

//        System.out.println(firstActionMovie.getId());
//        System.out.println(firstActionMovie.getGenres());

        TmdbMovies movies = new TmdbApi("API_KEY").getMovies();
        MovieDb movie = movies.getMovie(436969, "en");
//        System.out.println(movie.getGenres().get(0).getId());











//        System.out.println(movie);
//        System.out.println(movie2);
//        System.out.println(movieList);
//        System.out.println(movieList.size());
//        System.out.println(movieAntz);
    }
}
