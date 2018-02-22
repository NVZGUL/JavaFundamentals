import java.util.stream.IntStream;

public class NotepadWriter {
    private Notepad notepad;

    NotepadWriter(Notepad notepad){
        this.notepad = notepad;
    }
    public void writeToNotepad(String note){
        if (!note.equals("")) {
            String[] oldArr = notepad.getNotes();
            String[] newArr = new String[oldArr.length+1];
            System.arraycopy(oldArr,0,newArr,0,oldArr.length);
            newArr[newArr.length-1]=note;
            notepad.setNotes(newArr);
        }
    }

    public void deleteFromNotepad(int position){
        String[] notes = notepad.getNotes();
        if (notes.length != 0 && position < notes.length){
            notepad.setNotes(IntStream.range(0, notes.length)
                    .filter(i -> i != position)
                    .mapToObj(i -> notes[i])
                    .toArray(String[]::new));
        }

    }

    public void editNote(int position, String newNote){
        String[] notes = notepad.getNotes();
        if (notes.length != 0 && position < notes.length) {
            String[] arr = newNote.equals("") ?
                    IntStream.range(0, notes.length)
                            .mapToObj(i -> i == position ? newNote : notes[i])
                            .filter(n -> !n.equals(""))
                            .toArray(String[]::new) :
                    IntStream.range(0, notes.length)
                            .mapToObj(i -> i == position ? newNote : notes[i])
                            .toArray(String[]::new);
            notepad.setNotes(arr);
        }
    }

}
