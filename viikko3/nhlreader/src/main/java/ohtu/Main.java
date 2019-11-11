package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
                
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        System.out.println("Suomalaiset pelaajat " + formatter.format(date) + "\n");

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        List<Player> playersSorted = new ArrayList<>();

        for (Player player : players) {
            if (player.getNationality().equals("FIN")) {
                playersSorted.add(player);
            }
        }   

        Collections.sort(playersSorted);

        for (Player p : playersSorted) {
            System.out.println(p);
        }
    }
}
