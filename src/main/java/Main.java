import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.MovieDb;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public  class Main extends API {
    public static RankedRating rankedMovies = new RankedRating();
    public static void main (String[] args) {
        System.out.println("----------------------");
        System.out.println("Welcome to Movie Madness!");
        System.out.println("----------------------");
        System.out.println("Instructions: To progress through the application, please type the number for your selection and press enter. If at anytime you wish to close the program, type 00 and press enter.");
        System.out.println("");

        mainMenu();
    }


  public static void mainMenu(){
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println("How would you like to view the movies?");
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println("");
      System.out.println("1. Ranked by Popularity");
      System.out.println("2. Grouped by Genre");
      System.out.println("3. Movies by Rating");
      System.out.println("`````````````````````````````````````````````````````````````");

      Scanner scan = new Scanner(System.in);
      System.out.println("Selection =>  ");
      int userInput = scan.nextInt();
      switch (userInput){
          case 1:
             if(RankedPopularity.popularMovieList.size() > 0){
                 RankedPopularity.displayPopularMovies(RankedPopularity.popularMovieList);
             } else {
                 RankedPopularity.fetchMostPopularMovies();
                 RankedPopularity.displayPopularMovies(RankedPopularity.popularMovieList);
             }

//          case 2:
//              getRatingMovies();
//              displayRatingMovies(rankedMovies.getRankedList());



          case 00:
              break;


      }


  }

    public static void showMovieDetails (MovieDb movie){
        TmdbMovies getMovieDetails = new TmdbApi(API_KEY).getMovies();
        MovieDb movieDetail = getMovieDetails.getMovie(movie.getId(), "en");

        System.out.println("============================================================");
        System.out.println("Title: " + movieDetail.getTitle());
        int numGenres = movieDetail.getGenres().size();
        switch (numGenres){
            case 2:
                System.out.println("Genre: " + movieDetail.getGenres().get(0).getName() + " " + movieDetail.getGenres().get(1).getName());
                break;
            case 3:
                System.out.println("Genre: " + movieDetail.getGenres().get(0).getName() + " " + movieDetail.getGenres().get(1).getName() + " " + movieDetail.getGenres().get(2).getName());
                break;
            case 0:
                System.out.println("Sorry, Genre is not on record for this film.");
                break;
            default:
                System.out.println("Genre: " + movieDetail.getGenres().get(0).getName());

        }

        System.out.println("Vote Average: " + movieDetail.getVoteAverage());
        System.out.println("Total Votes: " + movieDetail.getVoteCount());
        System.out.println("Overview: ");
        System.out.println(movieDetail.getOverview());
        System.out.println("");
        System.out.println("____________________________");
        System.out.println(" 1. Back to Movie Selection");
        System.out.println(" 2. Back to Main Menu");
        System.out.println(" 00. Exit program");

        Scanner afterDetail = new Scanner(System.in);
        int userInput = afterDetail.nextInt();

        switch (userInput){
            case 1:
                RankedPopularity.displayPopularMovies(RankedPopularity.popularMovieList);
                break;
            case 2:
                mainMenu();
                break;
            case 00:
                break;
        }


    }



    public static List<MovieDb> moviesByGenre(Genre genreMovies, String type){

        List<MovieDb> selectedGenre = new ArrayList<>();

         switch (type) {
            case "action":
                if(genreMovies.actionMovies.size() > 0) {
                    genreMovies.fetchActionMovies();
                    selectedGenre = genreMovies.actionMovies;
                }
                selectedGenre = genreMovies.actionMovies;
                break;
            case "adventure":
                if(genreMovies.adventureMovies.size() > 0) {
                    genreMovies.fetchAdventureMovies();
                    selectedGenre = genreMovies.adventureMovies;
                }
                selectedGenre = genreMovies.adventureMovies;
            break;
            case "drama":
                if(genreMovies.dramaMovies.size() > 0) {
                    genreMovies.fetchDramaMovies();
                    selectedGenre = genreMovies.dramaMovies;
                }
                selectedGenre = genreMovies.dramaMovies;
            break;
            case "thriller":
                if(genreMovies.thrillerMovies.size() > 0) {
                    genreMovies.fetchThrillerMovies();
                    selectedGenre = genreMovies.thrillerMovies;
                }
                selectedGenre = genreMovies.thrillerMovies;
            break;
            case "comedy":
                if(genreMovies.comedyMovies.size() > 0) {
                    genreMovies.fetchComedyMovies();
                    selectedGenre = genreMovies.comedyMovies;
                }
                selectedGenre = genreMovies.comedyMovies;
            break;
            case "horror":
                if(genreMovies.horrorMovies.size() > 0) {
                    genreMovies.fetchHorrorMovies();
                    selectedGenre = genreMovies.horrorMovies;
                }
                selectedGenre = genreMovies.horrorMovies;
            break;
            case "family":
                if(genreMovies.familyMovies.size() > 0) {
                    genreMovies.fetchFamilyMovies();
                    selectedGenre = genreMovies.familyMovies;
                }
                selectedGenre = genreMovies.familyMovies;
            break;
            case "documentary":
                if(genreMovies.documentaryMovies.size() > 0) {
                    genreMovies.fetchDocumentaryMovies();
                    selectedGenre = genreMovies.documentaryMovies;
                }
                selectedGenre = genreMovies.documentaryMovies;
            break;
        }
        return selectedGenre;
    }

}
