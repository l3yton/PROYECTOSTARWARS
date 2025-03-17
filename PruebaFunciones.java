package tests;

import java.sql.Connection;
import java.util.Date;
import java.util.ArrayList;
import DAO.SithDAO;
import DAO.JediDAO;
import DO.ClonDO;
import utils.UtilsBD;

public class PruebaFunciones {
    public static void main(String[] args) {
        // 1. Conecta a la base de datos
        Connection con = UtilsBD.ConectarBD();
        if(con != null) {
            System.out.println("Conexión establecida a las: " + new Date());
            
            // 2. Ejecutar calcularTotalEnergiaOscuraSith
            // Supongamos que usamos idSith = 1 para la prueba
            double totalEnergia = SithDAO.calcularTotalEnergiaOscuraSith(con, 1);
            System.out.println("Total de energía oscura del Sith con id 1: " + totalEnergia + " a las: " + new Date());
            
            // 3. Ejecutar cantidadArmas
            // Supongamos que usamos idJedi = 1 para la prueba
            int numArmas = JediDAO.cantidadArmas(1, con);
            System.out.println("Cantidad de armas asignadas a los clones del Jedi con id 1: " + numArmas + " a las: " + new Date());
            
            // 4. Ejecutar cargarClonesConRefuerzoAdrenalina
            ArrayList<ClonDO> clonesConAdrenalina = JediDAO.cargarClonesConRefuerzoAdrenalina(con, 1);
            System.out.println("Clones con refuerzo de adrenalina del Jedi con id 1:");
            for(ClonDO clon : clonesConAdrenalina) {
                System.out.println(clon.toString() + " a las: " + new Date());
            }
        } else {
            System.out.println("No se pudo establecer la conexión a la base de datos.");
        }
    }
}
