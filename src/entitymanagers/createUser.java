/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitymanagers;

import dev.entity.Users;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author eldin
 */
public class createUser {
    
    public static void main(String[] args){
        
    }
    
    public void create(String username, String password, int balance, String firstname, String lastname, String iban, int slots, int monthspayed, boolean banned, String lastpayment){
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Dev_assignmentPU");
        
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        
        Users user = new Users();
        
        user.setUserName(username);
        user.setPassword(password);
        user.setBalance(balance);
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setIban(iban);
        user.setCharacterSlots(slots);
        user.setMonthsPayed(monthspayed);
        user.setBanned(banned);
        user.setLastPayment(lastpayment);
        
        em.persist( user );
        em.getTransaction().commit();
        
        em.close();
        emFactory.close();
    }
    
}
