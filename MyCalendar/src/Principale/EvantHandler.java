package Principale;

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
        // Ajout simplifié d'un RDV personnel
        System.out.print("Titre de l'événement : ");
        String titre = scanner.nextLine();
        LocalDateTime localDate = makeDate();
        System.out.print("Durée (en minutes) : ");
        int duree = Integer.parseInt(scanner.nextLine());

        calendar.ajouterEvent("RDV_PERSONNEL", titre, utilisateur, localDate, duree, "", "", 0);

        System.out.println("Événement ajouté.");
    }

    public void ajoutReunion(CalendarManager calendar, String utilisateur){
        System.out.print("Titre de l'événement : ");
        String titre2 = scanner.nextLine();
        LocalDateTime localDate2 = makeDate();
        System.out.print("Durée (en minutes) : ");
        int duree2 = Integer.parseInt(scanner.nextLine());
        System.out.println("Lieu :");
        String lieu = scanner.nextLine();

        StringBuilder participants = new StringBuilder(utilisateur);

        System.out.println("Ajouter un participant ? (oui / non)");
        while (scanner.nextLine().equals("oui"))
        {
            System.out.print("Participants : " + participants);
            participants.append(", ").append(scanner.nextLine());
        }

        calendar.ajouterEvent("REUNION", titre2, utilisateur, localDate2, duree2, lieu, participants.toString(), 0);

        System.out.println("Événement ajouté.");
    }

    public void ajoutPeriodique(CalendarManager calendar, String utilisateur){
        System.out.print("Titre de l'événement : ");
        String titre3 = scanner.nextLine();
        LocalDateTime localDate3 = makeDate();
        System.out.print("Frequence (en jours) : ");
        int frequence = Integer.parseInt(scanner.nextLine());

        calendar.ajouterEvent("PERIODIQUE", titre3, utilisateur, localDate3, 0, "", "", frequence);

        System.out.println("Événement ajouté.");
    }

    public void event_mois(CalendarManager calendar){
        System.out.print("Entrez l'année (AAAA) : ");
        int anneeMois = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le mois (1-12) : ");
        int mois = Integer.parseInt(scanner.nextLine());

        LocalDateTime debutMois = LocalDateTime.of(anneeMois, mois, 1, 0, 0);
        LocalDateTime finMois = debutMois.plusMonths(1).minusSeconds(1);

        afficherListe(calendar.eventsDansPeriode(debutMois, finMois));
    }

    public void event_semaine(CalendarManager calendar){
        System.out.print("Entrez l'année (AAAA) : ");
        int anneeSemaine = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le numéro de semaine (1-52) : ");
        int semaine = Integer.parseInt(scanner.nextLine());

        LocalDateTime debutSemaine = LocalDateTime.now()
                .withYear(anneeSemaine)
                .with(WeekFields.of(Locale.FRANCE).weekOfYear(), semaine)
                .with(WeekFields.of(Locale.FRANCE).dayOfWeek(), 1)
                .withHour(0).withMinute(0);
        LocalDateTime finSemaine = debutSemaine.plusDays(7).minusSeconds(1);

        afficherListe(calendar.eventsDansPeriode(debutSemaine, finSemaine));
    }

    public void event_jour(CalendarManager calendar){
        System.out.print("Entrez l'année (AAAA) : ");
        int anneeJour = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le mois (1-12) : ");
        int moisJour = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le jour (1-31) : ");
        int jour = Integer.parseInt(scanner.nextLine());

        LocalDateTime debutJour = LocalDateTime.of(anneeJour, moisJour, jour, 0, 0);
        LocalDateTime finJour = debutJour.plusDays(1).minusSeconds(1);

        afficherListe(calendar.eventsDansPeriode(debutJour, finJour));
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
