package com.practice;

public class DoublyLinkedList
{
    Node head;
    Node tail;
    int size;
    
    public DoublyLinkedList(){
        head = new Node();
        tail = head;
    }
    
    public static void main(String args[]){
        
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.toString());
    }
    
    public void add(int n)
    {
        Node node = null;
        if(size==0)
            node = head;
        else
            node = new Node();
        node.data= n;
        tail.nextNode = node;
        node.prevNode = tail;
        tail = node;
        
        size++;
        
    }
    
    public void remove(int n){
        
    }

    @Override
    public String toString()
    {
        Node node = head;
        String returnString = "";
        while(node!=null){
            returnString+=node.toString() +" ";
            node=node.nextNode;
        }
        return returnString;
    }
}


class Node{
    Node prevNode;
    Node nextNode;
    int data;
    
    public Node(){
        
        data= 0;
        prevNode=null;
        nextNode=null;
    }
    
  
    @Override
    public String toString()
    {
        return "[ data=" + data + "]";
    }
    
}