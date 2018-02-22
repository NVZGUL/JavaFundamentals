import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotepadWriterTest {
    private Notepad notepad;
    private NotepadWriter nw;
    @BeforeEach
    void setUp() {
        notepad = new Notepad();
        nw = new NotepadWriter(notepad);
    }

    @Test
    void writeToNotepad() {
        nw.writeToNotepad("1");
        assertArrayEquals(new String[]{"1"}, notepad.getNotes());
    }

    @Test
    void writeEmptyStringToNotepad(){
        nw.writeToNotepad("");
        assertArrayEquals(new String[0], notepad.getNotes());
    }

    @Test
    void writeToExistingNotepad() {
        notepad.setNotes(new String[]{"1","2","3","4"});
        nw.writeToNotepad("5");
        nw.writeToNotepad("6");
        assertArrayEquals(new String[]{"1","2","3","4","5","6"}, notepad.getNotes());
    }

    @Test
    void deleteFromNotepad() {
        notepad.setNotes(new String[]{"1","2","3","4"});
        nw.deleteFromNotepad(2);
        assertArrayEquals(new String[]{"1","2","4"}, notepad.getNotes());
    }

    @Test
    void deleteFromEmptyNotepad() {
        nw.deleteFromNotepad(0);
        assertArrayEquals(new String[0], notepad.getNotes());
    }

    @Test
    void deleteNotExistingPositionFromNotepad() {
        notepad.setNotes(new String[]{"1","2","321"});
        nw.deleteFromNotepad(321);
        assertArrayEquals(new String[]{"1","2","321"}, notepad.getNotes());
    }

    @Test
    void editNote() {
        notepad.setNotes(new String[]{"1","2","321"});
        nw.editNote(2,"3");
        assertArrayEquals(new String[]{"1","2","3"}, notepad.getNotes());
    }

    @Test
    void editNotExistingNote() {
        notepad.setNotes(new String[]{"1","2","3"});
        nw.editNote(321,"new");
        assertArrayEquals(new String[]{"1","2","3"}, notepad.getNotes());
    }

    @Test
    void editToEmptyNote() {
        notepad.setNotes(new String[]{"1","2","2","3"});
        nw.editNote(2, "");
        assertArrayEquals(new String[]{"1","2","3"}, notepad.getNotes());
    }
}