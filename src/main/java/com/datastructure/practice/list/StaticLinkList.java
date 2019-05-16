package com.datastructure.practice.list;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@ToString(onlyExplicitlyIncluded = true)
public class StaticLinkList<E> implements List<E>{
    @ToString.Include
    private Object[] datas;
    private final int maxLength;
    private int listLength = 0;
    private Node idleFirstNode;
    private Node dataFirstNode;

    public StaticLinkList(int capacity){
        datas = new Object[capacity];
        maxLength = capacity;
        Node<E> node = idleFirstNode = new Node(null,0);
        for (int i = 0; i < capacity; i++) {
            datas[i] = new Node(null, i + 1);
        }
        dataFirstNode = new Node(null,null);
    }

    @Override
    public boolean add(E e) {
        if(listLength == maxLength) {
            throw new IllegalArgumentException("list is full !");
        }
        Node<E> node = dataFirstNode;
        while (node.next != null) {
            node = (Node<E>) datas[node.next];
        }
        Integer idleIndex = idleFirstNode.next;
        Integer nextIdle = ((Node<E>)datas[idleIndex]).next;
        idleFirstNode.next = nextIdle;
        node.next = idleIndex;
        datas[idleIndex] = new Node<>(e,null);
        listLength++;
        return true;
    }

    @Override
    public E get(int index) {
        if(index >= listLength) {
            throw new IllegalArgumentException("index is error");
        }
        Node<E> node = dataFirstNode;
        for (int i = 0; i <= index; i++) {
            node = (Node<E>) datas[node.next];
        }
        return node.getData();
    }

    @Override
    public int indexOf(E e) {
        int index = -1;
        if(maxLength == 0) {
            return index;
        }
        Node<E> node = dataFirstNode;
        int temp = -1;
        do{
            temp++;
            node = (Node<E>) datas[node.next];
            if(e == null) {
                if(node.getData() == null) {
                    index = temp;
                    break;
                }
            }else {
                if(e.equals(node.getData())){
                    index = temp;
                    break;
                }
            }
        }while (node.next != null);
        return index;
    }

    @Override
    public boolean add(int index, E e) {
        if(index >= maxLength){
            throw new IllegalArgumentException("index is large than max index");
        }
        if(listLength == maxLength) {
            return false;
        }
        if(index == maxLength) {
            add(e);
        }
        Node<E> node = dataFirstNode;
        for (int i = 0; i <= index; i++) {
            node = (Node<E>) datas[node.next];
        }
        int idleIndex = idleFirstNode.next;
        Node<E> temp = (Node<E>) datas[idleIndex];
        datas[idleIndex] = new Node<E>(e,null);
        idleFirstNode.next = temp.next;
        listLength++;
        return true;
    }

    @Override
    public E remove(int index) {
        if(index >= maxLength) {
            throw new IllegalArgumentException("index is large than max index");
        }
        Node<E> node = dataFirstNode;
        for (int i = 0; i < index; i++) {
            node = (Node<E>) datas[node.next];
        }
        int idle = node.next;
        Node<E> next = (Node<E>) datas[idle];
        node.next = next.next;
        E data = next.data;
        int currIdle = idleFirstNode.next;
        ((Node<E>)datas[idle]).data = null;
        ((Node<E>)datas[idle]).next = currIdle;
        idleFirstNode.next = idle;
        listLength--;
        return data;
    }

    @Override
    public int size() {
        return listLength;
    }

    @Override
    public void clear() {
        listLength = 0;
        datas = new Object[maxLength];
        Node<E> node = idleFirstNode = new Node(null,0);
        for (int i = 0; i < maxLength; i++) {
            datas[i] = new Node(null, i + 1);
        }
        dataFirstNode = new Node(null,null);
    }

    @Data
    @AllArgsConstructor
    private static class Node<E> {
        private E data;
        private Integer next;
    }
}
