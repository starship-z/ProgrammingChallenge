/*
 * @author: anytochka
 *
 * Purpose: A hash table data storage. The data is stored using
 *          string keys, and string values.
 *
 *          ENABLES SEARCH, ADD, & REMOVE
 */
package com.company.hashtable;

import java.util.*;

public class Hashtable {
    private int size;
    private Entry[] storage;

    public Hashtable() {
        this.size = 0;
        this.storage = new Entry[0];
    }

    // HASH FUNCTION
    /*
    * As long a string is turned into a number in a unique way to
    * minimize collisions, it is suitable.
    */
    private int _hash(String key){
        int asciiCodeSum = 0;

        for(int i = 0; i < key.length(); i++){
            asciiCodeSum += (int)key.charAt(i);
        }

        // random prime ascii hash
        return asciiCodeSum * 157 % this.size;
    }

    // O(1) LOOK UP
    /*
    * Hashing allows for constant lookup because the hash is unique
    * and there is no need to traverse the entire hashtable for an
    * entry.
    */
    public boolean containsKey(String key){
        if(this.size <= 0){
            return false;
        }

        int index = this._hash(key);
        int counter = 0;

        // not null and not the needed key
        while(!this.storage[index].key.equals("-1") && !this.storage[index].key.equals(key)){
            if(counter >= this.size){
                return false;
            }

            index++;
            index %= this.size;
            counter++;
        }

        return true;
    }

    // RESIZING ON CHANGE
    /*
    * Both ADD and REMOVE call resize, so it has to be generic. A new hashtable
    * with the given size is created, then the entries are rehashed and placed in
    * the new hashtable.
    */
    private Entry[] _resize(int newSize){
        this.size = newSize;

        // current hashtable
        Entry[] oldStorage = this.storage;
        // new hashtable
        Entry[] newStorage = new Entry[newSize];
        // null fill
        Arrays.fill(newStorage, new Entry("-1", "-1"));

        for(Entry entry : oldStorage){
            if(entry.key.equals("-1")){
                continue;
            }

            int index = this._hash(entry.key);

            // not null
            while(!newStorage[index].key.equals("-1")){
                index++;
                index %= this.size;
            }

            newStorage[index] = entry;
        }

        return newStorage;
    }

    public void put(String key, String value){
        if(!containsKey(key)){
            this.storage = this._resize(this.size + 1);
        }

        int index = this._hash(key);

        // the current index's key != null AND
        // if the input key already exists then update
        while(!this.storage[index].key.equals("-1") && !this.storage[index].key.equals(key)){
            index++;
            index %= this.size;
        }

        Entry temp = new Entry(key, value);
        this.storage[index] = temp;
    }

    public void remove(String key){
        int index = this._hash(key);

        while(!this.storage[index].key.equals("-1")){

            // if key exists then set to null
            if(this.storage[index].key.equals(key)){
                this.storage[index] = new Entry("-1", "-1");
            }

            index++;
            index %= this.size;
        }

        this.storage = this._resize(this.size - 1);
    }

    public void prettyPrint(){
        for(Entry temp : this.storage){
            System.out.print("{K:\""+temp.key+"\", V:\""+temp.value+"\"} ");
        }

        System.out.println();
    }

}
