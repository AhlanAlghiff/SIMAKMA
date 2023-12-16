/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simakma.controller;

import db.DBHelper;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import simakma.sesi.sesiAkun;

/**
 * FXML Controller class
 *
 * @author ahlan
 */
public class MasukController implements Initializable {
    @FXML
    private TextField tfUsername;
    @FXML
    private Button btnMasuk;
    @FXML
    private Button btnDaftar;
    @FXML
    private PasswordField pfPassword;

    /**
     * Initializes the controller class.
     */
    
    

    
    @FXML
    void login(ActionEvent event) {   
        String username = tfUsername.getText();
        String password = pfPassword.getText();
    
        if (validateLogin(username, password)) {
                sesiAkun.setUsername(username);
                showAlert(Alert.AlertType.INFORMATION, "Login Berhasil", "Selamat datang, " + username + "!");
                System.out.println("Login berhasil!");
                redirectTo();
                
            } else {
                // Display login failed message
                showAlert(Alert.AlertType.ERROR, "Login Gagal", "Username atau password salah.");
                System.out.println("Login gagal!");
            }
    }

    private boolean validateLogin(String username, String password) {
        Connection conn = DBHelper.getConnection();
        String query = "SELECT * FROM `akun` WHERE username = '" + username
                + "' AND password = '" + password + "'";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(query)) {
            return rs.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    private void redirectTo() {
    String username = tfUsername.getText();
        try {
            FXMLLoader loader;
            if ("admin".equals(username)) {
                loader = new FXMLLoader(getClass().getResource("/simakma/fxml/HomeAdmin.fxml"));
            } else if ("dosen".equals(username)) {
                loader = new FXMLLoader(getClass().getResource("/simakma/fxml/HomeDosen.fxml"));
            } else {
                loader = new FXMLLoader(getClass().getResource("/simakma/fxml/Home.fxml"));
            }

            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) btnMasuk.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
    @FXML
    void toDaftar(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/simakma/fxml/Daftar.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) btnDaftar.getScene().getWindow();
        stage.setScene(new Scene(root));
    }    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TO Do
    }
    
    

}
