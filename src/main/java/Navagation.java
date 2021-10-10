import info.movito.themoviedbapi.model.MovieDb;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Navagation {
    static Scanner scan = new Scanner(System.in);

    public static void mainMenuNav(){
        int userInput = scan.nextInt();
        switch (userInput){
            case 1:
                if(RankedPopularity.popularMovieList.size() == 0){
                    RankedPopularity.fetchMostPopularMovies();
                }
                RankedPopularity.displayPopularMovies();
                break;
            case 2:
                Genre.displayGenres();
            case 3:
                if(RankedRating.rankedList.size() == 0){
                    RankedRating.fetchRankedMovies();
                }
                    RankedRating.displayRankedRating();
                break;
            case 4:
                WatchList.displayWatchList();
            case 00:
                System.out.println("Thanks for using Movie Madness!! : )");
                scan.close();
                break;
            default:
                System.out.println("Invalid entry. Please enter the number next to the selection you want.");
                System.out.println("`````````````````````````````````````````````````````````````");
                System.out.println("Selection => ");
                mainMenuNav();
        }
    }

    public static void movieSelectionNav(List<MovieDb> popularMovieList, String section){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("- Enter number next to movie to see more detail.");
        System.out.println("- Enter 1111 to go back to the main menu.");
        System.out.println("- Enter 00 to exit the program.");
        System.out.println("============================================================");
        System.out.println("Selection => ");

        int userSelection = scan.nextInt();

        if(userSelection >=1 && userSelection <= 200){
            Main.showMovieDetails(popularMovieList.get((userSelection - 1)),section, userSelection);
        } else if(userSelection == 1111) {
            Main.mainMenu();
        } else if(userSelection == 00){
            System.out.println("Thanks for using Movie Madness!! : )");
            scan.close();
        }
        else {
            System.out.println("Invalid entry. Please enter the number next to the selection you want.");
            System.out.println("`````````````````````````````````````````````````````````````");

            Navagation.movieSelectionNav(popularMovieList, section);
        }
    }

    public static void genreMovieNav(List<MovieDb> selectedGenre){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("- Enter number next to movie to see more detail.");
        System.out.println("- Enter 1111 to go back to the main menu.");
        System.out.println("- Enter 00 to exit the program.");
        System.out.println("============================================================");
        System.out.println("Selection => ");

        int userSelection = scan.nextInt();

        if(userSelection >=1 && userSelection <= 60){
            Main.showMovieDetails(selectedGenre.get((userSelection - 1)),"Genre", userSelection);
        } else if(userSelection == 1111){
            Main.mainMenu();
        } else if(userSelection == 00){
            System.out.println("Thanks for using Movie Madness!! : )");
            scan.close();
        }
        else {
            System.out.println("Invalid entry. Please enter the number next to the selection you want.");
            System.out.println("```````````````````````````````````````````````````````````````````````");
            System.out.println("Selection => ");
            genreMovieNav(selectedGenre);
        }
    }

    public static void movieDetailMenu(String section, MovieDb movie, int index){

        if(section.equals("Watch List")){
            System.out.println("____________________________");
            System.out.println(" 1. Back to " + section);
            System.out.println(" 2222. Delete from Watch List");
            System.out.println(" 1111. Back to Main Menu");
            System.out.println(" 00. Exit program");

        } else {
            System.out.println("____________________________");
            System.out.println(" 1. Back to " + section + " Selection");
            System.out.println(" 2. Add to watch List");
            System.out.println(" 1111. Back to Main Menu");
            System.out.println(" 00. Exit program");
        }

        int userInput = scan.nextInt();
        if(userInput == 1){
            switch(section){
                case "Popular":
                    RankedPopularity.displayPopularMovies();
                    break;
                case "Rating":
                    RankedRating.displayRankedRating();
                    break;
                case "Genre":
                    Genre.displayGenres();
                    break;
                case "Watch List":
                    WatchList.displayWatchList();
            }
        }
        if(userInput == 1111){
            Main.mainMenu();
        }

        if(userInput == 00){
            System.out.println("Thanks for using Movie Madness!! : )");
            scan.close();
        }

        if(userInput == 2){
            WatchList.addMovie(movie);
            Main.mainMenu();
        }

        if(userInput == 2222){
            WatchList.removeMovie(index - 1);
            WatchList.displayWatchList();
        }
    }

    public static void genreSelectorNav(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("- Enter number next to Genre to see movies.");
        System.out.println("- Enter 1111 to go back to the main menu.");
        System.out.println("- Enter 00 to exit the program.");
        System.out.println("============================================================");
        System.out.println("Selection =>  ");

        int userInput = scan.nextInt();
        switch (userInput){
            case 1:
                Genre.displayGenreMovies(Genre.getUserSelectedGenre(28));
                break;
            case 2:
                Genre.displayGenreMovies(Genre.getUserSelectedGenre(12));
                break;
            case 3:
                Genre.displayGenreMovies(Genre.getUserSelectedGenre(18));
                break;
            case 4:
                Genre.displayGenreMovies(Genre.getUserSelectedGenre(53));
                break;
            case 5:
                Genre.displayGenreMovies(Genre.getUserSelectedGenre(35));
                break;
            case 6:
                Genre.displayGenreMovies(Genre.getUserSelectedGenre(27));
                break;
            case 7:
                Genre.displayGenreMovies(Genre.getUserSelectedGenre(10751));
                break;
            case 8:
                Genre.displayGenreMovies(Genre.getUserSelectedGenre(99));
                break;
            case 1111:
                Main.mainMenu();
                break;
            case 00:
                System.out.println("Thanks for using Movie Madness!! : )");
                scan.close();
                break;
            default:
                System.out.println("Invalid entry. Please enter the number next to the selection you want.");
                System.out.println("```````````````````````````````````````````````````````````````````````");
                System.out.println("Selection => ");
                genreSelectorNav();
        }
    }

    public static void watchListNav(ArrayList<MovieDb> watchList){
        if(WatchList.getWatchList().size()==0){
            System.out.println("");
            System.out.println("Enter 0 to go back to Main Menu");
            System.out.println("=>");
            int userInput = scan.nextInt();
            if(userInput == 0){
                Main.mainMenu();
            } else {
                System.out.println("Invalid input. Try again.");
                Navagation.watchListNav(watchList);
            }
        }
        System.out.println("");
        System.out.println("Enter the movie index for more detail or 0 to go back to Main Menu.");
        System.out.println("=>");
        int userInput = scan.nextInt();
        if(userInput == 0){
            Main.mainMenu();
        }
        if(userInput > 0 &&  userInput <= watchList.size()){
            Main.showMovieDetails(watchList.get(userInput - 1), "Watch List", userInput);
        }
    }

}
