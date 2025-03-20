package Principale;

import ValueObject.EventType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CalendarManager {
    public ListEvent events;

    public CalendarManager() {
        this.events = new ListEvent();
    }

    public boolean ajouterEvent(Event event) {
        if (this.events.conflits(event)) {
            return false;
        }
        this.events.ajoutEvent(event);
        return true;
    }

    public ListEvent eventsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        ListEvent result = new ListEvent();
        for (Event e : events.getEvents()) {
            if (e.type == EventType.PERIODIQUE) { // Non refacto
                LocalDateTime temp = e.dateDebut.getDate();
                while (temp.isBefore(fin)) {
                    if (!temp.isBefore(debut)) {
                        result.ajoutEvent(e);
                        break;
                    }
                    temp = temp.plusDays(e.frequenceJours.getFrequence());
                }
            } else if (!e.dateDebut.getDate().isBefore(debut) && !e.dateDebut.getDate().isAfter(fin)) { // non refacto
                result.ajoutEvent(e);
            }
        }
        return result;
    }

    public void afficherEvenements() {
        for (Event e : events.getEvents()) {
            System.out.println(e.description());
        }
    }
}