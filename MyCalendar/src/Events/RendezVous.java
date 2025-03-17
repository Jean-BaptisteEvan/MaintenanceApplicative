package Events;

import Principale.Event;

import java.time.LocalDateTime;

public class RendezVous extends Event {
    public RendezVous(String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes) {
        super("RDV_PERSONNEL", title, proprietaire, dateDebut, dureeMinutes, "", "", 0);
    }

    //calendar.ajouterEvent("RDV_PERSONNEL", titre, utilisateur, localDate, duree, "", "", 0);

}
