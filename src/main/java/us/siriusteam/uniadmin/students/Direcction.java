package us.siriusteam.uniadmin.students;

public class Direcction {

    private String country;
    private String department;
    private String district;
    private boolean rural;
    private String postalCode;

    public Direcction(String country, String department, String district, boolean rural, String postalCode) {
        this.country = country;
        this.department = department;
        this.district = district;
        this.rural = rural;
        this.postalCode = postalCode;
    }

    public Direcction() {
    }

    public Direcction(String country, String department, String district, boolean rural) {
        this.country = country;
        this.department = department;
        this.district = district;
        this.rural = rural;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public boolean isRural() {
        return rural;
    }

    public void setRural(boolean rural) {
        this.rural = rural;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        String sb = "Direcction{" + "country='" + country + '\'' +
                ", department='" + department + '\'' +
                ", district='" + district + '\'' +
                ", rural=" + rural +
                ", postalCode='" + postalCode + '\'' +
                '}';
        return sb;
    }
}

