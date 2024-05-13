package com.example.weightliftingcompetition.model;


import java.util.ArrayList;
import java.util.Collections;

public class Athlete {
    private String name;
    private int personalWeight;
    private String country;
    private ArrayList<Integer> liftWeights = new ArrayList<>();

    public Athlete(String name, int personalWeight, String country) {
        this.name = name;
        this.personalWeight = personalWeight;
        this.country = country;
    }

    public String getName() { return name; }
    public double getPersonalWeight() { return personalWeight; }
    public String getCountry() { return country; }
    public ArrayList<Integer> getLiftWeights() { return liftWeights; }

    public void addLiftWeight(int weight) {
        if (liftWeights.size() < 3) {
            liftWeights.add(weight);
            Collections.sort(liftWeights);
        }
    }
}
