package model;

import java.io.Serializable;

public class Person implements Serializable{

    private static int count = 1;

    private int id;

    private String name;

    private String occupation;

    private AgeCategory ageCat;

    private Employment employment;

    private Boolean citizen;

    private String TaxID;

    private gender gender;

    public Person(String name, String occupation, AgeCategory ageCat, Employment employment, Boolean citizen, String taxID, model.gender gender) {
        this.name = name;
        this.occupation = occupation;
        this.ageCat = ageCat;
        this.employment = employment;
        this.citizen = citizen;
        TaxID = taxID;
        this.gender = gender;

        this.id = count;
        count++;
    }

    public Person(int id, String name, String occupation, AgeCategory ageCat, Employment employment, Boolean citizen, String taxID, model.gender gender) {

        this(name, occupation, ageCat, employment, citizen, taxID, gender);
        count++;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public AgeCategory getAgeCat() {
        return ageCat;
    }

    public void setAgeCat(AgeCategory ageCat) {
        this.ageCat = ageCat;
    }

    public Employment getEmployment() {
        return employment;
    }

    public void setEmployment(Employment employment) {
        this.employment = employment;
    }

    public Boolean getCitizen() {
        return citizen;
    }

    public void setCitizen(Boolean citizen) {
        this.citizen = citizen;
    }

    public String getTaxID() {
        return TaxID;
    }

    public void setTaxID(String taxID) {
        TaxID = taxID;
    }

    public model.gender getGender() {
        return gender;
    }

    public void setGender(model.gender gender) {
        this.gender = gender;
    }

    public String toString() {

        return id + ": " + "Name: " + name;
    }
}
