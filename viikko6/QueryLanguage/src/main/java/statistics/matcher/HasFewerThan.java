
package statistics.matcher;

import java.lang.reflect.Method;
import statistics.Player;

public class HasFewerThan extends Pino implements Matcher {
    private Pino pino;
    private int value;
    private String fieldName;

    public HasFewerThan(Pino pino, int value, String category) {
        this.pino = pino;
        this.value = value;
        fieldName = "get"+Character.toUpperCase(category.charAt(0))+category.substring(1, category.length());
    }

    @Override
    public boolean matches(Player p) {
        try {                                    
            Method method = p.getClass().getMethod(fieldName);
            int playersValue = (Integer)method.invoke(p);
            return playersValue<value;
            
        } catch (Exception ex) {
            System.out.println(ex);
            throw new IllegalStateException("Player does not have field "+fieldName.substring(3, fieldName.length()).toLowerCase());
        }       
        
    }    
    
}
