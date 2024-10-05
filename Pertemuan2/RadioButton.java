import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButton extends JFrame {
    public RadioButton() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JLabel labelInput = new JLabel("Input Your Name : ");
    labelInput.setBounds(15,40,350,10);
    JTextField textField = new JTextField();
    textField.setBounds(15,60,350,50);
    JLabel labelRadio = new JLabel("Jenis Member : ");
    labelRadio.setBounds(15,100,350,10);
    JRadioButton radioButton1 = new JRadioButton("TabunganKu", true);
    radioButton1.setBounds(15,115,350,30);
    JRadioButton radioButton2 = new JRadioButton("Tabungan Simpedes");
    radioButton2.setBounds(15,145,350,30);
    JRadioButton radioButton3 = new JRadioButton("Tabungan SimPel");
    radioButton3.setBounds(15,175,350,30);
    ButtonGroup bg = new ButtonGroup();
    bg.add(radioButton1);
    bg.add(radioButton2);
    bg.add(radioButton3);

    JButton button = new JButton("Save");
    button.setBounds(15,205,100,40);
    JTextArea txtOutput = new JTextArea();
    txtOutput.setEditable(false);
    txtOutput.setBounds(15, 250, 350, 100);
    button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String jenisMember = "";
            if (radioButton1.isSelected()) {
            jenisMember = radioButton1.getText();
            }
            if (radioButton2.isSelected()) {
            jenisMember = radioButton2.getText();
            }
            if (radioButton3.isSelected()) {
            jenisMember = radioButton3.getText();
            }
            String nama = textField.getText();
            txtOutput.append("Hello " + nama + "\n");
            txtOutput.append("Anda adalah member " + jenisMember + "\n");
            txtOutput.append("");
            }
        });
        this.add(button);
        this.add(textField);
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(radioButton3);
        this.add(labelInput);
        this.add(txtOutput);
        this.setSize(400, 500);
        setLayout(null);

    }
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                RadioButton h = new RadioButton();
                h.setVisible(true);
            }
        });
    }
}