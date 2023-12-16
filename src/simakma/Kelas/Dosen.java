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
public class Dosen {
   private String nip;
   private String nama_dosen;
   private String noTelp;

    public Dosen(String nip, String nama_dosen, String noTelp) {
        this.nip = nip;
        this.nama_dosen = nama_dosen;
        this.noTelp = noTelp;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNama_dosen() {
        return nama_dosen;
    }

    public void setNama_dosen(String nama_dosen) {
        this.nama_dosen = nama_dosen;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }
   
   
}
