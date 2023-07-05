package voedsel;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class HomePenjual implements Initializable {

    private Main main;

    public void setMainApp(Main main) {
        this.main = main;
    }

    @FXML
    private TextField textField1;

    @FXML
    private TextField textField2;

    @FXML
    private TextField textField3;

    @FXML
    private Button menuButton;

    @FXML
    private Button infoButton;

    @FXML
    private Button logoutButton;

    @FXML
    private Button editButton;

    @FXML
    private TableView<StokMakanan> TV;

    @FXML
    private TableColumn<StokMakanan, String> Column1;

    @FXML
    private TableColumn<StokMakanan, String> Column2;

    @FXML
    private TableColumn<StokMakanan, String> Column3;

    @FXML
    private Text textJumlahMakanan;
    
    private ObservableList<StokMakanan> data;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data = FXCollections.observableArrayList(
            new StokMakanan("Ayam Goreng", "30 pcs", "11-07-2023"),
            new StokMakanan("Nasi Goreng ", "25 pcs", "11-07-2023"));

        Column1.setCellValueFactory(new PropertyValueFactory<>("Nama"));
        Column2.setCellValueFactory(new PropertyValueFactory<>("Stok"));
        Column3.setCellValueFactory(new PropertyValueFactory<>("tanggal"));

        TV.setEditable(true);

        TV.setItems(data);
        updateJumlahMakanan();
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        String A = textField1.getText();
        String B = textField2.getText();
        String C = textField3.getText();
        data.add(new StokMakanan(A, B, C));

        textField1.clear();
        textField2.clear();
        textField3.clear();
        updateJumlahMakanan();
    }

    @FXML
    private void ButtonHapusData(ActionEvent event) {
       int selectedIndex = TV.getSelectionModel().getSelectedIndex();
       if (selectedIndex >= 0) {
        TV.getItems().remove(selectedIndex);
        updateJumlahMakanan();
       }
       
    }

    @FXML 
    private void Buttonedit(ActionEvent event) {
        StokMakanan selectedMakanan = TV.getSelectionModel().getSelectedItem();

        String name = selectedMakanan.getNama();
        String stock = selectedMakanan.getStok();
        String date = selectedMakanan.getTanggal();

        if (selectedMakanan != null){
            
            String nama = textField1.getText();
            String stok = textField2.getText();
            String tanggal = textField3.getText();

            if(nama.isEmpty()){
                selectedMakanan.setNama(name);
            } else {
                selectedMakanan.setNama(nama);
            }

            if(stok.isEmpty()){
                selectedMakanan.setStock(stock);
            }else {
                selectedMakanan.setStock(stok);
            }
            if(tanggal.isEmpty()){
                selectedMakanan.settanggal(date);
            }else {
                selectedMakanan.settanggal(tanggal);
            }
          
            TV.refresh();
            textField1.clear();
            textField2.clear();
            textField3.clear();
        }
    }

    private void updateJumlahMakanan(){
        int JumlahMakanan = TV.getItems().size();
        textJumlahMakanan.setText(Integer.toString(JumlahMakanan));
    }

    @FXML
    private void handlemenuButtonButtonAction(ActionEvent event) throws Exception{
        main.showHomeMakananPage();
    }

    @FXML
    private void handleinfoButtonButtonAction(ActionEvent event) throws Exception{
        main.showInformasiPage();
    }

    @FXML
    private void handlelogoutButtonButtonAction(ActionEvent event) throws Exception{
        main.showLogoutPage();
    }

   
}
