import java.util.HashMap;
import java.util.Set;

/**
 * HashMap
 */
public class HashMatique {
    public static void devonBand() {
    HashMap<String, String> trackList = new HashMap<String, String>();
    trackList.put("Beebop", "Woo Bop");
    trackList.put("Black", "We're back!");
    trackList.put("Welcome", "Hello!");
    trackList.put("Goodbye", "Miss you");
    // get the keys.
        Set<String> keys = trackList.keySet();
        for(String key :trackList.keySet()) {
            System.out.println("The track requested: " + trackList.get("Black"));
        }
    // get track names and lyrics
        for (HashMap.Entry<String, String> t : trackList.entrySet()){
            System.out.println(t.getKey() + ": " + t.getValue());
        }
    }
}