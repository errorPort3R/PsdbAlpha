package com.alphaprojects.aaronandporter.Psdbalpha.entities;

/**
 * Created by jeffryporter on 6/5/17.
 */
public class Channel
{
    private String type;

    private String ID;

    public Channel()
    {
    }

    public Channel(String type, String ID)
    {
        this.type = type;
        this.ID = ID;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getID()
    {
        return ID;
    }

    public void setID(String ID)
    {
        this.ID = ID;
    }
}
