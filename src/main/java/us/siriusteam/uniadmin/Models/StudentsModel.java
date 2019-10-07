package us.siriusteam.uniadmin.Models;

import javafx.beans.property.*;
import us.siriusteam.uniadmin.database.sql.students.StudentsManager;
import us.siriusteam.uniadmin.students.Careers;
import us.siriusteam.uniadmin.students.Direcction;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.UUID;

public class StudentsModel {

    private final ObjectProperty<UUID> uniqueId;
    private final StringProperty id;
    private final StringProperty name;
    private final StringProperty last_name;
    private final StringProperty idCard;
    private final ObjectProperty<LocalDate> date_of_birth;
    private final StringProperty sex;
    private final StringProperty religion;
    private final ObjectProperty<Direcction> direcction;
    private final ObjectProperty<Careers> career;
    private final IntegerProperty yearCursed;
    private final StringProperty civil_status;
    private final StringProperty zone;
    private final StringProperty phone_number;
    private final StringProperty email;


    public StudentsModel(UUID uniqueId, String id, String name, String last_name, String idCard, LocalDate date_of_birth, String sex, String religion, Direcction direcction, Careers career, int yearCursed, String civil_status, String zone, String phone_number, String email) {
        this.uniqueId = new SimpleObjectProperty<UUID>(uniqueId);
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.last_name = new SimpleStringProperty(last_name);
        this.idCard = new SimpleStringProperty(idCard);
        this.date_of_birth = new SimpleObjectProperty<LocalDate>(date_of_birth);
        this.sex = new SimpleStringProperty(sex);
        this.religion = new SimpleStringProperty(religion);
        this.direcction = new SimpleObjectProperty<Direcction>(direcction);
        this.career = new SimpleObjectProperty<Careers>(career);
        this.yearCursed = new SimpleIntegerProperty(yearCursed);
        this.civil_status = new SimpleStringProperty(civil_status);
        this.zone = new SimpleStringProperty(zone);
        this.phone_number = new SimpleStringProperty(phone_number);
        this.email = new SimpleStringProperty(email);
    }

    public StudentsModel(UUID uniqueId) throws SQLException {
        StudentsModel studentsModel = new StudentsManager().get(uniqueId);
        this.uniqueId = new SimpleObjectProperty<>(uniqueId);
        assert studentsModel != null;
        this.id = studentsModel.idProperty();
        this.name = studentsModel.nameProperty();
        this.last_name = studentsModel.last_nameProperty();
        this.idCard = studentsModel.idCardProperty();
        this.date_of_birth = studentsModel.date_of_birthProperty();
        this.sex = studentsModel.sexProperty();
        this.religion = studentsModel.religionProperty();
        this.direcction = studentsModel.direcctionProperty();
        this.career = studentsModel.careerProperty();
        this.yearCursed = studentsModel.yearCursedProperty();
        this.civil_status = studentsModel.civil_statusProperty();
        this.zone = studentsModel.zoneProperty();
        this.phone_number = studentsModel.phone_numberProperty();
        this.email = studentsModel.emailProperty();
    }

    //Inicio getters y setters

    public UUID getUniqueId() {
        return uniqueId.get();
    }

    public ObjectProperty<UUID> uniqueIdProperty() {
        return uniqueId;
    }

    public void setUniqueId(UUID uniqueId) {
        this.uniqueId.set(uniqueId);
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

    public String getIdCard() {
        return idCard.get();
    }

    public StringProperty idCardProperty() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard.set(idCard);
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth.get();
    }

    public ObjectProperty<LocalDate> date_of_birthProperty() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth.set(date_of_birth);
    }

    public String getSex() {
        return sex.get();
    }

    public StringProperty sexProperty() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex.set(sex);
    }

    public String getReligion() {
        return religion.get();
    }

    public StringProperty religionProperty() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion.set(religion);
    }

    public Direcction getDirecction() {
        return direcction.get();
    }

    public ObjectProperty<Direcction> direcctionProperty() {
        return direcction;
    }

    public void setDirecction(Direcction direcction) {
        this.direcction.set(direcction);
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

    public int getYearCursed() {
        return yearCursed.get();
    }

    public IntegerProperty yearCursedProperty() {
        return yearCursed;
    }

    public void setYearCursed(int yearCursed) {
        this.yearCursed.set(yearCursed);
    }

    public String getCivil_status() {
        return civil_status.get();
    }

    public StringProperty civil_statusProperty() {
        return civil_status;
    }

    public void setCivil_status(String civil_status) {
        this.civil_status.set(civil_status);
    }

    public String getZone() {
        return zone.get();
    }

    public StringProperty zoneProperty() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone.set(zone);
    }

    public String getPhone_number() {
        return phone_number.get();
    }

    public StringProperty phone_numberProperty() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number.set(phone_number);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }
    //fin getters y setters


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StudentsModel{");
        sb.append("uniqueId=").append(uniqueId);
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", last_name=").append(last_name);
        sb.append(", idCard=").append(idCard);
        sb.append(", date_of_birth=").append(date_of_birth);
        sb.append(", sex=").append(sex);
        sb.append(", religion=").append(religion);
        sb.append(", direcction=").append(direcction);
        sb.append(", career=").append(career);
        sb.append(", yearCursed=").append(yearCursed);
        sb.append(", civil_status=").append(civil_status);
        sb.append(", zone=").append(zone);
        sb.append(", phone_number=").append(phone_number);
        sb.append(", email=").append(email);
        sb.append('}');
        return sb.toString();
    }
}
