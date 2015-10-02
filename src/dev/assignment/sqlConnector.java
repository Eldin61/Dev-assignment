/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.assignment;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author eldin
 */
public class sqlConnector {
    String url = "jdbc:postgresql://localhost/test?user=postgres&password=root";
    
    public static void main(String[] args) throws Exception{
        
    }
    
    public void connect(){
        try {
            Connection conn = DriverManager.getConnection(url);
            System.out.println("connection worked!");
        } catch(Exception e){
            System.out.println("Connection failed");
        }
    }
}
