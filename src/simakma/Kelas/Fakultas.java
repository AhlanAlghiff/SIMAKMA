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
public class Fakultas {
    private int id_fakultas;
    private String nama_fakultas;

    public Fakultas(int id_fakultas, String nama_fakultas) {
        this.id_fakultas = id_fakultas;
        this.nama_fakultas = nama_fakultas;
    }

    public int getId_fakultas() {
        return id_fakultas;
    }

    public void setId_fakultas(int id_fakultas) {
        this.id_fakultas = id_fakultas;
    }

    public String getNama_fakultas() {
        return nama_fakultas;
    }

    public void setNama_fakultas(String nama_fakultas) {
        this.nama_fakultas = nama_fakultas;
    }
    
    
}
