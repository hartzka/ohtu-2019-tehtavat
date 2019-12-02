package statistics.matcher;

import java.util.LinkedList;
import statistics.Player;

public class Pino implements Matcher {

    private LinkedList<String> alkiot;
    
    private Matcher[] matchers;

    public Pino(Matcher... matchers) {
        this.matchers = matchers;
    }

    public void push(String alkio) {
        alkiot.addFirst(alkio);
    }

    public String pop() {
        return alkiot.remove();
    }

    public boolean empty() {
        return alkiot.isEmpty();
    }

    /*@Override
    public boolean matches(Player p) {
        /*for (Matcher matcher : matchers) {
            if (!matcher.matches(p)) {
                return false;
            }
        }

        return super.m;
    }*/

    @Override
    public boolean matches(Player p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
