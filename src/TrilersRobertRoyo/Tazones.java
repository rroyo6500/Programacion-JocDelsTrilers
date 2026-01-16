package TrilersRobertRoyo;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tazones {

    public static int[][] defaultPolygon = {
            // X
            {
                -50, 50, 100, -100
            },
            // Y
            {
                -100, -100, 100, 100
            },
            // Center
            {0, 0}
    };

    public static List<Polygon> tazones = new ArrayList<>();
    public static int[] centrosX = new int[3];
    public static int centroY = 0;

    public static int tazonPremiado = mezclar(10);

    public static void crearTazones(int[] centrosX, int centroY) {
        Tazones.centrosX = centrosX;
        Tazones.centroY = centroY;

        for (int i = 0; i < 3; i++) {
            int[] X = {
                    defaultPolygon[0][0] + centrosX[i],
                    defaultPolygon[0][1] + centrosX[i],
                    defaultPolygon[0][2] + centrosX[i],
                    defaultPolygon[0][3] + centrosX[i]
            };
            int[] Y = {
                    defaultPolygon[1][0] + centroY,
                    defaultPolygon[1][1] + centroY,
                    defaultPolygon[1][2] + centroY,
                    defaultPolygon[1][3] + centroY
            };
            tazones.add(new Polygon(X, Y, 4));
        }
    }

    public static int mezclar (int repeticiones) {
        int r = 0;
        for (int i = 0; i < repeticiones; i++) {
            r = new Random().nextInt(3);
        }
        return r;
    }

}
