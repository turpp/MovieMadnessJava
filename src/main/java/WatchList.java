import info.movito.themoviedbapi.model.MovieDb;

import java.util.ArrayList;


public class WatchList {
    //working on if i need a constructor and have a watchlist object or use it as a class and just add to it.
    private static ArrayList<MovieDb> watchList = new ArrayList<>();


    public static void addMovie(MovieDb movie){
        watchList.add(movie);
    }

    public ArrayList<MovieDb> getWatchList(){
        return watchList;
    }

    public static void displayWatchList(){
        int i = 1;
        if(watchList.size() == 0){
            System.out.println("List is empty. View movies and add them to your list.");
        } else {
            for (MovieDb movie: watchList) {
                System.out.println(i+"." + " " + movie.getTitle());
                i++;
            }
        }
        Navagation.watchListNav();
    }

}
