package simakma.controller;

    import db.DBHelper;
    import java.sql.Connection;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.sql.Statement;
    import javafx.collections.FXCollections;
    import javafx.collections.ObservableList;
    import javafx.event.ActionEvent;
    import javafx.fxml.FXML;
    import javafx.scene.control.Button;
    import javafx.scene.control.ComboBox;
    import javafx.scene.control.TableColumn;
    import javafx.scene.control.TableView;
    import simakma.Kelas.MataKuliah;
    import simakma.sesi.sesiAkun;

public class MataKuliahController {

    @FXML
    private TableColumn<MataKuliah, String> NamaMatkul;

    @FXML
    private TableColumn<MataKuliah, Integer> SKS;

    @FXML
    private Button btnSubmit;

    @FXML
    private TableColumn<MataKuliah, String> deskripsiMatkul;

    @FXML
    private TableColumn<MataKuliah, String> dosenMatkul;

    @FXML
    private TableColumn<MataKuliah, Integer> idMatkul;

    @FXML
    private ComboBox<MataKuliah> matKul;

    @FXML
    private TableView<MataKuliah> tvData;

    Connection conn = DBHelper.getConnection();

    Statement st;
    ResultSet rs;

    String username = sesiAkun.getUsername();

    @FXML
    void initialize() {
        cbMatkul();
    }

    @FXML
    void pilihMatkul(ActionEvent event) {

    }

    public ObservableList<MataKuliah> getDataMatkul() {
        ObservableList<MataKuliah> matkulList = FXCollections.observableArrayList();
        Connection conn = DBHelper.getConnection();
        String query = "SELECT nama_mata_kuliah " +
                "FROM matakuliah " +
                "JOIN programstudi ON matakuliah.id_program_studi = programstudi.id_program_studi " +
                "JOIN mahasiswa ON programstudi.id_program_studi = mahasiswa.id_program_studi " +
                "WHERE mahasiswa.npm = '" + username + "'";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            
            while (rs.next()) {
                MataKuliah matkul = new MataKuliah(rs.getString("nama_mata_kuliah"));
                matkulList.add(matkul);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return matkulList;
    }

    public void cbMatkul() {
        ObservableList<MataKuliah> matkulList = getDataMatkul();
        matKul.setItems(matkulList);

 
    }

    @FXML
    void submit(ActionEvent event) {
//         MataKuliah selectedMatkul = matKul.getValue();
//        if (selectedMatkul != null) {
//            // Mengisi TableView dengan mata kuliah yang dipilih
//            populateTableView(selectedMatkul);
//        } else {
//            System.out.println("Tidak ada mata kuliah yang dipilih.");
//        }
    }
}
