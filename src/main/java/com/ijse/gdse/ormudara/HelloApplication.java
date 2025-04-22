package com.ijse.gdse.ormudara;

import com.ijse.gdse.ormudara.config.FactoryConfiguration;
import com.ijse.gdse.ormudara.entity.Laptop;
import com.ijse.gdse.ormudara.entity.Student;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Laptop laptop = new Laptop();
        laptop.setLid(1);
        laptop.setName("Laptop 1");

        Student student = new Student();
        student.setId(1);
        student.setName("Jack2");
        student.setAddress("Colombo");
        student.setLaptop(laptop);
        session.save(student);

        session.persist(laptop);
        session.persist(student);

//        Student student = new Student();
//        student.setId(1);
//        student.setName("Jack2");
//        student.setAddress("Colombo");
//        session.save(student);

//        session.update(student);

//        Student student = session.get(Student.class,1);
//        System.out.println(student.getName());

//        Student student = session.get(Student.class,1);
//        session.delete(student);

        transaction.commit();
        session.close();
    }
}