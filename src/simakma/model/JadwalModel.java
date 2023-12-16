/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simakma.model;

import db.DBHelper;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.ObservableList;
import simakma.Kelas.Jadwal;
import simakma.Kelas.Mahasiswa;

/**
 *
 * @author ahlan
 */
public class JadwalModel {
    private final Connection conn;
    
    Statement st;
    ResultSet rs;

    public JadwalModel() {
        this.conn = DBHelper.getConnection();
    }

    public void insertJadwal(Jadwal jadwal) throws SQLException {
 //       int idProdi = getIdProdi(jadwal.);
        
        try {
            String insertQuery = "INSERT INTO jadwal ("
                    + "id_jadwal, "
                    + "kode_matkul, "
                    + "id_ruangan, "
                    + "hari, "
                    + "jam_mulai, "
                    + "jam_selesai)"
                    + "VALUES (?, ?, ?, ?, ?)";
            
            PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);

            //Menginput data Jadwal ke database
            preparedStatement.setInt(1, jadwal.getId_jadwal());
            preparedStatement.setString(2, jadwal.getKode_matkul());
            preparedStatement.setString(3, jadwal.getNama_ruangan());
            preparedStatement.setString(4, jadwal.getHari());
            preparedStatement.setTime(5, jadwal.getJam_mulai());
            preparedStatement.setTime(6, jadwal.getJam_selesai());
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    

}
