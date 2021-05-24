
package com.integrador2.serviciosgenerales.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@MultipartConfig
@WebServlet(name = "Control", urlPatterns = {"/Control"})
public class Control extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     /*   String paginaListarCliente="paginas cliente/listar.jsp";
        String paginaAgregarCliente="paginas cliente/agregar.jsp";
        String paginaEditarCliente="paginas cliente/editar.jsp";
        String paginaListarDistrito="paginas distrito/listar.jsp";
        String paginaAgregarDistrito="paginas distrito/agregar.jsp";
        String paginaEditarDistrito="paginas distrito/editar.jsp";
        String paginaAgregarCuenta="paginas cuenta/agregar.jsp";
        String paginaListarCuenta="paginas cuenta/listar.jsp";
        String paginaMovimientoCuenta="paginas cuenta/movimiento.jsp";
        String paginaAgregarEmpleado="paginas empleado/agregar.jsp";
        String paginaListarEmpleado="paginas empleado/listar.jsp";
                
        String action = request.getParameter("accion");
        
        String acceso=null;
        

        
        //accesos a las paginas empleado
        if(action.equalsIgnoreCase("login")){
            acceso="Login.jsp";
        }
        
        
        //accesos a las paginas cliente
        if(action.equalsIgnoreCase("listarCliente")){
            acceso=paginaListarCliente;
        }
        if(action.equalsIgnoreCase("agregarCliente")){
            acceso=paginaAgregarCliente;
        }
        if(action.equalsIgnoreCase("enviar Cliente")){
            String dni = request.getParameter("dni");
            String nom = request.getParameter("nombre");
            String dir = request.getParameter("direccion");
            String tel = request.getParameter("telefono");
            String cor = request.getParameter("correo");            
            int dis = Integer.parseInt(request.getParameter("distrito"));
            c=new Cliente();
            c.setDni(dni);
            c.setNombre(nom);
            c.setDireccion(dir);
            c.setTelefono(tel);
            c.setCorreo(cor);
            c.setCodDistrito(dis);
            
            dao.agregar(c);
            acceso=paginaListarCliente;
        }
        if(action.equalsIgnoreCase("borrarCliente")){
            String dni = request.getParameter("dni");
            dao.eliminar(dni);
            acceso=paginaListarCliente;
        }
        if(action.equalsIgnoreCase("editarCliente")){
            request.setAttribute("miDni", request.getParameter("dni"));
            acceso=paginaEditarCliente;
        }
        if(action.equalsIgnoreCase("actualizar Cliente")){
            String dni = request.getParameter("dni");
            String nom = request.getParameter("nombre");
            String dir = request.getParameter("direccion");
            String tel = request.getParameter("telefono");
            String cor = request.getParameter("correo");
            int dis = Integer.parseInt(request.getParameter("distrito"));
            c.setDni(dni);
            c.setNombre(nom);
            c.setDireccion(dir);
            c.setTelefono(tel);
            c.setCorreo(cor);
            c.setCodDistrito(dis);
            dao.editar(c);
            acceso=paginaListarCliente;
        }
        
        //accesos a las paginas distrito
        if(action.equalsIgnoreCase("listarDistrito")){
            acceso=paginaListarDistrito;
        }
        if(action.equalsIgnoreCase("agregarDistrito")){
            acceso=paginaAgregarDistrito;
        }
        if(action.equalsIgnoreCase("enviar distrito")){
            int cod = Integer.parseInt(request.getParameter("codigo"));
            String nom = request.getParameter("nombre");
           // d=new Distrito();
            d.setCodigo(cod);
            d.setNombre(nom);            
            dao2.agregar(d);
            acceso=paginaListarDistrito;
        }
        if(action.equalsIgnoreCase("borrarDistrito")){
            int cod = Integer.parseInt(request.getParameter("codigo"));
            dao2.eliminar(cod);
            acceso=paginaListarDistrito;
        }
        if(action.equalsIgnoreCase("editarDistrito")){
            request.setAttribute("codigoDistrito", request.getParameter("codigo"));
            acceso=paginaEditarDistrito;
        }
        if(action.equalsIgnoreCase("actualizar distrito")){
            int cod = Integer.parseInt(request.getParameter("codigo"));
            String nom = request.getParameter("nombre");            
            d.setCodigo(cod);
            d.setNombre(nom);
            dao2.editar(d);
            acceso=paginaListarDistrito;
        }
        
        //accesos pagina cuenta
        if(action.equalsIgnoreCase("agregarCuenta")){
            acceso=paginaAgregarCuenta;
        }
        if(action.equalsIgnoreCase("Buscar")){
           int nro = Integer.parseInt(request.getParameter("numero"));
           String dni=request.getParameter("dni");  
           c=dao.listar(dni);      
           request.setAttribute("cta", nro);
           request.setAttribute("cli", c);
           request.setAttribute("lista", vc);           
           acceso=paginaAgregarCuenta;
        }
        
        if(action.equalsIgnoreCase("Agregar")){
            int nro = Integer.parseInt(request.getParameter("numero"));
            String dni = request.getParameter("dni");
            String nom = request.getParameter("nombre");
            String tel = request.getParameter("telefono");
            c.setDni(dni);
            c.setNombre(nom);
            c.setTelefono(tel);
            vc.add(c);
            System.out.println("CANT: "+vc.size());
            request.setAttribute("cta", nro);
            request.setAttribute("lista", vc);
            acceso=paginaAgregarCuenta;
        }
        
        if(action.equalsIgnoreCase("Guardar cuenta")){
            int nro = Integer.parseInt(request.getParameter("numero"));
            double sal = Double.parseDouble(request.getParameter("saldo"));
            String mon = request.getParameter("moneda");
            t.setNumero(nro);
            t.setSaldo(sal);
            t.setMoneda(mon);
            dao3.agregar(t);
            //Guardar tabla cli/cta
            for(int i=0; i<vc.size(); i++){
                t=new Cuenta();
                t.setNumero(nro);
                t.setDni(vc.get(i).getDni());
                dao3.agregarCuentaCliente(t);
            }
            acceso=paginaAgregarCuenta;
        }
        if(action.equalsIgnoreCase("listarCuenta")){
            vt=dao3.listarTodo();
            request.setAttribute("listaCta", vt);
            acceso=paginaListarCuenta;
        }
        

   
         
        RequestDispatcher rd=request.getRequestDispatcher(acceso);
        rd.forward(request, response);*/
        
        
        
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
        processRequest(request, response);
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
