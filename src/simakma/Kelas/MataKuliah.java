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
public class MataKuliah {
    private String kode_matkul;
    private String id_program_studi;
    private String nip;
    private String nama_mata_kuliah;
    private String deksripsi;
    
    public MataKuliah(String nama_mata_kuliah){
        this.nama_mata_kuliah = nama_mata_kuliah;
    }

    public MataKuliah(String kode_matkul, String id_program_studi, String nip, String nama_mata_kuliah, String deksripsi) {
        this.kode_matkul = kode_matkul;
        this.id_program_studi = id_program_studi;
        this.nip = nip;
        this.nama_mata_kuliah = nama_mata_kuliah;
        this.deksripsi = deksripsi;
    }
    
    public String getKode_matkul() {
        return kode_matkul;
    }

    public void setKode_matkul(String kode_matkul) {
        this.kode_matkul = kode_matkul;
    }

    public String getId_program_studi() {
        return id_program_studi;
    }

    public void setId_program_studi(String id_program_studi) {
        this.id_program_studi = id_program_studi;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNama_mata_kuliah() {
        return nama_mata_kuliah;
    }

    public void setNama_mata_kuliah(String nama_mata_kuliah) {
        this.nama_mata_kuliah = nama_mata_kuliah;
    }

    public String getDeksripsi() {
        return deksripsi;
    }

    public void setDeksripsi(String deksripsi) {
        this.deksripsi = deksripsi;
    }
    
    
}
