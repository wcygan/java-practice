package io.wcygan.collections.tree;

public interface BinaryTreeNode<T> {
    T getValue();

    BinaryTreeNode<T> getRight();

    BinaryTreeNode<T> getLeft();

    void insert(T value);
}
