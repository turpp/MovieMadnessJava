import com.google.gson.Gson;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;


public class MovieDataFetch {

    public static void main (String[] args) throws Exception {

        fetchMovieData();
        convertToObj(fetchMovieData());
    }

    public static String fetchMovieData () throws Exception {
        URL tmdb = new URL("https://api.themoviedb.org/3/discover/movie?api_key=356630208dd743ca0f8ab6dcc24b36c6&language=en-US&region=us&sort_by=vote_count.desc&include_adult=true&include_video=false&page=#{n}&with_genres=28%7C35%7C53%7C10749%7C18%7C12%7C27%7C878");
        URLConnection apiFetch = tmdb.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                apiFetch.getInputStream()));
        String inputLine = in.readLine();
        in.close();
        System.out.println(inputLine);
        return inputLine;

    }

    HashMap<String, String> movieObj = new HashMap<String, String>();

    public static void convertToObj(String fetchResults){
//        Gson gson = new Gson();
//        System.out.println(gson.fromJson(fetchResults, Object[].class ));

        ArrayList<String>[] myArr = new ArrayList[]{ new ArrayList(1), new ArrayList(2) };
        JSONArray jArr = new JSONArray();
// these will not be wrapped
        jArr.putAll(myArr);
// these will not be wrapped
        jArr.putAll(fetchResults);
// our jArr is now consistent.
        System.out.println(jArr);

    }
}
