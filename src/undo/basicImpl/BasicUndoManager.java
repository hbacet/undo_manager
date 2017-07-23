package undo.basicImpl;

import undo.interfaces.Change;
import undo.interfaces.Document;
import undo.interfaces.UndoManager;

import java.util.ListIterator;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Bacet on 7/18/2017.
 */
public class BasicUndoManager implements UndoManager {
    private Document doc;
    private int bufferSize;
    private Vector<Change> changes;
    private ListIterator<Change> iterator;

    public BasicUndoManager(Document doc, int bufferSize) {
        this.doc = doc;
        this.bufferSize = bufferSize;
        this.changes = new Vector<>(bufferSize);
        this.iterator = this.changes.listIterator();
    }

    @Override
    public synchronized void registerChange(Change change) {
        System.out.println("Registering new change: " + change.toString());
        if(this.iterator.hasNext()) {
            this.removeTailingElements();
        }
        this.iterator.add(change);
        change.apply(this.doc);
    }

    @Override
    public boolean canUndo() {
        return iterator.hasPrevious();
    }

    @Override
    public synchronized void undo() throws IllegalStateException {
        if (this.canUndo()) {
            try {
                System.out.println("proceeding to apply Undo...");
                Change change = iterator.previous();
                change.revert(doc);
                System.out.println("Undo applied successfully!");
            } catch (IllegalStateException e) {
                throw new IllegalStateException("Failed to apply undo", e);
            }
        } else {
            throw new IllegalStateException("No changes to undo");
        }
    }

    @Override
    public boolean canRedo() {
        return iterator.hasNext();
    }

    @Override
    public synchronized void redo() throws IllegalStateException {
        if (this.canRedo()) {
            try {
                System.out.println("proceeding to apply Redo...");
                Change change = iterator.next();
                change.apply(doc);
                System.out.println("Undo applied successfully!");
            } catch (IllegalStateException e) {
                throw new IllegalStateException("Failed to apply redo", e);
            }
        } else {
            throw new IllegalStateException("No changes to redo");
        }
    }

    private void removeTailingElements() {
        System.out.println("Removing tailing elements:");
        while(this.iterator.hasNext()){
            System.out.println("--> Removing " + this.iterator.next().toString());
            this.iterator.remove();
        }
    }
}
