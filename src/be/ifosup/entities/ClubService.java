package be.ifosup.entities;

import java.util.ArrayList;
import java.util.List;

public class ClubService {
    private static List <Club> clubs = new ArrayList<>();

    public List<Club> recupereClub(){
        return clubs;
    }

    public void ajouteClub(Club club) {
        clubs.add(club);
    }

    public void supprime(Club club) {
        clubs.remove(club);
    }
}
