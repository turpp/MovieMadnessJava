import info.movito.themoviedbapi.model.MovieDb;

import java.util.List;
import java.util.Scanner;

public class Navagation {
    static Scanner scan = new Scanner(System.in);

    public static void mainMenuNav(){
        int userInput = scan.nextInt();
        switch (userInput){
            case 1:
                if(RankedPopularity.popularMovieList.size() > 0){
                    RankedPopularity.displayPopularMovies();
                } else {
                    RankedPopularity.fetchMostPopularMovies();
                    RankedPopularity.displayPopularMovies();
                }
            case 2:
                //add logic to fetch genre and display genre
                Genre.displayGenres();
            case 3:
                if(RankedRating.rankedList.size() > 0){
                    RankedRating.displayRankedRating();
                } else {
                    RankedRating.fetchRankedMovies();
                    RankedRating.displayRankedRating();
                }
            case 00:
                break;
        }
    }

    public static void popularSelectionNav(List<MovieDb> popularMovieList){
        int userSelection = scan.nextInt();
        if (userSelection == 0){
            Main.mainMenu();
        }

        if(userSelection >=1 && userSelection <= 200){
            Main.showMovieDetails(popularMovieList.get((userSelection - 1)),"Popular");

        } else {
            System.out.println("Invalid input. Please select movie by index or enter 00 to exit the program.");
            scan.nextInt();
            System.out.println(scan);
        }
    }

    public static void movieDetailMenu(String section){

        System.out.println("____________________________");
        System.out.println(" 1. Back to " + section + " Selection");
        System.out.println(" 2. Back to Main Menu");
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
        if(userInput == 2){
            Main.mainMenu();
        }

        if(userInput == 00){
            System.out.println("Thanks for using Movie Madness!! : )");
            scan.close();
        }


    }

}
