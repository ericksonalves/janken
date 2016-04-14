package br.ufam.edu.vss.janken.model;

public class Player {

    private PlayerId id;
    private String name;
    private Shape shape;

    public Player(PlayerId id, String name) {
        setId(id);
        setName(name);
    }

    public PlayerId getId() {
        return id;
    }

    public void setId(PlayerId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }
}
