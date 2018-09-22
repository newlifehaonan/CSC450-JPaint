package model;

import java.awt.*;
import java.io.*;
import java.sql.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class database {

    private List<Person> people;
    private Connection con;


    public database() {
        this.people = new LinkedList<>();
    }

    public void connect() throws Exception{

        if (con != null) return;

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            new Exception("Driver not found");
        }

        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "ZWxf2017!");

        System.out.println("Connection Success!");
    }

    public void disconnect() throws Exception{

        if (con != null)

            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("can not close");
            }
    }

    public void load() throws SQLException {

        people.clear();

        String selectquery = "select id, name, age, employment_state, tax_id, us_citizen, occupation, gender from person order by name";

        Statement selectstatement = con.createStatement();

        ResultSet selectresult = selectstatement.executeQuery(selectquery);

        while (selectresult.next()) {

            int p_id = selectresult.getInt("id");
            String p_name = selectresult.getString("name");
            String p_age= selectresult.getString("age");
            String p_empstatus= selectresult.getString("employment_state");
            String p_taxid =selectresult.getString("tax_id");
            Boolean p_iscitizen =selectresult.getBoolean("us_citizen");
            String p_occup =selectresult.getString("occupation");
            String p_gender =selectresult.getString("gender");

            Person person = new Person(p_id,p_name, p_occup, AgeCategory.valueOf(p_age),Employment.valueOf(p_empstatus),p_iscitizen,p_taxid,gender.valueOf(p_gender));
            people.add(person);

            System.out.println(person);

        }



    }
    public void save() throws SQLException {

        String sqlquery = "select count(*) as count from person where id =?";
        String sqlinsert = "insert into person (id, name, age, employment_state, tax_id, us_citizen, occupation, gender) values (?, ?, ?, ?, ?, ?, ?, ?)";
        String sqlupdate = "Update person set name=?, age=?, employment_state=?, tax_id=?, us_citizen=?, occupation=?, gender=? where id=?";
        PreparedStatement preparedStatement = con.prepareStatement(sqlquery);
        PreparedStatement preparedStatement2 = con.prepareStatement(sqlinsert);
        PreparedStatement updateStatement = con.prepareStatement(sqlupdate);
        for (Person fella : people) {

            int id = fella.getId();
            String Name = fella.getName();
            AgeCategory Age = fella.getAgeCat();
            Employment Employment = fella.getEmployment();
            String Taxid = fella.getTaxID();
            Boolean isuscitizen = fella.getCitizen();
            String Occup = fella.getOccupation();
            gender Gender = fella.getGender();

            preparedStatement.setInt(1,id);

            ResultSet queryresult = preparedStatement.executeQuery();

            queryresult.next();

            int count = queryresult.getInt(1);

            System.out.println("Count with ID " + id + "is " + count);

            if(count == 0) {

                System.out.println("Insert into person" + id);

                preparedStatement2.setInt(1, id);
                preparedStatement2.setString(2, Name);
                preparedStatement2.setString(3, Age.name());
                preparedStatement2.setString(4, Employment.name());
                preparedStatement2.setString(5, Taxid);
                preparedStatement2.setBoolean(6,isuscitizen);
                preparedStatement2.setString(7,Occup);
                preparedStatement2.setString(8,Gender.name());

                preparedStatement2.executeUpdate();

            } else {
                System.out.println("Update into person" + id);

                updateStatement.setString(1, Name);
                updateStatement.setString(2, Age.name());
                updateStatement.setString(3, Employment.name());
                updateStatement.setString(4, Taxid);
                updateStatement.setBoolean(5,isuscitizen);
                updateStatement.setString(6,Occup);
                updateStatement.setString(7,Gender.name());
                updateStatement.setInt(8, id);

                updateStatement.executeUpdate();
            }

        }

        preparedStatement.close();
        preparedStatement2.close();
        updateStatement.close();
    }

    public void deletePerson(int index) {
        people.remove(index);
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public List<Person> getPeople() {
        return people;
    }

    public void ExportToFile(File file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        Person[] persons = people.toArray(new Person[people.size()]);

        oos.writeObject(persons);

        oos.close();
    }

    public void ImportFromFile(File file) throws  IOException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        try {
            Person[] person = (Person[])ois.readObject();
            people.clear();
            people.addAll(Arrays.asList(person));

        } catch (ClassNotFoundException e){
            System.err.println("File not found");
        }

    }

}
