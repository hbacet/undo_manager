package undo.basicImpl;

import undo.interfaces.Change;
import undo.interfaces.ChangeFactory;

/**
 * Created by Bacet on 7/18/2017.
 */
public class BasicChangeFactory implements ChangeFactory {
    @Override
    public Change createDeletion(int pos, String s, int oldDot, int newDot) {
        return new BasicChange(pos, s, oldDot, newDot, Change.DELETION);
    }

    @Override
    public Change createInsertion(int pos, String s, int oldDot, int newDot) {
        return new BasicChange(pos, s, oldDot, newDot, Change.INSERTION);
    }
}
