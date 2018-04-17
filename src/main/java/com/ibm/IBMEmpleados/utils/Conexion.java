/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.IBMEmpleados.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Luis Eduardo Montoya
 */
public class Conexion {
    public static Connection getConexion() throws SQLException {
        //Este es la instrucción para la conexión. Cabe destacar que se quitó password porque mi servidor no tiene contraseña
        //"jdbc:mysql://localhost/test?user=root&password=root";
        String cadenaConexion = "jdbc:mysql://158.85.231.24/devops?user=devops&password=caminorojoecatepec";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return DriverManager.getConnection(cadenaConexion);
        //return DriverManager.getConnection("jdbc:mariadb://localhost/devops", "root", null);
    }
    
    public static void main(String[] args) {
        try {
            if(Conexion.getConexion() != null)
                System.out.println("Conexión realizada");
            else
                System.out.println("Fallo de conexión");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
