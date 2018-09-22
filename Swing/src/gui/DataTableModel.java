package gui;

import model.Person;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class DataTableModel extends AbstractTableModel {


    private List<Person> personList;
    private String[] colName =
            {"ID", "Name", "AgeCatagory","Occupation","Employment","Citizenship","Tax Id"};

    public DataTableModel() {

    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public int getRowCount() {
        return personList.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }


    @Override
    public String getColumnName(int column) {
        return colName[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Person person = personList.get(rowIndex);

        switch (columnIndex) {
            case 0:
                 return person.getId();
            case 1:
                return person.getName();
            case 2:
                return person.getAgeCat();
            case 3:
                return person.getOccupation();
            case 4:
                return person.getEmployment();
            case 5:
                return person.getCitizen();
            case 6:
                return person.getTaxID();
        }
        return null;
    }


}

