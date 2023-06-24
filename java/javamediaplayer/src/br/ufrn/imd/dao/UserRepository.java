package br.ufrn.imd.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import br.ufrn.imd.model.Usuario;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class UserRepository extends BaseRepository<Usuario>{
	private static UserRepository instance;
	private Usuario authenticatedUser;
	
	public UserRepository() {
		this.entities = new ArrayList<Usuario>();
		this.authenticatedUser = new Usuario();
	}
	
	public static UserRepository getInstance() {
		if(instance == null) {
			instance = new UserRepository();
		}
		
		return instance;
	}
	
	@Override
	public void seed() {
		try {			
			Path usersFile = Paths.get("src/br/ufrn/imd/data/usuarios.txt");
			List<String> usersRegisters = Files.readAllLines(usersFile);
			
			for(String register : usersRegisters) {
				String[] userData = register.split(",");
				
				String id = userData[0];
				String username = userData[1];
				String password = userData[2];
				String role = userData[3];
				
				Usuario localUser = new Usuario(id, username, password, role);
				add(localUser);
			}
		}
		catch(IOException ioe) {
			Alert alert = new Alert(AlertType.ERROR, "Erro ao ler arquivo de usuários.");
			alert.showAndWait();
		}
	}

	@Override
	public void write(Usuario entity) {
		add(entity);
	}
	
	public boolean writeUser(String username, String password, String role) {
		try {
			Path filePath = Paths.get("src/br/ufrn/imd/data/usuarios.txt");
			List<String> lines = Files.readAllLines(filePath);
			String lastId = "";
			for(String line : lines) {
				String[] userData = line.split(",");
				String usernameData = userData[1];
				
				if(username.equals(usernameData)) {
					throw new Exception("Usuario já cadastrado.");
				}
				
				lastId = Integer.toString(Integer.parseInt(userData[0])+1);
			}
			
			// Adicionar os dados do usuário ao arquivo
			String userData = lastId + "," + username + "," + password + "," + role;
			Files.write(filePath, (userData + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
			
			write(new Usuario(lastId, username, password, role));
			
			return true;
		}
		catch(IOException ioe) {
			Alert alert = new Alert(AlertType.ERROR, "Algo deu errado, tente novamente.");
			alert.showAndWait();
		}
		catch(Exception ex) {
			Alert alert = new Alert(AlertType.ERROR, ex.getMessage());
			alert.showAndWait();
		}
		
		return false;
	}
	
	public Usuario getAuthenticatedUser() {
		return this.authenticatedUser;
	}
	
	public boolean authenticateUser(String username, String password) {
		for(Usuario user : entities) {
			if(user.getUsername().equals(username) && user.getPassword().equals(password))
			{
				this.authenticatedUser = user;
				return true;
			}
		}
		
		return false;
	}
}
