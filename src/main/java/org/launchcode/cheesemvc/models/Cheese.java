package org.launchcode.cheesemvc.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Cheese {

    @NotNull
    @Size(min=3, max=15, message="Name must not be empty.")
    private String cheeseName;

    @NotNull
    @Size(min=1, message="Description must not be empty.")
    private String cheeseDesc;

    private CheeseType cheeseType;

    @NotNull
    @Max(value=5, message="The maximum rating you can enter is 5.")
    @Min(value=1, message="The minimum rating you can enter is 1.")
    private int cheeseRating;

    private int cheeseID;
    private static int nextID = 1;

    public Cheese (String cheeseName, String cheeseDesc, CheeseType cheeseType, int cheeseRating) {
        this();
        setCheeseName(cheeseName);
        setCheeseDesc(cheeseDesc);
        setCheeseType(cheeseType);
        setCheeseRating(cheeseRating);
    }

    public Cheese () {
        cheeseID = nextID;
        nextID++;
    }

    public int getCheeseID() {
        return cheeseID;
    }

    public void setCheeseID(int cheeseID) {
        this.cheeseID = cheeseID;
    }

    public String getCheeseName() {
        return cheeseName;
    }

    public void setCheeseName(String givenCheeseName) {
        cheeseName = givenCheeseName;
    }

    public String getCheeseDesc() {
        return cheeseDesc;
    }

    public void setCheeseDesc(String givenCheeseDesc) {
        cheeseDesc = givenCheeseDesc;
    }

    public CheeseType getCheeseType() {
        return cheeseType;
    }

    public void setCheeseType(CheeseType cheeseType) {
        this.cheeseType = cheeseType;
    }

    public int getCheeseRating() {
        return cheeseRating;
    }

    public void setCheeseRating(int cheeseRating) {
        this.cheeseRating = cheeseRating;
    }
}
