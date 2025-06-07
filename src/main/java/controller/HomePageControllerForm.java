package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class HomePageControllerForm {

    public List<User> getUserList() {
        return userList;
    }

    List<User> userList=new ArrayList<>();

        @FXML
        private TextField txtEmail;

        @FXML
        private TextField txtPassword;

        @FXML
        void btnAddOnClickAction(ActionEvent event) {

            ListOfNames.getItems().add(txtEmail.getText());

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

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    private ListView<?> ListOfNames;

    public static void AddUser(){

        try {
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/clothify","root","1234");
            Statement statement= connection.createStatement();
            ResultSet resultSet=statement.executeQuery("Select * From users");

            while (resultSet.next()){

            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


}
