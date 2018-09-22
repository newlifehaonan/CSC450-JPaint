package GUI;

import Controller.DrawShape.Shape;
import GUI.interfaces.IViewShape;
import Utility.Observer;
import Controller.Interfaces.IShape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

public class GuiWindow implements Observer {
    JPanel buttomPanel;
    JPanel paintPanel;

    public GuiWindow() {
        createView();

    }

    public void createView() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame window = new JFrame("PaintCanvas");
        window.setSize(new Dimension(600,600));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createButtomPanel();
        createPaintPanel();

        window.getContentPane().add(buttomPanel, BorderLayout.NORTH);
        window.getContentPane().add(paintPanel, BorderLayout.CENTER);

        window.setVisible(true);



    }

    public void createButtomPanel() {
        buttomPanel = new JPanel();
        buttomPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton drawRactangle = new JButton("DrawRectangle");
        JButton drawEllipise = new JButton("DrawEllipise");

        buttomPanel.add(drawRactangle);
        buttomPanel.add(drawEllipise);
    }

    public void createPaintPanel() {

        paintPanel = new JPanel();
        paintPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

    }


    @Override
    public void update() {

    }
}
