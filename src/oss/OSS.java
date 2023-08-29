/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package oss;

import java.sql.*;

/**
 *
 * @author HELLO
 */
public class OSS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //String ret=DB_Part.DriverTest();
        //System.out.println(ret);
        Connection con =DB_Part.getConnection("root","Akshay");
        if(con!=null){
            System.out.println("Successfully connected");
            FrmLoginSymbol.main(null);
        }
        else
            System.out.println("Error while connecting to the Database!");
    }
    
}
