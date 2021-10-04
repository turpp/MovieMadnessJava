import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.MovieDb;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public  class Main extends API {

    public static void main (String[] args) {

        System.out.println("--------------------------");
        System.out.println("Welcome to Movie Madness!");
        System.out.println("--------------------------");
        System.out.println("Instructions: ");
        System.out.println("=> To progress through the application, please type the number for your selection and press enter.");
        System.out.println("=> If at anytime you wish to close the program, type 00 and press enter.");
        System.out.println("=> If at anytime you wish to go back to the main menu, type 1111 and press enter.");
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
      System.out.println("4. View Watch List");
      System.out.println("`````````````````````````````````````````````````````````````");


      System.out.println("Selection =>  ");
      //enter nav function
      Navagation.mainMenuNav();
  }

    public static void showMovieDetails (MovieDb movie, String section){
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
            case 4:
                System.out.println("Genre: " + movieDetail.getGenres().get(0).getName() + " " + movieDetail.getGenres().get(1).getName() + " " + movieDetail.getGenres().get(2).getName() + " " + movieDetail.getGenres().get(3).getName());
                break;
            case 5:
                System.out.println("Genre: " + movieDetail.getGenres().get(0).getName() + " " + movieDetail.getGenres().get(1).getName() + " " + movieDetail.getGenres().get(2).getName() + " " + movieDetail.getGenres().get(3).getName() + " " + movieDetail.getGenres().get(4).getName());
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
        //put in movie detail menu here
        Navagation.movieDetailMenu(section, movieDetail);
//        System.out.println("____________________________");
//        System.out.println(" 1. Back to Movie Selection");
//        System.out.println(" 2. Back to Main Menu");
//        System.out.println(" 00. Exit program");
//        detailMenu(section);
    }

    public static void detailMenu(String section){
        switch (section){
            case "popular":
                Scanner afterDetail = new Scanner(System.in);
                int userInput = afterDetail.nextInt();

                switch (userInput){
                    case 1:
                        RankedPopularity.displayPopularMovies();
                        break;
                    case 2:
                        mainMenu();
                        break;
                    case 00:
                        break;
                }
            case "rating":
                Scanner afterRatingDetail = new Scanner(System.in);
                int userRatingInput = afterRatingDetail.nextInt();

                switch (userRatingInput){
                    case 1:
                        RankedRating.displayRankedRating();
                        break;
                    case 2:
                        mainMenu();
                        break;
                    case 00:
                        break;
                }
            case "genre":
                Scanner afterGenreDetail = new Scanner(System.in);
                int userGenreInput = afterGenreDetail.nextInt();

                switch (userGenreInput){
                    case 1:
                        Genre.displayGenres();
                        break;
                    case 2:
                        mainMenu();
                        break;
                    case 00:
                        break;
                }
        }
    }



}
