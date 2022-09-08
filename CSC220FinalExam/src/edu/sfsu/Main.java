/**
 * @author Ana Nytochka
 * 12/15/2020
 * CSC220 Final Project Exam
 */

package edu.sfsu;

import sfsuexam.Candidate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static List createGovList() throws IOException {
        List<Candidate> govList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("governors_county_data.csv"));
        Candidate c;
        while (br.readLine() != null) {
            String str = br.readLine();
            String[] parts = str.split(",");
            c = new Candidate(parts[0], parts[1], parts[2], parts[3], Integer.parseInt(parts[4]), Boolean.parseBoolean(parts[5]));
            govList.add(c);
        }
        return govList;
    }

    public static List createPresList() throws IOException {
        List<Candidate> presList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("president_county_data.csv"));
        Candidate c;
        while (br.readLine() != null) {
            String str = br.readLine();
            String[] parts = str.split(",");
            c = new Candidate(parts[0], parts[1], parts[2], parts[3], Integer.parseInt(parts[4]), Boolean.parseBoolean(parts[5]));
            presList.add(c);
        }
        return presList;
    }

    public static void main(String[] args) throws IOException {

        System.out.println("Loading presidential candidates county data....");
        createPresList();
        System.out.println("Presidential candidates county data loading complete!");
        System.out.println("Loading governor candidates county data....");
        createGovList();
        System.out.println("Governors candidates county data loading complete!");

        System.out.println();

        System.out.println("********    U.S. Elections 2020 Data (last update Dec 2020)    ********");
        System.out.println("[1] For every state, display democratic counties that won both presidential and governors ordered by name of county in ascending order");
        System.out.println("[2] For every state, display republican counties that won both presidential and governors ordered by name of county in ascending order");
        System.out.println("Presidential Elections Options:");
        System.out.println("[3] For every state, display top 10 democratic counties ordered by count in descending order");
        System.out.println("[4] For every state, display top 10 republican counties ordered by count in descending order");
        System.out.println("Governors Elections Options:");
        System.out.println("[5] For every state, display top 10 democratic counties and governor name ordered by count in descending order");
        System.out.println("[6] For every state, display top 10 republican counties and governor name ordered by count in descending order");
        System.out.println("[7] To exit");
        System.out.println("Enter your choice:");

        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();

        switch (choice) {
            case 1:
                System.out.println("******** Democratic States That Won Both ********");
                optionOne();
                break;
            case 2:
                System.out.println("******** Republican States That Won Both ********");
                optionTwo();
                break;
            case 3:
                System.out.println("******** Presidential Democratic States ********");
                optionThree();
                break;
            case 4:
                System.out.println("******** Presidential Republican States ********");
                optionFour();
                break;
            case 5:
                System.out.println("******** Governor Democratic States ********");
                optionFive();
                break;
            case 6:
                System.out.println("******** Governor Republic States ********");
                optionSix();
                break;
            case 7:
                System.out.println("Good Bye!");
                break;
        }

    }

    //Display up to 10 DEM counties that won pres and gov ordered by name of county
    public static void optionOne() throws IOException {
        List<Candidate> pres = createPresList();
        List<Candidate> gov = createGovList();
        HashMap<String, ArrayList<ArrayList<Candidate>>> map = new HashMap<>();
        String current = "";
        for (Candidate c : pres) {
            if (!current.equals(c.getState())) {
                current = c.getState();
            } else if (current.equals(c.getState())) {
                continue;
            }
            ArrayList<ArrayList<Candidate>> temp1 = new ArrayList<>();
            for (Candidate b : gov) {
                ArrayList<Candidate> temp = new ArrayList<>();
                if (c.getState().equals(b.getState())) {
                    if (c.getParty().equals(b.getParty())) {
                        if (c.getParty().equals("DEM")) {
                            if (c.isWon() == b.isWon()) {
                                temp.add(c);
                                temp.add(b);
                                temp1.add(temp);
                            }
                        }
                    }
                }

            }
            map.put(c.getState(), temp1);
        }

        for (Map.Entry<String, ArrayList<ArrayList<Candidate>>> entry : map.entrySet()) {
            String key = entry.getKey();
            ArrayList<ArrayList<Candidate>> value = entry.getValue();
            if (value.size() == 0) {
                continue;
            }
            System.out.println(key);
            int i = 0;
            for (int j = 0; j < value.size(); j++) {
                String key1 = value.get(j).get(0).getCounty();
                String value1 = value.get(j).get(0).getCounty();
                String value2 = value.get(j).get(1).getCounty();
                System.out.println(value2);
                if (i == 9) {
                    break;
                }
                i++;
            }
            System.out.println();
        }
    }

    public static void optionTwo() throws IOException {
        List<Candidate> pres = createPresList();
        List<Candidate> gov = createGovList();
        HashMap<String, ArrayList<ArrayList<Candidate>>> map = new HashMap<>();
        String current = "";
        for (Candidate c : pres) {
            if (!current.equals(c.getState())) {
                current = c.getState();
            } else if (current.equals(c.getState())) {
                continue;
            }
            ArrayList<ArrayList<Candidate>> temp1 = new ArrayList<>();
            for (Candidate b : gov) {
                ArrayList<Candidate> temp = new ArrayList<>();
                if (c.getState().equals(b.getState())) {
                    if (c.getParty().equals(b.getParty())) {
                        if (c.getParty().equals("REP")) {
                            if (c.isWon() == b.isWon()) {
                                temp.add(c);
                                temp.add(b);
                                temp1.add(temp);
                            }
                        }
                    }
                }

            }
            map.put(c.getState(), temp1);
        }

        for (Map.Entry<String, ArrayList<ArrayList<Candidate>>> entry : map.entrySet()) {
            String key = entry.getKey();
            ArrayList<ArrayList<Candidate>> value = entry.getValue();
            if (value.size() == 0) {
                continue;
            }
            System.out.println(key);
            int i = 0;
            for (int j = 0; j < value.size(); j++) {
                String key1 = value.get(j).get(0).getCounty();
                String value1 = value.get(j).get(0).getCounty();
                String value2 = value.get(j).get(1).getCounty();
                System.out.println(value2);
                if (i == 9) {
                    break;
                }
                i++;
            }
            System.out.println();
        }
    }

    public static void optionThree() throws IOException {
        HashMap<String, HashMap<String, Integer>> demWinners = new HashMap<>();
        HashMap<String, Integer> demWinners1 = null;
        List<Candidate> pres = createPresList();
        for (Candidate c : pres) {
            if (c.getParty().equals("DEM")) {
                demWinners1 = new HashMap<>();
                for (Candidate b : pres) {
                    if (b.getState().equals(c.getState()) && b.getParty().equals("DEM")) {
                        demWinners1.put(b.getCounty(), b.getVotes());
                    }
                }
                demWinners.put(c.getState(), demWinners1);
            }
        }
        for (String str : demWinners.keySet()) {
            String key = str.toString();
            String value = demWinners.get(str).toString();
            int i = 0;
            System.out.println(key + ":");
            HashMap<String, Integer> temp = demWinners.get(key);

            for (String str1 : temp.keySet()) {
                String key1 = str1.toString();
                String value1 = temp.get(str1).toString();

                System.out.println(key1 + " " + value1);
                if (i == 9) {
                    break;
                }
                i++;
            }
            System.out.println();
        }
    }

    public static void optionFour() throws IOException {
        HashMap<String, HashMap<String, Candidate>> repWinners = new HashMap<>();
        HashMap<String, ArrayList<Candidate>> repWinners1 = new HashMap<>();
        List<Candidate> pres = createPresList();
        for (Candidate c : pres) {
            if (c.getParty().equals("REP")) {
                ArrayList<Candidate> temp = new ArrayList<>();
                for (Candidate b : pres) {
                    if (b.getState().equals(c.getState()) && b.getParty().equals("REP")) {
                        temp.add(b);
                    }
                }
                repWinners1.put(c.getState(), temp);
            }
        }

        System.out.println(repWinners);

        for (Map.Entry<String, ArrayList<Candidate>> entry : repWinners1.entrySet()) {
            String key = entry.getKey();
            ArrayList<Candidate> value = entry.getValue();
            Collections.sort(value, Collections.reverseOrder());
            System.out.println(key);
            int i = 0;
            for (Candidate str1 : value) {
                String key1 = str1.getCounty();
                String value1 = Integer.toString(str1.getVotes());

                System.out.println(key1 + " " + value1);
                if (i == 9) {
                    break;
                }
                i++;
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void optionFive() throws IOException {
        HashMap<String, HashMap<String, Candidate>> repWinners = new HashMap<>();
        HashMap<String, ArrayList<Candidate>> repWinners1 = new HashMap<>();
        List<Candidate> pres = createGovList();
        for (Candidate c : pres) {
            if (c.getParty().equals("DEM")) {
                ArrayList<Candidate> temp = new ArrayList<>();
                for (Candidate b : pres) {
                    if (b.getState().equals(c.getState()) && b.getParty().equals("DEM")) {
                        temp.add(b);
                    }
                }
                repWinners1.put(c.getState(), temp);
            }
        }

        System.out.println(repWinners);

        for (Map.Entry<String, ArrayList<Candidate>> entry : repWinners1.entrySet()) {
            String key = entry.getKey();
            ArrayList<Candidate> value = entry.getValue();
            Collections.sort(value, Collections.reverseOrder());
            System.out.println(key);
            int i = 0;
            for (Candidate str1 : value) {
                String key1 = str1.getCounty();
                String value1 = Integer.toString(str1.getVotes());

                System.out.println(key1 + " " + value1);
                if (i == 9) {
                    break;
                }
                i++;
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void optionSix() throws IOException {
        HashMap<String, HashMap<String, Candidate>> repWinners = new HashMap<>();
        HashMap<String, ArrayList<Candidate>> repWinners1 = new HashMap<>();
        List<Candidate> pres = createGovList();
        for (Candidate c : pres) {
            if (c.getParty().equals("REP")) {
                ArrayList<Candidate> temp = new ArrayList<>();
                for (Candidate b : pres) {
                    if (b.getState().equals(c.getState()) && b.getParty().equals("REP")) {
                        temp.add(b);
                    }
                }
                repWinners1.put(c.getState(), temp);
            }
        }

        System.out.println(repWinners);

        for (Map.Entry<String, ArrayList<Candidate>> entry : repWinners1.entrySet()) {
            String key = entry.getKey();
            ArrayList<Candidate> value = entry.getValue();
            Collections.sort(value, Collections.reverseOrder());
            System.out.println(key);
            int i = 0;
            for (Candidate str1 : value) {
                String key1 = str1.getCounty();
                String value1 = Integer.toString(str1.getVotes());

                System.out.println(key1 + " " + value1);
                if (i == 9) {
                    break;
                }
                i++;
            }
            System.out.println();
        }
        System.out.println();
    }
}