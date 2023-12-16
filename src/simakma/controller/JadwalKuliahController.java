/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simakma.controller;

import db.DBHelper;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import simakma.Kelas.Jadwal;

/**
 * FXML Controller class
 *
 * @author ahlan
 */
public class JadwalKuliahController implements Initializable {
    @FXML
    private TableColumn<Jadwal, Integer> colNo;
    @FXML
    private TableColumn<Jadwal, String> colHari;
    @FXML
    private TableColumn<Jadwal, String> colMatkul;
    @FXML
    private TableColumn<Jadwal, String> colRuangan;
    @FXML
    private TableColumn<Jadwal, Time> colJamMulai;
    @FXML
    private TableColumn<Jadwal, Time> colJamSelsai;
    @FXML
    private TableView<Jadwal> tvData;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       showJadwal();
    }    
    

    
    public ObservableList<Jadwal> getDataJadwal() {
        ObservableList<Jadwal> jadwal = FXCollections.observableArrayList();
        Connection conn = DBHelper.getConnection();

        Statement st;
        ResultSet rs;        
        String query = "SELECT jadwal.id_jadwal, " +
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
        
        colHari.setCellValueFactory(new PropertyValueFactory<>("hari"));        
        colJamMulai.setCellValueFactory(new PropertyValueFactory<>("jam_mulai"));
        colJamSelsai.setCellValueFactory(new PropertyValueFactory<>("jam_selesai"));
        colMatkul.setCellValueFactory(new PropertyValueFactory<>("kode_matkul"));
        colNo.setCellValueFactory(new PropertyValueFactory<>("id_jadwal"));
        colRuangan.setCellValueFactory(new PropertyValueFactory<>("nama_ruangan"));
        tvData.setItems(List);
    }
    
}
