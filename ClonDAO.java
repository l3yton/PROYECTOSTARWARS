package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DO.ClonDO;

public class ClonDAO {

    /****************************
     * FUNCIONES
     ****************************/

    public static int eliminar(int id, Connection con) {
    	String sql = "SELECT * FROM Clon WHERE idJedi = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0 ? 0 : -1;
        } catch (SQLException e) {
            System.err.println("⚠️ Error en la consulta: " + sql);
            e.printStackTrace();
            return -1;
        }
    }

    public static int insertar(ClonDO clon, Connection con) {
        String sql = "INSERT INTO Clon (apodoGuerra, modelo, fuerza, inteligencia, horasInactividad, tiempoRefuerzoAdrenalina, rolEnSpeeder, Speeder_id, Jedi_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, clon.getApodoGuerra());
            pstmt.setString(2, clon.getModelo());
            pstmt.setInt(3, clon.getFuerza());
            pstmt.setInt(4, clon.getInteligencia());
            pstmt.setInt(5, clon.getHorasInactividad());
            pstmt.setInt(6, clon.getTiempoRefuerzoAdrenalina());
            pstmt.setInt(7, clon.getRolEnSpeeder());
            pstmt.setInt(8, clon.getSpeeder_id());
            pstmt.setInt(9, clon.getJedi_id());
            return pstmt.executeUpdate() > 0 ? 0 : -1;
        } catch (SQLException e) {
            System.err.println("⚠️ Error en la consulta: " + sql);
            e.printStackTrace();
            return -1;
        }
    }

    public static int actualizar(ClonDO clon, Connection con) {
        String sql = "UPDATE Clon SET apodoGuerra = ?, modelo = ?, fuerza = ?, inteligencia = ?, horasInactividad = ?, tiempoRefuerzoAdrenalina = ?, rolEnSpeeder = ?, Speeder_id = ?, Jedi_id = ? WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, clon.getApodoGuerra());
            pstmt.setString(2, clon.getModelo());
            pstmt.setInt(3, clon.getFuerza());
            pstmt.setInt(4, clon.getInteligencia());
            pstmt.setInt(5, clon.getHorasInactividad());
            pstmt.setInt(6, clon.getTiempoRefuerzoAdrenalina());
            pstmt.setInt(7, clon.getRolEnSpeeder());
            pstmt.setInt(8, clon.getSpeeder_id());
            pstmt.setInt(9, clon.getJedi_id());
            pstmt.setInt(10, clon.getId());
            return pstmt.executeUpdate() > 0 ? 0 : -1;
        } catch (SQLException e) {
            System.err.println("⚠️ Error en la consulta: " + sql);
            e.printStackTrace();
            return -1;
        }
    }

    public static ArrayList<ClonDO> cargarTodo(Connection con) {
        ArrayList<ClonDO> clones = new ArrayList<>();
        String sql = "SELECT * FROM Clon";
        try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                clones.add(mapearClon(rs));
            }
        } catch (SQLException e) {
            System.err.println("⚠️ Error en la consulta: " + sql);
            e.printStackTrace();
        }
        return clones;
    }

    public static ClonDO cargar(Connection con, int id) {
        String sql = "SELECT * FROM Clon WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return mapearClon(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("⚠️ Error en la consulta: " + sql);
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<ClonDO> buscarConFiltros(Connection con, String modelo, Integer fuerzaMin, Integer jediId) {
        ArrayList<ClonDO> clones = new ArrayList<>();
        String sql = "SELECT * FROM Clon WHERE 1=1";

        if (modelo != null && !modelo.isEmpty()) sql += " AND modelo LIKE ?";
        if (fuerzaMin != null) sql += " AND fuerza >= ?";
        if (jediId != null) sql += " AND Jedi_id = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            int index = 1;
            if (modelo != null && !modelo.isEmpty()) pstmt.setString(index++, "%" + modelo + "%");
            if (fuerzaMin != null) pstmt.setInt(index++, fuerzaMin);
            if (jediId != null) pstmt.setInt(index++, jediId);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    clones.add(mapearClon(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println("⚠️ Error en la consulta: " + sql);
            e.printStackTrace();
        }
        return clones;
    }

    private static ClonDO mapearClon(ResultSet rs) throws SQLException {
        ClonDO clon = new ClonDO();
        clon.setId(rs.getInt("id"));
        clon.setApodoGuerra(rs.getString("apodoGuerra") != null ? rs.getString("apodoGuerra") : "Desconocido");
        clon.setModelo(rs.getString("modelo") != null ? rs.getString("modelo") : "Sin modelo");
        clon.setFuerza(rs.getInt("fuerza"));
        clon.setInteligencia(rs.getInt("inteligencia"));
        clon.setHorasInactividad(rs.getInt("horasInactividad"));
        clon.setTiempoRefuerzoAdrenalina(rs.getInt("tiempoRefuerzoAdrenalina"));
        clon.setRolEnSpeeder(rs.getInt("rolEnSpeeder"));
        clon.setSpeeder_id(rs.getInt("Speeder_id"));
        clon.setJedi_id(rs.getInt("Jedi_id"));
        return clon;
    }

}

