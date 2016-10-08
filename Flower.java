package com.karpinsky.csucu.Lab_4_git;

public class Flower extends OrganicObject implements Comparable<Flower>{

    private int freshnessLevel;
    public int GetFreshnessLevel() { return this.freshnessLevel; }
    public void SetFreshnessLevel(int value) { this.freshnessLevel = value; }

    private float stemLength;
    public float GetStemLength() { return this.stemLength; }
    public void SetStemLength(float value) { this.stemLength = value; }

    public String toString()
    {
        return "Freshness level: " + Integer.toString(freshnessLevel) + " Stem Length: " + Float.toString(stemLength) + " Price: " + Float.toString(valueBasedPrice);
    }

    public Flower(float valueBasedPrice_, int freshnessLevel_, float stemLength_)
    {
        super("Plantae", valueBasedPrice_);
        this.freshnessLevel = freshnessLevel_;
        this.stemLength = stemLength_;
    }

    @Override
    public int compareTo(Flower o)
    {
        if (o == null)
        {
            return -1;
        }

        if (valueBasedPrice < o.GetValueBasedPrice())
        {
            return -1;
        }
        else if (valueBasedPrice > o.GetValueBasedPrice())
        {
            return 1;
        }

        return 0;
    }
}
