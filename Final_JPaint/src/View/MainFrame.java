package View;

import Model.Interfaces.IApplicationState;
import Model.Interfaces.MouseObserver;
import Utility.FileController;
import View.Adaptor.DrawMouseAdaptor;
import View.Adaptor.JpgFileChooser;
import View.Adaptor.MoveMouseAdaptor;
import View.Adaptor.SelectMouseAdaptor;
import View.Enum.StartAndEndPointMode;
import View.Interfaces.GuiControl;
import View.Interfaces.IDrawCanvas;
import View.Interfaces.PointListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class MainFrame extends JFrame implements MouseObserver {

    private GuiControl guiControl;

    private IDrawCanvas canvas;

    private ShapeList shapeList;

    private JFileChooser fileChooser;

    private FileController fileController;

    private IApplicationState applicationState;

    private MoveMouseAdaptor moveMouseAdaptor;
    private DrawMouseAdaptor drawMouseAdaptor;
    private SelectMouseAdaptor selectMouseAdaptor;

    public MainFrame(GuiControl guiControl, IDrawCanvas drawCanvas, IApplicationState applicationState, ShapeList shapeList) {

        super("H.C JPaint");

        this.guiControl = guiControl;

        this.canvas = drawCanvas;

        this.shapeList = shapeList;

        this.applicationState = applicationState;

        this.fileController = new FileController(shapeList);

        this.fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new JpgFileChooser());


        applicationState.registerObserver(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(2000,700);

        setVisible(true);

        setLayout(new BorderLayout());

        add((Component) guiControl, BorderLayout.NORTH);

        add((Component) canvas, BorderLayout.CENTER);

        setJMenuBar(CreateMenuBar());

        ((Component) canvas).setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));


        drawMouseAdaptor = new DrawMouseAdaptor(applicationState,shapeList);
        moveMouseAdaptor = new MoveMouseAdaptor(applicationState,shapeList);
        selectMouseAdaptor = new SelectMouseAdaptor(applicationState,shapeList);

        ((Component) canvas).addMouseListener(drawMouseAdaptor);
        System.out.println("Draw listener added");

//        ((Component) canvas).addMouseListener(moveMouseAdaptor);
//        System.out.println("move listener added");



    }


    @Override
    public void update() {
        MouseListener[] listeners = ((Component) canvas).getMouseListeners();
        for(MouseListener mouseListener: listeners) {
            ((Component) canvas).removeMouseListener(mouseListener);
        }

        StartAndEndPointMode startAndEndPointMode = applicationState.getActiveStartAndEndPointMode();

        if(startAndEndPointMode.equals(StartAndEndPointMode.DRAW)) {
            ((Component) canvas).addMouseListener(drawMouseAdaptor);
            System.out.println("draw adaptor added");
        }

        else if(startAndEndPointMode.equals(StartAndEndPointMode.SELECT)) {
            ((Component) canvas).addMouseListener(selectMouseAdaptor);
            System.out.println("select adaptor added");
        }

        else if(startAndEndPointMode.equals(StartAndEndPointMode.MOVE)) {
            ((Component) canvas).addMouseListener(moveMouseAdaptor);

            System.out.println("move adaptor added");
        }

    }

    private JMenuBar CreateMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu File = new JMenu("File");
        JMenuItem exportItem = new JMenuItem("Export File");
        JMenuItem importItem = new JMenuItem("Import File");
        JMenuItem exitItem = new JMenuItem("Exit");

        importItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int exp = fileChooser.showOpenDialog(MainFrame.this);

                if (exp == JFileChooser.APPROVE_OPTION) {
                    try {
                        fileController.refresh();
                        fileController.importFromFile(fileChooser.getSelectedFile());
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(MainFrame.this,"Can't import file","ERRO",JOptionPane.ERROR_MESSAGE);
                    }

                }
            }
        });

        exportItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int exp = fileChooser.showSaveDialog(MainFrame.this);

                if (exp == JFileChooser.APPROVE_OPTION) {

                    try {
                        fileController.saveToFile(fileChooser.getSelectedFile());
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(MainFrame.this,"Can't export file","ERRO",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int comfirmexit = JOptionPane.showConfirmDialog(MainFrame.this, "Do You Really Wanna Exit?", "Exit Comfirm", JOptionPane.OK_CANCEL_OPTION);

                if (comfirmexit == JOptionPane.OK_OPTION) {
                    System.exit(1);
                }
            }
        });

        File.add(exportItem);
        File.add(importItem);
        File.addSeparator();
        File.add(exitItem);
        menuBar.add(File);

        return menuBar;
    }

}
