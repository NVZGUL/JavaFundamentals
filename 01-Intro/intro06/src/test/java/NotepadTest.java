import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotepadTest {
    private Notepad n;
    @BeforeEach
    void setUp() {
        n = new Notepad();
    }

    @Test
    void getNotes() {
        assertArrayEquals(new String[0], n.getNotes());
    }

    @Test
    void setNotes() {
        n.setNotes(new String[]{"1","test"});
        assertArrayEquals(new String[]{"1","test"}, n.getNotes());
    }

    @Test
    void getNotModifideNotes() {
        n.setNotes(new String[]{"1","test"});
        n.getNotes()[0] = "2";
        assertArrayEquals(new String[]{"1","test"}, n.getNotes());
    }

    @Test
    void setCanOnlyModifyNotes() {
        n.setNotes(new String[]{"1","test"});
        String[] newN = n.getNotes();
        newN[0] = "2";
        n.setNotes(newN);
        assertArrayEquals(new String[]{"2", "test"}, n.getNotes());
    }
}