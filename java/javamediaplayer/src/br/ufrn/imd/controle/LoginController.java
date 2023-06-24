package br.ufrn.imd.controle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import br.ufrn.imd.MainApp;
import br.ufrn.imd.dao.UserRepository;
import javafx.event.ActionEvent;

public class LoginController {
	@FXML
    private Button btnLogin;

    @FXML
    private PasswordField inputPassword;

    @FXML
    private TextField inputUsername;

    @FXML
    private Label lblLoginMessage;
    
    private UserRepository userRepository;
	
	public LoginController() {
		this.userRepository = UserRepository.getInstance();
	}
	
    @FXML
    void click_btnLogin(ActionEvent event) {
    	checkAndLogin();
    }

	private void checkAndLogin() {
		String username = inputUsername.getText();
		String password = inputPassword.getText();
		
		if (username.isEmpty() || password.isEmpty()) {
			lblLoginMessage.setText("Informe Usuário e Senha.");
			return;
		}
		
		if(userRepository.authenticateUser(username, password)) {
			lblLoginMessage.setText("Sucesso.");
			MainApp.changeScene("principal");
			return;
		}
		
		lblLoginMessage.setText("Usuário e/ou Senha errados.");
	}
}
