package com.karpinsky.csucu.Lab_4_git;

public class Flower extends OrganicObject implements Comparable<Flower>{

    private String name;
    private FlowerSpec flowerSpec;

    public String toString()
    {
        return "Name: " + this.name;
    }

    public Flower(float valueBasedPrice_, String name_, FlowerSpec flowerSpec_)
    {
        super("Plantae", valueBasedPrice_);
        this.name = name_;
        this.flowerSpec = flowerSpec_;
    }

    public String getName() { return this.name; }

    public FlowerSpec getFlowerSpec() { return this.flowerSpec; }

    @Override
    public int compareTo(Flower o)
    {
        if (o == null)
        {
            return -1;
        }

        if (this.valueBasedPrice < o.GetValueBasedPrice())
        {
            return -1;
        }
        else if (this.valueBasedPrice > o.GetValueBasedPrice())
        {
            return 1;
        }

        return 0;
    }
}
