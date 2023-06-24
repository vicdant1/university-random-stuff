package br.ufrn.imd;

import java.io.IOException;
import br.ufrn.imd.dao.DirectoryRepository;
import br.ufrn.imd.dao.MusicRepository;
import br.ufrn.imd.dao.PlaylistRepository;
import br.ufrn.imd.dao.UserRepository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class MainApp extends Application {

	public static Stage stg;
	private static Scene principalScene;
	private static Scene loginScene;
	private static Scene cadastroScene;
	private static Scene playlistScene;
	
	private UserRepository userRepository;
	private DirectoryRepository directoryRepository;
	private MusicRepository musicRepository;
	private PlaylistRepository playlistRepository;

	@Override
	public void start(Stage stage) throws Exception {
		this.userRepository = UserRepository.getInstance();
		this.directoryRepository = DirectoryRepository.getInstance();
		this.musicRepository = MusicRepository.getInstance();
		this.playlistRepository = PlaylistRepository.getInstance();
		
		// Lendo arquivo de usuários
		readUsersFile();

		// Lendo arquivo de diretorios
		readDirectoriesFile();
		
		// Lendo arquivo de diretorios
		readMusicsFile();
		
		// Lendo arquivos de playlists
		readPlaylistsFile();
		// Iniciando aplicação
		setSceneConfiguration(stage);
	}

	private void readPlaylistsFile() {
		this.playlistRepository.seed();
	}

	private void readMusicsFile() {
		this.musicRepository.seed();
	}

	private void readDirectoriesFile() {
		this.directoryRepository.seed();
	}

	private void readUsersFile() {
		this.userRepository.seed();
	}

	private void setSceneConfiguration(Stage stage) {
		try {
			stg = stage;
			stage.setTitle("Media Player");
			stage.setResizable(false);
	
			Parent fxmlLogin = FXMLLoader.load(getClass().getResource("visao/TelaLogin.fxml"));
			loginScene = new Scene(fxmlLogin);
	
			stage.setScene(loginScene);
			stage.show();
		}
		catch(IOException ioe) {
			Alert alert = new Alert(AlertType.ERROR, "Erro ao trocar de tela.");
			alert.showAndWait();
		}
	}

	public static void changeScene(String fxml) {
		try {
			switch (fxml) {
			case "principal":
				Parent fxmlPrincipal = FXMLLoader.load(MainApp.class.getResource("visao/TelaPrincipal.fxml"));
				principalScene = new Scene(fxmlPrincipal);
				stg.setScene(principalScene);
				break;
			case "login":
				stg.setScene(loginScene);
				break;
			case "cadastro":
				Parent fxmlCadastro = FXMLLoader.load(MainApp.class.getResource("visao/TelaCadastroUsuario.fxml"));
				cadastroScene = new Scene(fxmlCadastro);
				
				Stage cadastroStage = new Stage();
				cadastroStage.setTitle("Cadastro de Usuário");
				cadastroStage.setScene(cadastroScene);
				cadastroStage.showAndWait();
				break;
				
			case "novaplaylist":
				Parent fxmlNovaPlaylist = FXMLLoader.load(MainApp.class.getResource("visao/TelaNovaPlaylist.fxml"));
				playlistScene = new Scene(fxmlNovaPlaylist);
				
				Stage novaPlaylistStage = new Stage();
				novaPlaylistStage.setTitle("Cadastro de Usuário");
				novaPlaylistStage.setScene(playlistScene);
				novaPlaylistStage.showAndWait();
				break;
			}
		}
		catch(IOException ioe) {
			Alert alert = new Alert(AlertType.ERROR, "Erro ao trocar de tela.");
			alert.showAndWait();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
