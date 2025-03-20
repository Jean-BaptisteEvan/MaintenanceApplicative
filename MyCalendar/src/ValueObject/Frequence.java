package ValueObject;

public class Frequence {

    final int frequence;

    public Frequence(int freq) {
        this.frequence = freq;
    }

    public int getFrequence() {
        return frequence;
    }

    @Override
    public String toString() {
        return Integer.toString(frequence);
    }
}
