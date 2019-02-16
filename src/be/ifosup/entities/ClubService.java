package be.ifosup.entities;

import be.ifosup.database.ClubManager;

import java.util.ArrayList;
import java.util.List;

public class ClubService {
    private static List <Club> clubs = new ArrayList<>();

    public List<Club> recupereClub(){


       return ClubManager.Instance().DisplayClubs();
       //test
        //testgit
		//testgit2
		

    }

    public void ajouteClub(Club club) {

        ClubManager.Instance().AddClub(club);

            }

    public void supprime(Club club) {
        clubs.remove(club);
    }
}
