package etudiant;

import java.util.ArrayList;

import jfc.ICalculateurPlusCourtChemin;
import jfc.Ville;
/**
 * Les instances de cette classe permette de calculer un plus court chemine entre deux villes en utilisant l'algorithme de Dijkstra.
 * @author Jean-François Condotta, 04 juin 2023.
 *
 */
public class CalculateurPlusCourtChemin implements ICalculateurPlusCourtChemin{
    //la methode plusCourtChemin est une methode qui permet de retourner le plus court chemin entre deux villes en utilisant l'algorithme de Dijkstra
    @Override
    public ArrayList<Ville> plusCourtChemin(ArrayList<Ville> toutesLesVilles, Ville villeDepart, Ville villeArrivee) {
        // on cree une liste pour associer chaquet ville a un sommet
        ArrayList<Sommet> sommets = new ArrayList<>();
        for (Ville ville : toutesLesVilles) {
            sommets.add(new Sommet(ville));
        }
        // on recupere les sommets arrivé et depart
        Sommet sommetDepart = Sommet.getSommet(sommets, villeDepart);
        Sommet sommetArrivee = Sommet.getSommet(sommets, villeArrivee);
        // on met le cout a 0 ( parce que c'est le sommets de depart donc on a pas bouger)
        sommetDepart.setCout(0);
        // faire la boucle tant que on a pas visité tous les sommets
        while (!sommets.isEmpty()) {
            // recuperer le cout du sommet on est
            Sommet sommetMin = Sommet.getSommetCoutMin(sommets);
            // iteration ou on visite chaques voisins du sommet sommetMin
            for (Sommet voisin : Sommet.getSommetsVoisins(sommets, sommetMin)) {
                // initialisation du cout = le cout du sommet actuel + la distance entre sommetMin et le voisin
                int cout = sommetMin.getCout() + sommetMin.getVille().getDistanceMetres(voisin.getVille());
                // on compare si le nouveau coût calculé pour atteindre voisin est inférieur au coût actuel enregistré pour voisin
                if (cout < voisin.getCout()) {
                    voisin.setCout(cout);
                    voisin.setPredecesseur(sommetMin);
                }
            }
            // on supprime le sommet visité
            sommets.remove(sommetMin);
        }
        // on creer un arraylist pour stocker le chemin
        ArrayList<Ville> chemin = new ArrayList<>();
        //on initialise sommet a sommetArrivee
        Sommet sommet = sommetArrivee;
        // on attend que le sommet soit pas null
        while (sommet != null) {
            //on ajoute au chemin la ville associer au sommet
            chemin.add(0, sommet.getVille());
            //et on definit le sommet par le predecesseur
            sommet = sommet.getPredecesseur();
        }
        //puis on fini par retourner le chemin
        return chemin;
    }
}
