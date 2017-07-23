package undo.basicImpl;

import undo.interfaces.Document;
import undo.interfaces.UndoManager;
import undo.interfaces.UndoManagerFactory;

/**
 * Created by Bacet on 7/18/2017.
 */
public class BasicUndoManagerFactory implements UndoManagerFactory {

    @Override
    public UndoManager createUndoManager(Document doc, int bufferSize) {
        return new BasicUndoManager(doc, bufferSize);
    }
}
