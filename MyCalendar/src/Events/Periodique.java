package Events;

import Principale.Event;

import java.time.LocalDateTime;

public class Periodique extends Event {
    public Periodique(String title, String proprietaire, LocalDateTime dateDebut, int frequenceJours) {
        super("PERIODIQUE", title, proprietaire, dateDebut,  0, "", "",  frequenceJours);
    }

    //calendar.ajouterEvent("PERIODIQUE", titre3, utilisateur, localDate3, 0, "", "", frequence);
}
