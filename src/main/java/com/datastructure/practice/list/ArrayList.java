package com.datastructure.practice.list;

import lombok.ToString;

import java.util.Iterator;

@ToString(onlyExplicitlyIncluded = true)
public class ArrayList<E> implements List<E> {

    @ToString.Include
    private final Object[] datas;
    private final int maxIndex;
    private int listLength;

    public ArrayList(int capacity) {
        datas = new Object[capacity];
        maxIndex = capacity - 1;
        listLength = 0;
    }

    public boolean add(E e) {
        if (listLength == maxIndex + 1) {
            System.out.println("list is full !");
            return false;
        }
        datas[listLength] = e;
        listLength++;
        return true;
    }

    public E get(int index) {
        if (index > maxIndex) {
            throw new IllegalArgumentException(String.format("index is large than max index [%d] !", maxIndex));
        }
        return (E) datas[index];
    }

    public int indexOf(E e) {
        if (e == null) {
            for (int i = 0; i < datas.length; i++) {
                if (datas[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < datas.length; i++) {
                if (datas[i].equals(e)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean add(int index, E e) {
        if (listLength == maxIndex + 1) {
            System.out.println("list is full !");
            return false;
        }
        if (index > listLength) {
            throw new IllegalArgumentException(String.format("index is >= max index [%d]", maxIndex));
        }
        if (index == listLength) {
            return add(e);
        }
        for (int moveIndex = listLength - 1; moveIndex >= index; moveIndex--) {
            datas[moveIndex + 1] = datas[moveIndex];
        }
        datas[index] = e;
        listLength++;
        return true;
    }

    public E remove(int index) {
        if (index >= listLength) {
            throw new IllegalArgumentException("index is large than list length !");
        }
        E removeElement = (E) datas[index];
        for (int i = index; i < listLength; i++) {
            if (index == listLength - 1) {
                datas[index] = null;
                continue;
            }
            datas[index] = datas[index + 1];
        }
        listLength--;
        return removeElement;
    }

    public int size() {
        return listLength;
    }

    public void clear() {
        for (int i = 0; i < listLength; i++) {
            datas[i] = null;
        }
        listLength = 0;
    }
}
