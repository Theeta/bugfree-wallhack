
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class StatisticsTest {
    
    Statistics stats;
    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };
    
    public StatisticsTest() {
    }
    
    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }

    /**
     * Test of search method, of class Statistics.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        String name = "Kurri";
        Player result = stats.search(name);
        assertEquals("Kurri", result.getName());
        assertEquals("EDM", result.getTeam());
        assertEquals(37, result.getGoals());
        assertEquals(53, result.getAssists());
    }
    
    @Test
    public void testNullSearch() {
        System.out.println("search");
        String name = "Hermanni";
        Player result = stats.search(name);
        assertNull(result);
        
    }

    /**
     * Test of team method, of class Statistics.
     */
    @Test
    public void testTeam() {
        System.out.println("team");
        String teamName = "EDM";
        List<Player> result = stats.team(teamName);
        assertEquals(3, result.size());
        assertEquals("Semenko", result.get(0).getName());
    }

    /**
     * Test of topScorers method, of class Statistics.
     */
    @Test
    public void testTopScorers() {
        System.out.println("topScorers");
        int howMany = 1;
        List<Player> result = stats.topScorers(howMany);
        assertEquals("Gretzky", result.get(0).getName());
        
    }
    
}
