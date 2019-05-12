package com.OneToOneMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToneDemo {
    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cgf.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetails.class)
                .buildSessionFactory();

        //create session
        Session session = factory.openSession();
        try {
            //create object of both classes
            Instructor instructor =  new Instructor("Umang","Rastogi","umangrastog@hays.com");
            InstructorDetails instructorDetails = new InstructorDetails("www.youtube.com","Hibernate");

            //begin the transcation
            session.beginTransaction();

            //assosiates the objects together
            instructor.setInstructorDetails(instructorDetails);

            //save the session will save both objects because of cascade all
            session.save(instructor);

            //commit the transcation
            session.getTransaction().commit();

        }

        finally {
            factory.close();
        }

    }
}
