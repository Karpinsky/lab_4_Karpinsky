package com.karpinsky.csucu.Lab_4_git;
import java.util.Arrays;

public class Bouquet {

    public static void main(String[] args)
    {
        Bouquet bouquetExample = new Bouquet(new Flower(10, "Tinky Winky", new FlowerSpec(FlowerSpec.FlowerColor.MAGENTA, 12, 42)));
        bouquetExample.addFlower(new Flower(5, "Dipsy", new FlowerSpec(FlowerSpec.FlowerColor.GREEN, 56, 7)));
        bouquetExample.addFlower(new Flower(5, "Dipsy2", new FlowerSpec(FlowerSpec.FlowerColor.GREEN, 56, 7)));
        bouquetExample.addFlower(new Flower(7, "Lala", new FlowerSpec(FlowerSpec.FlowerColor.YELLOW, 42, 3)));
        bouquetExample.addFlower(new Flower(2, "Po", new FlowerSpec(FlowerSpec.FlowerColor.RED, 511, 32)));
        bouquetExample.deleteFlower();
        bouquetExample.deleteFlower();
        bouquetExample.sortBouquetByValueBasedPrice();

        System.out.println(bouquetExample.findFlowerInScopeOfStemLength(49, 340));

        System.out.println(bouquetExample);
        System.out.println(Arrays.toString(bouquetExample.search(new FlowerSpec(FlowerSpec.FlowerColor.GREEN, 56, 7))));
    }

    private Flower[] allFlowers;
    private int flowerArraySize;
    private int lastFreeElementIndex;

    private float bouquetPrice;
    public float GetBouquetPrice() { return bouquetPrice; }

    public int Length() { return lastFreeElementIndex; }

    public Flower getFlower(int index)
    {
        if (index >= this.flowerArraySize || index < 0)
        {
            throw new IndexOutOfBoundsException("No such flower slot in bouquet");
        }

        return this.allFlowers[index];
    }

    public void addFlower(Flower flowerToAdd)
    {
        if (this.lastFreeElementIndex == this.flowerArraySize)
        {
            this.flowerArraySize *= 2;
            Flower[] swapFlowerArray = new Flower[this.flowerArraySize];

            for (int i = 0; i < this.allFlowers.length; i++)
            {
                swapFlowerArray[i] = this.allFlowers[i];
            }

            this.allFlowers = swapFlowerArray;
        }

        this.allFlowers[lastFreeElementIndex] = flowerToAdd;
        this.lastFreeElementIndex++;

        this.bouquetPrice += flowerToAdd.GetValueBasedPrice();
    }

    public void deleteFlower()
    {
        this.bouquetPrice -= this.allFlowers[this.lastFreeElementIndex - 1].GetValueBasedPrice();

        this.allFlowers[this.lastFreeElementIndex - 1] = null;
        this.lastFreeElementIndex--;

        if (this.lastFreeElementIndex < this.flowerArraySize / 2)
        {
            this.flowerArraySize = this.flowerArraySize / 2;
            Flower[] swapFlowerArray = new Flower[this.flowerArraySize];

            for (int i = 0; i < this.flowerArraySize; i++)
            {
                swapFlowerArray[i] = this.allFlowers[i];
            }

            this.allFlowers = swapFlowerArray;
        }
    }

    public void deleteFlower(int index)
    {
        if (index >= this.flowerArraySize || index < 0)
        {
            throw new IndexOutOfBoundsException("No such flower slot in bouquet");
        }

        this.bouquetPrice -= this.allFlowers[index].GetValueBasedPrice();
        this.allFlowers[index] = null;

        for (int i = index + 1; i < this.flowerArraySize; i++)
        {
            this.allFlowers[i - 1] = this.allFlowers[i];
        }

        this.lastFreeElementIndex--;
    }

    public Flower findFlowerInScopeOfStemLength(float minLength, float maxLength)
    {
        for (int i = 0; i < this.Length(); i++)
        {
            float currentFlowerStemLength = this.allFlowers[i].getFlowerSpec().getStemLength();
            if (currentFlowerStemLength > minLength && currentFlowerStemLength < maxLength)
            {
                return this.allFlowers[i];
            }
        }

        return null;
    }

    public void sortBouquetByValueBasedPrice()
    {
        Flower[] newArray = new Flower[this.lastFreeElementIndex];
        System.arraycopy(this.allFlowers, 0, newArray, 0, this.lastFreeElementIndex);
        MergeSort.SortMerge(newArray);
        System.arraycopy(newArray, 0, this.allFlowers, 0, this.lastFreeElementIndex);
    }

    public Flower[] search(FlowerSpec spec)
    {
        int[] flowerIndices = new int[this.lastFreeElementIndex];
        int flowerIndexCount = 0;
        for (int i = 0; i < this.lastFreeElementIndex; ++i)
        {
            if (this.allFlowers[i].getFlowerSpec().matches(spec))
            {
                flowerIndices[flowerIndexCount] = i;
                flowerIndexCount += 1;
            }
        }

        Flower[] newArray = new Flower[flowerIndexCount];
        for (int i = 0; i < flowerIndexCount; ++i)
        {
            newArray[i] = this.allFlowers[flowerIndices[i]];
        }
        return newArray;
    }

    public String toString()
    {
        return Arrays.toString(this.allFlowers);
    }

    public Bouquet()
    {
        this.lastFreeElementIndex = 0;
        this.flowerArraySize = 1;
        this.allFlowers = new Flower[this.flowerArraySize];
        this.bouquetPrice = 0;
    }

    public Bouquet(int size)
    {
        this.lastFreeElementIndex = 0;
        this.flowerArraySize = size;
        this.allFlowers = new Flower[this.flowerArraySize];
        this.bouquetPrice = 0;
    }

    public Bouquet(Flower startingFlower)
    {
        this.lastFreeElementIndex = 0;
        this.flowerArraySize = 1;
        this.allFlowers = new Flower[this.flowerArraySize];
        this.allFlowers[lastFreeElementIndex] = startingFlower;
        lastFreeElementIndex++;

        this.bouquetPrice = startingFlower.GetValueBasedPrice();
    }

    public Bouquet(int size, Flower startingFlower)
    {
        this.lastFreeElementIndex = 0;
        this.flowerArraySize = size;
        this.allFlowers = new Flower[this.flowerArraySize];
        this.allFlowers[lastFreeElementIndex] = startingFlower;
        this.lastFreeElementIndex++;

        this.bouquetPrice = startingFlower.GetValueBasedPrice();
    }

    public Bouquet(Flower[] readyFlowerArray)
    {
        this.lastFreeElementIndex = 0;
        this.flowerArraySize = readyFlowerArray.length;
        this.allFlowers = new Flower[this.flowerArraySize];

        this.bouquetPrice = 0;

        for (int i = 0; i < this.flowerArraySize; i++)
        {
            if (readyFlowerArray[i] != null)
            {
                this.allFlowers[this.lastFreeElementIndex] = readyFlowerArray[i];
                this.lastFreeElementIndex++;

                this.bouquetPrice += readyFlowerArray[i].GetValueBasedPrice();
            }
        }
    }

}
