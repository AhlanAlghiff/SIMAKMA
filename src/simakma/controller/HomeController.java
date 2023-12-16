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
import java.sql.Time;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import simakma.Kelas.Jadwal;
import simakma.sesi.sesiAkun;

/**
 * FXML Controller class
 *
 * @author ahlan
 */
public class HomeController implements Initializable {
    @FXML
    private BorderPane bp;
    
    @FXML
    private Button btnHome;
    
    @FXML
    private Button btnProfil;
    
    @FXML
    private Button btnMatkul;
    
    @FXML
    private Button btnJadwal;
    
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
    private Button mnJadwal;
    
    @FXML
    private Button mnSetting;
    
    @FXML
    private TableView<Jadwal> tvData;
    
    @FXML
    private TableColumn<Jadwal, Integer> tcIdJadwal;
    
    @FXML
    private TableColumn<Jadwal, String> tcMatKul;
    
    @FXML
    private TableColumn<Jadwal, String> tcRuangan;
    
    @FXML
    private TableColumn<Jadwal, Time> tcJamMulai;
    
    @FXML
    private TableColumn<Jadwal, Time> tcJamSelesai;

    /**
     * Initializes the controller class.
     */
    
    ObservableList<Jadwal> jadwal = FXCollections.observableArrayList();
    Connection conn = DBHelper.getConnection();

    Statement st;
    ResultSet rs;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String username = sesiAkun.getUsername();
        lbNamaPojok.setText(username);
        lbMainName.setText(username);
        
        showJadwal();
    }    

    @FXML
    private void Home(MouseEvent event) {
        bp.setCenter(ap);
    }

    @FXML
    private void Profil(MouseEvent event) {
        loadPage("Profil");
    }

    @FXML
    private void MataKuliah(MouseEvent event) {
        loadPage("MataKuliah");
    }

    @FXML
    private void JadwalKuliah(MouseEvent event) {
        loadPage("JadwalKuliah");
    }

    @FXML
    private void keProfil(MouseEvent event) {
       loadPage("Profil");  
    }

    @FXML
    private void keMatkul(MouseEvent event) {
        loadPage("MataKuliah");
    }

    @FXML
    private void keJadwal(MouseEvent event) {
        loadPage("JadwalKuliah");
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
    
    
    public ObservableList<Jadwal> getDataJadwal() {
    String query ="SELECT jadwal.id_jadwal, " +
                    "matakuliah.nama_mata_kuliah, "+
                    "ruangan.nama_ruangan, "+
                    "jadwal.hari, "+
                    "jadwal.jam_mulai, "+
                    "jadwal.jam_selesai "+
                    "FROM jadwal "+
                    "JOIN matakuliah ON jadwal.kode_matkul = matakuliah.kode_matkul "+ 
                    "JOIN ruangan ON jadwal.id_ruangan = ruangan.id_ruangan;";

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Jadwal temp;
            while (rs.next()) {
                temp = new Jadwal(
                    rs.getInt("id_jadwal"),
                    rs.getString("hari"), 
                    rs.getString("nama_ruangan"),
                    rs.getString("nama_mata_kuliah"),
                    rs.getTime("jam_mulai"), 
                    rs.getTime("jam_selesai") 
                );
                jadwal.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return jadwal;
    }
    
        public void showJadwal(){
        ObservableList<Jadwal> List = getDataJadwal();
            tcIdJadwal.setCellValueFactory(new PropertyValueFactory<>("id_jadwal"));
            tcMatKul.setCellValueFactory(new PropertyValueFactory<>("kode_matkul"));  
            tcRuangan.setCellValueFactory(new PropertyValueFactory<>("nama_ruangan"));            
            tcJamMulai.setCellValueFactory(new PropertyValueFactory<>("jam_mulai"));
            tcJamSelesai.setCellValueFactory(new PropertyValueFactory<>("jam_selesai"));
            tvData.setItems(List);
    }
}
