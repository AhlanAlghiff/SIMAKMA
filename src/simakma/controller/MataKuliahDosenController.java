/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simakma.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ahlan
 */
public class MataKuliahDosenController implements Initializable {
    @FXML
    private TableView<?> tvInformasiMatkul;
    @FXML
    private TableColumn<?, ?> colNo;
    @FXML
    private TableColumn<?, ?> colMatKul;
    @FXML
    private TableColumn<?, ?> colSKS;
    @FXML
    private TableColumn<?, ?> colJadwal;
    @FXML
    private TableColumn<?, ?> colDeskripsi;
    @FXML
    private Button btnPerbaruiInfo;
    @FXML
    private TextField tfUbahNama;
    @FXML
    private TextField tfUbahJadwal;
    @FXML
    private TextField tfUbahJamMulai;
    @FXML
    private TextField tfUbahJamSelesai;
    @FXML
    private TextField tfUbahDeskripsi;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void submitPembaruan(ActionEvent event) {
    }
    
}
