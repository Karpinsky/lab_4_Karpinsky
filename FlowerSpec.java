package com.karpinsky.csucu.Lab_4_git;

public class FlowerSpec {

    public enum FlowerColor
    {
        RED, GREEN, BLUE, TRANSPARENT, MAGENTA, YELLOW;

        public String toString()
        {
            switch (this)
            {
                case RED: return "red";
                case GREEN: return "green";
                case BLUE: return "blue";
                case TRANSPARENT: return "transparent";
                case MAGENTA: return "magenta";
                case YELLOW: return "yellow";
                default: return "color not found";
            }
        }
    }

    private FlowerColor flowerColor;
    private int freshnessLevel;
    private float stemLength;

    public FlowerSpec(FlowerColor flowerColor_, int freshnessLevel_, float stemLength_)
    {
        this.flowerColor = flowerColor_;
        this.freshnessLevel = freshnessLevel_;
        this.stemLength = stemLength_;
    }

    public FlowerColor getFlowerColor() { return this.flowerColor; }

    public int getFreshnessLevel() { return this.freshnessLevel; }
    public void setFreshnessLevel(int value) { this.freshnessLevel = value; }

    public float getStemLength() { return this.stemLength; }
    public void setStemLength(float value) { this.stemLength = value; }

    public boolean matches(FlowerSpec other)
    {
        if (this.flowerColor != other.flowerColor)
        {
            return false;
        }
        if (this.freshnessLevel != other.freshnessLevel)
        {
            return false;
        }
        if (this.stemLength != other.stemLength)
        {
            return false;
        }
        return true;
    }

}
