package tests;

import java.sql.Connection;
import java.util.ArrayList;

import DAO.JediDAO;
import DAO.SithDAO;
import DO.ClonDO;
import utils.UtilsBD;

public class PruebaBD {

    public static void main(String[] args) {
        // Conexión a la base de datos usando UtilsBD
        Connection con = UtilsBD.ConectarBD();

        if (con != null) {
            System.out.println("Conexión a la base de datos establecida.");

            // ID del Jedi para las pruebas 
            int idJedi = 8;

            // calcularTotalEnergiaOscuraSith
            int totalEnergiaOscura = SithDAO.calcularTotalEnergiaOscuraSith(con, idJedi);
            System.out.println("Total de energía oscura de los Sith con nivel de maldad > 7: " + totalEnergiaOscura);

            //  cantidadArmas
            int cantidadArmas = JediDAO.cantidadArmas(idJedi, con);
            System.out.println("Cantidad de armas bláster asignadas a los clones del Jedi con ID " + idJedi + ": " + cantidadArmas);

            // Prueba de cargarClonesConRefuerzoAdrenalina
            ArrayList<ClonDO> clonesConRefuerzo = JediDAO.cargarClonesConRefuerzoAdrenalina(con, idJedi);
            System.out.println("Clones con refuerzo adrenalina activo liderados por el Jedi con ID " + idJedi + ":");
            for (ClonDO clon : clonesConRefuerzo) {
                System.out.println(clon);
            }

            // Cerrar la conexión a la base de datos
            try {
                con.close();
                System.out.println("Conexión a la base de datos cerrada.");
            } catch (Exception e) {
                System.err.println("Error al cerrar la conexión a la base de datos:");
                e.printStackTrace();
            }
        } else {
            System.err.println("No se pudo establecer la conexión a la base de datos.");
        }
    }
}