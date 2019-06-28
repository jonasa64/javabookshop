/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jonas
 */
public class DBConnection {
    
    
     private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://165.227.129.80:3306/webshop";
    private static String user = "";
    private static String password = "";
    private static Connection conn = null;

    public static Connection getConnection()
    {
        if (conn == null)
        {
            try
            {
                Class.forName(driver);
                conn = DriverManager.getConnection(url, user, password);
            }
            catch (ClassNotFoundException ex)
            {
                ex.printStackTrace();
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }
        
        return conn;
    }
    
}
