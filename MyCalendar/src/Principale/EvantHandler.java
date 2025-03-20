package Principale;

import Events.AffichageCalendrier;
import Events.Periodique;
import Events.RendezVous;
import Events.Reunion;
import ValueObject.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
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

        DateEvent localDate = new DateEvent(makeDate());

        System.out.print("Durée (en minutes) : ");
        DureeEvent duree = new DureeEvent(scanner.nextInt());

        calendar.ajouterEvent(new RendezVous(titre,new ProprioEvent(utilisateur),localDate,duree));
        System.out.println("Événement ajouté.");
    }

    public void ajoutReunion(CalendarManager calendar, String utilisateur){
        System.out.print("Titre de l'événement : ");
        TitreEvent titre = new TitreEvent(scanner.nextLine());

        DateEvent localDate = new DateEvent(makeDate());

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
        DateEvent localDate = new DateEvent(makeDate());

        System.out.print("Frequence (en jours) : ");
        Frequence freq = new Frequence(scanner.nextInt());

        Event e = new Periodique(titre,new ProprioEvent(utilisateur),localDate,freq);
        calendar.ajouterEvent(e);
        System.out.println("Événement ajouté.");
    }

    public void event_mois(CalendarManager calendar){
        AffichageCalendrier.filtrerListeEvent(scanner,0,calendar).showListe();
    }

    public void event_semaine(CalendarManager calendar){
        AffichageCalendrier.filtrerListeEvent(scanner,1,calendar).showListe();
    }

    public void event_jour(CalendarManager calendar){
        AffichageCalendrier.filtrerListeEvent(scanner,2,calendar).showListe();
    }

    //utilisataires
    private LocalDateTime makeDate() {
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
