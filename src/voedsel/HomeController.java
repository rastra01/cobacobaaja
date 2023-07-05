package voedsel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HomeController {

    private Main main;

    public void setMainApp(Main main) {
        this.main = main;
    }

    @FXML
    private Button penjualButton;

    @FXML
    private void handlepenjualButtonButtonAction(ActionEvent event) throws Exception {
        main.showLoginPenjualPage();
    }

     @FXML
    private Button pembeliButton;

    @FXML
    private void handlepembeliButtonButtonAction(ActionEvent event) throws Exception {
        main.showLoginPage();
    }

    @FXML
    private Button daftaButton;

    @FXML
    private void handledaftarButtonButtonAction(ActionEvent event) throws Exception {
        main.showSignInPage();

    }

    public void setMain(Main voedsel) {
    }

}

