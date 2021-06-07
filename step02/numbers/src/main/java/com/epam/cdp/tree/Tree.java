package com.epam.cdp.tree;

import lombok.Getter;

import javax.annotation.Nullable;
import java.util.Random;

public class Tree {
    private long id_seq = 0;
    private Node root = new Node(id_seq);
    private long size;

    public Tree(long size) {
        this.size = size;
    }

    private  void set_depth(Node node) {
        long value = Math.max(depth(node.getLeft()), depth(node.getRight())) + 1;
        node.setDepth(value);
    }

    private long depth(Node node) {
        if (node == null) return 0;
        return node.getDepth();
    }

    public Node rotate_right(Node a) {
        Node b = a.getLeft();
        Node c = b.getRight();

        b.setRight(a);
        a.setLeft(c);

        set_depth(a);
        set_depth(b);

        return b;
    }

    public Node rotate_left(Node a) {
        Node b = a.getRight();
        Node c = b.getLeft();

        b.setLeft(a);
        a.setRight(c);

        set_depth(a);
        set_depth(b);

        return b;
    }


}
