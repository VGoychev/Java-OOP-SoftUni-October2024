package _03_Inheritance.lab._04_StackOfStrings;

import java.util.ArrayList;

public class StackOfStrings{

    private ArrayList<String> data = new ArrayList<>();

    public void push(String item){
        this.data.add(item);
    }

    public String pop(){
        if (!this.data.isEmpty()) {
            return this.data.removeLast();
        } else {
            throw new IllegalArgumentException("StackOfStrings is empty.");
        }
    }

    public String peek(){
        if (!this.data.isEmpty()) {
            return this.data.getLast();
        } else {
            throw new IllegalArgumentException("StackOfStrings is empty.");
        }
    }

    public boolean isEmpty(){
        return this.data.isEmpty();
    }


}
