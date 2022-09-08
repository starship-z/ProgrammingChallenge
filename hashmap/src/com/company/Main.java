/*
 * @author: anytochka
 *
 *  Purpose: Driver of the Hashtable data structure. Using user input to
 *           operate the hashtable.
 *
 *           DOES NOT ACCOUNT FOR USER ERROR
 */
package com.company;

import com.company.hashtable.Hashtable;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean cont = true;
        Hashtable hashmap = new Hashtable();

        while(cont){
            System.out.println("***** HashTable Options *****");
            System.out.println("[1] Add key-value pair");
            System.out.println("[2] Remove key-value pair");
            System.out.println("[3] Exit");

            System.out.println();
            System.out.println("Enter operation number:");

            Scanner in = new Scanner(System.in);
            int choice = in.nextInt();

            switch(choice){
                case 1:
                    methodAdd(hashmap);
                    break;
                case 2:
                    methodRemove(hashmap);
                    break;
                case 3:
                    System.out.println("GoodBye!");
                    cont = false;
                    break;
            }
        }
    }

    public static void methodAdd(Hashtable hashmap){
        System.out.println("Enter a key to add:");
        Scanner inK = new Scanner(System.in);
        String inKey = inK.nextLine();

        System.out.println("Enter a value to add:");
        Scanner inV = new Scanner(System.in);
        String inVal = inV.nextLine();

        hashmap.put(inKey, inVal);
        hashmap.prettyPrint();
    }

    public static void methodRemove(Hashtable hashmap){
        System.out.println("Enter a key to remove:");
        Scanner in = new Scanner(System.in);
        String inKey = in.nextLine();

        if(!hashmap.containsKey(inKey)){
            System.out.println("Key Not Found");
        }else{
            hashmap.remove(inKey);
        }
        hashmap.prettyPrint();
    }
}
