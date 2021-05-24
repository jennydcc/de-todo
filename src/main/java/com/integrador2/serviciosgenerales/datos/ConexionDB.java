package com.integrador2.serviciosgenerales.datos;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConexionDB {
    Connection cn =null;
    public Connection abrirConexion(){       
        try{        
           Class.forName("com.mysql.jdbc.Driver");
           cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/detodo","root","@#jDev4321");           
        }catch (ClassNotFoundException ex){
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex){
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cn;
    }

    public void cerrarConexion(){
        try{
            cn.close();
        }catch(SQLException ex){
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}