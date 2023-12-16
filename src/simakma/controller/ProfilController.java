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
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import simakma.Kelas.Mahasiswa;
import simakma.sesi.sesiAkun;
import simakma.Kelas.Mahasiswa;

/**
 * FXML Controller class
 *
 * @author ahlan
 */
public class ProfilController implements Initializable {
    @FXML
    private Label labNama;
    @FXML
    private Label labNPM;
    @FXML
    private Label labProdi;
    @FXML
    private Label labTempat;
    @FXML
    private Label tabAlamat;
    @FXML
    private Label tabEmail;
    @FXML
    private Label labTanggal;
    @FXML
    private Label tabTelepon;
    @FXML
    private Label tabSekolah;

    /**
     * Initializes the controller class.
     */

    Connection conn = DBHelper.getConnection();

    Statement st;
    ResultSet rs;
    String username = sesiAkun.getUsername();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showData();
    }


    public ObservableList<Mahasiswa> getDataProfil(){
        ObservableList<Mahasiswa> mhs = FXCollections.observableArrayList();
        String query = ("SELECT mahasiswa.npm, mahasiswa.nama_mahasiswa, programstudi.nama_program_studi, mahasiswa.email, "+
                "mahasiswa.tempatLahir, mahasiswa.tanggalLahir, mahasiswa.asalSekolah, "+
                "mahasiswa.alamat, mahasiswa.jenisKelamin, mahasiswa.noTelp "+
                "FROM akun " +
                "JOIN mahasiswa ON akun.npm = mahasiswa.npm "+
                "JOIN programstudi ON mahasiswa.id_program_studi = programstudi.id_program_studi "+
                "WHERE akun.npm = "+ username);

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                Mahasiswa mahasiswa;
                mahasiswa = new Mahasiswa(
                        rs.getString("npm"),
                        rs.getString("nama_mahasiswa"),
                        rs.getString("alamat"),
                        rs.getString("email"),
                        rs.getString("asalSekolah"),
                        rs.getString("tempatLahir"),
                        rs.getDate("tanggalLahir"),
                        rs.getString("jenisKelamin"),
                        rs.getString("noTelp"),
                        rs.getString("nama_program_studi")
                );
                mhs.add(mahasiswa);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return mhs;
        
    }

    public void showData(){
        Mahasiswa mahasiswa = getDataProfil().get(0);
        
        labNama.setText(mahasiswa.getNama());
        labNPM.setText(mahasiswa.getNpm());
        labProdi.setText(mahasiswa.getProdi());
        labTempat.setText(mahasiswa.getTempatLahir());
        tabAlamat.setText(mahasiswa.getAlamat());
        tabEmail.setText(mahasiswa.getEmail());
        labTanggal.setText(mahasiswa.getTanggalLahir().toString());
        tabTelepon.setText(mahasiswa.getNoTelp());
        tabSekolah.setText(mahasiswa.getAsalSekolah());
    }
}
