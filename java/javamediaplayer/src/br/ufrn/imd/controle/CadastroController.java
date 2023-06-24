package br.ufrn.imd.controle;

import br.ufrn.imd.dao.UserRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;


public class CadastroController {

    @FXML
    private Button btnRegister;

    @FXML
    private PasswordField inputConfirmPassReg;

    @FXML
    private PasswordField inputPasswordReg;

    @FXML
    private TextField inputUsernameReg;

    @FXML
    private Label lblRegMessage;

    @FXML
    private CheckBox cbxCheckVipUser;
    
    
    
    private UserRepository userRepository;
    
    public CadastroController() {
    	this.userRepository = UserRepository.getInstance();
	}

	@FXML
    void click_btnRegister(ActionEvent event) {
    	checkAndRegister();
    }

	private void checkAndRegister() {
		lblRegMessage.setText("");
		
		
		String username = inputUsernameReg.getText();
		String password = inputPasswordReg.getText();
		String passwordConfirmation = inputConfirmPassReg.getText();
		String userRole = "2"; // 2 = comum (padrao)
		
		if(username.isEmpty() || password.isEmpty() || passwordConfirmation.isEmpty()) {
			lblRegMessage.setTextFill(Color.RED);
			lblRegMessage.setText("Por favor insira todos os dados.");
			return;
		}
		
		if(!password.equals(passwordConfirmation)) {
			lblRegMessage.setTextFill(Color.RED);
			lblRegMessage.setText("As senhas não coincidem.");
			return;
		}
		
		if(cbxCheckVipUser.isSelected())
			userRole = "1"; // 1 - VIP
		
		if(this.userRepository.writeUser(username, password, userRole)) {
			
			lblRegMessage.setTextFill(Color.GREEN);
			lblRegMessage.setText("Usuário criado com sucesso.");
			
			cbxCheckVipUser.setSelected(false);
			inputUsernameReg.setText("");
			inputPasswordReg.setText("");
			inputConfirmPassReg.setText("");
		}
	}
}