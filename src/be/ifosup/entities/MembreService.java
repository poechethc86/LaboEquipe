package be.ifosup.entities;

import be.ifosup.entities.Membre;

import java.util.ArrayList;
import java.util.List;

public class MembreService {
    private static List <Membre> membres = new ArrayList<>();

    public List<Membre> recupereMembre(){
        return membres;
    }

    public void ajouteMembre( Membre membre) {
        membres.add(membre);
    }

    public void supprime( Membre membre) {
        membres.remove(membre);
    }
}
