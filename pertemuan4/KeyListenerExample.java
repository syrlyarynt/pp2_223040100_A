package pertemuan4;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author syrly
 */
public class KeyListenerExample {
     public static void main(String[] args) {
        //membuat frame
        JFrame frame = new JFrame("KeyListener Example");
        
        //membuat label untuk menampilkan pesan
        JLabel label = new JLabel("Tekan tombol pada keyboard");
        
        //menambahkan text field untuk fokus keyboard
        JTextField textField = new JTextField();
        textField.setBounds (50, 50, 300, 30);
        
        //menambahkan keylistener ke text field
        textField.addKeyListener(new KeyListener() {
            //dijalankan ketika tombol ditekan
            public void keyPressed(KeyEvent e) {
                label.setText("Key Pressed: " + KeyEvent.getKeyText(e.getKeyCode()));
            }
            
            public void keyReleased(KeyEvent e) {
                label.setText("Key Released: " + KeyEvent.getKeyText(e.getKeyCode()));
            }
            
            public void keyTyped(KeyEvent e) {
                label.setText("Key Typed: " + e.getKeyChar());
            }
        });
        
        //menambahkan komponen ke frame
        frame.add(label);
        frame.add(textField);
        
        //setting frame
        frame.setSize(400, 200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
}
