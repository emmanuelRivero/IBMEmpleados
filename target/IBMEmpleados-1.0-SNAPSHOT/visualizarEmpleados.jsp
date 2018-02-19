<%-- 
    Document   : visualizarEmpleados
    Created on : Feb 13, 2018, 10:20:24 AM
    Author     : LUISEDUARDOMONTOYAMA
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.ibm.IBMEmpleados.utils.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visualizar Empleados</title>
         <script
            src="http://code.jquery.com/jquery-3.3.1.js"
            integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
            crossorigin="anonymous"></script>
        <!-- Latest compiled and minified CSS -->
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" 
              integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        
        <script type="application/javascript">
            $(document).ready(function(){
                $("#registrar").click(function(){
                    window.location = "index.jsp";
                });
            });
        </script>
    </head>
    <body>
        <div class="container">
            <table class="table">
                <thead>
                    <th>Nombre</th>
                    <th>Apellido Paterno</th>
                    <th>Apellido Materno</th>
                    <th>Fecha Nacimiento</th>
                    <th>Género</th>
                </thead>
                <tbody>
                    <%
                        Connection conn = Conexion.getConexion();
                        String sql = "SELECT nombre,apPaterno,apMaterno,feNacimiento,genero FROM empleados";
                        try {
                            PreparedStatement statement = conn.prepareStatement(sql);
                            ResultSet rs = statement.executeQuery();
                            while(rs.next()){
                                %>
                                <tr>
                                    <td><%= rs.getString(1)%></td>
                                    <td><%= rs.getString(2)%></td>
                                    <td><%= rs.getString(3)%></td>
                                    <td><%= rs.getString(4)%></td>
                                    <td><%= rs.getString(5)%></td>
                                </tr>
                                <%
                            }
                            
                        } catch(SQLException ex){
                            System.out.println(ex.getMessage());
                        }
                    %>
                </tbody>
            </table>
            <button class="btn btn-primary" id="registrar">Registrar Empleado</button>
        </div>
    </body>
</html>
