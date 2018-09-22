package gui;

import javax.swing.*;
import java.awt.*;

/*

put component in JPanel

 */
public class TextPanel extends JPanel {

    private JTextArea textArea;

    public TextPanel() {

        this.textArea = new JTextArea();

        setLayout(new BorderLayout());

        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }


    public void appendtext(String string) {

        textArea.append(string);
    }
}
