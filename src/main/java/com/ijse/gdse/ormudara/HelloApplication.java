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
import java.util.ArrayList;
import java.util.List;

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

        Laptop laptop1 = new Laptop();
        laptop1.setLid(1);
        laptop1.setName("Laptop 1");



        Laptop laptop2 = new Laptop();
        laptop2.setLid(2);
        laptop2.setName("Laptop 2");

        List<Laptop>laptops = new ArrayList<>();
        laptops.add(laptop1);
        laptops.add(laptop2);

        Student student1 = new Student();
        student1.setId(1);
        student1.setName("John Doe");
        student1.setAddress("Panadura");
        student1.setLaptop(laptops);

        laptop1.setStudent(student1);
        laptop2.setStudent(student1);

        session.save(laptop1);
        session.save(laptop2);
        session.save(student1);

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