module ku.cs {
    requires javafx.controls;
    requires javafx.fxml;
    requires bcrypt;

    opens ku.cs.lab08 to javafx.fxml;
    exports ku.cs.lab08;
    exports ku.cs.controllers;
    opens ku.cs.controllers to javafx.fxml;
    exports ku.cs.models;
    opens ku.cs.models to javafx.base;
}