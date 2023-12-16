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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import simakma.Kelas.Mahasiswa;
import simakma.model.MahasiswaModel;

/**
 * FXML Controller class
 *
 * @author ahlan
 */
public class DaftarController implements Initializable {
    @FXML
    private Button btnMasuk;
    @FXML
    private TextField tfNama;
    @FXML
    private TextField tfNpm;
    @FXML
    private TextField tfEmail;
    @FXML
    private DatePicker dpTL;
    @FXML
    private TextField tfTelepon;
    @FXML
    private RadioButton rbLaki;
    @FXML
    private ToggleGroup tgGender;
    @FXML
    private RadioButton rbPerempuan;
    @FXML
    private ComboBox<String> cbFakultas;
    @FXML
    private ComboBox<String> cbProdi;
    @FXML
    private TextField tfTempatLahir;
    @FXML
    private TextArea taAlamat;
    @FXML
    private Button btnSubmit;
    @FXML
    private TextField tfAsalSekolah;

    /**
     * Initializes the controller class.
     */
    
    Connection conn = DBHelper.getConnection();
    Statement st;
    ResultSet rs;
    
    //Buat data baru MahasiswaModel
    MahasiswaModel mahasiswaModel = new MahasiswaModel(); 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            fakultasComboBox();
        } catch (SQLException ex) {
            Logger.getLogger(DaftarController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Set the visible row count for the ComboBox
        cbFakultas.setVisibleRowCount(5); // Adjust the value as needed
        cbProdi.setVisibleRowCount(3); 
    }
    
    @FXML
    private void submit(ActionEvent event) throws IOException, SQLException {
        if (isDataValid()) {
            saveMahasiswaData();
            daftarAkun();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/simakma/fxml/Masuk.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) btnMasuk.getScene().getWindow();
            stage.setScene(new Scene(root)); 
        }else{
            showAlert("Data belum terisi. Harap isi semua data!");
        }
    }

    @FXML
    private void toMasuk(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/simakma/fxml/Masuk.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) btnMasuk.getScene().getWindow();
        stage.setScene(new Scene(root));        
    }
    
    
    @FXML
    private void onFakultasSelected(ActionEvent event) throws SQLException {
        String pilihFakultas = cbFakultas.getSelectionModel().getSelectedItem();
        prodiComboBox(pilihFakultas);
    }

    //membuat Akun
    private void daftarAkun(){
        String query = "INSERT INTO `akun` VALUES ('" + tfNpm.getText() + "','" + tfNpm.getText() + "','" + tfNpm.getText() + "')";
        
        try{
            st = conn.createStatement();
            st.executeUpdate(query);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    // Fungsi untuk memilih combo Box Fakultas    
    private void fakultasComboBox() throws SQLException {
        ObservableList<String> fakultasList = FXCollections.observableArrayList();

        st = conn.createStatement();
        rs = st.executeQuery("SELECT nama_fakultas FROM fakultas");

        while (rs.next()) {
            String fakultas = rs.getString("nama_fakultas");
            fakultasList.add(fakultas);
        }

        // Set the items in the ComboBox
        if (cbFakultas != null) {
            cbFakultas.setItems(fakultasList);
        } else {
            System.out.println("cbFakultas kosong!");
        }
        System.out.println("Keluar dari FakultaCB"); 
    }
 
    // Fungsi untuk memilih combo Box Prodi berdasarkan comboBox Fakultas        
    private void prodiComboBox(String selectedFakultas) throws SQLException {
        ObservableList<String> prodiList = FXCollections.observableArrayList();

        String query = "SELECT nama_program_studi " + 
                   "FROM programstudi " +
                   "JOIN fakultas ON programstudi.id_fakultas = fakultas.id_fakultas " +
                   "WHERE nama_fakultas = ?";

        PreparedStatement preparedStatement = conn.prepareStatement(query);

        preparedStatement.setString(1, selectedFakultas);

        rs = preparedStatement.executeQuery();

        while (rs.next()) {
            String prodi = rs.getString("nama_program_studi");
            prodiList.add(prodi);
        }

        // Set the items in the ComboBox
        if (cbProdi != null) {
            cbProdi.setItems(prodiList);
        } else {
            System.out.println("cbProdi kosong!");
        }
    }

    private Mahasiswa createMahasiswaObject() {        
        LocalDate localDate = dpTL.getValue();
        Date date = (localDate != null) ? java.sql.Date.valueOf(localDate) : null;

        return new Mahasiswa(
            tfNpm.getText(),
            tfNama.getText(),
            taAlamat.getText(),
            tfEmail.getText(),
            tfAsalSekolah.getText(),
            tfTempatLahir.getText(),
            date,
            getSelectedJenisKelamin(),
            tfTelepon.getText(),
            cbProdi.getValue()
        );
    }

    // Metode ini untuk mendapatkan jenis kelamin yang dipilih dari radio button    
    private String getSelectedJenisKelamin() {       
        return rbLaki.isSelected() ? "Laki-Laki" : "Perempuan";
    }

    //Save data mahasiswa
    private void saveMahasiswaData() throws SQLException {
        Mahasiswa mahasiswa = createMahasiswaObject();
        // Insert into Mahasiswa table
        mahasiswaModel.insertMahasiswaData(mahasiswa);

        showAlert("Data mahasiswa berhasil disimpan!\nSilahkan login menggunakan username dan password\nsesuai NPM Anda.");
    }

    private boolean isDataValid() {
        return cbFakultas.getValue() != null
                && cbProdi.getValue() != null
                && !tfNama.getText().isEmpty()
                && !tfNpm.getText().isEmpty();
    }
    
    //Show Alert    
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informasi");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }       
}
