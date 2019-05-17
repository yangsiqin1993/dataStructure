package com.datastructure.practice.list;

import lombok.AllArgsConstructor;
import lombok.Data;

public class CycleLinkList<E> implements List<E> {
    private Node<E> first = null;
    private int listLength = 0;

    public CycleLinkList(){
        first = new Node<>(null,null);
    }

    @Override
    public boolean add(E e) {
        if(first.next == null) {
            first.next = new Node<>(e,first);
            listLength++;
            return true;
        }
        Node<E> node = first;
        while (!node.getNext().equals(first)) {
            node = node.getNext();
        }
        node.setNext(new Node<>(e,first));
        listLength++;
        return true;
    }

    @Override
    public E get(int index) {
        if(index >= listLength || index < 0) {
            throw new IllegalArgumentException("index is large than max index ");
        }
        Node<E> target = first.next;
        int currIndex = 0;
        while (currIndex < index){
            target = target.getNext();
            currIndex++;
        }
        return target.getData();
    }

    @Override
    public int indexOf(E e) {
        int targetIndex = -1;
        int tempIndex = -1;
        Node<E> target = first.next;
        while (target != null && !target.equals(first)) {
            tempIndex++;
            if(e == null) {
                if(target.getData() == null) {
                    targetIndex = tempIndex;
                    break;
                }
            }else {
                if(e.equals(target.getData())){
                    targetIndex = tempIndex;
                    break;
                }
            }
            target = target.getNext();
        }
        return targetIndex;
    }

    @Override
    public boolean add(int index, E e) {
        if(index > listLength) {
            throw new IllegalArgumentException("index is large than max index.");
        }
        if(index == listLength) {
            return add(e);
        }
        Node<E> node = first.next;
        for (int i = 1; i < index; i++) {
            node = node.getNext();
        }
        Node<E> newNode = new Node<>(e,node.getNext());
        node.setNext(newNode);
        return true;
    }

    @Override
    public E remove(int index) {
        if(index > listLength - 1) {
            throw new IllegalArgumentException("index is large than max index.");
        }
        if(index == 0) {
            E data = first.next.data;
            first = first.next.next;
            listLength--;
            return data;
        }
        Node<E> node = first.next;
        for (int i = 1; i < index; i++) {
            node = node.getNext();
        }
        Node<E> shouldRemove = node.getNext();
        node.setNext(shouldRemove.getNext());
        listLength--;
        return shouldRemove.getData();
    }

    @Override
    public int size() {
        return listLength;
    }

    @Override
    public void clear() {
        Node<E> node = first;
        while (node != null) {
            Node<E> next = node.getNext();
            node.setNext(null);
            node.setData(null);
            node = next;
        }
        first = null;
        listLength = 0;
    }

    @Data
    @AllArgsConstructor
    private static class Node<E> {
        private E data;
        private Node<E> next;
    }
}
