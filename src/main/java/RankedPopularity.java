import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbDiscover;
import info.movito.themoviedbapi.model.Discover;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;

import java.util.ArrayList;
import java.util.List;

public class RankedPopularity extends API {

    public RankedPopularity(){

    }

    public void fetchMostPopularMovies () {
        List<MovieDb> popularList = new ArrayList<>();
        //
        TmdbDiscover discoverMovies = new TmdbApi(API_KEY).getDiscover();
        Discover discoverPopular = new Discover();
        discoverPopular.page(1);
        discoverPopular.sortBy("popularity.desc");
        discoverPopular.language("en");
        discoverPopular.includeAdult(false);
        MovieResultsPage popularMovies = discoverMovies.getDiscover(discoverPopular);
        List<MovieDb> tempList = popularMovies.getResults();
        System.out.println(tempList);

    }






}
