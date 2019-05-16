package com.datastructure.practice.list;

import org.junit.Assert;
import org.junit.Test;

public class LinkListTest {

    @Test
    public void addTest(){
        List list = new LinkList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Assert.assertTrue(list.size() == 5);
        try {
            list.add(6);
        }catch (Exception e) {
            Assert.assertTrue(e instanceof IllegalArgumentException);
        }
    }

    @Test
    public void getTest(){
        List<Integer> list = new LinkList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Assert.assertTrue(list.size() == 5);
        Assert.assertTrue(list.get(0) == 1);
        Assert.assertTrue(list.get(1) == 2);
        Assert.assertTrue(list.get(2) == 3);
        Assert.assertTrue(list.get(3) == 4);
        Assert.assertTrue(list.get(4) == 5);
        try {
            list.get(5);
        }catch (Exception e) {
            Assert.assertTrue(e instanceof IllegalArgumentException);
        }
    }

    @Test
    public void indexOfTest(){
        List<Integer> list = new LinkList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Assert.assertTrue(list.indexOf(1) == 0);
        Assert.assertTrue(list.indexOf(2) == 1);
        Assert.assertTrue(list.indexOf(3) == 2);
        Assert.assertTrue(list.indexOf(4) == 3);
        Assert.assertTrue(list.indexOf(5) == 4);
    }


    @Test
    public void addTest2(){
        List list = new LinkList<Integer>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(5);
        Assert.assertTrue(list.size() == 4);
        try {
            list.add(5,6);
        }catch (Exception e) {
            Assert.assertTrue(e instanceof IllegalArgumentException);
        }
        list.add(2,3);
        Assert.assertTrue(list.indexOf(1) == 0);
        Assert.assertTrue(list.indexOf(2) == 1);
        Assert.assertTrue(list.indexOf(3) == 2);
        Assert.assertTrue(list.indexOf(4) == 3);
        Assert.assertTrue(list.indexOf(5) == 4);
    }

    @Test
    public void removeTest(){
        List<Integer> list = new LinkList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.remove(4);

        Assert.assertTrue(list.get(0) == 1);
        Assert.assertTrue(list.get(1) == 2);
        Assert.assertTrue(list.get(2) == 3);
        Assert.assertTrue(list.get(3) == 4);

        list.remove(2);

        Assert.assertTrue(list.get(0) == 1);
        Assert.assertTrue(list.get(1) == 2);
        Assert.assertTrue(list.get(2) == 4);
    }

    @Test
    public void sizeTest(){
        List<Integer> list = new LinkList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.remove(4);
        Assert.assertTrue(list.size() == 4);
        list.remove(3);
        Assert.assertTrue(list.size() == 3);
        list.remove(2);
        Assert.assertTrue(list.size() == 2);
        list.remove(1);
        Assert.assertTrue(list.size() == 1);
        list.remove(0);
        Assert.assertTrue(list.size() == 0);
    }


    @Test
    public void clearTest(){
        List<Integer> list = new LinkList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.clear();
        Assert.assertTrue(list.size() == 0);
    }
}
