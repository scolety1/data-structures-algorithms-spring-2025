package program02;

public class Word implements Comparable<Word> {
    String word;
    int distance;

    public Word(String word, int distance) {
        this.word = word;
        this.distance = distance;
    }

    public int compareTo(Word other) {
        return this.distance - other.distance;
    }
}
