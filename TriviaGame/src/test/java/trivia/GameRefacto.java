package trivia;

import org.junit.jupiter.api.Test;

import java.util.Objects;


import static org.junit.jupiter.api.Assertions.*;

public class GameRefacto {

    @Test
    public void testMax6Player(){
        IGame game = new Game();
        for (int i = 0; i < 6; i++) {
            game.add(i + "");
        }
        boolean is_rejected = game.add("Joueur_de_trop");
        assertFalse(is_rejected, "Should have rejected adding a seventh player");
    }

    @Test
    public void testNewCategorie() {
        boolean categoriePresent = false;
        for (int i = 0; i < Categorie.values().length; i++) {
            if (Objects.equals(Categorie.values()[i].toString(), "Géographie")) {
                categoriePresent = true;
                break;
            }
        }
        assertTrue(categoriePresent, "Catégorie 'Géographie' non présente !");
    }

    @Test
    public void testMinPlayers() {
        IGame game = new Game();
        //Test à 0
        game.isGameValid();
        //Test à 1
        game.add("J1");
        game.isGameValid();
        //Test à 2
        game.add("J2");
        game.isGameValid();
    }

    @Test
    public void testPlayerEnterAfterGameStart() {
        IGame game = new Game();
        game.add("JI");
        game.add("JO");
        assertFalse(game.isGameInProgress());
        game.roll(42);
        boolean result = game.add("JÜ");
        assertFalse(result);
        assertTrue(game.isGameInProgress());
    }

    @Test
    public void testTwoPlayerSameName() {
        IGame game = new Game();
        boolean result;
        result = game.add("JI");
        assertTrue(result);
        result = game.add("JI");
        assertFalse(result);
    }

    @Test
    public void testStreak(){
        Game game = new Game();
        game.add("J1");
        game.add("J2");
        Player p = game.getTheCurrentPlayer();
        System.out.println(p.getName());
        // test if streak increment by 2
        game.handleCorrectAnswer();//J1
        game.nextPlayer();//J2
        game.handleCorrectAnswer();//J1
        game.nextPlayer();//J2
        game.handleCorrectAnswer();//J1
        assertEquals(4, p.getScore());
        // test if streak avoid jail
        game.nextPlayer();//J2
        game.wrongAnswer();//J1

        assertFalse(p.isInJail());
        // test if no streak increment only by 1
        game.nextPlayer();//J2
        game.handleCorrectAnswer();//J1
        assertEquals(5, p.getScore());
        // test if no streak avoid jail
        game.nextPlayer();//J2
        game.wrongAnswer();//J1
        assertTrue(p.isInJail());
    }
}