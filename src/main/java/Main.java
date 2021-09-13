import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.MovieDb;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public  class Main extends API {
    public static RankedPopularity popularMovies = new RankedPopularity();
    public static RankedRating rankedMovies = new RankedRating();
    public static void main (String[] args) {
//        RankedPopularity popularMovies = new RankedPopularity();

        System.out.println("----------------------");
        System.out.println("Welcome to Movie Madness!");
        System.out.println("----------------------");
        System.out.println("Instructions: To progress through the application, please type the number for your selection and press enter. If at anytime you wish to close the program, type 00 and press enter.");
        System.out.println("");

        mainMenu(popularMovies);

//        while(true){
//            Scanner scan = new Scanner(System.in);
//            System.out.println("Selection:");
//            int userInput = scan.nextInt();
//            switch (userInput){
//                case 1:
//                    popularMovies(popularMovies);
//                    displayPopularMovies(popularMovies.popularMovieList);
//
//
//
//            }
//            if(userInput == 00){
//                break;
//            }
//
//        }

    }


  public static void mainMenu(RankedPopularity popularMovies){
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
              getPopularMovies(popularMovies);
              displayPopularMovies(popularMovies.popularMovieList, popularMovies);
          case 2:
              getRatingMovies();
              displayRatingMovies(rankedMovies.getRankedList());



          case 00:
              break;


      }


  }







    public static void getPopularMovies(RankedPopularity popularMovies){
        if(popularMovies.popularMovieList.size() == 0) {
            popularMovies.fetchMostPopularMovies();
        }
    }

    public static void displayPopularMovies(List<MovieDb> popularMovieList, RankedPopularity popularMovies){
        int n = 1;
        for(MovieDb movie: popularMovieList){
            System.out.println("____________________________________________________________");
            System.out.println(n + " " + movie.getTitle());
            System.out.println("````````````````````````````````````````````````````````````");
            n++;
        }

        Scanner scan = new Scanner(System.in);
        System.out.println("Section => ");
        int userSelection = scan.nextInt();
        if (userSelection == 0){
            mainMenu(popularMovies);
        }

        if(userSelection >=1 && userSelection <= 200){
            movieDetails(popularMovieList.get((userSelection - 1)));

        } else {
            System.out.println("Invalid input. Please select movie by index or enter 00 to exit the program.");
            scan.nextInt();
            System.out.println(scan);


        }
    }






    public static void movieDetails (MovieDb movie){
        TmdbMovies getMovieDetails = new TmdbApi(API_KEY).getMovies();
        MovieDb movieDetail = getMovieDetails.getMovie(movie.getId(), "en");

        System.out.println("============================================================");
        System.out.println("Title: " + movieDetail.getTitle());
        System.out.println("Genre: " + movieDetail.getGenres().get(0).getName() + " " + movieDetail.getGenres().get(1).getName());
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
                displayPopularMovies(popularMovies.popularMovieList, popularMovies);
            case 2:
                mainMenu(popularMovies);
            case 00:
                break;
        }


    }












    public static void getRatingMovies(){
        if(rankedMovies.getRankedList().size() == 0) {
            rankedMovies.fetchRankedMovies();
        }
    }

    public static void displayRatingMovies(List<MovieDb> ratingList) {
        int n = 1;
        for (MovieDb movie : ratingList) {
            System.out.println("____________________________________________________________");
            System.out.println(n + " " + movie.getTitle());
            System.out.println("````````````````````````````````````````````````````````````");
            n++;
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("Section => ");
        int userSelection = scan.nextInt();

        if (userSelection >= 1 && userSelection <= 200) {
            movieDetails(ratingList.get((userSelection - 1)));
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
