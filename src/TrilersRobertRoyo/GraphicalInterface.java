package TrilersRobertRoyo;

import javax.swing.*;
import java.awt.*;
import java.lang.Override;

public class GraphicalInterface extends JFrame {

    public static JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER)){
        @Override
        public void paint(Graphics g){
            super.paint(g);


            g.setColor(Color.gray);
            for (Polygon t : Tazones.tazones) {
                if (TrilersRobertRoyo.Override.o(Mouse.getMousePosition(), t)) {
                    if (Mouse.isClicked) g.setColor(Color.yellow);
                    else g.setColor(Color.cyan);
                }
                else g.setColor(Color.gray);
                g.fillPolygon(t);
            }

            panel.repaint();


        }
    };

    public static void GameInterface(){
        Tazones.crearTazones(new int[]{200, 500, 800}, 200);

        // Ventana para las tazas

        JFrame it = new JFrame();
        //it.setLayout(null);
        it.setTitle("Juego del Trilero");
        it.setBounds(0, 0, 1000, 500);
        it.setResizable(false);
        it.setLocationRelativeTo(null);
        it.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Mouse.configureMouse(it);

        panel.setBounds(0,0,it.getWidth(),it.getHeight());
        it.add(panel);

        JLabel playingPlayer = new JLabel("", SwingConstants.CENTER);
        playingPlayer.setText("Turno de: " + Players.getPlayerName(Players.playingPlayer));
        panel.add(playingPlayer);

        // Ventana de informacion

        JFrame ii = new JFrame();
        ii.setLayout(new BoxLayout(ii.getContentPane(), BoxLayout.X_AXIS));
        ii.setTitle("Juego del Trilero");
        ii.setBounds(0, 0, 500, 150);
        ii.setResizable(false);
        ii.setLocationRelativeTo(null);
        ii.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p1 = new JPanel();
        p1.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.cyan, 2), Players.getPlayerName(1) + " (Jugador 1)")
        );
        ii.add(p1);

        {
            JLabel points = new JLabel("Puntos: " + Players.getPlayerPoints(1));
            points.setBounds(10, 20, 50, 20);
            p1.add(points);
        }

        JPanel p2 = new JPanel();
        p2.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.red, 2), Players.getPlayerName(2) + " (Jugador 2)")
        );
        ii.add(p2);

        {
            JLabel points = new JLabel("Puntos: " + Players.getPlayerPoints(1));
            points.setBounds(10, 20, 50, 20);
            p2.add(points);
        }

        it.setVisible(true);
        ii.setVisible(true);
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

                Players.setPlayerName(2, userName);
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
