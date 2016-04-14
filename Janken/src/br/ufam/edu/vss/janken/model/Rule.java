package br.ufam.edu.vss.janken.model;

public class Rule extends Pair<Shape, Shape> {

    public Rule(Shape first, Shape second) {
        super(first, second);
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object != null && object.getClass() == getClass()) {
            result = ((Rule) object).getFirst() == this.getFirst() && ((Rule) object).getSecond() == this.getSecond();
        }
        return result;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 7 * hash + this.getFirst().hashCode();
        hash = 7 * hash + this.getSecond().hashCode();
        return hash;
    }

}
