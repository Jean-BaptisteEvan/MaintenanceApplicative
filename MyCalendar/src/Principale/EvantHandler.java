package Principale;

import Events.AffichageCalendrier;
import Events.Periodique;
import Events.RendezVous;
import Events.Reunion;
import ValueObject.*;

import java.io.LineNumberInputStream;
import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class EvantHandler {
    Scanner scanner = new Scanner(System.in);

    public String connectUtilisateur(HashMap<String,String> user_passwords){
        System.out.println("Nom d'utilisateur: ");
        String user = scanner.nextLine();
        if(user_passwords.containsKey(user)){
            System.out.println("Entrer votre mot de passe : ");
            String password = scanner.nextLine();
            if (user_passwords.get(user).equals(password)) {
                return user;
            }
        }
        return null;
    }

    public String createUtilisateur(HashMap<String, String> user_passwords){
        System.out.print("Nom d'utilisateur: ");
        String utilisateur = scanner.nextLine();
        System.out.print("Mot de passe: ");
        String motDePasse = scanner.nextLine();
        System.out.print("Répéter mot de passe: ");
        if (scanner.nextLine().equals(motDePasse)) {
            user_passwords.put(utilisateur, motDePasse);
        } else {
            System.out.println("Les mots de passes ne correspondent pas...");
            utilisateur = null;
        }
        return utilisateur;
    }

    public void ajoutRDV(CalendarManager calendar, String utilisateur){
        System.out.print("Titre de l'événement : ");
        TitreEvent titre = new TitreEvent(scanner.nextLine());

        DateEvent localDate = new DateEvent();

        System.out.print("Durée (en minutes) : ");
        DureeEvent duree = new DureeEvent(scanner.nextInt());

        calendar.ajouterEvent(new RendezVous(titre,new ProprioEvent(utilisateur),localDate,duree));
        System.out.println("Événement ajouté.");
    }

    public void ajoutReunion(CalendarManager calendar, String utilisateur){
        System.out.print("Titre de l'événement : ");
        TitreEvent titre = new TitreEvent(scanner.nextLine());

        DateEvent localDate = new DateEvent();

        System.out.print("Durée (en minutes) : ");
        DureeEvent duree = new DureeEvent(scanner.nextInt());

        System.out.println("Lieu :");
        LieuEvent lieu = new LieuEvent(scanner.nextLine());

        ListeParticipant participants = new ListeParticipant();

        System.out.println("Ajouter un participant ? (oui / non)");
        while (scanner.nextLine().equals("oui")) {
            System.out.print("Participants : " + participants);
            participants.addParticipant(new Participant(scanner.nextLine()));
        }

        Event e = new Reunion(titre,new ProprioEvent(utilisateur),localDate,duree,lieu,participants);
        calendar.ajouterEvent(e);
        System.out.println("Événement ajouté.");
    }

    public void ajoutPeriodique(CalendarManager calendar, String utilisateur){
        System.out.print("Titre de l'événement : ");
        TitreEvent titre = new TitreEvent(scanner.nextLine());

        DateEvent localDate = new DateEvent();

        System.out.print("Frequence (en jours) : ");
        Frequence freq = new Frequence(scanner.nextInt());

        Event e = new Periodique(titre,new ProprioEvent(utilisateur),localDate,freq);
        calendar.ajouterEvent(e);
        System.out.println("Événement ajouté.");
    }

    public void event_mois(CalendarManager calendar){
        AffichageCalendrier.affichageFiltrer(scanner,0,calendar);
    }

    public void event_semaine(CalendarManager calendar){
        AffichageCalendrier.affichageFiltrer(scanner,1,calendar);
    }

    public void event_jour(CalendarManager calendar){
        AffichageCalendrier.affichageFiltrer(scanner,2,calendar);
    }

    //utilisataires
    private static void afficherListe(List<Event> evenements) {
        if (evenements.isEmpty()) {
            System.out.println("Aucun événement trouvé pour cette période.");
        } else {
            System.out.println("Événements trouvés : ");
            for (Event e : evenements) {
                System.out.println("- " + e.description());
            }
        }
    }

}
