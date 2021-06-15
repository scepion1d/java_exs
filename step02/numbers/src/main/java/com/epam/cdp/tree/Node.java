package com.epam.cdp.tree;

import lombok.Getter;
import lombok.Setter;

import javax.annotation.Nullable;

@Getter
@Setter
public class Node {
    private long id;

    private @Nullable Node left;
    private @Nullable Node right;

    public Node(long id) {
        this.id = id;
    }

    public boolean is_leaf() {
        return  left == null && right == null;
    }
}
