package com.datastructure.practice.list;


/**
 * 线性表
 */
public interface List<E> {

    /**
     * 插入一个元素到线性表
     */
    boolean add(E e);

    /**
     * 获取 index 位置上的元素，index 从 0 开始
     */
    E get(int index);

    /**
     * 查找给定元素在线性表中的index
     */
    int indexOf(E e);

    /**
     * 在 index 上插入元素，后续元素（如果有的话）向右移
     */
    boolean add(int index, E e);

    /**
     * 删除位于 index 上的元素
     */
    E remove(int index);

    /**
     * 返回线性表的长度
     */
    int size();

    /**
     * 清空线性表
     */
    void clear();
}
