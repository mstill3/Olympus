/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stillwell.olympus.moneta;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NetBeans_connection_test {
    static final String userName="******";//put your MySQL user name
    static final String password="*****";//put your MySQL password
    private static Connection connection=null;
    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        Object newInstance;
        newInstance = Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://triton.towson.edu:3360/*****db", userName, password);// Please use your database name here
        PreparedStatement updateStaff;
        Statement queryStatement = connection.createStatement();
        updateStaff = null;
            String querys="select * from shongdb.staff;";
            ResultSet results = queryStatement.executeQuery(querys);
            while(results.next())
            {
                System.out.print(results.getString("fName"));
                System.out.print("    ");
                System.out.print(results.getString("lName"));
                System.out.println();
            }   querys="UPDATE shongdb.staff SET salary = 8802 WHERE staffNo = 'SA9';";
            updateStaff = connection.prepareStatement(querys);
            updateStaff.executeUpdate();
            
        
        
        // TODO code application logic here
    }
    
}
