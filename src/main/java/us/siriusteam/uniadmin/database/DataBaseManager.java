package us.siriusteam.uniadmin.database;

import us.siriusteam.uniadmin.Models.User;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface DataBaseManager {

    /**
     * Registra la tabla SQL si no existe.
     */
    void registerTable();


    /**
     * Inserta el usuario en la tabla.
     *
     * @param user
     * @return La cantidad de campos modificados.
     * @throws SQLException Error al hacer la consulta.
     */
    int insert(User user) throws SQLException;

    /**
     * Actualiza el usuario a existente en la tabla.
     *
     * @param user
     * @return La cantidad de campos modificados.
     * @throws SQLException Error al hacer la consulta.
     */
    int update(User user) throws SQLException;

    /**
     * Selecciona todos los usuarios existentes en la tabla.
     *
     * @return Una lista ordenada por momento de ingreso de los usuarios en la tabla.
     * @throws SQLException Error al hacer la consulta.
     */
    List<User> selectAll() throws SQLException;

    /**
     * Selecciona un usuario en la tabla, a partir de su UUID
     *
     * @param uniqueId
     * @return el usuario selecciona, y retorna null si no existe.
     * @throws SQLException
     */
    User getUser(UUID uniqueId) throws SQLException;

    /**
     * Selecciona un usuario en la tabla, a partir de su nombre
     *
     * @param userName
     * @return el usuario seleccionado, y retorna null si no existe.
     * @throws SQLException
     */
    User getUser(String userName) throws SQLException;


}
