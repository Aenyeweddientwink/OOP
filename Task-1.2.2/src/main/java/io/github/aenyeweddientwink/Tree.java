/*package io.github.aenyeweddientwink;


import java.util.ArrayList;
import java.util.Iterator;

/**
 * Tree generic class.
 * @param <E> nodes cannot be primitive types

public class Tree<E> implements Iterable<E>{
    /**
     * Search can be a BFS or DFS.
     */
    enum Search {
        // Breadth First Search
        BFS,
        // Depth First Search
        DFS
    }
    private E value;
    private Tree<E> parent;

    public Tree(){
        value = null;
        parent = null;

    }




}