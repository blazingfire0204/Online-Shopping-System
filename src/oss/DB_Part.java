/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oss;

import java.sql.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HELLO
 */
public class DB_Part {
     public static Connection con = null;
     public static String DriverTest() {
            String ret ="";
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
            }catch (java.lang.ClassNotFoundException e){
                return"Class Not Found Exception!";
            }
            return("Driver found");
    }
      public static Connection getConnection(String uid,String pwd) {
            String userid = uid;
            String password =pwd;
            String hostname ="127.0.0.1";
            String dbName ="onlineshopping_db";
            String url ="jdbc:mysql://"+hostname+":3306/"+dbName+"?autoReconnect=true&useSSL=false";
            con = null;
            try{
                con =DriverManager.getConnection(url,userid,password);
            }
            catch (SQLException ex) {
                System.out.println("Error:"+ex);
                con=null;
            }
            return(con);
        }
       public static int UpdateTable(Connection conn,String SQL)throws SQLException,ClassNotFoundException{
        Statement stmt=null;
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
               ResultSet.CONCUR_UPDATABLE);
        
        int ret=stmt.executeUpdate(SQL);
        return(ret);
    }
        public static ResultSet Query(Connection conn,String SQL)throws SQLException,ClassNotFoundException{
        Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
               ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery(SQL);
        return(rs);
    }
    public static DefaultTableModel buildTableModel(ResultSet rs)
            throws SQLException {
        DefaultTableModel tablemodel = new DefaultTableModel();
        ResultSetMetaData metaData = rs.getMetaData();
        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            tablemodel.addColumn(metaData.getColumnName(column));
        }
        ResultSetMetaData meta = rs.getMetaData();
        int numberOfColumns = meta.getColumnCount();
        // data of the table
        while (rs.next()) {
            Object[] rowData = new Object[numberOfColumns];
            for (int i = 0; i < rowData.length; ++i) {
                rowData[i] = rs.getObject(i + 1);
            }
            tablemodel.addRow(rowData);
        }
        return (tablemodel);
    }
   
    
}
