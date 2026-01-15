package TrilersRobertRoyo;

import javax.swing.*;
import java.awt.*;

public class GraphicalInterface extends JFrame {

    public static JPanel panel = new JPanel(){
        @Override
        public void paint(Graphics g){
            super.paint(g);

            g.setColor(Color.gray);
            for (Polygon t : Tazones.tazones) g.fillPolygon(t);

        }
    };

    public static void GameInterface(){
        JFrame gi = new JFrame();
        gi.setLayout(null);
        gi.setTitle("Juego del Trilero");
        gi.setBounds(0, 0, 1000, 500);
        gi.setResizable(false);
        gi.setLocationRelativeTo(null);
        gi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gi.setVisible(true);

        Tazones.crearTazones(new int[]{200, 500, 800}, 200);

        panel.setBounds(0,0,gi.getWidth(),gi.getHeight());
        panel.setLayout(null);
        gi.add(panel);
        panel.repaint();

    }

    public GraphicalInterface () {
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0,0, 290, 160);
        p1.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.black, 2), "Player 1")
        );
        add(p1);

        // Player 1
        {
            JLabel nameLabel = new JLabel("Nombre:");
            nameLabel.setBounds(10, 20, 50, 20);
            p1.add(nameLabel);

            JTextField name = new JTextField();
            name.setBounds(10, 50, 270, 20);
            name.setBorder(BorderFactory.createLineBorder(Color.black));
            p1.add(name);

            JButton addPlayer = new JButton("Añadir");
            addPlayer.setBounds(10, 100, 270, 50);
            addPlayer.setBackground(Color.green);
            addPlayer.setBorder(BorderFactory.createLineBorder(Color.black));
            addPlayer.addActionListener(_ -> {
                String userName = name.getText();
                if (userName.isBlank()) return;

                Players.setPlayerName(1, userName);
                p1.setVisible(false);

                Players.playerCount--;
                if (Players.playerCount == 0) {
                    setVisible(false);
                    GameInterface();
                    dispose();
                }
            });
            p1.add(addPlayer);
        }

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(295,0, 290, 160);
        p2.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.black, 2), "Player 2")
        );
        add(p2);

        // Player 2
        {
            JLabel nameLabel = new JLabel("Nombre:");
            nameLabel.setBounds(10, 20, 50, 20);
            p2.add(nameLabel);

            JTextField name = new JTextField();
            name.setBounds(10, 50, 270, 20);
            name.setBorder(BorderFactory.createLineBorder(Color.black));
            p2.add(name);

            JButton addPlayer = new JButton("Añadir");
            addPlayer.setBounds(10, 100, 270, 50);
            addPlayer.setBackground(Color.green);
            addPlayer.setBorder(BorderFactory.createLineBorder(Color.black));
            addPlayer.addActionListener(_ -> {
                String userName = name.getText();
                if (userName.isBlank()) return;

                Players.setPlayerName(1, userName);
                p2.setVisible(false);

                Players.playerCount--;
                if (Players.playerCount == 0) {
                    setVisible(false);
                    GameInterface();
                    dispose();
                }
            });
            p2.add(addPlayer);
        }


        setTitle("Juego del Trilero - Seleccion de Jugadores");
        setBounds(0, 0, 600, 200);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
