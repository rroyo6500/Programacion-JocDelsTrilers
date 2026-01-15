package TrilersRobertRoyo;

import java.awt.*;

public class Tazones {

    public static Polygon[] tazones = new Polygon[3];
    public static int[] _centrosX = new int[3];
    public static int centroY = 0;
    public static int tazonPremiado = 0;

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

    public static void crearTazones (int[] centrosX, int Y) {
        _centrosX = centrosX;
        centroY = Y;
        for (int i = 0; i < centrosX.length; i++) {
            int[] x = {
                    defaultPolygon[0][0] + centrosX[i],
                    defaultPolygon[0][1] + centrosX[i],
                    defaultPolygon[0][2] + centrosX[i],
                    defaultPolygon[0][3] + centrosX[i]
            };
            int[] y = {
                    defaultPolygon[1][0] + Y,
                    defaultPolygon[1][1] + Y,
                    defaultPolygon[1][2] + Y,
                    defaultPolygon[1][3] + Y
            };
            tazones[i] = new Polygon(x, y, 4);
        }
    }

    public static void intercambiarTazones (int t1, int t2) {

        Polygon[] temp = {tazones[t1-1], tazones[t2-1]};

        boolean T1_greater_T2 = tazones[t1-1].getBounds().x > tazones[t2-1].getBounds().x;

        try {



            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
