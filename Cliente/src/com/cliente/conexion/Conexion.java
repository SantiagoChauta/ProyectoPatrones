package com.cliente.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

import oracle.jdbc.driver.OracleDriver;

public class Conexion {
	Connection con;
    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    String user="SANTIAGO";
    String pass ="SANTI";
    
    
    public Connection conectar(){
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con =DriverManager.getConnection(url,user,pass);
        }catch(Exception e){
            System.out.println("Fallo la conexion");
        }
        return con;
    }
}
