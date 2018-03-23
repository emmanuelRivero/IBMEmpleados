/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.IBMEmpleados.controller;

import com.ibm.IBMEmpleados.bean.Empleado;
import com.ibm.IBMEmpleados.dao.EmpleadoDao;
import com.ibm.IBMEmpleados.utils.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LUISEDUARDOMONTOYAMA
 */
@WebServlet(name = "RegistraEmpleadoController", urlPatterns = {"/RegistraEmpleadoController"})
public class RegistraEmpleadoController extends HttpServlet {

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
        
        Empleado empleado = new Empleado();
        empleado.setNombre(request.getParameter("nombre"));
        empleado.setApPaterno(request.getParameter("apPaterno"));
        empleado.setApMaterno(request.getParameter("apMaterno"));
        empleado.setFeNacimiento(request.getParameter("feNacimiento"));
        empleado.setGenero(request.getParameter("genero").charAt(0));
        
        try {
            int id = EmpleadoDao.registraEmpleado(Conexion.getConexion(), empleado);
            if(id == -1)
            {
                request.setAttribute("mensaje", "No se insertó correctamente");
            }else {
               request.setAttribute("mensaje", "Se insertó correctamente");
            }
            
            request.getRequestDispatcher("registroEmpleados.jsp").forward(request, response);
                    
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n" + ex.getCause());
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
