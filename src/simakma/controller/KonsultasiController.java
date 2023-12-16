/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simakma.controller;

import db.DBHelper;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import simakma.Kelas.Konsultasi;

/**
 * FXML Controller class
 *
 * @author ahlan
 */

public class KonsultasiController implements Initializable {
    @FXML
    private Button btnHapus;

    @FXML
    private Button btnTambah;

    @FXML
    private Button btnUpdate;
 
    @FXML
    private TextArea tfDeskripsi;

    @FXML
    private TextField tfNama;

    @FXML
    private TextField tfNpm;

    @FXML
    private TextField tfTopik;

    @FXML
    private DatePicker tfWaktu;

    @FXML
    private TableColumn<Konsultasi, String> colDeskripsi;

    @FXML
    private TableColumn<Konsultasi, String> colNPM;

    @FXML
    private TableColumn<Konsultasi, String> colNamaMahasiswa;

    @FXML
    private TableColumn<Konsultasi, Date> colTanggalKonsul;

    @FXML
    private TableColumn<Konsultasi, String> colTopik;

    @FXML
    private TableView<Konsultasi> tvJadwalKonsul;

    @FXML
    void hapusKonsult(ActionEvent event) {
        Konsultasi selectedKonsul= tvJadwalKonsul.getSelectionModel().getSelectedItem();

        if (selectedKonsul!= null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Konfirmasi Hapus");
            alert.setHeaderText(null);
            alert.setContentText("Apakah Anda yakin ingin menghapus data ini?");

            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    String query = "DELETE FROM `konsultasi` WHERE npm ='" + selectedKonsul.getNpm()+ "'";
                    update(query);
                    showMahasiswa();
                }
            });
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Peringatan");
            alert.setHeaderText(null);
            alert.setContentText("Pilih baris yang ingin dihapus.");
            alert.showAndWait();
        }        
    }

    @FXML
    void tambahKonsul(ActionEvent event) {
        LocalDate localDate = tfWaktu.getValue();
        Date date = (localDate != null) ? java.sql.Date.valueOf(localDate) : null;    
         // Pastikan semua field tidak kosong
        if (isEmptyTextField()) {
            showAlert("Peringatan", "Isian Tidak Lengkap", "Silakan isi semua kolom.");
            return;
        }
        
        String query = "INSERT INTO `mahasiswa` VALUES ('" + tfNama.getText() + "','" + tfNpm.getText() + "','" + date+ "','" + tfTopik.getText()+ "','" + tfDeskripsi.getText() + "')";
        update(query);
        showMahasiswa();
        
        tfNpm.clear();
        tfNama.clear();
        tfTopik.clear();
        tfDeskripsi.clear();
    }

    @FXML
    void updateKonsul(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showKonsultasi();
    }
    
    public ObservableList<Konsultasi> getDataKonsultasi(){
        ObservableList<Konsultasi> konsul = FXCollections.observableArrayList();
        Connection conn = DBHelper.getConnection();
        String query = "SELECT mahasiswa.nama_mahasiswa, mahasiswa.npm, waktu, topik, deskripsi\n"
                + "FROM konsultasi\n"
                + "JOIN mahasiswa ON konsultasi.npm = mahasiswa.npm;";
        Statement st;
        ResultSet rs;
        
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Konsultasi temp;
            while(rs.next()){
                temp = new Konsultasi(rs.getString("nama_mahasiswa"), rs.getString("npm"), rs.getDate("waktu"), rs.getString("topik"), rs.getString("deskripsi"));
                konsul.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return konsul;
    }    
    public void showKonsultasi() {
        ObservableList<Konsultasi> list = getDataKonsultasi();

        colNamaMahasiswa.setCellValueFactory(new PropertyValueFactory<>("nama_mahasiswa"));
        colNPM.setCellValueFactory(new PropertyValueFactory<>("npm"));
        colTanggalKonsul.setCellValueFactory(new PropertyValueFactory<>("waktu"));
        colTopik.setCellValueFactory(new PropertyValueFactory<>("topik"));
        colDeskripsi.setCellValueFactory(new PropertyValueFactory<>("deskripsi"));
        tvJadwalKonsul.setItems(list);
    }
    
     private void showAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }   

    private void update(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void showMahasiswa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private boolean isEmptyTextField() {
        return tfNama.getText().isEmpty() || tfNpm.getText().isEmpty() || tfTopik.getText().isEmpty()|| tfDeskripsi.getText().isEmpty();
    }
}
