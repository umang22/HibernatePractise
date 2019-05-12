package com.crudInHB;

import com.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateObject {

    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cgf.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        //create session
        Session session = factory.openSession();
        try {
            //give the student id to be updated
            int studentId = 1;
            //begin the transaction
            session.beginTransaction();
            Student student = (Student) session.get(Student.class, studentId);

            // we have the student object whose id is 1 , now we can update any details of it
            student.setFirstName("Umang");
            student.setLastName("Rastogi");

            // now only you have commit the object only not to save it.

            session.getTransaction().commit();
        } finally {
            factory.close();
        }


    }
}
