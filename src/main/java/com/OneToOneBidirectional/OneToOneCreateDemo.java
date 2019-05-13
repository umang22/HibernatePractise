package com.OneToOneBidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneCreateDemo {
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
            int id =2;

            InstructorDetails instructorDetails = (InstructorDetails) session.get(InstructorDetails.class,id);
            System.out.println("InstructorDetails " + instructorDetails);
            System.out.println("associated instructor details " + instructorDetails.getInstructor());
        }

        finally {
            factory.close();
        }

    }
}
