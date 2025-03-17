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

    public void ajouterEvent(Event event) {
       this.events.ajoutEvent(event);
    }

    public List<Event> eventsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        List<Event> result = new ArrayList<>();
        for (Event e : events.getEvents()) {
            if (e.type == EventType.PERIODIQUE) {
                LocalDateTime temp = e.dateDebut.getDate();
                while (temp.isBefore(fin)) {
                    if (!temp.isBefore(debut)) {
                        result.add(e);
                        break;
                    }
                    temp = temp.plusDays(e.frequenceJours.getFrequence());
                }
            } else if (!e.dateDebut.getDate().isBefore(debut) && !e.dateDebut.getDate().isAfter(fin)) {
                result.add(e);
            }
        }
        return result;
    }

    public boolean conflit(Event e1, Event e2) {
        LocalDateTime fin1 = e1.dateDebut.getDate().plusMinutes(e1.dureeMinutes.getDuree());
        LocalDateTime fin2 = e2.dateDebut.getDate().plusMinutes(e2.dureeMinutes.getDuree());

        if (e1.type == EventType.PERIODIQUE || e2.type == EventType.PERIODIQUE) {
            return false; // Simplification abusive
        }

        return e1.dateDebut.getDate().isBefore(fin2) && fin1.isAfter(e2.dateDebut.getDate());
    }

    public void afficherEvenements() {
        for (Event e : events.getEvents()) {
            System.out.println(e.description());
        }
    }
}