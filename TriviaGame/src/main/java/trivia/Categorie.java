package trivia;

public enum Categorie {
    ROCK("Rock"),
    POP("Pop"),
    SCIENCE("Science"),
    SPORT("Sports"),
    GEOGRAPHIE("Géographie");


    private final String name;
    Categorie(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}