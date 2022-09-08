/*
* @author: anytochka
*
* Purpose: A tuple structure used to store the key and value together.
*          Makes it easier to handle collisions.
*/
package com.company.hashtable;

public class Entry {
    public String key;
    public String value;

    public Entry(String key, String value){
        this.key = key;
        this.value = value;
    }

}
