package it.edu.iisgubbio.grafo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;







public class grafo {

	int processo = 3, risorse = 3;
	private int[][] grafo;
	private int dimensione;

	
	
	public grafo() {

		int matrice[][];

		matrice = new int[3][3];

		for (int riga = 0; riga < processo; riga++) {

			for (int colonna = 0; colonna < risorse; colonna++) {

				matrice[colonna][riga] = 0;

			}
		}

	}
public void setRequest(int processo, int risorsa) {
	if(this.grafo[processo][risorsa]==0) {
		if(this.checkcolum(risorse)) {
			this.grafo[processo][risorse]=1;
			
			
		}else {
			
			
			
		}
		
		
		
	}
	
}
public boolean checkcolum(int risorsa) {

	int somma =0;
	for (int i=0;i<this.dimensione;i++)
	
	return false;
	return false;
}

}
