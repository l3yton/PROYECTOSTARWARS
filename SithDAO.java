package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DO.SithDO;

public class SithDAO {

	/****************
	*FUNCIONES
	*****************/
    /**
     * Elimina un Sith de la base de datos por su ID.
     *
     * @param id  El ID del Sith a eliminar.
     * @param con La conexión a la base de datos.
     * @return 0 si la operación fue exitosa, -1 si hubo un error.
     */
    public static int eliminar(int id, Connection con) {
        String sql = "DELETE FROM Sith WHERE idSith = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0 ? 0 : -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Inserta un nuevo Sith en la base de datos.
     *
     * @param sith El objeto SithDO con los datos del Sith.
     * @param con  La conexión a la base de datos.
     * @return 0 si la operación fue exitosa, -1 si hubo un error.
     */
    public static int insertar(SithDO sith, Connection con) {
        String sql = "INSERT INTO Sith (nombre, apodoGuerra, edad, altura, nivelMaldad, energiaOscura) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, sith.getNombre());
            pstmt.setString(2, sith.getApodoGuerra());
            pstmt.setInt(3, sith.getEdad());
            pstmt.setInt(4, sith.getAltura());
            pstmt.setInt(5, sith.getNivelMaldad());
            pstmt.setInt(6, sith.getEnergiaOscura());
            return pstmt.executeUpdate() > 0 ? 0 : -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Actualiza un Sith existente en la base de datos.
     *
     * @param sith El objeto SithDO con los datos actualizados.
     * @param con  La conexión a la base de datos.
     * @return 0 si la operación fue exitosa, -1 si hubo un error.
     */
    public static int actualizar(SithDO sith, Connection con) {
        String sql = "UPDATE Sith SET nombre = ?, apodoGuerra = ?, edad = ?, altura = ?, nivelMaldad = ?, energiaOscura = ? WHERE idSith = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, sith.getNombre());
            pstmt.setString(2, sith.getApodoGuerra());
            pstmt.setInt(3, sith.getEdad());
            pstmt.setInt(4, sith.getAltura());
            pstmt.setInt(5, sith.getNivelMaldad());
            pstmt.setInt(6, sith.getEnergiaOscura());
            pstmt.setInt(7, sith.getId());
            return pstmt.executeUpdate() > 0 ? 0 : -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Carga todos los Siths de la base de datos.
     *
     * @param con La conexión a la base de datos.
     * @return Una lista de objetos SithDO con todos los Siths.
     */
    public static ArrayList<SithDO> cargarTodo(Connection con) {
        ArrayList<SithDO> siths = new ArrayList<>();
        String sql = "SELECT * FROM Sith";
        try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                SithDO sith = new SithDO();
                sith.setId(rs.getInt("id"));
                sith.setNombre(rs.getString("nombre"));
                sith.setApodoGuerra(rs.getString("apodoGuerra"));
                sith.setEdad(rs.getInt("edad"));
                sith.setAltura(rs.getInt("altura"));
                sith.setNivelMaldad(rs.getInt("nivelMaldad"));
                sith.setEnergiaOscura(rs.getInt("energiaOscura"));
                siths.add(sith);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return siths;
    }

    /**
     * Carga un Sith específico de la base de datos por su ID.
     *
     * @param con La conexión a la base de datos.
     * @param id  El ID del Sith a cargar.
     * @return Un objeto SithDO con los datos del Sith, o null si no se encontró.
     */
    public static SithDO cargar(Connection con, int id) {
        SithDO sith = null;
        String sql = "SELECT * FROM Sith WHERE idSith = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    sith = new SithDO();
                    sith.setId(rs.getInt("id"));
                    sith.setNombre(rs.getString("nombre"));
                    sith.setApodoGuerra(rs.getString("apodoGuerra"));
                    sith.setEdad(rs.getInt("edad"));
                    sith.setAltura(rs.getInt("altura"));
                    sith.setNivelMaldad(rs.getInt("nivelMaldad"));
                    sith.setEnergiaOscura(rs.getInt("energiaOscura"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sith;
    }

    /**
     * Calcula el total de energía oscura de todos los Sith que tengan un nivel de maldad superior a 7.
     *
     * @param con    La conexión a la base de datos.
     * @param idSith El ID del Sith (no utilizado en esta implementación).
     * @return El total de energía oscura de los Sith con nivel de maldad mayor a 7.
     */
    public static int calcularTotalEnergiaOscuraSith(Connection con, int idSith) {
        int totalEnergiaOscura = 0;
        String sql = "SELECT energiaOscura, nivelMaldad FROM Sith";
        try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int energiaOscura = rs.getInt("energiaOscura");
                int nivelMaldad = rs.getInt("nivelMaldad");
                if (nivelMaldad > 7) { // Filtro: nivel de maldad mayor a 7
                    totalEnergiaOscura += energiaOscura;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalEnergiaOscura;
    }
}