package com.example.sundy_android_test.chapter5;

/**
 * @author xiads
 * @date 14-7-10
 */
public class ThreadObjectTest {

    static Person p;
    public static void main(String[] args) {
       new Thread(new Runnable() {
           @Override
           public void run() {
                p = new Person(1, "sam");
           }
       }).start();
    }

}

class Person {

    int id;
    String name;

    Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "id=" + id + ",name=" + name;
    }
}
