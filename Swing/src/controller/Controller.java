package controller;

import gui.FormEvent;
import model.*;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Controller {
    database db = new database();

    public List<Person> getpeople() {
        return db.getPeople();
    }

    public void addPerson(FormEvent ev){


        String name = ev.getName();
        String occupation = ev.getOccupation();
        int ageCatId = ev.getAgeCat();

        String employment = ev.getEmployment();
        Boolean iscitizen = ev.isCitizen();
        String taxid = ev.getTaxID();
        String sex = ev.getGender();



        AgeCategory ageCategory = null;

        switch (ageCatId) {
            case 0 :
                ageCategory = ageCategory.child;
                break;
            case 1 :
                ageCategory = ageCategory.adult;
                break;
            case 2:
                ageCategory = ageCategory.senior;
                break;
        }

        gender persongen = null;

        if(sex.equals("male")) {
            persongen = persongen.male;
        }
        else {
            persongen = persongen.female;
        }

        Employment employstatus = null;
        if(employment.equals("employed")){
            employstatus = employstatus.employed;
        }
        else if (employment.equals("self-employed")) {
            employstatus = employstatus.selfemployed;
        }
        else if(employment.equals("unemployed")) {
            employstatus = employstatus.nonemployed;
        }
        else {
            employstatus = employstatus.others;
        }


        Person person = new Person(name,occupation,ageCategory, employstatus, iscitizen, taxid,persongen);

        db.addPerson(person);

    }

    public void deleteperson(int index) {

        db.deletePerson(index);
    }

    public void saveToFile(File file) throws IOException {
        db.ExportToFile(file);
    }

    public void importFromFile(File file) throws IOException {
        db.ImportFromFile(file);
    }

    public void save() throws SQLException {
        db.save();
    }

    public void refresh() throws SQLException {
        db.load();
    }

    public void connect() throws Exception {
        db.connect();
    }

    public void disconnect() throws Exception {
        db.disconnect();
    }
}
