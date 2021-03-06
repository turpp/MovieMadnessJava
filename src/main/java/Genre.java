import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbGenre;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;
import java.util.ArrayList;
import java.util.List;

public class Genre extends API {
    public static List<MovieDb> actionMovies = new ArrayList<>();
    public static List<MovieDb> adventureMovies = new ArrayList<>();
    public static List<MovieDb> dramaMovies = new ArrayList<>();
    public static List<MovieDb> thrillerMovies = new ArrayList<>();
    public static List<MovieDb> comedyMovies = new ArrayList<>();
    public static List<MovieDb> horrorMovies = new ArrayList<>();
    public static List<MovieDb> familyMovies = new ArrayList<>();
    public static List<MovieDb> documentaryMovies = new ArrayList<>();

    public static void displayGenres(){
        System.out.println("____________________________________________________________");
        System.out.println("1. Action");
        System.out.println("------------------------------------------------------------");
        System.out.println("____________________________________________________________");
        System.out.println("2. Adventure");
        System.out.println("------------------------------------------------------------");
        System.out.println("____________________________________________________________");
        System.out.println("3. Drama");
        System.out.println("------------------------------------------------------------");
        System.out.println("____________________________________________________________");
        System.out.println("4. Thriller");
        System.out.println("------------------------------------------------------------");
        System.out.println("____________________________________________________________");
        System.out.println("5. Comedy");
        System.out.println("------------------------------------------------------------");
        System.out.println("____________________________________________________________");
        System.out.println("6. Horror");
        System.out.println("------------------------------------------------------------");
        System.out.println("____________________________________________________________");
        System.out.println("7. Family");
        System.out.println("------------------------------------------------------------");
        System.out.println("____________________________________________________________");
        System.out.println("8. Documentary");
        System.out.println("------------------------------------------------------------");


        Navagation.genreSelectorNav();
    }

    public static void displayGenreMovies(List<MovieDb> selectedGenre){
        int n = 1;
        for(MovieDb movie: selectedGenre){
            System.out.println("____________________________________________________________");
            System.out.println(n + " " + movie.getTitle());
            System.out.println("````````````````````````````````````````````````````````````");
            n++;
        }

        Navagation.genreMovieNav(selectedGenre);
    }

    public static List<MovieDb> getUserSelectedGenre(int genreId){
        List<MovieDb> selectedGenre = new ArrayList<>();

        switch (genreId) {
            case 28:
                if(actionMovies.size() == 0) {
                    fetchGenreMovies(28);
                }
                    selectedGenre = actionMovies;
                break;
            case 12:
                if(adventureMovies.size() == 0) {
                    fetchGenreMovies(12);
                }
                    selectedGenre = adventureMovies;
                break;
            case 18:
                if(dramaMovies.size() == 0) {
                    fetchGenreMovies(18);
                }
                    selectedGenre = dramaMovies;

                break;
            case 53:
                if(thrillerMovies.size() == 0) {
                    fetchGenreMovies(53);
                }
                selectedGenre = thrillerMovies;
                break;
            case 35:
                if(comedyMovies.size() == 0) {
                    fetchGenreMovies(35);
                }
                    selectedGenre = comedyMovies;
                break;
            case 27:
                if(horrorMovies.size() == 0) {
                    fetchGenreMovies(27);
                }
                    selectedGenre = horrorMovies;
                break;
            case 10751:
                if(familyMovies.size() == 0) {
                    fetchGenreMovies(10751);
                }
                selectedGenre = familyMovies;
                break;
            case 99:
                if(documentaryMovies.size() == 0) {
                    fetchGenreMovies(99);
                }
                selectedGenre = documentaryMovies;
                break;
        }
        return selectedGenre;
    }


    public static void fetchGenreMovies(int genreId){
        TmdbGenre genre = new TmdbApi(API_KEY).getGenre();
        List<MovieDb> genreMovieList = new ArrayList<>();
        for(int i = 1; i < 4; i++){
            MovieResultsPage genreRequest = genre.getGenreMovies(genreId,"en", i, true);
            List<MovieDb> genreMovies = genreRequest.getResults();
            for (MovieDb movie: genreMovies) {
                genreMovieList.add(movie);
            }
        }

        switch(genreId){
            case 28:
                actionMovies = genreMovieList;
                break;
            case 12:
                adventureMovies = genreMovieList;
                break;
            case 18:
                dramaMovies = genreMovieList;
                break;
            case 53:
                thrillerMovies = genreMovieList;
                break;
            case 35:
                comedyMovies = genreMovieList;
                break;
            case 27:
                horrorMovies = genreMovieList;
                break;
            case 10751:
                familyMovies = genreMovieList;
                break;
            case 99:
                documentaryMovies = genreMovieList;
                break;
        }
    }











