package model;

public interface Mapperable {
    public interface mapperable {
        public String map(Note note);
        public Note map(String line);
    }
}
