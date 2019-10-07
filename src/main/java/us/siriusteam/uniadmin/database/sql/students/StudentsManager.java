package us.siriusteam.uniadmin.database.sql.students;

import us.siriusteam.uniadmin.Models.StudentsModel;
import us.siriusteam.uniadmin.database.DataBaseManager;
import us.siriusteam.uniadmin.database.sql.ConnectSQL;
import us.siriusteam.uniadmin.students.Careers;
import us.siriusteam.uniadmin.students.Direcction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class StudentsManager implements DataBaseManager<StudentsModel> {

    private ConnectStudents connectStudents = null;
    private Connection sqlConnection = null;

    {
        connectStudents = new ConnectStudents();
    }

    @Override
    public void registerTable() {
        Connection conn = null;
        String query = "CREATE TABLE IF NOT EXISTS students\n" +
                "(\n" +
                "\tID INTEGER not null\n" +
                "\t\tconstraint students_pk\n" +
                "\t\t\tprimary key autoincrement,\n" +
                "\tUUID TEXT not null,\n" +
                "\tName TEXT not null,\n" +
                "\tLastName TEXT,\n" +
                "\tIdCard TEXT,\n" +
                "\tDateOfBirth TEXT,\n" +
                "\tSex TEXT,\n" +
                "\tReligion TEXT,\n" +
                "\tDirection TEXT,\n" +
                "\tCareer TEXT,\n" +
                "\tYearCursed int,\n" +
                "\tZone TEXT,\n" +
                "\tPhoneNumber TEXT,\n" +
                "\tEmail TEXT\n" +
                "\tScoreTableId TEXT not null,\n" +
                ");\n" +
                "\n" +
                "create unique index students_ID_uindex\n" +
                "\ton students (ID);\n" +
                "\n";
        // Ejecutando consulta
        try{
            conn = connectStudents.getConnection();
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(conn != null) ConnectSQL.close(conn);
        }
    }

    @Override
    public int insert(StudentsModel student) throws SQLException {
        //Parametros del objeto estudiante.
        UUID uniqueId = student.getUniqueId();
        String name = student.getName();
        String lastName = student.getLast_name();
        String idCard = student.getIdCard();
        LocalDate dateOfBirth = student.getDate_of_birth();
        String sex = student.getSex();
        String religion = student.getReligion();
        Direcction direcction = student.getDirecction();
        Careers career = student.getCareer();
        Integer yearCursed = student.getYearCursed();
        String civilStatus = student.getCivil_status();
        String zone = student.getZone();
        String phoneNumber = student.getPhone_number();
        String email = student.getEmail();
        //Fin de los parametros del objeto estudiante

        final String QUERY = "INSERT INTO students(UUID, Name, LastName, IdCard, DateOfBirth, Sex, Religion, Direction, Career, YearCursed, Zone, PhoneNumber, Email, ScoreTableId) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            Connection connection = null;
        PreparedStatement preparedStatement = null;

        int rows;

        try {
            connection = (sqlConnection != null) ? sqlConnection :connectStudents.getConnection();
            int index = 1;
            preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(index++, uniqueId.toString());
            preparedStatement.setString(index++, name);
            preparedStatement.setString(index++, lastName);
            preparedStatement.setString(index++, idCard);
            preparedStatement.setString(index++, dateOfBirth.toString());
            preparedStatement.setString(index++, sex);
            preparedStatement.setString(index++, religion);
            preparedStatement.setString(index++, direcction.toString());
            preparedStatement.setString(index++, career.toString());
            preparedStatement.setInt(index++, yearCursed);
            preparedStatement.setString(index++, zone);
            preparedStatement.setString(index++, phoneNumber);
            preparedStatement.setString(index++, email);
            preparedStatement.setString(index, uniqueId.toString()+"_"+career.getCareer_name());

            rows = preparedStatement.executeUpdate();
        }finally {
            ConnectSQL.close(preparedStatement);
            if(connection != null) ConnectSQL.close(connection);
        }
        return rows;
    }

    @Override
    public int update(StudentsModel student) throws SQLException {
        return 0;
    }

    @Override
    public List<StudentsModel> selectAll() throws SQLException {
        return null;
    }

    @Override
    public StudentsModel get(UUID uniqueId) throws SQLException {
        return null;
    }

    @Override
    public StudentsModel get(String userName) throws SQLException {
        return null;
    }
}
