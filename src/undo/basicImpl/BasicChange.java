package undo.basicImpl;

import undo.interfaces.Change;
import undo.interfaces.Document;

/**
 * Created by Bacet on 7/18/2017.
 */
public class BasicChange implements Change {
    private int pos;
    private String s;
    private int oldDot;
    private int newDot;
    private String type;

    public BasicChange(int pos, String s, int oldDot, int newDot, String type) {
        this.pos = pos;
        this.s = s;
        this.oldDot = oldDot;
        this.newDot = newDot;
        this.type = type;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void apply (Document doc) throws IllegalStateException {
        switch (type){
            case Change.INSERTION:
                doc.insert(pos, s);
                break;
            case Change.DELETION:
                doc.delete(pos, s);
                break;
        }
        doc.setDot(newDot);
    }

    @Override
    public void revert(Document doc) throws IllegalStateException {
        switch (type){
            case Change.DELETION:
                doc.insert(pos, s);
                break;
            case Change.INSERTION:
                doc.delete(pos, s);
                break;
        }
        doc.setDot(oldDot);
    }

    @Override
    public String toString() {
        return "BasicChange{" +
                "pos=" + pos +
                ", s='" + s + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
