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

    public static final List<Polygon> tazones = new ArrayList<>();
    public static int[] centrosX = new int[3];
    public static int centroY = 0;

    public static boolean inAnimation = false;

    public static int tazonPremiado = mezclar(10);

    public static void crearTazones(int[] centrosX, int centroY) {
        Tazones.centrosX = centrosX;
        Tazones.centroY = centroY;

        tazones.clear();
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
            r = new Random().nextInt(3) + 1;
        }
        return r;
    }

    // Animaciones

    public static Rectangle oval_premio;

    public static void revelarPremio() {
        inAnimation = true;
        switch (tazonPremiado) {
            case 1 -> oval_premio = new Rectangle(centrosX[0] - 50, centroY, 100, 100);
            case 2 -> oval_premio = new Rectangle(centrosX[1] - 50, centroY, 100, 100);
            case 3 -> oval_premio = new Rectangle(centrosX[2] - 50, centroY, 100, 100);
        }

        tazonPremiado = mezclar(10);
        int tmpCentroY = centroY;

        try {
            while (centroY > tmpCentroY - 110) {
                centroY -= 10;
                Tazones.crearTazones(centrosX, centroY);
                Thread.sleep(1000/30);
            }
            Thread.sleep(1000);
            while (centroY < tmpCentroY) {
                centroY += 10;
                Tazones.crearTazones(centrosX, centroY);
                Thread.sleep(1000/30);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        oval_premio = null;
        inAnimation = false;
    }

    public static void remover(int repeticiones) {
        while (inAnimation)
            tazonPremiado = mezclar(1);

        inAnimation = true;

        try {
            for (int i = 0; i < repeticiones; i++) {
                int t1 = new Random().nextInt(3);
                int t2 = new Random().nextInt(3);

                if (t1 == t2)
                    t2 = (t1+1 > 2) ? t1-1 : t1+1;
                if (t1 > t2) {
                    int aux = t1;
                    t1 = t2;
                    t2 = aux;
                }

                int x1 = centrosX[t1];
                int x2 = centrosX[t2];

                while (centrosX[t1] < x2 && centrosX[t2] > x1) {
                    centrosX[t1] += 10;
                    centrosX[t2] -= 10;

                    int[] X1 = {
                            defaultPolygon[0][0] + centrosX[t1],
                            defaultPolygon[0][1] + centrosX[t1],
                            defaultPolygon[0][2] + centrosX[t1],
                            defaultPolygon[0][3] + centrosX[t1]
                    };
                    int[] Y1 = {
                            defaultPolygon[1][0] + centroY,
                            defaultPolygon[1][1] + centroY,
                            defaultPolygon[1][2] + centroY,
                            defaultPolygon[1][3] + centroY
                    };
                    tazones.set(t1, new Polygon(X1, Y1, 4));

                    int[] X2 = {
                            defaultPolygon[0][0] + centrosX[t2],
                            defaultPolygon[0][1] + centrosX[t2],
                            defaultPolygon[0][2] + centrosX[t2],
                            defaultPolygon[0][3] + centrosX[t2]
                    };
                    int[] Y2 = {
                            defaultPolygon[1][0] + centroY,
                            defaultPolygon[1][1] + centroY,
                            defaultPolygon[1][2] + centroY,
                            defaultPolygon[1][3] + centroY
                    };
                    tazones.set(t2, new Polygon(X2, Y2, 4));

                    Thread.sleep(1000/60);
                }

                centrosX[t1] = x1;
                centrosX[t2] = x2;

                Tazones.crearTazones(centrosX, centroY);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        inAnimation = false;
        IA.seleccionar();
    }

}
