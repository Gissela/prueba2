
package conexion.java;

import java.sql.ResultSet;
import java.sql.Statement;


public class ConexionOracle {

    public static void main(String[] args) {
        if (Conexion.conectar()==null) {
            System.out.println("La conexion falló!!!!!");
        } else {
            System.out.println("La conexión fue exitosa :) :) ");
           
            try {
                 Statement st= Conexion.conectar().createStatement();
                 ResultSet rs= st.executeQuery("Select * from persona");
                 
                 while (rs.next()) {   
                     System.out.println("ID:"+rs.getInt("IDPERSONA")+" "+"NOMBRE:"
                             +rs.getString("NOMBRE")+" "+"APELLIDO PATERNO:"
                             +rs.getString("APELLIDO_PAT")+"  "+"APELLIDO MATERNO:" 
                             +rs.getString("APELLIDO_MAT"));
                    
                }
            } 
            catch (Exception e) {
                
            }
            
        }
    }
    
}
