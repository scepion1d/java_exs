package com.epam.cdp.tree;

import javax.annotation.Nullable;
import java.util.Random;
import java.util.Stack;

public class Tree {
    private long id_seq;
    private Node root;

    public Tree(long depth) {
        id_seq = 0;
        root = new Node(id_seq);
        grow(root, depth);
    }

    private void grow(Node node, long depth) {
        if (node == null || depth == 0) return;
        System.out.format("Node %d on level %d\n", node.getId(), depth);

        int state = new Random().nextInt(3);

        if (state < 1) {
            node.setLeft(new Node(++this.id_seq));
            node.setRight(new Node(++this.id_seq));
        } else if (state < 2) {
            node.setLeft(new Node(++this.id_seq));
        } else {
            node.setRight(new Node(++this.id_seq));
        }
        grow(node.getLeft(), depth - 1);
        grow(node.getRight(), depth - 1);
    }

    public void swap_all_recursive() {
        swap_all_recursive(root);
    }

    private void swap_all_recursive(@Nullable Node node) {
        if (node == null || node.is_leaf()) return;

        swap_children(node);

        if (node.getLeft() != null) swap_all_recursive(node.getLeft());
        if (node.getRight() != null) swap_all_recursive(node.getLeft());
    }

    private void swap_children(Node node) {
        Node buffer = node.getLeft();
        node.setLeft(node.getRight());
        node.setRight(buffer);
    }

    public void swap_all() {
        Stack<Node> stack = new Stack<>();

        Node node = root;

        while (node != null || stack.size() > 0) {
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }

            node = stack.pop();
            swap_children(node);

            node = node.getRight();
        }
    }
}
