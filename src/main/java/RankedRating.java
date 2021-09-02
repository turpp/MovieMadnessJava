import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbDiscover;
import info.movito.themoviedbapi.model.Discover;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;

import java.util.ArrayList;
import java.util.List;

public class RankedRating extends API {

    public RankedRating(){

    }

    public void fetchRankedMovies(){
        List<MovieDb> RankedList = new ArrayList<>();

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
                RankedList.add(movie);
            }
            n++;
        }

    }






}
