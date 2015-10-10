/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.assignment;

import dev.entity.Servers;
import dev.entity.Users;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author eldin
 */
public class serverController implements Initializable {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Dev_assignmentPU");
    private EntityManager em = emf.createEntityManager();
    private Servers server1 = em.find(Servers.class, "valveServers");
    @FXML
    private Label active;
    @FXML
    private Label servername;
    private fxmlController controller = new fxmlController();

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updateActiveServer();
        getServer();

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                updateActiveServerMin();
            }
        });
    }

    public void updateActiveServer() {
        server1.setConnectedUsers(server1.getConnectedUsers() + 1);
        updateObjectData(server1);
    }

    public void updateActiveServerMin() {
        server1.setConnectedUsers(server1.getConnectedUsers() - 1);
        updateObjectData(server1);
    }

    private void updateObjectData(Object currentObject) {
        em.getTransaction().begin();
        em.merge(currentObject);
        em.getTransaction().commit();
    }
    



    public void getServer() {
        Servers server = em.find(Servers.class, "valveServers");
        active.setText("Active Users: " + server.getConnectedUsers());
        servername.setText("Server Name: " + server.getName());
    }


}

