package TrilersRobertRoyo;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.Override;

public class Mouse {

    public static int[] mousePosition = new int[2];

    public static boolean isClicked = false;

    public static void configureMouse(Component component) {
        component.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                mousePosition = new int[] {e.getX(), e.getY()};
            }
        });

        component.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                isClicked = true;
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                isClicked = false;
            }
        });
    }

    public static void addConfig(Component component, MouseAdapter ma) {
        component.addMouseListener(ma);
        component.addMouseMotionListener(ma);
    }

}
