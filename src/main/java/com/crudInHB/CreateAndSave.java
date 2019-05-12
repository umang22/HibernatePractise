package com.crudInHB;

import com.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateAndSave {
    public static void main(String[] args) {
        //create session factory

        SessionFactory factory = new Configuration().configure("hibernate.cgf.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory(); /*new  AnnotationConfiguration()
                .addAnnotatedClass(Student.class)
                .configure("hibernate.cgf.xml").buildSessionFactory();*/

        //create session
        Session session = factory.openSession();
        try {
            //use the  session object to save to database
            //create a student object
            System.out.println("creating a new student object");
            Student student = new Student("Paul", "Wall", "parul@hays.com");
            //being the transaction
            session.beginTransaction();
            //save the student object
            System.out.println("saving the student object");
            session.save(student);
            //commit the transcation
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
