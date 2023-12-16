package simakma.model;

import db.DBHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import simakma.Kelas.Konsultasi;

/**
 *
 * author ahlan
 */

public class KonsultasiModel {
    private final Connection CONN;

    public KonsultasiModel() {
        this.CONN = DBHelper.getConnection();
    }

    // CREATE DATA
    public void addKonsultasi(Konsultasi konsul) {
        String insert = "INSERT INTO `konsultasi` VALUES ('" + konsul.getNama_mahasiswa() + "','" + konsul.getNpm() + "','" + konsul.getWaktu() + "','" + konsul.getTopik() + "','" + konsul.getDeskripsi() + "')";

        System.out.println(insert);

        try {
            Statement statement = CONN.createStatement();
            if (statement.executeUpdate(insert) > 0) {
                System.out.println("Done");
            } else {
                System.out.println("Error: gagal memasukkan data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(KonsultasiModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error");
        }
    }

    // READ DATA
    public ArrayList<Konsultasi> getKonsultasi() {
        String query = "SELECT mahasiswa.nama_mahasiswa, mahasiswa.npm, waktu, topik, deskripsi\n"
                + "FROM konsultasi\n"
                + "JOIN mahasiswa ON konsultasi.npm = mahasiswa.npm;";
        ArrayList<Konsultasi> konsultasiList = new ArrayList<>();

        try {
            Statement statement = CONN.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Konsultasi temp = new Konsultasi(
                        rs.getString("nama_mahasiswa"),
                        rs.getString("npm"),
                        rs.getDate("waktu"), // Ganti dengan tipe data yang sesuai (mungkin LocalDateTime)
                        rs.getString("topik"),
                        rs.getString("deskripsi")
                );
                konsultasiList.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KonsultasiModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return konsultasiList;
    }

    // DELETE DATA
    public void deleteKonsultasi(String npm) {
        String delete = "DELETE FROM `konsultasi` WHERE `npm` = '" + npm + "'";

        try {
            Statement statement = CONN.createStatement();
            int rowsAffected = statement.executeUpdate(delete);
            if (rowsAffected > 0) {
                System.out.println("Data berhasil dihapus");
            } else {
                System.out.println("Error: gagal menghapus data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(KonsultasiModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error");
        }
    }
    
}
