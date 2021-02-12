package org.gregory;

public class NodeDummy extends Node{

    public NodeDummy() {
        super(0);
        this.next = this;
        this.prev = this;
    }
}
