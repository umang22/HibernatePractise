package com.crudInHB;

import com.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudent {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cgf.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        Session session =  factory.openSession();


    }
}
