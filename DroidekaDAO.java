package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DO.DroidekaDO;

public class DroidekaDAO {
	

	/****************
	*FUNCIONES
	*****************/


    /**
     * Elimina un droideka de la base de datos por su ID.
     *
     * @param id  El ID del droideka a eliminar.
     * @param con La conexión a la base de datos.
     * @return 0 si la operación fue exitosa, -1 si hubo un error.
     */
    public static int eliminar(int id, Connection con) {
        String sql = "DELETE FROM Droideka WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0 ? 0 : -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Inserta un nuevo droideka en la base de datos.
     *
     * @param droideka El objeto DroidekaDO con los datos del droideka.
     * @param con      La conexión a la base de datos.
     * @return 0 si la operación fue exitosa, -1 si hubo un error.
     */
    public static int insertar(DroidekaDO droideka, Connection con) {
        String sql = "INSERT INTO Droideka (nombre, apodoGuerra, modelo, fuerza, horasInactividad, tiempoRefuerzoAdrenalina) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, droideka.getNombre());
            pstmt.setString(2, droideka.getApodoGuerra());
            pstmt.setString(3, droideka.getModelo());
            pstmt.setInt(4, droideka.getFuerza());
            pstmt.setInt(5, droideka.getHorasInactividad());
            pstmt.setInt(6, droideka.getTiempoRefuerzoAdrenalina());
            return pstmt.executeUpdate() > 0 ? 0 : -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Actualiza un droideka existente en la base de datos.
     *
     * @param droideka El objeto DroidekaDO con los datos actualizados.
     * @param con      La conexión a la base de datos.
     * @return 0 si la operación fue exitosa, -1 si hubo un error.
     */
    public static int actualizar(DroidekaDO droideka, Connection con) {
        String sql = "UPDATE Droideka SET nombre = ?, apodoGuerra = ?, modelo = ?, fuerza = ?, horasInactividad = ?, tiempoRefuerzoAdrenalina = ? WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, droideka.getNombre());
            pstmt.setString(2, droideka.getApodoGuerra());
            pstmt.setString(3, droideka.getModelo());
            pstmt.setInt(4, droideka.getFuerza());
            pstmt.setInt(5, droideka.getHorasInactividad());
            pstmt.setInt(6, droideka.getTiempoRefuerzoAdrenalina());
            pstmt.setInt(7, droideka.getId());
            return pstmt.executeUpdate() > 0 ? 0 : -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Carga todos los droidekas de la base de datos.
     *
     * @param con La conexión a la base de datos.
     * @return Una lista de objetos DroidekaDO con todos los droidekas.
     */
    public static ArrayList<DroidekaDO> cargarTodo(Connection con) {
        ArrayList<DroidekaDO> droidekas = new ArrayList<>();
        String sql = "SELECT * FROM Droideka";
        try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                DroidekaDO droideka = new DroidekaDO();
                droideka.setId(rs.getInt("id"));
                droideka.setNombre(rs.getString("nombre"));
                droideka.setApodoGuerra(rs.getString("apodoGuerra"));
                droideka.setModelo(rs.getString("modelo"));
                droideka.setFuerza(rs.getInt("fuerza"));
                droideka.setHorasInactividad(rs.getInt("horasInactividad"));
                droideka.setTiempoRefuerzoAdrenalina(rs.getInt("tiempoRefuerzoAdrenalina"));
                droidekas.add(droideka);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return droidekas;
    }

    /**
     * Carga un droideka específico de la base de datos por su ID.
     *
     * @param con La conexión a la base de datos.
     * @param id  El ID del droideka a cargar.
     * @return Un objeto DroidekaDO con los datos del droideka, o null si no se encontró.
     */
    public static DroidekaDO cargar(Connection con, int id) {
        DroidekaDO droideka = null;
        String sql = "SELECT * FROM Droideka WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    droideka = new DroidekaDO();
                    droideka.setId(rs.getInt("id"));
                    droideka.setNombre(rs.getString("nombre"));
                    droideka.setApodoGuerra(rs.getString("apodoGuerra"));
                    droideka.setModelo(rs.getString("modelo"));
                    droideka.setFuerza(rs.getInt("fuerza"));
                    droideka.setHorasInactividad(rs.getInt("horasInactividad"));
                    droideka.setTiempoRefuerzoAdrenalina(rs.getInt("tiempoRefuerzoAdrenalina"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return droideka;
    }

    /**
     * Carga una lista de droidekas liderados por un Sith específico, filtrados según los parámetros proporcionados.
     *
     * @param con        La conexión a la base de datos.
     * @param idSith     El ID del Sith que lidera los droidekas.
     * @param parametros Un array de 4 elementos que contiene: campo, comparación, valor y tipo de dato.
     *                   Ejemplo: ("fuerza", ">", "50", "entero").
     * @return Una lista de objetos DroidekaDO con los droidekas que cumplen los filtros.
     */
    public static ArrayList<DroidekaDO> cargarDroidekasFiltrado(Connection con, int idSith, String[] parametros) {
        ArrayList<DroidekaDO> droidekas = new ArrayList<>();
        // Verificar que los parámetros sean válidos
        if (parametros == null || parametros.length != 4) {
            throw new IllegalArgumentException("El array de parámetros debe contener 4 elementos: campo, comparación, valor y tipo de dato.");
        }
        String campo = parametros[0];
        String comparacion = parametros[1];
        String valor = parametros[2];
        String tipoDato = parametros[3];

        // Construir la consulta SQL dinámicamente
        String sql = "SELECT * FROM Droideka WHERE Sith_id = ? AND " + campo + " " + comparacion + " ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, idSith);
            // Establecer el valor según el tipo de dato
            switch (tipoDato.toLowerCase()) {
                case "entero":
                    pstmt.setInt(2, Integer.parseInt(valor));
                    break;
                case "decimal":
                    pstmt.setDouble(2, Double.parseDouble(valor));
                    break;
                case "texto":
                    pstmt.setString(2, valor);
                    break;
                default:
                    throw new IllegalArgumentException("Tipo de dato no válido. Use 'entero', 'decimal' o 'texto'.");
            }
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    DroidekaDO droideka = new DroidekaDO();
                    droideka.setId(rs.getInt("id"));
                    droideka.setNombre(rs.getString("nombre"));
                    droideka.setApodoGuerra(rs.getString("apodoGuerra"));
                    droideka.setModelo(rs.getString("modelo"));
                    droideka.setFuerza(rs.getInt("fuerza"));
                    droideka.setHorasInactividad(rs.getInt("horasInactividad"));
                    droideka.setTiempoRefuerzoAdrenalina(rs.getInt("tiempoRefuerzoAdrenalina"));
                    droidekas.add(droideka);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El valor proporcionado no coincide con el tipo de dato especificado.");
        }
        return droidekas;
       
    }
    
}