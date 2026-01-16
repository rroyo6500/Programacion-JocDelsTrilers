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

        new Thread(() -> {
            while (centroY > 100) {
                try {
                    centroY -= 10;
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

                    Thread.sleep(1000/30);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            while (centroY <= 200) {
                try {
                    centroY += 10;
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

                    Thread.sleep(1000/30);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            inAnimation = false;
        }).start();

    }

    public static void remover(int repeticiones) {

        // Pendiente animacion

    }

}
