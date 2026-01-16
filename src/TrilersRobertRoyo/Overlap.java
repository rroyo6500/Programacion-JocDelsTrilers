package TrilersRobertRoyo;

import java.awt.*;

public class Overlap {

    public static boolean o(int[] coords, Polygon polygon) {
        return polygon.contains(coords[0], coords[1]);
    }

}
