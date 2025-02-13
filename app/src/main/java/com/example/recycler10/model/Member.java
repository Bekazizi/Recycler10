package com.example.recycler10.model;

public class Member {
    public final static int HEADER = 0;
    public final static int FOOTER = 4;

    public final static int TYPE_MEMBER_ONE = 1;
    public final static int TYPE_MEMBER_TWO = 2;
    public final static int TYPE_MEMBER_THRE = 3;

    private String first_name;
    private String full_name;
    private  int type;

    public int getType() {
        return type;
    }


    public String getFirst_name() {
        return first_name;
    }

    public String getFull_name() {
        return full_name;
    }

    public Member(int type, String first_name, String full_name){
        this.type = type;
        this.first_name = first_name;
        this.full_name = full_name;
    }

    @Override
    public String toString() {
        return "Member{" +
                "first_name=" + first_name +
                ", full_name=" + full_name +
                '}';
    }
}
