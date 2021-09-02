import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbGenre;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;

import java.util.ArrayList;
import java.util.List;

public class Genre extends API {

    public Genre(){

    }
//    public String name;
//    public int tmdbId;
    List<MovieDb> actionMovies = new ArrayList<>();
    List<MovieDb> adventureMovies = new ArrayList<>();
    List<MovieDb> dramaMovies = new ArrayList<>();
    List<MovieDb> sciFiMovies = new ArrayList<>();
    List<MovieDb> thrillerMovies = new ArrayList<>();
    List<MovieDb> comedyMovies = new ArrayList<>();
    List<MovieDb> horrorMovies = new ArrayList<>();
    List<MovieDb> familyMovies = new ArrayList<>();
    List<MovieDb> mysteryMovies = new ArrayList<>();
    List<MovieDb> documentaryMovies = new ArrayList<>();

//    public Genre(String name, int id){
//        this.name = name;
//        tmdbId = id;
//    }

    public void fetchActionMovies(){
//setup for api calls
        TmdbGenre action = new TmdbApi(API_KEY).getGenre();
        TmdbMovies getMovieDetail = new TmdbApi(API_KEY).getMovies();
        //loop till I have 50 movies with action as the main genre or look through 10 pages of results approximately 200 movies
        for(int i = 1; i <=10 ; i++){
            MovieResultsPage actionMoviesList = action.getGenreMovies(28,"en", i, true);
            List<MovieDb> tempList = actionMoviesList.getResults();
//            System.out.println(tempList);
            //loops through each result list and checks to see if action is main genre type
            //not sure if I am going to keep it this way. its a lot of api requests.
            //have to do it this way since getGenreMovies returns any movie that has action in the genres section but does not give you a list of the genres. So we have to make a second detailed request for each movie to get the list of genres to check its main genre.
            for(MovieDb movie: tempList){
                MovieDb movieDetail = getMovieDetail.getMovie(movie.getId(), "en");
//                System.out.println(movieDetail.getGenres().get(0).getName().equalsIgnoreCase("Action"));
                if(movieDetail.getGenres().get(0).getName().equalsIgnoreCase("Action")){
                    actionMovies.add(movieDetail);
//                    System.out.println(actionMovies);
                }
                //stops loop once there are 50  movies
                if(actionMovies.size() > 49){
                    break;
                }
            }
            //double check to make sure we do not keep looping past 50 movies
            if(actionMovies.size() > 49){
                break;
            }
        }
//        System.out.println(actionMovies.size());
    }


}

