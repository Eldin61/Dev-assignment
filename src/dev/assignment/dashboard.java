/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.assignment;

import static dev.assignment.DevAssignment.primaryStage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.eclipse.persistence.internal.libraries.asm.util.ASMifierAnnotationVisitor;

/**
 *
 * @author eldin
 */
public class dashboard extends Application{;
    
    static Stage stage;
    Parent root;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        
    }
    
    public void close(){
        stage.close();
    }
    
}
