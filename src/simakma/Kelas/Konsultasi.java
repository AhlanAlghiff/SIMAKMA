/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simakma.Kelas;

import java.sql.Date;
import java.time.LocalDateTime;
/**
 *
 * @author ahlan
 */
public class Konsultasi {
    private String nama_mahasiswa;
    private String npm;
    private Date waktu;
    private String topik;
    private String deskripsi;

    public Konsultasi(String nama_mahasiswa, String npm, Date waktu, String topik, String deskripsi) {
        this.nama_mahasiswa = nama_mahasiswa;
        this.npm = npm;
        this.waktu = waktu;
        this.topik = topik;
        this.deskripsi = deskripsi;
    }

    public String getNama_mahasiswa() {
        return nama_mahasiswa;
    }

    public void setNama_mahasiswa(String nama_mahasiswa) {
        this.nama_mahasiswa = nama_mahasiswa;
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public Date getWaktu() {
        return waktu;
    }

    public void setWaktu(Date waktu) {
        this.waktu = waktu;
    }

    public String getTopik() {
        return topik;
    }

    public void setTopik(String topik) {
        this.topik = topik;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    
    
    
}
