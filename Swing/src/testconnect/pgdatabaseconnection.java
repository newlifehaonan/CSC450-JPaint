package testconnect;

import model.*;

import java.sql.SQLException;

public class pgdatabaseconnection {

    public static void main(String[] args) {

        database db = new database();

        db.addPerson(
                new Person("haonan",
                        "student",
                        AgeCategory.senior,
                        Employment.employed,
                        true,
                        "123456",
                        gender.male)
        );

        db.addPerson(
                new Person("harry",
                        "student",
                        AgeCategory.senior,
                        Employment.employed,
                        true,
                        "1234888",
                        gender.male)
        );

        try {
            db.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            db.save();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            db.load();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            db.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
