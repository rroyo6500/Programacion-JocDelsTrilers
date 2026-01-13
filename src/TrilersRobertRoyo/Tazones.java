package TrilersRobertRoyo;

import java.awt.*;

public class Tazones {

    public static Polygon[] tazones = new Polygon[3];
    public static int tazonPremiado = 0;

    public static void intercambiarTazones (int t1, int t2) {

        Polygon[] temp = {tazones[t1-1], tazones[t2-1]};

        boolean T1_greater_T2 = tazones[t1-1].getBounds().x > tazones[t2-1].getBounds().x;

        try {
            while (
                    !tazones[t1-1].getBounds().equals(temp[1].getBounds()) ||
                    !tazones[t2-1].getBounds().equals(temp[0].getBounds())
            ) {

                if (T1_greater_T2) {

                }

            }

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
