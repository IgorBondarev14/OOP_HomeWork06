package model;

public class NoteMapper implements Mapperable {
    public String mapS(Note note) {
        return String.format("%s, %s, %s", note.getId(), note.getName(), note.getText());
    }

    public Note mapN(String string) {
        String[] strings = string.split(", ", 3);
        return new Note(strings[0], strings[1], strings[2]);
    }
}

