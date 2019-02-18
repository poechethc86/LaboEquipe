package be.ifosup.entities;

import be.ifosup.database.MemberManager;
import be.ifosup.entities.Membre;

import java.util.ArrayList;
import java.util.List;

public class MembreService {
    private static List <Membre> membres = new ArrayList<>();

    public List<Membre> recupereMembre(){
        List<Membre> list = MemberManager.Instance().DisplayMembers();
        return list;
    }

    public void ajouteMembre( Membre membre) {
        membres.add(membre);
    }

    public void supprime( Membre membre) {
        membres.remove(membre);
    }
}
