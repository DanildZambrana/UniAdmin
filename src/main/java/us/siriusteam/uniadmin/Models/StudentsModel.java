package us.siriusteam.uniadmin.Models;

import javafx.beans.property.*;
import us.siriusteam.uniadmin.students.Careers;
import us.siriusteam.uniadmin.students.Direcction;

import java.time.LocalDate;
import java.util.UUID;

public class StudentsModel {

    private final StringProperty id;
    private final StringProperty name;
    private final StringProperty last_name;/*
    private final StringProperty identification_card;
    private final ObjectProperty<LocalDate> date_of_birth;
    private final StringProperty sex;
    private final StringProperty religion;
    private final StringProperty direction;*/
    private final ObjectProperty<Careers> career;/*
    private final IntegerProperty year_taken;
    private final StringProperty civil_status;
    private final StringProperty zone;
    private final ObjectProperty<UUID> uniqueId;

    public StudentsModel(ObjectProperty<UUID> uniqueId) {
        this.uniqueId = uniqueId;
    }

    public StudentsModel(StringProperty id) {
        this.id = id;
    }*/

    public StudentsModel(String id, String name, String last_name, Careers career) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.last_name = new SimpleStringProperty(last_name);
        this.career = new SimpleObjectProperty<Careers>(career);
    }

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getLast_name() {
        return last_name.get();
    }

    public StringProperty last_nameProperty() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name.set(last_name);
    }

    public Careers getCareer() {
        return career.get();
    }

    public ObjectProperty<Careers> careerProperty() {
        return career;
    }

    public void setCareer(Careers career) {
        this.career.set(career);
    }
}
