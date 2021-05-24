
package com.integrador2.serviciosgenerales.negocio;

import com.integrador2.serviciosgenerales.datos.ConexionDB;
import com.integrador2.serviciosgenerales.entidad.Administrador;
import com.integrador2.serviciosgenerales.entidad.Cliente;
import com.integrador2.serviciosgenerales.entidad.Especialista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lhuallpa
 */
public class Proceso_Validadores{
    
    public ArrayList Login(String correo,String contra){
        Cliente c= logcli(correo, contra);
        Administrador a = logadm(correo, contra);
        Especialista e= logesp(correo, contra);        
        ArrayList lista = new ArrayList();
        if(c!=null){
            lista.add(c.getIdCliente());
            lista.add(c.getIdUsuario());
        }
        if(a!=null){
            lista.add(a.getIdAdmin());
            lista.add(a.getIdUsuario());
        }
        if(e!=null){
            lista.add(e.getIdEspecialista());
            lista.add(e.getIdUsuario());
        }
        return lista;
    }
    private Cliente logcli(String correo, String contrasena){
        Cliente c = null;
        ConexionDB objcn = new ConexionDB();
        Connection cn= objcn.abrirConexion();
        String sqlcli="SELECT idCLIENTE,idUSUARIO from CLIENTE WHERE CLIENTE_correo=? and CLIENTE_contrasena=?";
        try {
            PreparedStatement st= cn.prepareStatement(sqlcli);
            st.setString(1, correo);
            st.setString(2, contrasena);            
            ResultSet rs= st.executeQuery();
                        
            while (rs.next()){ 
                c= new Cliente();
                c.setIdCliente(rs.getString(1));
                c.setIdUsuario(rs.getString(2));
            }            
        } catch (SQLException ex) {
            Logger.getLogger(Proceso_Validadores.class.getName()).log(Level.SEVERE, null, ex);
        }
        objcn.cerrarConexion();
        return c;
    }
    
    private Administrador logadm(String correo, String contrasena){
        Administrador a = null;
        ConexionDB objcn = new ConexionDB();
        Connection cn= objcn.abrirConexion();
        String sqlAdmi="SELECT idADMINISTRADOR,idUSUARIO from ADMINISTRADOR WHERE ADMINISTRADOR_correo=? and ADMINISTRADOR_contrasena=?";
        try {
            PreparedStatement st= cn.prepareStatement(sqlAdmi);
            st.setString(1, correo);
            st.setString(2, contrasena);            
            ResultSet rs= st.executeQuery();                        
            while (rs.next()){ 
                a= new Administrador();
                a.setIdAdmin(rs.getString(1));
                a.setIdUsuario(rs.getString(2));
            }            
        } catch (SQLException ex) {
            Logger.getLogger(Proceso_Validadores.class.getName()).log(Level.SEVERE, null, ex);
        }
        objcn.cerrarConexion();
        return a;
    }
        
    private Especialista logesp(String correo, String contrasena){
        Especialista e = null;
        ConexionDB objcn = new ConexionDB();
        Connection cn= objcn.abrirConexion();        
        String sqlEspe="SELECT idESPECIALISTA,idUSUARIO from ESPECIALISTA WHERE ESPECIALISTA_correo=? and ESPECIALISTA_contrasena=?";        
        try {
            PreparedStatement st= cn.prepareStatement(sqlEspe);
            st.setString(1, correo);
            st.setString(2, contrasena);            
            ResultSet rs= st.executeQuery();
                        
            while (rs.next()){ 
                e= new Especialista();
                e.setIdEspecialista(rs.getString(1));
                e.setIdUsuario(rs.getString(2));
            }            
        } catch (SQLException ex) {
            Logger.getLogger(Proceso_Validadores.class.getName()).log(Level.SEVERE, null, ex);
        }
        objcn.cerrarConexion();
        return e;
    }
    
    public String Formato24(String hora){
        SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm");
        SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
        String hora24="";  
        try {
            Date date = parseFormat.parse(hora);
            hora24=displayFormat.format(date);
        } catch (Exception ex) {
            
        }        
        return hora24;
    }
    
    public String Formato12(String hora){
        SimpleDateFormat displayFormat = new SimpleDateFormat("hh:mm a");
        SimpleDateFormat parseFormat = new SimpleDateFormat("HH:mm");
        String hora12="";  
        try {
            Date date = parseFormat.parse(hora);
            hora12=displayFormat.format(date);
        } catch (Exception ex) {
            
        }        
        return hora12;
    }
    

	
// Suma los días recibidos a la fecha  
    public String SumarFechas(Date fecha, int dias){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        calendar.setTime(fecha); // Configuramos la fecha que se recibe
	calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0        
        String fechaTexto = formatter.format(calendar.getTime());	
        return fechaTexto; // Devuelve el objeto Date con los nuevos días añadidos
        
    }
    
    
}


