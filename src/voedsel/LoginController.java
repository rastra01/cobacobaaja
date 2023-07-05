package voedsel;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class LoginController implements Initializable{

    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }


    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Label resultLabel;

    @FXML
    private ComboBox<String> ComboList;

    

    @FXML
    private void initialize() {
       
    }

    public void userLogin(ActionEvent event) throws Exception {
        handleLoginButtonButtonAction();
    }

    @FXML
    private void handleLoginButtonButtonAction() throws Exception{
        String username = usernameField.getText();
        String password = passwordField.getText();
        
        if (username.equals("penjual") && password.equals("password")) {
            main.showHomePenjualPage();
        } else {
            resultLabel.setText("Login gagal!");
        }
    }

    @FXML
    private Button menuButton;

    @FXML
    private void handlemenuButtonAction(ActionEvent event) throws Exception {
        main.showHomePage();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        ObservableList<String> List = FXCollections.observableArrayList("Penjual Makanan","Penjual Bahan Makanan");
        ComboList.setItems(List);
        
    }

    

    
}
