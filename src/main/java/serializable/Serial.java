package serializable;

import java.io.Serializable;


public class Serial implements Serializable,Comparable{

    private static final long serialVersionUID = 6977402643848374753L;
    int id;
    String name;

    public Serial(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "DATA: " + id + " " + name;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
