module com.ijse.gdse.ormudara {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires java.naming;


    opens com.ijse.gdse.ormudara to javafx.fxml;
    exports com.ijse.gdse.ormudara;
    opens com.ijse.gdse.ormudara.entity to org.hibernate.orm.core;
}