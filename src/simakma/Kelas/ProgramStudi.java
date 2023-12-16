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
public class ProgramStudi {
    private int id_program_studi;
    private Fakultas fakultas;
    private String nama_program_studi;

    public ProgramStudi(int id_program_studi, Fakultas fakultas, String nama_program_studi) {
        this.id_program_studi = id_program_studi;
        this.fakultas = fakultas;
        this.nama_program_studi = nama_program_studi;
    }

    public int getId_program_studi() {
        return id_program_studi;
    }

    public void setId_program_studi(int id_program_studi) {
        this.id_program_studi = id_program_studi;
    }

    public Fakultas getFakultas() {
        return fakultas;
    }

    public void setFakultas(Fakultas fakultas) {
        this.fakultas = fakultas;
    }

    public String getNama_program_studi() {
        return nama_program_studi;
    }

    public void setNama_program_studi(String nama_program_studi) {
        this.nama_program_studi = nama_program_studi;
    }
    
    
    
}
