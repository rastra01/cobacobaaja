package voedsel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignInController {
    
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
    private Button menuButton;

    @FXML
    private Label resultLabel;

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
       
        if (username.equals("admin@pengguna") && password.equals("password")) {
            main.showLoginPage();
        } else 
        if (username.equals("admin@penjual") && password.equals("password"))  {
            main.showLoginPenjualPage();
        } else {
            resultLabel.setText("Daftar gagal");
        }
    }

    @FXML
    private void handlemenuButtonAction(ActionEvent event) throws Exception {
        main.showHomePage();
    }

    
}
