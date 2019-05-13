package com.OneToManyBidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyCreateCourseDemo {
    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cgf.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetails.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        //create session
        Session session = factory.openSession();
        try {
            //begin the transcation
            session.beginTransaction();

            Course course = new Course("Core Java");
            Instructor instructor = new Instructor();
            instructor.setId(2);
            course.setInstructor(instructor);

            session.save(course);

            session.getTransaction().commit();


        } finally {
            factory.close();
        }

    }
}
