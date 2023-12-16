/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simakma.Kelas;

/**
 *
 * @author ahlan
 */
public class Ruangan {
    private String id_ruangan;
    private String kapasitas;
    private String lokasi;
    private String nama_ruangan;

    public Ruangan(String id_ruangan, String kapasitas, String lokasi, String nama_ruangan) {
        this.id_ruangan = id_ruangan;
        this.kapasitas = kapasitas;
        this.lokasi = lokasi;
        this.nama_ruangan = nama_ruangan;
    }

    public String getId_ruangan() {
        return id_ruangan;
    }

    public void setId_ruangan(String id_ruangan) {
        this.id_ruangan = id_ruangan;
    }

    public String getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(String kapasitas) {
        this.kapasitas = kapasitas;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getNama_ruangan() {
        return nama_ruangan;
    }

    public void setNama_ruangan(String nama_ruangan) {
        this.nama_ruangan = nama_ruangan;
    }
    
    
}
