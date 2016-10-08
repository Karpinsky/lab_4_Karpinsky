package com.karpinsky.csucu.Lab_4_git;

public class Candy extends OrganicObject implements Comparable<Candy>{

    private int sugarLevel;
    public int GetSugarLevel() { return this.sugarLevel; }
    public void SetSugarLevel(int value) { this.sugarLevel = value; }

    private float chocolatness;
    public float GetChocolatness() { return this.chocolatness; }
    public void SetChocolatness(float value) { this.chocolatness = value; }

    public String toString()
    {
        return "Sugar level: " + Integer.toString(sugarLevel) + " Chocolatness: " + Float.toString(chocolatness) + " Price: " + Float.toString(valueBasedPrice);
    }

    public Candy(float valueBasedPrice_, int freshnessLevel_, float chocolatness_)
    {
        super("Chocolate", valueBasedPrice_);
        this.sugarLevel = freshnessLevel_;
        this.chocolatness = chocolatness_;
    }

    @Override
    public int compareTo(Candy o)
    {
        if (o == null)
        {
            return -1;
        }

        if (sugarLevel < o.GetSugarLevel())
        {
            return -1;
        }
        else if (sugarLevel > o.GetSugarLevel())
        {
            return 1;
        }

        return 0;
    }
}
