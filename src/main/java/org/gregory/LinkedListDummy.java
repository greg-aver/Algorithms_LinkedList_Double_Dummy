package org.gregory;

import java.util.ArrayList;

public class LinkedListDummy {

    private NodeDummy nodeDummy;

    public LinkedListDummy() {
        this.nodeDummy = new NodeDummy();
    }

    private NodeDummy getNodeDummy() {
        return nodeDummy;
    }

    public void add(Node nodeInsert) {
        getNodeDummy().getPrev().setNext(nodeInsert);
        nodeInsert.setNext(getNodeDummy());
        nodeInsert.setPrev(getNodeDummy().getPrev());
        getNodeDummy().setPrev(nodeInsert);
    }

    public void add(Node... nodeInsert) {
        for (Node node : nodeInsert) {
            add(node);
        }
    }

    public Node find(int _value) {
        Node node = getNodeDummy().getNext();
        while (node != getNodeDummy()) {
            if (node.getValue() == _value)
                return node;
            node = node.getNext();
        }
        return null;
    }

    public boolean remove(int _value) {

        Node index = this.getNodeDummy().getNext();
        while (index != nodeDummy) {
            if (index.getValue() == _value) {
                index.getPrev().setNext(index.getNext());
                index.getNext().setPrev(index.getPrev());
                return true;
            }
            index = index.getNext();
        }
        return false;
    }

    public void removeAll(int _value) {
        Node index = this.getNodeDummy().getNext();
        while (index != nodeDummy) {
            if (index.getValue() == _value) {
                index.getPrev().setNext(index.getNext());
                index.getNext().setPrev(index.getPrev());
            }
            index = index.getNext();
        }
    }


    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        if (_nodeAfter == null) {
            _nodeToInsert.setNext(this.getNodeDummy().getNext());
            this.getNodeDummy().getNext().setPrev(_nodeToInsert);
            _nodeToInsert.setPrev(getNodeDummy());
            this.getNodeDummy().setNext(_nodeToInsert);
            return;
        }
        Node index = this.getNodeDummy().getNext();
        while (index != getNodeDummy()) {
            if (_nodeAfter.equals(index)) {
                _nodeToInsert.setNext(_nodeAfter.getNext());
                _nodeToInsert.setPrev(_nodeAfter);
                _nodeAfter.setNext(_nodeToInsert);
                _nodeToInsert.getNext().setPrev(_nodeToInsert);
                return;
            }
            index = index.next;
        }
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.getNodeDummy().getNext();
        while (node != getNodeDummy()) {
            if (node.getValue() == _value) {
                nodes.add(node);
            }
            node = node.getNext();
        }
        return nodes;
    }

    public void clear() {
        this.getNodeDummy().setNext(getNodeDummy());
        this.getNodeDummy().setPrev(getNodeDummy());
    }

    public int count() {
        int i = 0;
        Node index = this.getNodeDummy().getNext();
        while (index != getNodeDummy()) {
            i++;
            index = index.getNext();
        }
        return i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LinkedListDummy that = (LinkedListDummy) o;

        Node nodeThis = this.getNodeDummy().getNext();
        Node nodeThat = that.getNodeDummy().getNext();

        if (nodeThat == that.getNodeDummy() ^ nodeThis == this.getNodeDummy()) {
            return false;
        }

        while (nodeThat != that.getNodeDummy() && nodeThis != this.getNodeDummy()) {
            if (nodeThat.getValue() != nodeThis.getValue()) {
                return false;
            }
            nodeThat = nodeThat.getNext();
            nodeThis = nodeThis.getNext();
        }

        nodeThat = that.getNodeDummy().getPrev();
        nodeThis = this.getNodeDummy().getPrev();

        while (nodeThat != that.getNodeDummy() && nodeThis != this.getNodeDummy()) {
            if (nodeThat.getValue() != nodeThis.getValue()) {
                return false;
            }
            nodeThat = nodeThat.getPrev();
            nodeThis = nodeThis.getPrev();
        }
        return true;
    }

}
