package ohtuesimerkki;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;
import ohtuesimerkki.Statistics;

public class StatisticsTest {

    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
            players.add(new Player("Laine",   "WPG", 50, 40));
            players.add(new Player("Heinola", "WPG", 5, 30));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        stats = new Statistics(readerStub);
    }  

    @Test
    public void testSearchWhenFound() {
        assertEquals("Kurri", stats.search("Kurri").getName());
    }

    @Test
    public void testSearchWhenNotFound() {
        assertEquals(null, stats.search("Selanne"));
    }

    @Test
    public void testTeam() {
        List<Player> team = stats.team("WPG");
        assertEquals(2, team.size());
    }

    @Test
    public void testTopScorers() {
        List<Player> topScorers = stats.topScorers(5);
        assertEquals(6, topScorers.size());
        assertEquals("Gretzky", topScorers.get(0).getName());
    }

}