
package com.integrador2.serviciosgenerales.negocio;

import com.integrador2.serviciosgenerales.datos.ConexionDB;
import com.integrador2.serviciosgenerales.entidad.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Proceso_Cliente {

  public boolean registrar(Cliente cliente) {
    Boolean result = false;
    ConexionDB objcn = new ConexionDB();
    Connection cn = objcn.abrirConexion();
    String SQL_INSERT = "insert into cliente values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    try {
      PreparedStatement st = cn.prepareStatement(SQL_INSERT);
      st.setString(1, cliente.getIdCliente());
      st.setString(2, cliente.getNombreCliente());
      st.setString(3, cliente.getApellidopaternoCliente());
      st.setString(4, cliente.getApellidomaternoCliente());
      st.setString(5, cliente.getTipodocumentoCliente());
      st.setInt(6, cliente.getNumerodocumentoCliente());
      st.setString(7, cliente.getCorreoCliente());
      st.setString(8, cliente.getSexoCliente());
      st.setString(9, cliente.getFechanacimientoCliente());
      st.setString(10, cliente.getDireccionCliente());
      st.setString(11, cliente.getDepartamentoCliente());
      st.setString(12, cliente.getProvinciaCliente());
      st.setString(13, cliente.getDistritoCliente());
      st.setInt(14, cliente.getCelularCliente());
      st.setString(15, cliente.getContrasenaCliente());
      st.setString(16, cliente.getEstadoCliente());
      st.setString(17, cliente.getIdUsuario());
      if (st.executeUpdate() > 0) {
        result = true;
      }
    } catch (SQLException ex) {
      Logger.getLogger(Proceso_Validadores.class.getName()).log(Level.SEVERE, null, ex);
    }

    objcn.cerrarConexion();

    return result;
  }
}
