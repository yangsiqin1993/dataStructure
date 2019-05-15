package com.datastructure.practice.list;

import lombok.AllArgsConstructor;
import lombok.Data;

public class LinkList<E> implements List<E> {
    private Node<E> first = null;
    private int listLength = 0;

    @Override
    public boolean add(E e) {
        if(first == null) {
            first = new Node<>(e,null);
            listLength++;
            return true;
        }
        Node<E> node = first.getNext();
        while (node != null) {
            node = node.getNext();
        }
        node.setNext(new Node<>(e,null));
        listLength++;
        return true;
    }

    @Override
    public E get(int index) {
        if(index >= listLength) {
            throw new IllegalArgumentException("index is large than max index ");
        }
        if(index == 0) {

        }
        return null;
    }

    @Override
    public int indexOf(E e) {
        return 0;
    }

    @Override
    public boolean add(int index, E e) {
        return false;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Data
    @AllArgsConstructor
    private static class Node<E> {
        private E data;
        private Node<E> next;
    }
}
