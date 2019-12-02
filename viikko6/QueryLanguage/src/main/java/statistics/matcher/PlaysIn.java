
package statistics.matcher;

import statistics.Player;

public class PlaysIn extends Pino implements Matcher {
    private String team;
    private Pino pino;

    public PlaysIn(Pino pino, String team) {
        this.pino = pino;
        this.team = team;
    }        
    
    @Override
    public boolean matches(Player p) {
        return p.getTeam().contains(team);
    }
    
}
