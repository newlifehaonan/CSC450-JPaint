package gui;

import java.util.EventObject;

public class FormEvent extends EventObject {

    private String name;

    private String occupation;

    private ageCatmodel ageCat;

    private String employment;

    private Boolean citizen;

    private String TaxID;

    private String gender;

    public FormEvent(Object source) {

        super(source);
    }


    public FormEvent(Object source, String name, String occupation, ageCatmodel ageCat, String employment, Boolean citizen, String TaxId, String gender) {

        super(source);

        this.name = name;

        this.occupation = occupation;

        this.ageCat = ageCat;

        this.employment = employment;

        this.citizen = citizen;

        this.TaxID = TaxId;

        this.gender = gender;
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

    public int getAgeCat() {
        return ageCat.getid();
    }

    public void setAgeCat(ageCatmodel ageCat) {
        this.ageCat = ageCat;
    }

    public int getageid() {

        return  ageCat.getid();
    }

    public String getEmployment() {
        return employment;
    }

    public void setEmployment(String employment) {
        this.employment = employment;
    }

    public Boolean isCitizen() {
        return citizen;
    }

    public String getTaxID() {
        return TaxID;
    }

    public String getGender() {
        return gender;
    }
}
