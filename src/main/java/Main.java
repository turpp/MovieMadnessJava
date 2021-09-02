import info.movito.themoviedbapi.model.MovieDb;

import java.util.ArrayList;
import java.util.List;

public  class Main {
    public static void main (String[] args) {
        Genre action = new Genre();
        action.fetchFamilyMovies();
    }

    public static void popularMovies(){
        RankedPopularity popularMovies = new RankedPopularity();
        popularMovies.fetchMostPopularMovies();
    }

    public static void RankedMovies(){
        RankedRating rankedMovies = new RankedRating();
        rankedMovies.fetchRankedMovies();
    }

    public static List<MovieDb> moviesByGenre(String type){
        Genre genreMovies = new Genre();
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
