package TP2.Tests;
import TP2.*;

public class TestMoteurDistanceMoyenne {

	public static void main(String[] args) {
		
		Configuration conf = new Configuration();
		PopulationVilles popsVille = new PopulationVilles(conf);
		MoteurDistanceMoyenne mtdm = new MoteurDistanceMoyenne(popsVille);
		
		Liste section1 = new Liste();
		Liste section2 = new Liste();
		
		for(int i=0; i<2; i++) {
			
			
			Ville villeSource = popsVille.getVille(i);
			Ville villeDest;

			int index = i;
			villeDest = popsVille.getVille(++index);
			
			Lien lien = new Lien(villeSource, villeDest);
			section1.insererALaPosition(lien, i);
		}
		
		for(int i=2; i<4; i++) {
			
			
			Ville villeSource = popsVille.getVille(i);
			Ville villeDest;
			
			int index = i;
			index++;
			if(index==4) {
				//La dernière ville à un lien avec la première
				villeDest = popsVille.getVille(0);
			} else {
				villeDest = popsVille.getVille(index);
			
			}
			
			Lien lien = new Lien(villeSource, villeDest);
			section2.insererALaPosition(lien, i);
		
		}
		
		Carte carte = new Carte(mtdm, section1, section2);
		
		carte.evalueScore(true);
	}
}