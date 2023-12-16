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
import simakma.Kelas.Mahasiswa;

/**
 *
 * @author ahlan
 */

public class MahasiswaModel {
    private final Connection CONN;

    public MahasiswaModel() {
        this.CONN = DBHelper.getConnection();
    }

    public void insertMahasiswaData(Mahasiswa mahasiswa) throws SQLException {
        int idProdi = getIdProdi(mahasiswa.getProdi());
        
        try {
            String insertQuery = "INSERT INTO mahasiswa ("
                    + "npm, "
                    + "id_program_studi, "
                    + "nama_mahasiswa, "
                    + "email, "
                    + "tempatLahir, "
                    + "tanggalLahir, "
                    + "asalSekolah, "
                    + "alamat, "
                    + "jenisKelamin, "
                    + "noTelp) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement preparedStatement = CONN.prepareStatement(insertQuery);

            //Menginput data Mahasiswa ke database
            preparedStatement.setString(1, mahasiswa.getNpm());
            preparedStatement.setInt(2, idProdi);
            preparedStatement.setString(3, mahasiswa.getNama());
            preparedStatement.setString(4, mahasiswa.getEmail());
            preparedStatement.setString(5, mahasiswa.getTempatLahir());
            preparedStatement.setDate(6, (Date) mahasiswa.getTanggalLahir());
            preparedStatement.setString(7, mahasiswa.getAsalSekolah());
            preparedStatement.setString(8, mahasiswa.getAlamat());
            preparedStatement.setString(9, mahasiswa.getJenisKelamin());
            preparedStatement.setString(10, mahasiswa.getNoTelp());
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }  
    
    public int getIdProdi(String namaProdi){
        String query = "SELECT id_program_studi FROM programstudi WHERE nama_program_studi = ?";
        int idProdi = -1;
        
        try (PreparedStatement preparedStatement = CONN.prepareStatement(query)) {
            preparedStatement.setString(1, namaProdi);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    idProdi = resultSet.getInt("id_program_studi");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return idProdi;
    }
}
