module Media_Player {
	requires javafx.fxml;
	requires transitive javafx.graphics;
	requires javafx.controls;
	requires javafx.media;
	
	
	opens br.ufrn.imd.controle to javafx.fxml;
	exports br.ufrn.imd;
}