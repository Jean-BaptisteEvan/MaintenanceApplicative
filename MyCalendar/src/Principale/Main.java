package Principale;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {
        CalendarManager calendar = new CalendarManager();
        EvantHandler gestEvent = new EvantHandler();
        Scanner scanner = new Scanner(System.in);
        AtomicReference<String> utilisateur = new AtomicReference<>();
        AtomicBoolean continuer = new AtomicBoolean(true);

        HashMap<String, String> user_passwords = new HashMap<>();
        user_passwords.put("Roger", "Chat");
        user_passwords.put("Pierre", "KiRouhl");

        while (true) {
            if (utilisateur.get() == null) {
                System.out.println("=== Menu Principal ===");
                System.out.println("1 - Se connecter");
                System.out.println("2 - Créer un compte");
                System.out.print("Choix : ");

                Map<String, Runnable> loginActions = new HashMap<>();
                loginActions.put("1", () -> utilisateur.set(gestEvent.connectUtilisateur(user_passwords)));
                loginActions.put("2", () -> utilisateur.set(gestEvent.createUtilisateur(user_passwords)));

                loginActions.getOrDefault(scanner.nextLine(), () -> {}).run();
            }

            while (continuer.get() && utilisateur.get() != null) {
                System.out.println("\nBonjour, " + utilisateur);
                System.out.println("=== Menu Gestionnaire d'Événements ===");
                System.out.println("1 - Voir les événements");
                System.out.println("2 - Ajouter un rendez-vous perso");
                System.out.println("3 - Ajouter une réunion");
                System.out.println("4 - Ajouter un évènement périodique");
                System.out.println("5 - Se déconnecter");
                System.out.print("Votre choix : ");
                String choix = scanner.nextLine();

                Map<String, Runnable> mainMenuActions = new HashMap<>();
                mainMenuActions.put("1", () -> {
                    System.out.println("\n=== Menu de visualisation d'Événements ===");
                    System.out.println("1 - Afficher TOUS les événements");
                    System.out.println("2 - Afficher les événements d'un MOIS précis");
                    System.out.println("3 - Afficher les événements d'une SEMAINE précise");
                    System.out.println("4 - Afficher les événements d'un JOUR précis");
                    System.out.println("5 - Retour");
                    System.out.print("Votre choix : ");

                    Map<String, Runnable> eventViewActions = new HashMap<>();
                    eventViewActions.put("1", calendar::afficherEvenements);
                    eventViewActions.put("2", () -> gestEvent.event_mois(calendar));
                    eventViewActions.put("3", () -> gestEvent.event_semaine(calendar));
                    eventViewActions.put("4", () -> gestEvent.event_jour(calendar));

                    eventViewActions.getOrDefault(scanner.nextLine(), () -> {}).run();
                });
                mainMenuActions.put("2", () -> gestEvent.ajoutRDV(calendar, utilisateur.get()));
                mainMenuActions.put("3", () -> gestEvent.ajoutReunion(calendar, utilisateur.get()));
                mainMenuActions.put("4", () -> gestEvent.ajoutPeriodique(calendar, utilisateur.get()));
                mainMenuActions.put("5", () -> {
                    System.out.println("Déconnexion ! Voulez-vous continuer ? (O/N)");
                    continuer.set(scanner.nextLine().trim().equalsIgnoreCase("oui"));
                    utilisateur.set(null);
                });

                mainMenuActions.getOrDefault(choix, () -> System.out.println("Choix invalide")).run();
            }
        }
    }
}
