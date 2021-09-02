
public  class Main {
    public static void main (String[] args) {

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
