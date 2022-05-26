package com.example.demo;


import java.util.ArrayList;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private int id;
    private ArrayList<Person> friendList = new ArrayList<>();
    private ArrayList<String> messages = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Person(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Person> getFriendList() {
        return friendList;
    }

    public Person getFriendFromIndex(int i) {
        return friendList.get(i);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addToFriendList(Person person) {
        friendList.add(person);
    }

    public void printFriendList() {
        for (int i = 0; i < friendList.size(); i++)
            System.out.println(friendList.get(i));
    }

    public void addToMessages(String message) {
        messages.add(message);
    }

    public String printMessages() {
        String result = messages.stream().map(n -> String.valueOf(n)).collect(Collectors.joining("-", "{", "}"));
        return result;
    }

    public int getNumberOfFriends() {
        return friendList.size();
    }

}
