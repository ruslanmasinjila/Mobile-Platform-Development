package com.m.inter_activity_communication;

import java.util.LinkedList;

public class SharedSpace {

    private static LinkedList<Integer> data;

    public SharedSpace()
    {

    }

    public LinkedList<Integer> getData() {
        return data;
    }

    public void setData(LinkedList<Integer> data) {
        this.data = data;
    }


}
