package dev.assignment;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eldin
 */
public class serverWindow extends Application{;
    
    static Stage stage;
    Parent root;
    
    private int balance;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        root = FXMLLoader.load(getClass().getResource("serverLoginScreen.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        
    }
    
    public void close(){
        stage.close();
    }
}
