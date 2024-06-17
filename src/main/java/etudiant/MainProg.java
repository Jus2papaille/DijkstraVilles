package etudiant;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jfc.ViewVilles;
/**
 * Le programme principal.
 * @author Jean-François Condotta, 04 juin 2023.
 *
 */
public class MainProg extends Application{

	@Override
	public void start(Stage ignored) {   
		ViewVilles viewVilles=new ViewVilles(new CalculateurPlusCourtChemin());
		Scene scene = new Scene(viewVilles, 1900, 1000);
		Stage stage = new Stage(StageStyle.DECORATED);
		stage.setTitle("Villes autour de Lens ... Jean-Francois Condotta");
		stage.setScene(scene);
		stage.show();
		viewVilles.setAutomaticLayout(true);
		viewVilles.init();
	}
/**
 * La méthode principale.
 * @param args Aucun.
 */
	public static void main(String[] args) {
		launch(args);
	}
}

