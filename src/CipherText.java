import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CipherText implements ActionListener {
    public String text;
    public JTextField input, output;
    CipherText(){
        //declare frame and exit when closed
        JFrame jfrm = new JFrame ("Simple Cipher Coder");
        jfrm.getContentPane().setLayout(new FlowLayout());
        jfrm.setSize(400, 200);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create labels
        JLabel plain = new JLabel("Plain Text:");
        JLabel cipher = new JLabel("Cipher Text:");

        //create text fields
        input = new JTextField(30);
        output = new JTextField(30);
        output.setEditable(false);

        //create buttons
        JButton enc = new JButton("Encode");
        JButton dec = new JButton("Decode");
        JButton reset = new JButton("Reset");

        //action listeners
        input.addActionListener(this);
        enc.addActionListener(this);
        dec.addActionListener(this);
        reset.addActionListener(this);

        //declare text input
        text = input.getText();

        //add labels and buttons to content pane
        jfrm.getContentPane().add(plain, Component.CENTER_ALIGNMENT);
        jfrm.getContentPane().add(input);
        jfrm.getContentPane().add(cipher, Component.CENTER_ALIGNMENT);
        jfrm.getContentPane().add(output);

        jfrm.getContentPane().add(enc);
        jfrm.getContentPane().add(dec);
        jfrm.getContentPane().add(reset);

        jfrm.setVisible(true);
    }

    public String cipher (String input){

        return "";
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        /*if(ae.getActionCommand().equals("Encode"))
            //cipher(text);
        else */
        if(ae.getActionCommand().equals("Reset")) {
            input.setText("");
            output.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CipherText();
            }
        });
    }
}