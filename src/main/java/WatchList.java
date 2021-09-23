import info.movito.themoviedbapi.model.MovieDb;

import java.util.ArrayList;


public class WatchList {
    ArrayList<MovieDb> watchList = new ArrayList<>();

    public void addMovie(MovieDb movie){
        watchList.add(movie);
    }

    public ArrayList<MovieDb> getWatchList(){
        return watchList;
    }


}
