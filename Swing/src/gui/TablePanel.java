package gui;

import model.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class TablePanel extends JPanel {

    private DataTableModel tableModel;
    private JTable table;
    private JPopupMenu popupMenu;
    private DataListener dataListener;

    public TablePanel() {

        this.tableModel = new DataTableModel();

        this.table = new JTable(tableModel);

        this.popupMenu = new JPopupMenu();

        setLayout(new BorderLayout());

        add(new JScrollPane(table), BorderLayout.CENTER);

        JMenuItem deleteItem = new JMenuItem("Delete");

        popupMenu.add(deleteItem);


        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    popupMenu.show(table, e.getX(), e.getY());
                }
            }
        });

        deleteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int row = table.getSelectedRow();

                if (dataListener != null) {
                    dataListener.deletedata(row);
                    tableModel.fireTableRowsDeleted(row,row);
                }
            }
        });
    }

    public void setdata(List<Person> person) {
        tableModel.setPersonList(person);
    }

    public void refresh() {
        tableModel.fireTableDataChanged();
    }

    public void setDataListener(DataListener dataListener) {

        this.dataListener = dataListener;
    }


}
