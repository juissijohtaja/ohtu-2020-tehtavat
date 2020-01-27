/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


public class StatisticsTest {
 
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }
    
    @Test
    public void olematonJoukkueEiLoydy() {
    	Assert.assertTrue(this.stats.team("Unknown").isEmpty());
    }
    
    @Test
    public void pelaajaLoytyy() {
        Assert.assertTrue(this.stats.search("Kurri").getName().contains("Kurri"));
    }
    
    @Test
    public void olematonPelaajaEiLoydy() {
    	Assert.assertNull(this.stats.search("Unknown"));
    }
    
    @Test
    public void oikeaMaaraTopPelaajia() {
        assertEquals(3, stats.topScorers(3).size());
    }
    
    @Test
    public void oikeaMaaraJoukkueenPelaajia() {
        assertEquals(3, this.stats.team("EDM").size());
    }
}
