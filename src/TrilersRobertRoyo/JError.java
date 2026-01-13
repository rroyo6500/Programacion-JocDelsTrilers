package TrilersRobertRoyo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class JError extends JFrame {
    public JError(String mensaje) {
        setLayout(new GridBagLayout());
        setTitle("Error");
        setBounds(0, 0, mensaje.length() * 10, 100);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setFocusable(true);
        requestFocus();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                setVisible(false);
                dispose();
            }
        });

        JLabel mensajeLabel = new JLabel(mensaje);
        mensajeLabel.setBounds(0, 0, mensaje.length() * 10, 100);
        mensajeLabel.setFont(new Font("Arial", Font.BOLD, 15));
        add(mensajeLabel);
    }
}