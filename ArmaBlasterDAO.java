package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DO.ArmaBlasterDO;

public class ArmaBlasterDAO {

    /**
     * Elimina un arma bláster de la base de datos por su ID.
     *
     * @param id  El ID del arma bláster a eliminar.
     * @param con La conexión a la base de datos.
     * @return 0 si la operación fue exitosa, -1 si hubo un error.
     */
    public static int eliminar(int id, Connection con) {
        String sql = "DELETE FROM ArmaBlaster WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0 ? 0 : -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Inserta un nuevo arma bláster en la base de datos.
     *
     * @param elementoDO El objeto ArmaBlasterDO con los datos del arma bláster.
     * @param con        La conexión a la base de datos.
     * @return 0 si la operación fue exitosa, -1 si hubo un error.
     */
    public static int insertar(ArmaBlasterDO elementoDO, Connection con) {
        String sql = "INSERT INTO ArmaBlaster (nombre, puntosRecarga, danio) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, elementoDO.getNombre());
            pstmt.setInt(2, elementoDO.getPuntosRecarga());
            pstmt.setInt(3, elementoDO.getDanio());
            return pstmt.executeUpdate() > 0 ? 0 : -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Actualiza un arma bláster existente en la base de datos.
     *
     * @param elementoDO El objeto ArmaBlasterDO con los datos actualizados.
     * @param con        La conexión a la base de datos.
     * @return 0 si la operación fue exitosa, -1 si hubo un error.
     */
    public static int actualizar(ArmaBlasterDO elementoDO, Connection con) {
        String sql = "UPDATE ArmaBlaster SET nombre = ?, puntosRecarga = ?, danio = ? WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, elementoDO.getNombre());
            pstmt.setInt(2, elementoDO.getPuntosRecarga());
            pstmt.setInt(3, elementoDO.getDanio());
            pstmt.setInt(4, elementoDO.getId());
            return pstmt.executeUpdate() > 0 ? 0 : -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Carga todas las armas bláster de la base de datos.
     *
     * @param con La conexión a la base de datos.
     * @return Una lista de objetos ArmaBlasterDO con todas las armas bláster.
     */
    public static ArrayList<ArmaBlasterDO> cargarTodo(Connection con) {
        ArrayList<ArmaBlasterDO> lista = new ArrayList<>();
        String sql = "SELECT * FROM ArmaBlaster";
        try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                ArmaBlasterDO armaBlaster = new ArmaBlasterDO();
                armaBlaster.setId(rs.getInt("id"));
                armaBlaster.setNombre(rs.getString("nombre"));
                armaBlaster.setPuntosRecarga(rs.getInt("puntosRecarga"));
                armaBlaster.setDanio(rs.getInt("danio"));
                lista.add(armaBlaster);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    /**
     * Carga un arma bláster específica de la base de datos por su ID.
     *
     * @param con La conexión a la base de datos.
     * @param id  El ID del arma bláster a cargar.
     * @return Un objeto ArmaBlasterDO con los datos del arma bláster, o null si no se encontró.
     */
    public static ArmaBlasterDO cargar(Connection con, int id) {
        ArmaBlasterDO armaBlaster = null;
        String sql = "SELECT * FROM ArmaBlaster WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                armaBlaster = new ArmaBlasterDO();
                armaBlaster.setId(rs.getInt("id"));
                armaBlaster.setNombre(rs.getString("nombre"));
                armaBlaster.setPuntosRecarga(rs.getInt("puntosRecarga"));
                armaBlaster.setDanio(rs.getInt("danio"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return armaBlaster;
    }
}