    //============================================================================================
//    below are fetches to get movies that have the genre listed first in the list of genres.
//        this requires a second fetch on each movie to get the detailed genre section. This leads to to many fetches
//            looking at one genre for 50 movies could be 200 request. going to switch to a ligher load for now. keeping this incase I want to switch back
//=================================================================================================
//    public static void fetchActionMovies(){
//        //setup for api calls
//        TmdbGenre action = new TmdbApi(API_KEY).getGenre();
//        TmdbMovies getMovieDetail = new TmdbApi(API_KEY).getMovies();
//        //loop till I have 50 movies with action as the main genre or look through 10 pages of results approximately 200 movies
//        for(int i = 1; i <=10 ; i++){
//            MovieResultsPage actionMoviesList = action.getGenreMovies(28,"en", i, true);
//            List<MovieDb> tempList = actionMoviesList.getResults();
////            System.out.println(tempList);
//            //loops through each result list and checks to see if action is main genre type
//            //not sure if I am going to keep it this way. its a lot of api requests.
//            //have to do it this way since getGenreMovies returns any movie that has action in the genres section but does not give you a list of the genres. So we have to make a second detailed request for each movie to get the list of genres to check its main genre.
//            for(MovieDb movie: tempList){
//                MovieDb movieDetail = getMovieDetail.getMovie(movie.getId(), "en");
////                System.out.println(movieDetail.getGenres().get(0).getName().equalsIgnoreCase("Action"));
//                if(movieDetail.getGenres().get(0).getName().equalsIgnoreCase("Action")){
//                    actionMovies.add(movieDetail);
////                    System.out.println(actionMovies);
//                }
//                //stops loop once there are 50  movies
//                if(actionMovies.size() > 49){
//                    break;
//                }
//            }
//            //double check to make sure we do not keep looping past 50 movies
//            if(actionMovies.size() > 49){
//                break;
//            }
//        }
////        System.out.println(actionMovies.size());
//    }
//
//    public static void fetchAdventureMovies(){
//        //setup for api calls
//        TmdbGenre adventure = new TmdbApi(API_KEY).getGenre();
//        TmdbMovies getMovieDetail = new TmdbApi(API_KEY).getMovies();
//        //loop till I have 50 movies with adventure as the main genre or look through 10 pages of results approximately 200 movies
//        for(int i = 1; i <=10 ; i++){
//            MovieResultsPage adventureMoviesList = adventure.getGenreMovies(12,"en", i, true);
//            List<MovieDb> tempList = adventureMoviesList.getResults();
//            //loops through each result list and checks to see if action is main genre type
//            //not sure if I am going to keep it this way. its a lot of api requests.
//            //have to do it this way since getGenreMovies returns any movie that has action in the genres section but does not give you a list of the genres. So we have to make a second detailed request for each movie to get the list of genres to check its main genre.
//            for(MovieDb movie: tempList){
//                MovieDb movieDetail = getMovieDetail.getMovie(movie.getId(), "en");
//                if(movieDetail.getGenres().get(0).getName().equalsIgnoreCase("Adventure")){
//                    adventureMovies.add(movieDetail);
//                }
//                //stops loop once there are 50  movies
//                if(adventureMovies.size() > 49){
//                    break;
//                }
//            }
//            //double check to make sure we do not keep looping past 50 movies
//            if(adventureMovies.size() > 49){
//                break;
//            }
//        }
////        System.out.println(adventureMovies.size());
//    }
//
//    public static void fetchDramaMovies(){
//        //setup for api calls
//        TmdbGenre drama = new TmdbApi(API_KEY).getGenre();
//        TmdbMovies getMovieDetail = new TmdbApi(API_KEY).getMovies();
//        //loop till I have 50 movies with drama as the main genre or look through 10 pages of results approximately 200 movies
//        for(int i = 1; i <=10 ; i++){
//            MovieResultsPage dramaMoviesList = drama.getGenreMovies(18,"en", i, true);
//            List<MovieDb> tempList = dramaMoviesList.getResults();
//            //loops through each result list and checks to see if action is main genre type
//            //not sure if I am going to keep it this way. its a lot of api requests.
//            //have to do it this way since getGenreMovies returns any movie that has drama in the genres section but does not give you a list of the genres. So we have to make a second detailed request for each movie to get the list of genres to check its main genre.
//            for(MovieDb movie: tempList){
//                MovieDb movieDetail = getMovieDetail.getMovie(movie.getId(), "en");
//                if(movieDetail.getGenres().get(0).getName().equalsIgnoreCase("Drama")){
//                    dramaMovies.add(movieDetail);
//                }
//                //stops loop once there are 50  movies
//                if(dramaMovies.size() > 49){
//                    break;
//                }
//            }
//            //double check to make sure we do not keep looping past 50 movies
//            if(dramaMovies.size() > 49){
//                break;
//            }
//        }
//        System.out.println(dramaMovies.size());
//    }
//
//    public static void fetchThrillerMovies(){
//        //setup for api calls
//        TmdbGenre thriller = new TmdbApi(API_KEY).getGenre();
//        TmdbMovies getMovieDetail = new TmdbApi(API_KEY).getMovies();
//        //loop till I have 50 movies with thriller as the main genre or look through 10 pages of results approximately 200 movies
//        for(int i = 1; i <=10 ; i++){
//            MovieResultsPage thrillerMoviesList = thriller.getGenreMovies(53,"en", i, true);
//            List<MovieDb> tempList = thrillerMoviesList.getResults();
//            //loops through each result list and checks to see if action is main genre type
//            //not sure if I am going to keep it this way. its a lot of api requests.
//            //have to do it this way since getGenreMovies returns any movie that has thriller in the genres section but does not give you a list of the genres. So we have to make a second detailed request for each movie to get the list of genres to check its main genre.
//            for(MovieDb movie: tempList){
//                MovieDb movieDetail = getMovieDetail.getMovie(movie.getId(), "en");
//                if(movieDetail.getGenres().get(0).getName().equalsIgnoreCase("Drama")){
//                    thrillerMovies.add(movieDetail);
//                }
//                //stops loop once there are 50  movies
//                if(thrillerMovies.size() > 49){
//                    break;
//                }
//            }
//            //double check to make sure we do not keep looping past 50 movies
//            if(thrillerMovies.size() > 49){
//                break;
//            }
//        }
//        System.out.println(thrillerMovies.size());
//    }
//
//    public static void fetchComedyMovies(){
//        //setup for api calls
//        TmdbGenre comedy = new TmdbApi(API_KEY).getGenre();
//        TmdbMovies getMovieDetail = new TmdbApi(API_KEY).getMovies();
//        //loop till I have 50 movies with thriller as the main genre or look through 10 pages of results approximately 200 movies
//        for(int i = 1; i <=10 ; i++){
//            MovieResultsPage comedyMoviesList = comedy.getGenreMovies(35,"en", i, true);
//            List<MovieDb> tempList = comedyMoviesList.getResults();
//            //loops through each result list and checks to see if action is main genre type
//            //not sure if I am going to keep it this way. its a lot of api requests.
//            //have to do it this way since getGenreMovies returns any movie that has comedy in the genres section but does not give you a list of the genres. So we have to make a second detailed request for each movie to get the list of genres to check its main genre.
//            for(MovieDb movie: tempList){
//                MovieDb movieDetail = getMovieDetail.getMovie(movie.getId(), "en");
//                if(movieDetail.getGenres().get(0).getName().equalsIgnoreCase("Comedy")){
//                    comedyMovies.add(movieDetail);
//                }
//                //stops loop once there are 50  movies
//                if(comedyMovies.size() > 49){
//                    break;
//                }
//            }
//            //double check to make sure we do not keep looping past 50 movies
//            if(comedyMovies.size() > 49){
//                break;
//            }
//        }
//        System.out.println(comedyMovies.size());
//    }
//
//    public static void fetchHorrorMovies(){
//        //setup for api calls
//        TmdbGenre horror = new TmdbApi(API_KEY).getGenre();
//        TmdbMovies getMovieDetail = new TmdbApi(API_KEY).getMovies();
//        //loop till I have 50 movies with horror as the main genre or look through 10 pages of results approximately 200 movies
//        for(int i = 1; i <=10 ; i++){
//            MovieResultsPage horrorMoviesList = horror.getGenreMovies(27,"en", i, true);
//            List<MovieDb> tempList = horrorMoviesList.getResults();
//            //loops through each result list and checks to see if action is main genre type
//            //not sure if I am going to keep it this way. its a lot of api requests.
//            //have to do it this way since getGenreMovies returns any movie that has horror in the genres section but does not give you a list of the genres. So we have to make a second detailed request for each movie to get the list of genres to check its main genre.
//            for(MovieDb movie: tempList){
//                MovieDb movieDetail = getMovieDetail.getMovie(movie.getId(), "en");
//                if(movieDetail.getGenres().get(0).getName().equalsIgnoreCase("Horror")){
//                    horrorMovies.add(movieDetail);
//                }
//                //stops loop once there are 50  movies
//                if(horrorMovies.size() > 49){
//                    break;
//                }
//            }
//            //double check to make sure we do not keep looping past 50 movies
//            if(horrorMovies.size() > 49){
//                break;
//            }
//        }
//        System.out.println(horrorMovies.size());
//    }
//
//    public static void fetchFamilyMovies(){
//        //setup for api calls
//        TmdbGenre family = new TmdbApi(API_KEY).getGenre();
//        TmdbMovies getMovieDetail = new TmdbApi(API_KEY).getMovies();
//        //loop till I have 50 movies with family as the main genre or look through 10 pages of results approximately 200 movies
//        for(int i = 1; i <=10 ; i++){
//            MovieResultsPage familyMoviesList = family.getGenreMovies(10751,"en", i, true);
//            List<MovieDb> tempList = familyMoviesList.getResults();
//            //loops through each result list and checks to see if action is main genre type
//            //not sure if I am going to keep it this way. its a lot of api requests.
//            //have to do it this way since getGenreMovies returns any movie that has family in the genres section but does not give you a list of the genres. So we have to make a second detailed request for each movie to get the list of genres to check its main genre.
//            for(MovieDb movie: tempList){
//                MovieDb movieDetail = getMovieDetail.getMovie(movie.getId(), "en");
//                if(movieDetail.getGenres().get(0).getName().equalsIgnoreCase("Family")){
//                    familyMovies.add(movieDetail);
//                }
//                //stops loop once there are 50  movies
//                if(familyMovies.size() > 49){
//                    break;
//                }
//            }
//            //double check to make sure we do not keep looping past 50 movies
//            if(familyMovies.size() > 49){
//                break;
//            }
//        }
//        System.out.println(familyMovies.size());
//    }
//
//    public static void fetchDocumentaryMovies(){
//        //setup for api calls
//        TmdbGenre documentary = new TmdbApi(API_KEY).getGenre();
//        TmdbMovies getMovieDetail = new TmdbApi(API_KEY).getMovies();
//        //loop till I have 50 movies with documentary as the main genre or look through 10 pages of results approximately 200 movies
//        for(int i = 1; i <=10 ; i++){
//            MovieResultsPage documentaryMoviesList = documentary.getGenreMovies(99,"en", i, true);
//            List<MovieDb> tempList = documentaryMoviesList.getResults();
//            //loops through each result list and checks to see if action is main genre type
//            //not sure if I am going to keep it this way. its a lot of api requests.
//            //have to do it this way since getGenreMovies returns any movie that has documentary in the genres section but does not give you a list of the genres. So we have to make a second detailed request for each movie to get the list of genres to check its main genre.
//            for(MovieDb movie: tempList){
//                MovieDb movieDetail = getMovieDetail.getMovie(movie.getId(), "en");
//                if(movieDetail.getGenres().get(0).getName().equalsIgnoreCase("Documentary")){
//                    documentaryMovies.add(movieDetail);
//                }
//                //stops loop once there are 50  movies
//                if(documentaryMovies.size() > 49){
//                    break;
//                }
//            }
//            //double check to make sure we do not keep looping past 50 movies
//            if(documentaryMovies.size() > 49){
//                break;
//            }
//        }
//        System.out.println(documentaryMovies.size());
//    }


}

