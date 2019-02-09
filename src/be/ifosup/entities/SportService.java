package be.ifosup.entities;

import be.ifosup.entities.Sport;

import java.util.ArrayList;
import java.util.List;

public class SportService {
    private static List <Sport> sports = new ArrayList<>();

    public List<Sport> recupereSport(){
        return sports;
    }

    public void ajouteSport( Sport sport) {
        sports.add(sport);
    }

    public void supprime( Sport sport) {
        sports.remove(sport);
    }
}
