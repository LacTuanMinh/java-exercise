package coaching.csv;

import java.util.HashMap;
import java.util.Map;

/**
 * Supplies information about CSV line
 */
public class CsvLine {

    private final Map<Integer,String> segments = new HashMap<>();

    /**
     * Get data at specific position in a row
     *
     * @param index Position of segment
     * @return Data
     */
    public String get(int index) {
        if(segments.containsKey(index))
            return segments.get(index);

        return null;
    }

    /**
     * Set data in a specific position
     *
     * @param position Position
     * @param data     Data
     */
    public void set(int position, String data) {

        this.segments.put(position,data);
    }

    public Map<Integer, String> getSegments() {
        return segments;
    }
}
