
package com.integrador2.serviciosgenerales.servlets;

import com.integrador2.serviciosgenerales.entidad.Cliente;
import com.integrador2.serviciosgenerales.negocio.Proceso_Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Cliente", urlPatterns = {"/cliente"})
public class ClienteController extends HttpServlet {

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try ( PrintWriter out = response.getWriter()) {
      /* TODO output your page here. You may use following sample code. */
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet RegistrarCliente</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Servlet RegistrarCliente at " + request.getContextPath() + "</h1>");
      out.println("</body>");
      out.println("</html>");
    }
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    // Campos
    UUID id = UUID.randomUUID();
    String nombre = request.getParameter("nombre");
    String apellidopaterno = request.getParameter("apellidopaterno");
    String apellidomaterno = request.getParameter("apellidomaterno");
    String tipodocumento = request.getParameter("tipodocumento");
    String numerodocumento = request.getParameter("numerodocumento");
    String correo = request.getParameter("correo");
    String sexo = request.getParameter("sexo");
    String fechanacimiento = "1990-01-01";
    String direccion = request.getParameter("direccion");
    String departamento = "LIMA";
    String provincia = "LIMA";
    String distrito = request.getParameter("distrito");
    String celular = "999888777";
    String contrasena = request.getParameter("contrasena");
    String estado = "ACTIVO";
    String idUSUARIO = "2";

    //  Objeto cliente
    Cliente cliente = new Cliente();
    cliente.setIdCliente(id.toString());
    cliente.setNombreCliente(nombre);
    cliente.setApellidopaternoCliente(apellidopaterno);
    cliente.setApellidomaternoCliente(apellidomaterno);
    cliente.setTipodocumentoCliente(tipodocumento);
    cliente.setNumerodocumentoCliente(Integer.parseInt(numerodocumento));
    cliente.setCorreoCliente(correo);
    cliente.setSexoCliente(sexo);
    cliente.setFechanacimientoCliente(fechanacimiento);
    cliente.setDireccionCliente(direccion);
    cliente.setDepartamentoCliente(departamento);
    cliente.setProvinciaCliente(provincia);
    cliente.setDistritoCliente(distrito);
    cliente.setCelularCliente(Integer.parseInt(celular));
    cliente.setContrasenaCliente(contrasena);
    cliente.setEstadoCliente(estado);
    cliente.setIdUsuario(idUSUARIO);

    Proceso_Cliente proceso = new Proceso_Cliente();
    Boolean result = proceso.registrar(cliente);
    RequestDispatcher rs = null;
    if (result) {
      rs = request.getRequestDispatcher("mensajeClienteRegistrado.jsp");
    } else {
      rs = request.getRequestDispatcher("loginCliente.jsp");
    }
    rs.forward(request, response);
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}
