package com.sic;

import java.sql.*;
/**
 
 * Consultar datos de MYSQL!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       // System.out.println( "Hello World!" );
       //Try-Catch para manejo de errores
        try {
            //Llamada a la libreria mysql conector
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Nueva conexión                           conexión a localhost |   nombre de bd | ususario mysql | contraseña  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/datos", "erikabarojas", "Hallie");
            //Nuevo statement para crear datos 
                 Statement stmt = con.createStatement(); 
           //Creación de Query | Insertar valores 
           //Estos valores deben coincidir con los tipos de datos que se asignaron durante la creación de la tabla 
                 stmt.executeUpdate("INSERT INTO alumnos VALUES(2,'Santiago','López','20524700')"); 
            //Nuevo statement para llamada de datos
            //Statement stmt = con.createStatement();
            //Creación de Query | llamada a todos los datos de la tabla alumnos
            ResultSet rs = stmt.executeQuery("select * from alumnos");
            //Ciclo de todos los elementos obtenidos por el query
            while (rs.next())
                //Impresión de los valores
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3)+ " " + rs.getString(4));
            //Se cierra la conexión 
            con.close();
        } catch (Exception e) {
            //Imprimir errores 
            System.out.println(e);
        }
    }

}
 
