package Principale;

import ValueObject.*;

import java.time.LocalDateTime;
import java.util.Scanner;

public abstract class Event {
    public EventType type; // "RDV_PERSONNEL", "REUNION", "PERIODIQUE"
    public TitreEvent title;
    public ProprioEvent  proprietaire;
    public DateEvent dateDebut;
    public DureeEvent dureeMinutes;
    public LieuEvent lieu; // utilisé seulement pour REUNION
    public ListeParticipant participants; // séparés par virgules (pour REUNION uniquement)
    public Frequence frequenceJours; // uniquement pour PERIODIQUE

    public Event(EventType type, TitreEvent title, ProprioEvent proprietaire, DateEvent dateDebut, DureeEvent dureeMinutes, LieuEvent lieu, ListeParticipant participants, Frequence frequenceJours) {
        this.type = type;
        this.title = title;
        this.proprietaire = proprietaire;
        this.dateDebut = dateDebut;
        this.dureeMinutes = dureeMinutes;
        this.lieu = lieu;
        this.participants = participants;
        this.frequenceJours = frequenceJours;
    }

    public String description() {
        return switch (type) {
            case RDV_PERSONNEL -> "RDV : " + title + " à " + dateDebut.toString();
            case REUNION -> "Réunion : " + title + " à " + lieu + " avec " + participants;
            case PERIODIQUE -> "Événement périodique : " + title + " tous les " + frequenceJours + " jours";
            case JESAISPAS -> null;
        };
    }

}