/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.IBMEmpleados.dao;

import com.ibm.IBMEmpleados.bean.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author LUISEDUARDOMONTOYAMA
 */
public class EmpleadoDao {
    public static int registraEmpleado(Connection conn, Empleado empleado){
        String consulta = "INSERT INTO empleados(nombre, apPaterno, apMaterno, feNacimiento, genero) VALUES(?,?,?,?,?)";
        int id = -1;
        try {
            PreparedStatement statement = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, empleado.getNombre()); statement.setString(2, empleado.getApPaterno());
            statement.setString(3, empleado.getApMaterno()); statement.setString(4, empleado.getFeNacimiento());
            statement.setString(5, empleado.getGenero() + ""); statement.execute();
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            id = rs.getInt(1);
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }    
    
}
