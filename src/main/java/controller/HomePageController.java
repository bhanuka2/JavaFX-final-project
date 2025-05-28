package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class HomePageController {
    List<User> userList = new ArrayList<>();

        @FXML
        private TextField txtEmail;

        @FXML
        private TextField txtPassword;

        @FXML
        void btnLoginOnClickAction(ActionEvent event) {
            try {
                Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/clothify","root","1234");
                PreparedStatement preparedStatement= connection.prepareStatement("Insert into users values(?,?)");

                preparedStatement.setString(1,txtEmail.getText());
                preparedStatement.setString(2,txtPassword.getText());

                preparedStatement.executeUpdate();


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

    }

    public static void AddUser(){

        try {
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/clothify","root","1234");




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


}
