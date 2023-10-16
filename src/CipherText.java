import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CipherText implements ActionListener {
    //declare text field to be accessible outside the method
    public String text;

    //declare text fields to be accessible outside the method
    public JTextField input, output;

    StringBuilder str = new StringBuilder();
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
        //output.setEditable(false);

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

        //set frame to be visible
        jfrm.setVisible(true);
    }

    //creating method to cipher the text in plain text field
    public String cipher (String phrase){
        str.setLength(0); //clears string builder
        //shift each part of text one forward (ex. a -> b)
        for (int i = 0; i < phrase.length(); ++i){
            str.append((char)(phrase.charAt(i) + 1));
        }

        return str.toString();
    }

    //when text is entered into "Cipher Text" it will shift letters back one
    public String decipher (String phrase){
        str.setLength(0); //clears string builder
        for (int i = 0; i < phrase.length(); ++i){
            str.append((char)(phrase.charAt(i) - 1));
        }

        return str.toString();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //set cipher text to ciphered plain text
        if(ae.getActionCommand().equals("Encode"))
            output.setText(cipher(input.getText()));

        //when text entered into cipher text, it will print regular text in "Plain Text"
        if(ae.getActionCommand().equals("Decode"))
            input.setText(decipher(output.getText()));

        //text clears when pressed
        if(ae.getActionCommand().equals("Reset")) {
            input.setText("");
            output.setText("");
        }
    }

    //run the program
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CipherText();
            }
        });
    }
}