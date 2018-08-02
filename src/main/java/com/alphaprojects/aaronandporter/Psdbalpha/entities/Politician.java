package com.alphaprojects.aaronandporter.Psdbalpha.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jeffryporter on 6/5/17.
 */
public class Politician
{
    public enum Level
    {
        FEDERAL,
        STATE,
        LOCAL
    }

    //declare variables
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String profilePictureLocation;

    @Column(nullable = false)
    private String partyAffiliation;

    @Column(nullable = false)
    private boolean currentlyHoldingOffice;

    @Column(nullable = false)
    private String position;

    @Column(nullable = true)
    private ArrayList<String> previousPositions;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private int yearsInPolitics;

    @Column(nullable = true)
    private String biography;

    @Column(nullable = true)
    private String criminalHistory;

    @Column(nullable = false)
    private HashMap<String, Boolean> votingRecord;

    @Column(nullable = false)
    private String region;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Level level;

    public Politician()
    {
    }

    public Politician(int id, String name, String profilePictureLocation, String partyAffiliation, boolean currentlyHoldingOffice, String position, ArrayList<String> previousPositions, int age, int yearsInPolitics, String region, Level level)
    {
        this.id = id;
        this.name = name;
        this.profilePictureLocation = profilePictureLocation;
        this.partyAffiliation = partyAffiliation;
        this.currentlyHoldingOffice = currentlyHoldingOffice;
        this.position = position;
        this.previousPositions = previousPositions;
        this.age = age;
        this.yearsInPolitics = yearsInPolitics;
        this.region = region;
        this.level = level;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getProfilePictureLocation()
    {
        return profilePictureLocation;
    }

    public void setProfilePictureLocation(String profilePictureLocation)
    {
        this.profilePictureLocation = profilePictureLocation;
    }

    public String getPartyAffiliation()
    {
        return partyAffiliation;
    }

    public void setPartyAffiliation(String partyAffiliation)
    {
        this.partyAffiliation = partyAffiliation;
    }

    public boolean isCurrentlyHoldingOffice()
    {
        return currentlyHoldingOffice;
    }

    public void setCurrentlyHoldingOffice(boolean currentlyHoldingOffice)
    {
        this.currentlyHoldingOffice = currentlyHoldingOffice;
    }

    public String getPosition()
    {
        return position;
    }

    public void setPosition(String position)
    {
        this.position = position;
    }

    public ArrayList<String> getPreviousPositions()
    {
        return previousPositions;
    }

    public void setPreviousPositions(ArrayList<String> previousPositions)
    {
        this.previousPositions = previousPositions;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public int getYearsInPolitics()
    {
        return yearsInPolitics;
    }

    public void setYearsInPolitics(int yearsInPolitics)
    {
        this.yearsInPolitics = yearsInPolitics;
    }

    public String getBiography()
    {
        return biography;
    }

    public void setBiography(String biography)
    {
        this.biography = biography;
    }

    public String getCriminalHistory()
    {
        return criminalHistory;
    }

    public void setCriminalHistory(String criminalHistory)
    {
        this.criminalHistory = criminalHistory;
    }

    public HashMap<String, Boolean> getVotingRecord()
    {
        return votingRecord;
    }

    public void setVotingRecord(HashMap<String, Boolean> votingRecord)
    {
        this.votingRecord = votingRecord;
    }

    public String getRegion()
    {
        return region;
    }

    public void setRegion(String region)
    {
        this.region = region;
    }

    public Level getLevel()
    {
        return level;
    }

    public void setLevel(Level level)
    {
        this.level = level;
    }
}
