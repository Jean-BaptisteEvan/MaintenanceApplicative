package Principale;

import java.time.LocalDateTime;
import java.util.Scanner;

public abstract class Event {
    public String type; // "RDV_PERSONNEL", "REUNION", "PERIODIQUE"
    public String title;
    public String proprietaire;
    public LocalDateTime dateDebut;
    public int dureeMinutes;
    public String lieu; // utilisé seulement pour REUNION
    public String participants; // séparés par virgules (pour REUNION uniquement)
    public int frequenceJours; // uniquement pour PERIODIQUE

    public Event(String type, String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes,
                 String lieu, String participants, int frequenceJours) {
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
            case "RDV_PERSONNEL" -> "RDV : " + title + " à " + dateDebut.toString();
            case "REUNION" -> "Réunion : " + title + " à " + lieu + " avec " + participants;
            case "PERIODIQUE" -> "Événement périodique : " + title + " tous les " + frequenceJours + " jours";
            default -> "";
        };
    }

    private LocalDateTime makeDate(){
        Scanner scanner =  new Scanner(System.in);
        System.out.print("Année (AAAA) : ");
        int annee = Integer.parseInt(scanner.nextLine());
        System.out.print("Mois (1-12) : ");
        int moisRdv = Integer.parseInt(scanner.nextLine());
        System.out.print("Jour (1-31) : ");
        int jourRdv = Integer.parseInt(scanner.nextLine());
        System.out.print("Heure début (0-23) : ");
        int heure = Integer.parseInt(scanner.nextLine());
        System.out.print("Minute début (0-59) : ");
        int minute = Integer.parseInt(scanner.nextLine());
        return LocalDateTime.of(annee, moisRdv, jourRdv, heure, minute);
    }

}