package com.alphaprojects.aaronandporter.Psdbalpha.entities;

import javax.persistence.*;
import java.util.HashMap;

/**
 * Created by jeffryporter on 6/8/17.
 */

@Entity
@Table(name = "polls")
public class PollQuestion
{
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String question;

    @Column(nullable = false)
    private int inFavor;

    @Column(nullable = false)
    private int against;

    @Column(nullable = false)
    private HashMap<String, Integer> forByState;

    @Column(nullable = false)
    private HashMap<String, Integer> againstByState;

    @Column(nullable = false)
    private HashMap<String, Integer> forByLocal;

    @Column(nullable = false)
    private HashMap<String, Integer> againstByLocal;

    public PollQuestion()
    {
    }

    public PollQuestion(String question, int inFavor, int against, HashMap<String, Integer> forByState, HashMap<String, Integer> againstByState, HashMap<String, Integer> forByLocal, HashMap<String, Integer> againstByLocal)
    {
        this.question = question;
        this.inFavor = inFavor;
        this.against = against;
        this.forByState = forByState;
        this.againstByState = againstByState;
        this.forByLocal = forByLocal;
        this.againstByLocal = againstByLocal;
    }

    public PollQuestion(int id, String question, int inFavor, int against, HashMap<String, Integer> forByState, HashMap<String, Integer> againstByState, HashMap<String, Integer> forByLocal, HashMap<String, Integer> againstByLocal)
    {
        this.id = id;
        this.question = question;
        this.inFavor = inFavor;
        this.against = against;
        this.forByState = forByState;
        this.againstByState = againstByState;
        this.forByLocal = forByLocal;
        this.againstByLocal = againstByLocal;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getQuestion()
    {
        return question;
    }

    public void setQuestion(String question)
    {
        this.question = question;
    }

    public int getInFavor()
    {
        return inFavor;
    }

    public void setInFavor(int inFavor)
    {
        this.inFavor = inFavor;
    }

    public int getAgainst()
    {
        return against;
    }

    public void setAgainst(int against)
    {
        this.against = against;
    }

    public HashMap<String, Integer> getForByState()
    {
        return forByState;
    }

    public void setForByState(HashMap<String, Integer> forByState)
    {
        this.forByState = forByState;
    }

    public HashMap<String, Integer> getAgainstByState()
    {
        return againstByState;
    }

    public void setAgainstByState(HashMap<String, Integer> againstByState)
    {
        this.againstByState = againstByState;
    }

    public HashMap<String, Integer> getForByLocal()
    {
        return forByLocal;
    }

    public void setForByLocal(HashMap<String, Integer> forByLocal)
    {
        this.forByLocal = forByLocal;
    }

    public HashMap<String, Integer> getAgainstByLocal()
    {
        return againstByLocal;
    }

    public void setAgainstByLocal(HashMap<String, Integer> againstByLocal)
    {
        this.againstByLocal = againstByLocal;
    }
}
