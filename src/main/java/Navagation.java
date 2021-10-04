import info.movito.themoviedbapi.model.MovieDb;

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
        int userSelection = scan.nextInt();

        if(userSelection >=1 && userSelection <= 200){
            Main.showMovieDetails(popularMovieList.get((userSelection - 1)),section);
        } else if(userSelection == 1111) {
            Main.mainMenu();
        } else if(userSelection == 00){
            System.out.println("Thanks for using Movie Madness!! : )");
            scan.close();
        }
        else {
            System.out.println("Invalid entry. Please enter the number next to the selection you want.");
            System.out.println("`````````````````````````````````````````````````````````````");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("- Enter number next to movie to see more detail.");
            System.out.println("- Enter 1111 to go back to the main menu.");
            System.out.println("- Enter 00 to exit the program.");
            System.out.println("============================================================");
            System.out.println("Section => ");
            Navagation.movieSelectionNav(popularMovieList, "Popular");
        }

    }

    public static void genreMovieNav(List<MovieDb> selectedGenre){
        int userSelection = scan.nextInt();

        if(userSelection >=1 && userSelection <= 60){
            Main.showMovieDetails(selectedGenre.get((userSelection - 1)),"Genre");
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

    public static void movieDetailMenu(String section){

        System.out.println("____________________________");
        System.out.println(" 1. Back to " + section + " Selection");
        System.out.println(" 1111. Back to Main Menu");
        System.out.println(" 00. Exit program");

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
            }
        }
        if(userInput == 1111){
            Main.mainMenu();
        }

        if(userInput == 00){
            System.out.println("Thanks for using Movie Madness!! : )");
            scan.close();
        }


    }

    public static void genreSelectorNav(){
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

    public static void watchListNav(){
        System.out.println("Enter the movie index for more detail or 0 to go back to Main Menu.");
        int userInput = scan.nextInt();
        if(userInput == 0){
            Main.mainMenu();
        }

    }

}
