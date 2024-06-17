//maroille matheo ines coeugniet Louis nolwenn

package etudiant;

import java.util.ArrayList;

import jfc.Ville;

/**
 * Une instance de la classe Sommet correspond à un noeud du graphe entre les différentes villes utilisée lors de la recherche
 * d'un plus court chemin entre deux villes en utilisant l'algorithme de Dijkstra.<br>
 * Chaque sommet est associé avec la ville qu'il représente, un coût représentant la plus courte distance pour atteindre le sommet (initialisé avec Integer.MAX_VALUE qui représentera ici la valeur infini) et un sommet prédécesseur
 * qui représentera le sommet voisin précédent afin d'atteindre le sommet pour obtenir le plus court chemin vers le sommet (le prédécesseur est initialisé avec null).
 * Les attributs cout et predecesseur sont utiles pour l'implémentation de l'algorithme de Dijkstra.
 * @author Jean-François Condotta, 04 juin 2023.
 *
 */
public class Sommet {

	/**
	 * La ville associée au sommet.
	 */
	private Ville ville;

	/**
	 * Le coût associé au sommet.
	 */
	private int cout;

	/**
	 * Le sommet prédécesseur pour atteindre le sommet.
	 */
	private Sommet predecesseur;

	/**
	 * Un constructeur permettant d'instancier un Sommet avec une ville, un coût de Integer.MAX_VALUE et un prédécesseur null.
	 * @param ville Une ville supposée non null. 
	 */
	public Sommet(Ville ville) {
		this.ville = ville;
		this.cout = Integer.MAX_VALUE;
		this.predecesseur = null;
	}

	/**
	 * Méthode retournant le sommet appartenant à une liste de sommets associée avec une ville donnée.
	 * Dans le cas où il n'existe pas un sommet avec la ville donnée, null est retournée.
	 * @param sommets Une liste de sommets.
	 * @param ville Une ville non null.
	 * @return Le sommet associée avec la ville ou null.
	 */

	//la methode getSommet est une methode qui permet de retourner le sommet associé à une ville donnée
	static public Sommet getSommet(ArrayList<Sommet> sommets, Ville ville) {
		for (Sommet sommet : sommets) {
			if (sommet.getVille().equals(ville)) {
				return sommet;
			}
		}
		return null;
	}

	/**
	 * Méthode retournant un des sommets avec un coût minimal parmi les sommets d'une liste.
	 * @param sommets Une liste de sommets supposée non null et non vide.
	 * @return Un sommet avec un coût minimal.
	 */

	//la methode getSommetCoutMin est une methode qui permet de retourner le sommet avec le cout minimal parmi les sommets d'une liste
	static public Sommet getSommetCoutMin(ArrayList<Sommet> sommets) {
		Sommet sommetMin = sommets.get(0);
		for (Sommet sommet : sommets) {
			if (sommet.getCout() < sommetMin.getCout()) {
				sommetMin = sommet;
			}
		}
		return sommetMin;
	}

	/**
	 * Méthode retournant les sommets d'une liste de sommets associés à une ville voisine à la ville d'un sommet donné en paramètre.
	 * @param sommets Une liste de sommets non null.
	 * @param sommet Un sommet non null.
	 * @return La liste des sommets voisins.
	 */


	//la methode getsommetsVoisins est une methode qui permet de retourner les sommets voisins d'un sommet donné en parametre
	static public ArrayList<Sommet> getSommetsVoisins(ArrayList<Sommet> sommets, Sommet sommet) {
		ArrayList<Ville> villesVoisines = sommet.ville.getVillesVoisines();
		ArrayList<Sommet> sommetsVoisins = new ArrayList<Sommet>();
		for (Ville ville : villesVoisines) {
			Sommet sommetVoisin = Sommet.getSommet(sommets, ville);
			if (sommetVoisin != null) {
				sommetsVoisins.add(sommetVoisin);
			}
		}
		return sommetsVoisins;
	}

	/**
	 * Méthode modifiant le coût d'un sommet.
	 * @param cout Le nouveau coût du sommet.
	 */
	public void setCout(int cout) {
		this.cout = cout ;
	}

	/**
	 * Méthode retournant la ville associée au sommet.
	 * @return La ville associée au sommet.
	 */
	public Ville getVille() {
		return ville;
	}

	/**
	 * Méthode retournant le prédécesseur du sommet.
	 * @return Le prédécesseur du sommet.
	 */
	public Sommet getPredecesseur() {
		return predecesseur;
	}

	/**
	 * Méthode retournant le coût du sommet.
	 * @return Le coût du sommet.
	 */
	public int getCout() {
		return cout;
	}

	/**
	 * Méthode permettant de modifier le prédécesseur du sommet.
	 * @param sommet Le nouveau prédécesseur du sommet.
	 */
	public void setPredecesseur(Sommet sommet) {
		this.predecesseur = sommet ;
	}

}

