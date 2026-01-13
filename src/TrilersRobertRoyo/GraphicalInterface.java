package TrilersRobertRoyo;

import javax.swing.*;
import java.awt.*;

public class GraphicalInterface extends JFrame {

    public static JPanel panel = new JPanel(){
        @Override
        public void paint(Graphics g){
            super.paint(g);
        }
    };

    public static void GameInterface(){
        JFrame gameInterface = new JFrame();
        gameInterface.setLayout(null);



        gameInterface.setTitle("Juego del Trilero");
        gameInterface.setBounds(0, 0, 600, 500);
        gameInterface.setResizable(false);
        gameInterface.setLocationRelativeTo(null);
        gameInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameInterface.setVisible(true);
    }

    public GraphicalInterface () {
        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));



        setTitle("Juego del Trilero - Seleccion de Jugadores");
        setBounds(0, 0, 600, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
