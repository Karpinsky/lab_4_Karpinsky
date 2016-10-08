package com.karpinsky.csucu.Lab_4_git;
import java.util.Arrays;

public class Gift {

    public static void main(String[] args)
    {
        Gift giftExample = new Gift(new Candy(1, 5, 342));
        giftExample.addCandy(new Candy(1, 2, 1512));
        giftExample.addCandy(new Candy(1, 6, 52));
        giftExample.addCandy(new Candy(1, 4, 583));
        giftExample.addCandy(new Candy(1, 3, 512));
        giftExample.deleteCandy();
        giftExample.deleteCandy();
        giftExample.addCandy(new Candy(1, 1, 53214));
        giftExample.addCandy(new Candy(1, 45214, 123));
        giftExample.deleteCandy(1);
        giftExample.deleteCandy();
        giftExample.sortGiftBySugarLevel();

        System.out.println(giftExample.findCandyInScopeOfChocolateness(49, 340));

        System.out.println(giftExample);
    }

    private Candy[] allCandies;
    private int candyArraySize;
    private int lastFreeElementIndex;

    private float giftPrice;
    public float GetBouquetPrice() { return giftPrice; }

    public int Length() { return lastFreeElementIndex; }

    public Candy getCandy(int index)
    {
        if (index >= this.candyArraySize || index < 0)
        {
            throw new IndexOutOfBoundsException("No such Candy slot in Gift");
        }

        return this.allCandies[index];
    }

    public void addCandy(Candy candyToAdd)
    {
        if (this.lastFreeElementIndex == this.candyArraySize)
        {
            this.candyArraySize *= 2;
            Candy[] swapCandyArray = new Candy[this.candyArraySize];

            for (int i = 0; i < this.allCandies.length; i++)
            {
                swapCandyArray[i] = this.allCandies[i];
            }

            this.allCandies = swapCandyArray;
        }

        this.allCandies[lastFreeElementIndex] = candyToAdd;
        this.lastFreeElementIndex++;

        this.giftPrice += candyToAdd.GetValueBasedPrice();
    }

    public void deleteCandy()
    {
        this.giftPrice -= this.allCandies[this.lastFreeElementIndex - 1].GetValueBasedPrice();

        this.allCandies[this.lastFreeElementIndex - 1] = null;
        this.lastFreeElementIndex--;

        if (this.lastFreeElementIndex < this.candyArraySize / 2)
        {
            this.candyArraySize = this.candyArraySize / 2;
            Candy[] swapCandyArray = new Candy[this.candyArraySize];

            for (int i = 0; i < this.candyArraySize; i++)
            {
                swapCandyArray[i] = this.allCandies[i];
            }

            this.allCandies = swapCandyArray;
        }
    }

    public void deleteCandy(int index)
    {
        if (index >= this.candyArraySize || index < 0)
        {
            throw new IndexOutOfBoundsException("No such candy slot in gift");
        }

        this.giftPrice -= this.allCandies[index].GetValueBasedPrice();
        this.allCandies[index] = null;

        for (int i = index + 1; i < this.candyArraySize; i++)
        {
            this.allCandies[i - 1] = this.allCandies[i];
        }

        this.lastFreeElementIndex--;
    }

    public Candy findCandyInScopeOfChocolateness(float minChocolatness, float maxChocolatness)
    {
        for (int i = 0; i < this.Length(); i++)
        {
            float currentChocolatness = this.allCandies[i].GetChocolatness();
            if (currentChocolatness > minChocolatness && currentChocolatness < maxChocolatness)
            {
                return this.allCandies[i];
            }
        }

        return null;
    }

    public void sortGiftBySugarLevel()
    {
        MergeSort.SortMerge(this.allCandies);
    }

    public String toString()
    {
        return Arrays.toString(this.allCandies);
    }

    public Gift()
    {
        this.lastFreeElementIndex = 0;
        this.candyArraySize = 1;
        this.allCandies = new Candy[this.candyArraySize];
        this.giftPrice = 0;
    }

    public Gift(int size)
    {
        this.lastFreeElementIndex = 0;
        this.candyArraySize = size;
        this.allCandies = new Candy[this.candyArraySize];
        this.giftPrice = 0;
    }

    public Gift(Candy startingCandy)
    {
        this.lastFreeElementIndex = 0;
        this.candyArraySize = 1;
        this.allCandies = new Candy[this.candyArraySize];
        this.allCandies[lastFreeElementIndex] = startingCandy;
        lastFreeElementIndex++;

        this.giftPrice= startingCandy.GetValueBasedPrice();
    }

    public Gift(int size, Candy startingCandy)
    {
        this.lastFreeElementIndex = 0;
        this.candyArraySize= size;
        this.allCandies = new Candy[this.candyArraySize];
        this.allCandies[lastFreeElementIndex] = startingCandy;
        this.lastFreeElementIndex++;

        this.giftPrice = startingCandy.GetValueBasedPrice();
    }

    public Gift(Candy[] readyCandyArray)
    {
        this.lastFreeElementIndex = 0;
        this.candyArraySize= readyCandyArray.length;
        this.allCandies = new Candy[this.candyArraySize];

        this.giftPrice = 0;

        for (int i = 0; i < this.candyArraySize; i++)
        {
            if (readyCandyArray[i] != null)
            {
                this.allCandies[this.lastFreeElementIndex] = readyCandyArray[i];
                this.lastFreeElementIndex++;

                this.giftPrice+= readyCandyArray[i].GetValueBasedPrice();
            }
        }
    }

}
