package TrilersRobertRoyo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.Override;

public class GraphicalInterface extends JFrame {

    public static JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER)){
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);

            if (Tazones.oval_premio != null) {
                g.setColor(Color.GREEN);
                g.fillOval(Tazones.oval_premio.x, Tazones.oval_premio.y, Tazones.oval_premio.width, Tazones.oval_premio.height);
                g.setColor(Color.BLACK);
                g.drawOval(Tazones.oval_premio.x, Tazones.oval_premio.y, Tazones.oval_premio.width, Tazones.oval_premio.height);
            }

            java.util.List<Polygon> copiaTazones;
            synchronized (Tazones.tazones) {
                copiaTazones = new java.util.ArrayList<>(Tazones.tazones);
            }

            for (Polygon t : copiaTazones) {
                if (Overlap.o(Mouse.mousePosition, t) && !Tazones.inAnimation) {
                    if (Players.playingPlayer == 1) g.setColor(Color.cyan);
                    else if (Players.playingPlayer == 2) g.setColor(Color.red);
                } else g.setColor(Color.gray);
                g.fillPolygon(t);
                g.setColor(Color.black);
                g.drawPolygon(t);
            }

        }
    };

    public static JFrame ii;
    public static JFrame it;

    public static JLabel pointsP1;
    public static JLabel pointsP2;
    public static JLabel playingPlayer;

    public static void GameInterface(){
        Tazones.crearTazones(new int[]{200, 500, 800}, 250);

        //Timer

        Timer refreshTimer = new Timer(1000/60, _ -> panel.repaint());
        refreshTimer.start();

        // Ventana de informacion

        ii = new JFrame();
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

        pointsP1 = new JLabel("Puntos: " + Players.getPlayerPoints(1));
        pointsP1.setBounds(10, 20, 50, 20);
        p1.add(pointsP1);

        JPanel p2 = new JPanel();
        p2.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.red, 2), Players.getPlayerName(2) + " (Jugador 2)")
        );
        ii.add(p2);

        pointsP2 = new JLabel("Puntos: " + Players.getPlayerPoints(1));
        pointsP2.setBounds(10, 20, 50, 20);
        p2.add(pointsP2);

        // Ventana para las tazas

        it = new JFrame();
        //it.setLayout(null);
        it.setTitle("Juego del Trilero");
        it.setBounds(0, 0, 1000, 500);
        it.setResizable(false);
        it.setLocationRelativeTo(null);
        it.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Mouse.configureMouse(it);
        Mouse.addConfig(it, new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (Tazones.inAnimation) return;

                Mouse.mousePosition = new int[]{e.getX(), e.getY()};

                java.util.List<Polygon> snapshot;
                synchronized (Tazones.tazones) {
                    snapshot = new java.util.ArrayList<>(Tazones.tazones);
                }

                for (Polygon t : snapshot) {
                    if (Overlap.o(Mouse.mousePosition, t)) {
                        Players.setPlayerSelection(Players.playingPlayer, Tazones.tazones.indexOf(t) + 1);
                        LogigaPrincipal.comprobarAcierto();
                    }
                }

            }
        });

        panel.setBounds(0,0,it.getWidth(),it.getHeight());
        it.add(panel);

        playingPlayer = new JLabel("", SwingConstants.CENTER);
        playingPlayer.setText("Turno de: " + Players.getPlayerName(Players.playingPlayer));
        panel.add(playingPlayer);



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

            JCheckBox chekboxIA = new JCheckBox("Jugador IA");
            chekboxIA.setBounds(10, 75, 270, 20);
            chekboxIA.setBorder(BorderFactory.createLineBorder(Color.black));
            p2.add(chekboxIA);

            JButton addPlayer = new JButton("Añadir");
            addPlayer.setBounds(10, 100, 270, 50);
            addPlayer.setBackground(Color.green);
            addPlayer.setBorder(BorderFactory.createLineBorder(Color.black));
            addPlayer.addActionListener(_ -> {
                String userName = name.getText();

                if (!chekboxIA.isSelected()) {
                    if (userName.isBlank()) return;

                    Players.setPlayerName(2, userName);
                    p2.setVisible(false);
                } else IA.setIA();

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


    public static boolean win = false;
    public static void win(String name, int points) {
        win = true;
        JFrame win = new JFrame();
        win.setLayout(null);
        win.setBounds(0, 0, 400, 125);
        win.setLocationRelativeTo(null);
        win.setTitle("Juego del Trilero - Victoria para: " + name);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setVisible(true);
        win.setFocusable(true);
        win.requestFocus();
        win.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    System.exit(0);
                }
            }
        });

        JLabel text = new JLabel("¡FELICIDADES!");
        text.setBounds(0, 20, 400, 25);
        text.setHorizontalAlignment(JLabel.CENTER);
        win.add(text);

        JLabel text2 = new JLabel("Ha ganado " + name + " con " + points + " puntos.");
        text2.setBounds(0, 50, 400, 25);
        text2.setHorizontalAlignment(JLabel.CENTER);
        win.add(text2);
    }

}
