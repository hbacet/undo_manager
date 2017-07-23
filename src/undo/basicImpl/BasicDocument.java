package undo.basicImpl;

import undo.interfaces.Document;

/**
 * Created by Bacet on 7/18/2017.
 */
public class BasicDocument implements Document {
    private StringBuilder content;
    private int dot;

    public BasicDocument() {
        this.content = new StringBuilder();
        this.dot = 0;
    }

    @Override
    public void delete(int pos, String s) throws IllegalStateException {
        if(this.content.indexOf(s, pos) == pos){
            this.content.delete(pos, pos + s.length());
        } else {
            throw new IllegalStateException("the document doesn't have " + s + " at position " + pos);
        }
    }

    @Override
    public void insert(int pos, String s) throws IllegalStateException {
        if(this.content.length() >= pos) {
            this.content.insert(pos, s);
        } else {
            throw new IllegalStateException("the document is shorter than " + pos);
        }
    }

    @Override
    public void setDot(int pos) throws IllegalStateException {
        if(this.content.length() >= pos) {
            this.dot = pos;
            this.showContent();
        } else {
            throw new IllegalStateException("the document is shorter than " + pos);
        }
    }

    private void showContent(){
        System.out.println("Document content: [" + this.content + "], dot at position: " + this.dot);
    }
}
