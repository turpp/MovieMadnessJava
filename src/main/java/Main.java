
public  class Main {
    public static void main (String[] args) {
        Genre action = new Genre();
        action.fetchActionMovies();
    }

    public static void popularMovies(){
        RankedPopularity popularMovies = new RankedPopularity();
        popularMovies.fetchMostPopularMovies();
    }

    public static void RankedMovies(){
        RankedRating rankedMovies = new RankedRating();
        rankedMovies.fetchRankedMovies();
    }
}
