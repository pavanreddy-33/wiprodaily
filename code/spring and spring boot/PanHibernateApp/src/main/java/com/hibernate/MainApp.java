package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.PAN;

public class MainApp {

    public static void main(String[] args) {

        // Create Hibernate SessionFactory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                                                    .addAnnotatedClass(PAN.class)
                                                    .buildSessionFactory();

        // Get session
        Session session = factory.getCurrentSession();

        try {
            // Create PAN object
            PAN pan = new PAN("Ravi Kumar", "ABCPK1234A");

            // Start transaction
            session.beginTransaction();

            // Save the object
            session.save(pan);

            // Commit
            session.getTransaction().commit();

            System.out.println("Data saved successfully!");
        } finally {
            factory.close();
        }
    }
}
