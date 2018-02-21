import lombok.Setter;

public class Notepad {
    private @Setter String[] notes;

    public Notepad() {
        notes = new String[0];
    }
    public String[] getNotes() {
        return notes.clone();
    }

}
