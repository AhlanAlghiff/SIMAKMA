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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author ahlan
 */
public class HomeDosenController implements Initializable {
    @FXML
    private BorderPane bp;
    @FXML
    private Button btnHome;
    @FXML
    private Button btnProfil;
    @FXML
    private Button btnMatkul;
    @FXML
    private Button btnKonsultasi;
    @FXML
    private AnchorPane ap;
    @FXML
    private Label lbNamaPojok;
    @FXML
    private Label lbMainName;
    @FXML
    private Button mnProfil;
    @FXML
    private Button mnMatkul;
    @FXML
    private Button mnKonsutlasi;
    @FXML
    private Button mnSetting;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Home(MouseEvent event) {
        bp.setCenter(ap);        
    }

    @FXML
    private void keHome(ActionEvent event) {
        bp.setCenter(ap);        
    }

    @FXML
    private void Profil(MouseEvent event) {
        loadPage("Profil");        
    }
    

    @FXML
    private void keProfil(ActionEvent event) {
        loadPage("Profil");        
    }

    @FXML
    private void MataKuliah(MouseEvent event) {
        loadPage("MataKuliahDosen");         
    }

    @FXML
    private void keMatkul(ActionEvent event) {
        loadPage("MataKuliahDosen");           
    }

    @FXML
    private void JadwalKuliah(MouseEvent event) {
        loadPage("Konsultasi");         
    }

    @FXML
    private void keKonsultasi(ActionEvent event) {
        loadPage("Konsultasi");          
    }

    @FXML
    private void keProfil(MouseEvent event) {
        loadPage("Profil");          
    }

    @FXML
    private void mnProfil(ActionEvent event) {
        loadPage("Profil");          
    }

    @FXML
    private void keMatkul(MouseEvent event) {
        loadPage("MataKuliahDosen");          
    }

    @FXML
    private void mnMatkul(ActionEvent event) {
        loadPage("MataKuliahDosen");          
    }

    @FXML
    private void keJadwal(MouseEvent event) {
        loadPage("JadwalDosen");          
    }

    @FXML
    private void mnKonsul(ActionEvent event) {
        loadPage("Konsultasi");              
    }

    @FXML
    private void keSetting(MouseEvent event) {

    }

    @FXML
    private void mnSetting(ActionEvent event) {
        
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
