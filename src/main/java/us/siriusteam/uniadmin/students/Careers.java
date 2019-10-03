package us.siriusteam.uniadmin.students;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class  Careers {
    private final int monthly_money_value_in_dolars;
    private final String career_name;
    private final int years;

    public Careers(int monthly_money_value_in_dolars, String career_name, int years) {
        this.monthly_money_value_in_dolars = monthly_money_value_in_dolars;
        this.career_name = career_name;
        this.years = years;
    }

    public int getMonthly_money_value_in_dolars() {
        return monthly_money_value_in_dolars;
    }

    public StringProperty getCareer_name() {
        return new SimpleStringProperty(career_name);
    }

    public int getYears() {
        return years;
    }


    /*LIC_ENFERMERIA(25, "Licenciatura en enfermería", 5),
    LIC_PSICOLOGIA_CLINICA(25, "Licenciatura en psicología clínica", 5),
    LIC_FARMACIA(25, "Licenciatura en farmacia", 5),
    LIC_PEDAGOGIA(25, ""),
    LIC_INGLES,
    LIC_ADMINISTRACION_DE_EMPRESAS,
    LIC_CONTADURIA_PUBLICA_AUDITORIA,
    LIC_BANCA_FINANZAS,
    LIC_TEOLOGIA,
    LIC_DERECHO,
    LIC_PERIODISMO,
    LIC_COMPUTACION,

    ING_SISTEMAS,
    ING_GERENCIA_AGROPECUARIA,

    FM_BACHILERATO_TEOLOGIA,
    FM_DIPLOMADO_TEOLOGIA;*/
}
