/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simakma.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author ahlan
 */
public class HomeAdminController implements Initializable {
    @FXML
    private BorderPane bp;
    @FXML
    private Button btnHome;
    @FXML
    private Button btnMhs;
    @FXML
    private Button btnDosen;
    @FXML
    private Button btnFakultas;
    @FXML
    private Button btnProdi;
    @FXML
    private Button btnRuangan;
    @FXML
    private Button btnJadwal;
    @FXML
    private Button btnMatkul;
    @FXML
    private AnchorPane ap;
    @FXML
    private Label lbNamaPojok;
    @FXML
    private Label lbMainName;
    @FXML
    private Button mnMhs;
    @FXML
    private Button mnMatkul;
    @FXML
    private Button mnJadwal;
    @FXML
    private Button mnSetting;
    @FXML
    private Button mnProfil1;
    @FXML
    private Button mnMatkul1;
    @FXML
    private Button mnJadwal1;
    @FXML
    private Button mnSetting1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Home(MouseEvent event) {
    }

    @FXML
    private void Profil(MouseEvent event) {
    }

    @FXML
    private void toMhs(ActionEvent event) {
    }

    @FXML
    private void MataKuliah(MouseEvent event) {
    }

    @FXML
    private void toDosen(ActionEvent event) {
    }

    @FXML
    private void JadwalKuliah(MouseEvent event) {
    }

    @FXML
    private void toFaculty(ActionEvent event) {
    }

    @FXML
    private void toProdi(ActionEvent event) {
    }

    @FXML
    private void toRuangan(ActionEvent event) {
    }

    @FXML
    private void toJadwal(ActionEvent event) {
    }

    @FXML
    private void toMatkul(ActionEvent event) {
         loadPage("MataKuliahDosen");       
    }

    @FXML
    private void keProfil(MouseEvent event) {

    }

    @FXML
    private void keMatkul(MouseEvent event) {
        loadPage("MataKuliahDosen");
    }

    @FXML
    private void keJadwal(MouseEvent event) {
        
    }

    @FXML
    private void keSetting(MouseEvent event) {
    }
    
    private void loadPage(String page){
        Parent root = null;    
        try {
            root = FXMLLoader.load(getClass().getResource("/simakma/fxml/"+ page + ".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        bp.setCenter(root);
    }
}
