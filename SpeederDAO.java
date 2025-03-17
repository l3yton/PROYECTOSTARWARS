package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DO.ClonDO;
import DO.SpeederDO;

public class SpeederDAO {

    /**
     * Elimina un Speeder de la base de datos por su ID.
     *
     * @param id  El ID del Speeder a eliminar.
     * @param con La conexión a la base de datos.
     * @return 0 si la operación fue exitosa, -1 si hubo un error.
     */
    public static int eliminar(int id, Connection con) {
        String sql = "DELETE FROM Speeder WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0 ? 0 : -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Inserta un nuevo Speeder en la base de datos.
     *
     * @param speeder El objeto SpeederDO con los datos del Speeder.
     * @param con     La conexión a la base de datos.
     * @return 0 si la operación fue exitosa, -1 si hubo un error.
     */
    public static int insertar(SpeederDO speeder, Connection con) {
        String sql = "INSERT INTO Speeder (numSerie, marca, velocidadMaxima, armamento, municion, estado) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, speeder.getNumSerie());
            pstmt.setString(2, speeder.getMarca());
            pstmt.setInt(3, speeder.getVelocidadMaxima());
            pstmt.setString(4, speeder.getArmamento());
            pstmt.setInt(5, speeder.getMunicion());
            pstmt.setString(6, speeder.getEstado());
            return pstmt.executeUpdate() > 0 ? 0 : -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Actualiza un Speeder existente en la base de datos.
     *
     * @param speeder El objeto SpeederDO con los datos actualizados.
     * @param con     La conexión a la base de datos.
     * @return 0 si la operación fue exitosa, -1 si hubo un error.
     */
    public static int actualizar(SpeederDO speeder, Connection con) {
        String sql = "UPDATE Speeder SET numSerie = ?, marca = ?, velocidadMaxima = ?, armamento = ?, municion = ?, estado = ? WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, speeder.getNumSerie());
            pstmt.setString(2, speeder.getMarca());
            pstmt.setInt(3, speeder.getVelocidadMaxima());
            pstmt.setString(4, speeder.getArmamento());
            pstmt.setInt(5, speeder.getMunicion());
            pstmt.setString(6, speeder.getEstado());
            pstmt.setInt(7, speeder.getId());
            return pstmt.executeUpdate() > 0 ? 0 : -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Carga todos los Speeders de la base de datos.
     *
     * @param con La conexión a la base de datos.
     * @return Una lista de objetos SpeederDO con todos los Speeders.
     */
    public static ArrayList<SpeederDO> cargarTodo(Connection con) {
        ArrayList<SpeederDO> speeders = new ArrayList<>();
        String sql = "SELECT * FROM Speeder";
        try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                SpeederDO speeder = new SpeederDO();
                speeder.setId(rs.getInt("id"));
                speeder.setNumSerie(rs.getString("numSerie"));
                speeder.setMarca(rs.getString("marca"));
                speeder.setVelocidadMaxima(rs.getInt("velocidadMaxima"));
                speeder.setArmamento(rs.getString("armamento"));
                speeder.setMunicion(rs.getInt("municion"));
                speeder.setEstado(rs.getString("estado"));
                speeders.add(speeder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return speeders;
    }

    /**
     * Carga un Speeder específico de la base de datos por su ID.
     *
     * @param con La conexión a la base de datos.
     * @param id  El ID del Speeder a cargar.
     * @return Un objeto SpeederDO con los datos del Speeder, o null si no se encontró.
     */
    public static SpeederDO cargar(Connection con, int id) {
        SpeederDO speeder = null;
        String sql = "SELECT * FROM Speeder WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    speeder = new SpeederDO();
                    speeder.setId(rs.getInt("id"));
                    speeder.setNumSerie(rs.getString("numSerie"));
                    speeder.setMarca(rs.getString("marca"));
                    speeder.setVelocidadMaxima(rs.getInt("velocidadMaxima"));
                    speeder.setArmamento(rs.getString("armamento"));
                    speeder.setMunicion(rs.getInt("municion"));
                    speeder.setEstado(rs.getString("estado"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return speeder;
    }

    /**
     * Carga una lista de todos los clones asignados al Speeder con el ID especificado.
     *
     * @param idSpeeder El ID del Speeder.
     * @param con       La conexión a la base de datos.
     * @return Una lista de objetos ClonDO con los clones asignados al Speeder.
     */
    public static ArrayList<ClonDO> cargarClonesEnSpeeder(int idSpeeder, Connection con) {
        ArrayList<ClonDO> clones = new ArrayList<>();
        String sql = "SELECT * FROM Clon WHERE Speeder_id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, idSpeeder);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    ClonDO clon = new ClonDO();
                    clon.setId(rs.getInt("id"));
                    clon.setNombre(rs.getString("nombre"));
                    clon.setFuerza(rs.getInt("fuerza"));
                    clon.setTiempoRefuerzoAdrenalina(rs.getInt("tiempoRefuerzoAdrenalina"));
                    // Asignar otros campos según la estructura de ClonDO
                    clones.add(clon);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clones;
    }

    /**
     * Carga una lista de Speeders que tengan un armamento peligroso (cañones turboláser o misiles de plasma).
     *
     * @param con La conexión a la base de datos.
     * @return Una lista de objetos SpeederDO con los Speeders que tienen armamento peligroso.
     */
    public static ArrayList<SpeederDO> cargarSpeedersConArmamentoPeligroso(Connection con) {
        ArrayList<SpeederDO> speedersPeligrosos = new ArrayList<>();
        String sql = "SELECT * FROM Speeder";
        try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String armamento = rs.getString("armamento");
                if (armamento.contains("cañones turboláser") || armamento.contains("misiles de plasma")) {
                    SpeederDO speeder = new SpeederDO();
                    speeder.setId(rs.getInt("id"));
                    speeder.setNumSerie(rs.getString("numSerie"));
                    speeder.setMarca(rs.getString("marca"));
                    speeder.setVelocidadMaxima(rs.getInt("velocidadMaxima"));
                    speeder.setArmamento(armamento);
                    speeder.setMunicion(rs.getInt("municion"));
                    speeder.setEstado(rs.getString("estado"));
                    speedersPeligrosos.add(speeder);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return speedersPeligrosos;
    }

    /**
     * Cuenta el número total de Speeders destruidos en la base de datos.
     *
     * @param con La conexión a la base de datos.
     * @return El número de Speeders destruidos.
     */
    public static int contarSpeedersDestruidos(Connection con) {
        int count = 0;
        String sql = "SELECT * FROM Speeder";
        try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                if (rs.getString("estado").equalsIgnoreCase("destruido")) {
                    count++;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}


