/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;
import java.sql.*;

/**
 *
 * @author guita
 */
public class Conexion {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    public Conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "12345678");
            System.out.println("Conectado BD ");
        } catch (Exception e) {
             System.out.println("Error al conectar BD ");
    }
    }
    
        public int Repersonas(String Cedula, String Nombres, String Correo) {
            int res=0;
            try {
               
                ps=con.prepareStatement(" insert into personas(Cedula,Nombres,Correo)values(?,?,?) ");
                ps.setString(1, Cedula);
                ps.setString(2, Nombres);
                ps.setString(3, Correo); 
                res=ps.executeUpdate();
                System.out.println("Usuario registrado correctamente ");
            } catch (Exception e){
                System.out.println("Error al registrar ");
            
        }  
            return res;
    }
             

    public Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


