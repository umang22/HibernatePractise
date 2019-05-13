package com.OneToManyBidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneDeleteDemo {
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

            //begin the transcation
            session.beginTransaction();
            int instructorId= 1;

            Instructor instructor = (Instructor) session.get(Instructor.class,instructorId);
            System.out.println("found the instructor " + instructor);
            //delete the instructor
            if(instructor != null){
                session.delete(instructor);
            }

            //commit the transcation
            session.getTransaction().commit();

        }

        finally {
            factory.close();
        }

    }
}
