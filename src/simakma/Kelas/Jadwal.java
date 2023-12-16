/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simakma.Kelas;

import java.sql.Time;

/**
 *
 * @author ahlan
 */
public class Jadwal {
    private int id_jadwal;
    private String kode_matkul;
    private String nama_ruangan;
    private String hari;
    private Time jam_mulai;
    private Time jam_selesai;

    public Jadwal(int id_jadwal, String hari, String nama_ruangan, String kode_matkul, Time jam_mulai, Time jam_selesai) {
        this.id_jadwal = id_jadwal;
        this.kode_matkul = kode_matkul;
        this.nama_ruangan = nama_ruangan;
        this.hari = hari;
        this.jam_mulai = jam_mulai;
        this.jam_selesai = jam_selesai;
    }

    
    public int getId_jadwal() {
        return id_jadwal;
    }

    public void setId_jadwal(int id_jadwal) {
        this.id_jadwal = id_jadwal;
    }

    public String getKode_matkul() {
        return kode_matkul;
    }

    public void setKode_matkul(String kode_matkul) {
        this.kode_matkul = kode_matkul;
    }

    public String getNama_ruangan() {
        return nama_ruangan;
    }

    public void setNama_ruangan(String nama_ruangan) {
        this.nama_ruangan = nama_ruangan;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public Time getJam_mulai() {
        return jam_mulai;
    }

    public void setJam_mulai(Time jam_mulai) {
        this.jam_mulai = jam_mulai;
    }

    public Time getJam_selesai() {
        return jam_selesai;
    }

    public void setJam_selesai(Time jam_selesai) {
        this.jam_selesai = jam_selesai;
    }
    
}
