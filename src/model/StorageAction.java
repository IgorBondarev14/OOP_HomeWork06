package model;

import java.util.ArrayList;
import java.util.List;

public class StorageAction implements Storage{
        private NoteMapper mapper = new NoteMapper();
        private Action action;

        public StorageAction(Action action) {
            this.action = action;
        }

        @Override
        public List<Note> getAllNotes() {
            List<String> strings = action.readAllStrings();
            List<Note> notes = new ArrayList<>();
            for (String string : strings) {
                notes.add(mapper.mapN(string));
            }
            return notes;
        }

        @Override
        public String CreateNote(Note note) {

            List<Note> notes = getAllNotes();
            int max = 0;
            for (Note n : notes) {
                int id = Integer.parseInt(n.getId());
                if (max < id) {
                    max = id;
                }
            }
            int newId = max + 1;
            String id = String.format("%d", newId);
            note.setId(id);
            notes.add(note);
            writeDown(notes);
            return id;
        }

        @Override
        public void updateNote (Note note) {
            List<Note> users = getAllNotes();
            Note target = users.stream().filter(i -> i.getId().equals(note.getId())).findFirst().get();
            target.setName(note.getName());
            target.setText(note.getText());
            writeDown(users);
        }

        @Override
        public void deleteNote (String delId) {
            List<Note> notes = getAllNotes();
            for (Note u : notes) {
                if (u.getId().equals(delId)) {
                    notes.remove(u);
                    break;
                }
            }
            writeDown(notes);
        }

        private void writeDown(List<Note> notes) {
            List<String> strings = new ArrayList<>();
            for (Note n: notes) {
                strings.add(mapper.mapS(n));
            }
            action.saveAllStrings(strings);
        }
}
