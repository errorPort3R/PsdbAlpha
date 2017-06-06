package com.alphaprojects.aaronandporter.Psdbalpha.entities;

import java.util.ArrayList;

/**
 * Created by jeffryporter on 6/5/17.
 */
public class Division
{
    private String name;

    ArrayList<Integer> officeIndicies;

    public Division()
    {
    }

    public Division(String name, ArrayList<Integer> officeIndicies)
    {
        this.name = name;
        this.officeIndicies = officeIndicies;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public ArrayList<Integer> getOfficeIndicies()
    {
        return officeIndicies;
    }

    public void setOfficeIndicies(ArrayList<Integer> officeIndicies)
    {
        this.officeIndicies = officeIndicies;
    }
}
