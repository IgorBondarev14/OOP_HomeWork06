package model;

public class Note  {
    private String id;
    private String name;
    private String text;

    public Note(String name, String text){
        this.name = name;
        this.text = text;
    }
    public Note (String id, String name, String text){
        this(name, text);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String toString() {
        return String.format("Название записки - `%s`, id записки - `%s`:\n%s", name, id, text);
    }
}

