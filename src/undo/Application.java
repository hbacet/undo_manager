package undo;

import undo.basicImpl.BasicChangeFactory;
import undo.basicImpl.BasicDocument;
import undo.basicImpl.BasicUndoManagerFactory;
import undo.interfaces.ChangeFactory;
import undo.interfaces.Document;
import undo.interfaces.UndoManager;
import undo.interfaces.UndoManagerFactory;

/**
 * Created by Bacet on 7/18/2017.
 */
public class Application {
    private static int DEFAULT_BUFFER_SIZE = 9;
    private static int SMALL_BUFFER_SIZE = 2;

    public static void main(String[] args) {
        Example1();
        Example2();
        Example3();
    }

    public static void Example1(){
        System.out.println("**************Example #1 is running*************************");

        try {
            Document doc = new BasicDocument();

            UndoManagerFactory factory = new BasicUndoManagerFactory();
            UndoManager undoManager = factory.createUndoManager(doc, DEFAULT_BUFFER_SIZE);

            ChangeFactory changeFactory = new BasicChangeFactory();

            undoManager.registerChange(changeFactory.createInsertion(0, "I ", 0, 2));

            undoManager.undo();
            undoManager.undo();

        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void Example2(){
        System.out.println("**************Example #2 is running*************************");

        try {
            Document doc = new BasicDocument();

            UndoManagerFactory factory = new BasicUndoManagerFactory();
            UndoManager undoManager = factory.createUndoManager(doc, DEFAULT_BUFFER_SIZE);

            ChangeFactory changeFactory = new BasicChangeFactory();

            undoManager.registerChange(changeFactory.createInsertion(0, "I ", 0, 2));
            undoManager.registerChange(changeFactory.createInsertion(2, "can ", 2, 6));
            undoManager.registerChange(changeFactory.createInsertion(6, "see ", 6, 10));
            undoManager.registerChange(changeFactory.createInsertion(10, "you.", 10, 1));
            undoManager.registerChange(changeFactory.createDeletion(2, "can", 2, 2));
            undoManager.registerChange(changeFactory.createInsertion(2, "want to", 2, 2));

            undoManager.undo();
            undoManager.undo();
            undoManager.undo();
            undoManager.redo();

            undoManager.registerChange(changeFactory.createInsertion(2, "really ", 2, 2));

            undoManager.redo();
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }



    public static void Example3(){
        System.out.println("**************Example #3 is running*************************");

        try {
            Document doc = new BasicDocument();

            UndoManagerFactory factory = new BasicUndoManagerFactory();
            UndoManager undoManager = factory.createUndoManager(doc, SMALL_BUFFER_SIZE);

            ChangeFactory changeFactory = new BasicChangeFactory();

            undoManager.registerChange(changeFactory.createInsertion(0, "I ", 0, 2));
            undoManager.registerChange(changeFactory.createInsertion(2, "can ", 2, 6));
            undoManager.registerChange(changeFactory.createInsertion(6, "see ", 6, 10));
            undoManager.registerChange(changeFactory.createInsertion(10, "you.", 10, 1));
            undoManager.registerChange(changeFactory.createDeletion(2, "can", 2, 2));
            undoManager.registerChange(changeFactory.createInsertion(2, "want to", 2, 2));
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
