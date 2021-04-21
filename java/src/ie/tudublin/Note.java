package ie.tudublin;

public class Note {

    private char note;
    private int duration;

    public Note(char note, int duration) {
        this.note = note;
        this.duration = duration;
    }

    public void setNote(char note) {
        this.note = note;
    }

    public char getNote() {
        return note;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

}