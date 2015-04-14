/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionocacle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author alumno04
 */
public class ConexionOracle {

    Connection cn = conexiondb.conectar();
    
    public Connection AbriConexion(){
        Connection cn = conexiondb.conectar(); 
        return cn;
}
    




  
    public static void main(String[] args) {
        ConexionOracle co =new ConexionOracle();
    
//        if (conexiondb.conectar() == null){
//            System.out.println("la conexion fallo.");
//            
//        } else {
//            System.out.println("la conexion fue un exito.");
//            
//        }
        //metodo que inserta un registro en la Db 
        co.insert();
        
        //metodo 
        
        //metodo que elimina registro mediante en la DB
        
        
        //
        
        
        
    }
    public void insert(){
        Statement st = null;
        String query = "INSERT INTO persona VALUE(1,'gisela','vasquez','salazar',46707501)";
        try {
            st = AbriConexion().createStatement();
            st.executeUpdate(query);
            AbriConexion().commit();
            AbriConexion().close();
            System.out.println("se inserto satisfactoriamente");
        } catch (Exception e) {
             e.printStackTrace();//corre en color rojo cuando imprimimos
            try {
                 AbriConexion().rollback();
                 AbriConexion().close();
            } catch (Exception ex) {
            }
           
            
        }
    }
    public void select(){
        Statement st = null;
        ResultSet rs = null;
        String query = "SELECT * FROM persona";
        try {
            st = AbriConexion().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {   
                System.out.println("ID:"+rs.getInt("idpersona")+", Nombre:"+rs.getString("nombre")+
                        ", apellido_pat"+rs.getString("apellido_pat")+", apellido_mat:"+rs.getString("apellido_mat")+
                        ", DNI:"+rs.getInt("dni"));
           
            }
            AbriConexion().close();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                AbriConexion().close();
            } catch (Exception ex) {
            }
        }
      }
    public void Delete(int id){
    
        Statement st =null;
        String query = "DELETE FROM persona WHERE idpersona="+id;
        try {
            st =AbriConexion().createStatement();
            st.executeUpdate(query);
            AbriConexion().commit();
            AbriConexion().close();
            System.out.println("elimine satisfactiriamente");
        } catch (Exception e) {
            e.printStackTrace();
            try {
                AbriConexion().commit();
                AbriConexion().close();
            } catch (Exception ex) {
            }
        }
    }
    public void Update (int id, String nombre, String apellido_pat, String apellido_mat, int dni){
        Statement st = null;
        String query = "UPDATE persona SET nombre='"(nombre)',apellido_pat:"+
        try {
            st = AbriConexion().createStatement();
            st.executeQuery(query);
            AbriConexion().commit();
            AbriConexion().close();
            System.out.println("Actualizo satisfactoriamente");
        } catch (Exception e) {
            e.printStackTrace();
           try {
               AbriConexion().rollback();
               AbriConexion().close();
           }
        } catch (Exception ex) {
        }
        }
        
    }
    
    }

