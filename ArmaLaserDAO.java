package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DO.ArmaLaserDO;

public class ArmaLaserDAO {

    /**
     * Elimina un arma láser de la base de datos por su ID.
     *
     * @param id  El ID del arma láser a eliminar.
     * @param con La conexión a la base de datos.
     * @return 0 si la operación fue exitosa, -1 si hubo un error.
     */
    public static int eliminar(int id, Connection con) {
        String sql = "DELETE FROM ArmaLaser WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0 ? 0 : -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Inserta un nuevo arma láser en la base de datos.
     *
     * @param elementoDO El objeto ArmaLaserDO con los datos del arma láser.
     * @param con        La conexión a la base de datos.
     * @return 0 si la operación fue exitosa, -1 si hubo un error.
     */
    public static int insertar(ArmaLaserDO elementoDO, Connection con) {
        String sql = "INSERT INTO ArmaLaser (nombre, puntosRecarga, danio) VALUES (?, ?, ?)";
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
     * Actualiza un arma láser existente en la base de datos.
     *
     * @param elementoDO El objeto ArmaLaserDO con los datos actualizados.
     * @param con        La conexión a la base de datos.
     * @return 0 si la operación fue exitosa, -1 si hubo un error.
     */
    public static int actualizar(ArmaLaserDO elementoDO, Connection con) {
        String sql = "UPDATE ArmaLaser SET nombre = ?, puntosRecarga = ?, danio = ? WHERE id = ?";
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
     * Carga todas las armas láser de la base de datos.
     *
     * @param con La conexión a la base de datos.
     * @return Una lista de objetos ArmaLaserDO con todas las armas láser.
     */
    public static ArrayList<ArmaLaserDO> cargarTodo(Connection con) {
        ArrayList<ArmaLaserDO> lista = new ArrayList<>();
        String sql = "SELECT * FROM ArmaLaser";
        try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                ArmaLaserDO armaLaser = new ArmaLaserDO();
                armaLaser.setId(rs.getInt("id"));
                armaLaser.setNombre(rs.getString("nombre"));
                armaLaser.setPuntosRecarga(rs.getInt("puntosRecarga"));
                armaLaser.setDanio(rs.getInt("danio"));
                lista.add(armaLaser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    /**
     * Carga un arma láser específica de la base de datos por su ID.
     *
     * @param con La conexión a la base de datos.
     * @param id  El ID del arma láser a cargar.
     * @return Un objeto ArmaLaserDO con los datos del arma láser, o null si no se encontró.
     */
    public static ArmaLaserDO cargar(Connection con, int id) {
        ArmaLaserDO armaLaser = null;
        String sql = "SELECT * FROM ArmaLaser WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                armaLaser = new ArmaLaserDO();
                armaLaser.setId(rs.getInt("id"));
                armaLaser.setNombre(rs.getString("nombre"));
                armaLaser.setPuntosRecarga(rs.getInt("puntosRecarga"));
                armaLaser.setDanio(rs.getInt("danio"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return armaLaser;
    }
}