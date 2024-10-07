package Pertemuan3.HelloBorderLayout;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelloBorderLayout extends JFrame {
    public HelloBorderLayout() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelPertanyaan = new JLabel("Apakah ibukota Indonesia?");
        JLabel labelHasil = new JLabel("Jawab pertanyaan di atas");

        JButton buttonA = new JButton("Jakarta");
        JButton buttonB = new JButton("Bandung");
        JButton buttonC = new JButton("Surabaya");

        buttonA.addActionListener(e -> labelHasil.setText("Jawaban anda benar"));
        buttonB.addActionListener(e -> labelHasil.setText("Jawaban anda salah"));
        buttonC.addActionListener(e -> labelHasil.setText("Jawaban anda salah"));

        this.add(labelPertanyaan, BorderLayout.NORTH);
        this.add(labelHasil, BorderLayout.SOUTH);
        this.add(buttonA, BorderLayout.WEST);
        this.add(buttonB, BorderLayout.CENTER);
        this.add(buttonC, BorderLayout.EAST);
        this.setSize(400, 200);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            HelloBorderLayout h = new HelloBorderLayout();
            h.setVisible(true);
        });
    }
}
