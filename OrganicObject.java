package com.karpinsky.csucu.Lab_4_git;

public class OrganicObject {

    protected String biologicalClassification = "Not Defined";
    public String GetBiologicalClassification() { return this.biologicalClassification; }
    public void SetBiologicalClassification(String value) { this.biologicalClassification = value; }

    protected float valueBasedPrice;
    public float GetValueBasedPrice() { return this.valueBasedPrice; }
    public void SetValueBasedPrice(float value) { this.valueBasedPrice = value; }

    public OrganicObject(String biologicalClassification_, float valueBasedPrice_)
    {
        this.biologicalClassification = biologicalClassification_;
        this.valueBasedPrice = valueBasedPrice_;
    }

}
