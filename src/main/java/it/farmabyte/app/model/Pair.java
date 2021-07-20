package it.farmabyte.app.model;

//Classe di utility per implementare la mappa che associa Farmacia -> <Farmaco, Lotto>
//(credit: https://stackoverflow.com/a/12328838)

public class Pair<X, Y> { 
    public final X x; 
    public final Y y; 
    public Pair(X x, Y y) { 
        this.x = x; 
        this.y = y; 
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Pair)){
            return false;
        }

        Pair<X,Y> other_ = (Pair<X,Y>) other;

        try{
            // this may cause NPE if nulls are valid values for x or y. The logic may be improved to handle nulls properly, if needed.
            return other_.x.equals(this.x) && other_.y.equals(this.y);
        }
        catch(NullPointerException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((x == null) ? 0 : x.hashCode());
        result = prime * result + ((y == null) ? 0 : y.hashCode());
        return result;
    }

    public X getX() {
        return x;
    }

    public Y getY() {
        return y;
    }
}