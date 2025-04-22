package com.ijse.gdse.ormudara.config;

import com.ijse.gdse.ormudara.entity.Laptop;
import com.ijse.gdse.ormudara.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration; //private static instance for singleton
    private SessionFactory sessionFactory; //build karapu session gactory eka me insttance ekata dagena session ekak open karagannawa (line 21)
    private FactoryConfiguration() { // private constructor for did not create object any class
        Configuration configuration = new Configuration().configure()
                .addAnnotatedClass(Student.class) //session ekak open karagnna nam session factory ekak configyre karaganna oni. e nisa ekata object ekak hadagaththa
                .addAnnotatedClass(Laptop.class);
        sessionFactory = configuration.buildSessionFactory(); //object eka true session factory ekak build karagaththa
    }

    public static FactoryConfiguration getInstance() { // static method for instance eka allaganna
        return (factoryConfiguration == null)
                ? factoryConfiguration = new FactoryConfiguration() : factoryConfiguration;
    }

    public Session getSession() { // public session for session ekak ganna illana illana thenata denna
        return sessionFactory.openSession(); //open session
    }
}
