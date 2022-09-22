package tool;

import pojo.Node;

public class BSTSet<E> implements Set<E> {
    private BST<E> bst;

    @Override
    public void add(Object o) {

    }

    @Override
    public void remove(Object o) {

    }

    @Override
    public boolean contains(Object o) {
        return bst.contain((Node) o);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
