package model;

import java.util.List;

public interface Storage {
    List<Note> getAllNotes();
    String CreateNote(Note note);
    void updateNote(Note note);
    void deleteNote(String delId);
}
