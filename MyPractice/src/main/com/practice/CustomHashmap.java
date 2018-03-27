package com.practice;

import java.util.Arrays;

public class CustomHashmap<K,V>{
    int capacity = 16;
    Entry<K,V>[] bucket ;
    
    public CustomHashmap(int initialcapacity){
        capacity = initialcapacity;
        bucket = new Entry[capacity];
    }
    
    public void put(K key,V value){
        int hash = key.hashCode();
        int index = getIndex(hash);
        Entry<K,V> entry = null;
        System.out.println("finding index : "+index);
        if(bucket[index] == null){
            entry = new Entry<K,V>(key, value);
            System.out.println("new bucket : "+ entry);
            bucket[index] = entry;
        }
        else{
            entry =  bucket[index];
            if(isContainsKey(entry,key)){
                System.out.println("key entry allready present : "+ entry);
                entry.value[entry.size]=new Value<V>(value);
                
            }
            else{
                System.out.println("new entry : "+ key);
                entry.next = new Entry<K,V>(key, value);
                
            }
        }
    }
    
    private boolean isContainsKey(Entry<K, V> entry, K key)
    {
       // Entry entry = entry1;
        while(entry!=null)
        {
            if(entry.key.equals(key))
                return true;
            entry = entry.next;
        }
        return false;
    }
    
    private Value<V>[] getKey(Entry<K, V> entry, K key)
    {
        //System.out.println("getting " +entry);
       // Entry entry = entry1;
        while(entry!=null)
        {
            System.out.println("----> "+entry);
            if(entry.key.equals(key)){
                System.out.println("I FOUND IT");
                return entry.value;
            }else{
            entry = entry.next;
            }
        }
        return null;
    }

    public String get(K key){
        System.out.println(Arrays.toString(bucket));
        int hash = key.hashCode();
        int index = getIndex(hash);
        Entry<K,V> entry = null;
        System.out.println("index : "+index);
        if(bucket[index] != null){
            Value<V>[] value= getKey(bucket[index], key);
            if(value== null)
                return null;
            return Arrays.toString(value);
            
        }
        
        return null;
    }
    
    private String getMultiValues(Value<V>[] value)
    {
        StringBuffer val = new StringBuffer();
        for (int i = 0; i < value.length; i++)
        {
            val.append(value[i]);
        }
        return val.toString();
    }
    

    public int size(){
        return 0;
        
    }
    
    private int getIndex(int hash){
        return hashCode() & (capacity -1);
    }
    
    
    public static void main(String args[]){
        
        CustomHashmap<Integer,String> ch= new CustomHashmap<>(16);
        ch.put(1, "test1");
        ch.put(1, "test2");
        ch.put(1, "test3");
        ch.put(1, "test4");
        ch.put(2, "testr");
        ch.put(3, "testu");
        ch.put(1, "test7");
        
        System.out.println("----------------------------------------------------" +ch.get(1));
        System.out.println(ch.get(2));
    }
    
}

class Entry<K,V>{
    K key;
    Value<V>[] value;
    Entry<K,V> next;
    Entry<K,V> child;
    int size;
    public Entry(K key, V value)
    {
        this.value = new Value[10];
        this.key = key;
        this.value[0] = new Value<V>(value);
        this.next = null;
        this.child=null;
        size++;
    }
    @Override
    public String toString()
    {
        return "Entry [key=" + key + ", value=" + Arrays.toString(value) + "]";
    }
    
   
}


class Value<V>{
    V value;
    
    public Value(V value){
        this.value = value;
    }

    @Override
    public String toString()
    {
        return " "+value + " ";
    }
}