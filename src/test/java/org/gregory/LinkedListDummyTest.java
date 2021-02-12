package org.gregory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListDummyTest {

    Node node1;
    Node node2;
    Node node3;
    Node node4;
    Node node5;

    Node node6;
    Node node7;
    Node node8;
    Node node9;
    Node node10;
    Node node11;

    LinkedListDummy linkedListDummyGrowing;
    LinkedListDummy linkedListDummyEmpty;
    LinkedListDummy linkedListDummyRepeat;
    
    @BeforeEach
    void setUp() {
        linkedListDummyGrowing = new LinkedListDummy();
        linkedListDummyGrowing.add(
                node1 = new Node(1),
                node2 = new Node(2),
                node3 = new Node(3),
                node4 = new Node(4),
                node5 = new Node(5)
        );

        linkedListDummyEmpty = new LinkedListDummy();

        linkedListDummyRepeat = new LinkedListDummy();

        linkedListDummyRepeat.add(
                node6 = new Node(6),
                node7 = new Node(7),
                node8 = new Node(8),
                node9 = new Node(6),
                node10 = new Node(6),
                node11 = new Node(8)
        );
    }

    @AfterEach
    void tearDown() {
        linkedListDummyEmpty = null;
        linkedListDummyGrowing = null;
        linkedListDummyRepeat = null;
    }

    @Test
    public void equalsLinkedList2() {
        assertFalse(linkedListDummyGrowing.equals(linkedListDummyEmpty));
        assertFalse(linkedListDummyGrowing.equals(linkedListDummyRepeat));
        assertTrue(linkedListDummyEmpty.equals(new LinkedListDummy()));
        assertTrue(linkedListDummyGrowing.equals(linkedListDummyGrowing));

        assertThat(linkedListDummyGrowing, is(not(linkedListDummyEmpty)));
        assertThat(linkedListDummyGrowing, is(not(linkedListDummyRepeat)));
        assertThat(linkedListDummyGrowing, is(equalTo(linkedListDummyGrowing)));
        assertThat(linkedListDummyEmpty, is(new LinkedListDummy()));
    }

    @Test
    public void removeNodeNotExist() {
        LinkedListDummy linkedListDummyExpected = new LinkedListDummy();
        linkedListDummyExpected.add(
                new Node(1),
                new Node(2),
                new Node(3),
                new Node(4),
                new Node(5)
        );

        assertFalse(linkedListDummyRepeat.remove(100));
        assertEquals(linkedListDummyExpected, linkedListDummyGrowing);

        assertThat(linkedListDummyRepeat.remove(100), is(false));
        assertThat(linkedListDummyGrowing, is(equalTo(linkedListDummyExpected)));
    }

    @Test
    public void removeNodeHead() {

        LinkedListDummy linkedListDummyExpected = new LinkedListDummy();
        linkedListDummyExpected.add(
                new Node(2),
                new Node(3),
                new Node(4),
                new Node(5)
        );

        assertTrue(linkedListDummyGrowing.remove(1));
        assertEquals(linkedListDummyExpected, linkedListDummyGrowing);

        assertThat(linkedListDummyGrowing, is(linkedListDummyExpected));
    }

    @Test
    public void removeNodeTail() {

        LinkedListDummy linkedListDummyExpected = new LinkedListDummy();
        linkedListDummyExpected.add(
                new Node(1),
                new Node(2),
                new Node(3),
                new Node(4)
        );

        assertTrue(linkedListDummyGrowing.remove(5));
        assertEquals(linkedListDummyExpected, linkedListDummyGrowing);

        assertThat(linkedListDummyGrowing, is(linkedListDummyExpected));
    }

    @Test
    public void removeAllElementNotExist() {
        LinkedListDummy linkedListDummyExpected = new LinkedListDummy();
        linkedListDummyExpected.add(
                new Node(1),
                new Node(2),
                new Node(3),
                new Node(4),
                new Node(5)
        );

        linkedListDummyGrowing.removeAll(100);
        assertEquals(linkedListDummyExpected, linkedListDummyGrowing);
        assertThat(linkedListDummyGrowing, is(linkedListDummyExpected));
    }

    @Test
    public void removeAll_RemoveOnlyHead() {
        LinkedListDummy linkedListDummyExpected = new LinkedListDummy();
        linkedListDummyExpected.add(
                new Node(2),
                new Node(3),
                new Node(4),
                new Node(5)
        );

        linkedListDummyGrowing.removeAll(1);

        assertEquals(linkedListDummyExpected, linkedListDummyGrowing);

        assertThat(linkedListDummyGrowing, is(linkedListDummyExpected));
    }

    @Test
    public void removeAll_RemoveOnlyMiddle1Element() {
        LinkedListDummy linkedListDummyExpected = new LinkedListDummy();
        linkedListDummyExpected.add(
                new Node(1),
                new Node(2),
                new Node(4),
                new Node(5)
        );

        linkedListDummyGrowing.removeAll(3);

        assertEquals(linkedListDummyExpected, linkedListDummyGrowing);

        assertThat(linkedListDummyGrowing, is(linkedListDummyExpected));
    }

    @Test
    public void removeAll_RemoveOnlyMiddle13Element() {
        LinkedListDummy linkedListDummyExpected = new LinkedListDummy();
        linkedListDummyExpected.add(
                new Node(1),
                new Node(2),
                new Node(4),
                new Node(5)
        );

        linkedListDummyGrowing.removeAll(3);

        assertEquals(linkedListDummyExpected, linkedListDummyGrowing);
    }

    @Test
    public void removeAll_RemoveOnlyTail() {

        LinkedListDummy linkedListDummyExpected = new LinkedListDummy();
        linkedListDummyExpected.add(
                new Node(1),
                new Node(2),
                new Node(3),
                new Node(4)
        );

        linkedListDummyGrowing.removeAll(5);

        assertEquals(linkedListDummyExpected, linkedListDummyGrowing);
    }

    @Test
    public void removeAll_1Element_NodeNotExist() {

        LinkedListDummy linkedListDummyExpected = new LinkedListDummy();
        linkedListDummyExpected.add(new Node(1));

        LinkedListDummy linkedListDummy1Node = new LinkedListDummy();
        linkedListDummy1Node.add(new Node(1));

        linkedListDummy1Node.removeAll(100);

        assertEquals(linkedListDummyExpected, linkedListDummy1Node);
    }

    //Must find in LinkedListDummy 1 Element

    @Test
    public void removeAll_1ElementRepeat() {

        LinkedListDummy linkedListDummyActual = new LinkedListDummy();
        linkedListDummyActual.add(
                new Node(1),
                new Node(1),
                new Node(1),
                new Node(1),
                new Node(1),
                new Node(1),
                new Node(1),
                new Node(1)
        );

        linkedListDummyActual.removeAll(1);

        assertEquals(linkedListDummyActual, linkedListDummyEmpty);
    }

    @Test
    public void removeAll_1Element() {

        LinkedListDummy linkedListDummyActual = new LinkedListDummy();
        linkedListDummyActual.add(new Node(1));

        linkedListDummyActual.removeAll(1);

        assertEquals(linkedListDummyEmpty, linkedListDummyActual);
    }


    @Test
    public void removeAll_Repeat_removeMiddle3Element() {
        LinkedListDummy linkedListDummyExpected = new LinkedListDummy();
        linkedListDummyExpected.add(
                new Node(7),
                new Node(8),
                new Node(8)
                );

        linkedListDummyRepeat.removeAll(6);

        assertEquals(linkedListDummyExpected, linkedListDummyRepeat);
    }

    //Repeat
    @Test
    public void removeAll_Repeat_removeMiddleAndTail2Element() {

        LinkedListDummy linkedListDummyExpected = new LinkedListDummy();
        linkedListDummyExpected.add(
                new Node(6),
                new Node(7),
                new Node(6),
                new Node(6)
                );

        linkedListDummyRepeat.removeAll(8);
        assertEquals(linkedListDummyExpected, linkedListDummyRepeat);

        assertThat(linkedListDummyRepeat, is(linkedListDummyExpected));
    }

    @Test
    public void removeAll() {
        LinkedListDummy linkedListDummyActual = new LinkedListDummy();
        linkedListDummyActual.add(
                new Node(1),
                new Node(1),
                new Node(1),
                new Node(1)
        );

        linkedListDummyActual.removeAll(1);
        assertEquals(linkedListDummyEmpty, linkedListDummyActual);

        assertThat(linkedListDummyActual, is(linkedListDummyEmpty));
    }

    @Test
    public void count5Elements() {
        assertEquals(5, linkedListDummyGrowing.count());
        assertEquals(6, linkedListDummyRepeat.count());

        assertThat(linkedListDummyGrowing.count(), is(5));
        assertThat(linkedListDummyRepeat.count(), is(6));
    }

    @Test
    public void countNullElements() {
        assertEquals(0, linkedListDummyEmpty.count());
        assertThat(linkedListDummyEmpty.count(), is(0));
    }

    @Test
    public void findNodeExist() {
        assertEquals(node3, linkedListDummyGrowing.find(3));
        assertEquals(node6, linkedListDummyRepeat.find(6));

        assertThat(linkedListDummyGrowing.find(3), is(node3));
        assertThat(linkedListDummyGrowing.find(6), is(not(node6)));
        assertThat(linkedListDummyRepeat.find(6), is(node6));

    }

    @Test
    public void findNodeNotExist() {
        assertNull(linkedListDummyGrowing.find(100));

        assertThat(linkedListDummyGrowing.find(100), nullValue());
    }

    @Test
    public void findAllValue6ShouldNode6Node9Node10() {
/*        List<Node> nodeListExpected = new ArrayList<>() {{
            add(node6);
            add(node9);
            add(node10);
        }};
        */
        List<Node> nodeListExpected = List.of(node6, node9, node10);

        assertEquals(nodeListExpected, linkedListDummyRepeat.findAll(6));

        assertThat(linkedListDummyRepeat.findAll(6), is(nodeListExpected));
    }

    @Test
    public void findAllNotExist() {
        assertEquals(new ArrayList<Node>(), linkedListDummyRepeat.findAll(100));

        assertThat(linkedListDummyRepeat.findAll(100), emptyCollectionOf(Node.class));
        assertThat(linkedListDummyRepeat.findAll(100), empty());
    }

    @Test
    public void insertAfterNull() {

        LinkedListDummy linkedListDummyExpected = new LinkedListDummy();
        linkedListDummyExpected.add(
                new Node(100),
                new Node(1),
                new Node(2),
                new Node(3),
                new Node(4),
                new Node(5)
        );

        Node nodeInsert = new Node(100);

        linkedListDummyGrowing.insertAfter(null, nodeInsert);

        assertThat(linkedListDummyGrowing, is(linkedListDummyExpected));
    }

    @Test
    public void insertAfter1Element() {
        LinkedListDummy linkedListDummyExpected = new LinkedListDummy();
        linkedListDummyExpected.add(
                new Node(1),
                new Node(100),
                new Node(2),
                new Node(3),
                new Node(4),
                new Node(5)
        );

        Node nodeInsert = new Node(100);

        linkedListDummyGrowing.insertAfter(node1, nodeInsert);
        assertEquals(linkedListDummyExpected, linkedListDummyGrowing);
    }


    @Test
    public void insertAfterTail() {

        LinkedListDummy linkedListDummyExpected = new LinkedListDummy();
        linkedListDummyExpected.add(
                new Node(1),
                new Node(2),
                new Node(3),
                new Node(4),
                new Node(5),
                new Node(100)
        );
        Node nodeInsert = new Node(100);

        linkedListDummyGrowing.insertAfter(node5, nodeInsert);
        assertEquals(linkedListDummyExpected, linkedListDummyGrowing);
    }


    @Test
    public void insertAfter1ElementTail() {
        LinkedListDummy linkedListDummyExpected = new LinkedListDummy();
        linkedListDummyExpected.add(
                new Node(1),
                new Node(100)
        );
        Node nodeInsert = new Node(100);

        linkedListDummyGrowing.remove(2);
        linkedListDummyGrowing.remove(3);
        linkedListDummyGrowing.remove(4);
        linkedListDummyGrowing.remove(5);

        linkedListDummyGrowing.insertAfter(node1, nodeInsert);
        assertEquals(linkedListDummyExpected, linkedListDummyGrowing);
    }

    @Test
    public void insertAfterMiddle() {

        LinkedListDummy linkedListDummyExpected = new LinkedListDummy();
        linkedListDummyExpected.add(
                new Node(1),
                new Node(2),
                new Node(3),
                new Node(100),
                new Node(4),
                new Node(5)
        );
        Node nodeInsert = new Node(100);

        linkedListDummyGrowing.insertAfter(node3, nodeInsert);
        assertEquals(linkedListDummyExpected , linkedListDummyGrowing);
    }

    @Test
    public void insertAfterEmptyList() {

        LinkedListDummy linkedListDummyExpected = new LinkedListDummy();
        linkedListDummyExpected.add(
                new Node(1)
        );

        Node node101 = new Node(1);

        linkedListDummyEmpty.insertAfter(null, node101);
        assertEquals(linkedListDummyExpected, linkedListDummyEmpty);
    }

    @Test
    public void insertAfterTail2() {

        LinkedListDummy linkedListDummyExpected = new LinkedListDummy();
        linkedListDummyExpected.add(
                new Node(1),
                new Node(2),
                new Node(3),
                new Node(4),
                new Node(5),
                new Node(100)
        );
        Node nodeInsert = new Node(100);

        linkedListDummyGrowing.insertAfter(node5, nodeInsert);
        assertEquals(linkedListDummyExpected, linkedListDummyGrowing);
    }


}