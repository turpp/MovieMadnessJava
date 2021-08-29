import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;


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

        return inputLine;

    }

    HashMap<String, String> movieObj = new HashMap<String, String>();

    public static void convertToObj(String fetchResults) throws ParseException {

        Object obj = new JSONParser().parse(fetchResults);

        JSONObject jo = (JSONObject) obj;


        //with this i can add multiple fetches to one array list to iterate through
        ArrayList <Object> ftest = new ArrayList<>();
        ftest.add(jo.get("results"));

        System.out.println(jo.get("results").getClass());
        //getting in array
//        JSONArray ja = (JSONArray) jo.get("results");
//        Iterator itr2 = ja.iterator();
//        Map address = ((Map)jo.get("results"));
//        Iterator<Map.Entry> itr1 = address.entrySet().iterator();
//
//        while (itr2.hasNext())
//        {
//            itr1 = ((Map) itr2.next()).entrySet().iterator();
//            while (itr1.hasNext()) {
//                Map.Entry pair = itr1.next();
//                System.out.println(pair.getKey() + " : " + pair.getValue());
//            }
//        }

        System.out.println(ftest.get(0));



    }
}
