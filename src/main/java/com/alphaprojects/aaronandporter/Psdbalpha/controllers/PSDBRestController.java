package com.alphaprojects.aaronandporter.Psdbalpha.controllers;

import com.alphaprojects.aaronandporter.Psdbalpha.entities.Bill;
import com.alphaprojects.aaronandporter.Psdbalpha.entities.Politician;
import com.alphaprojects.aaronandporter.Psdbalpha.services.BillRepository;
import com.alphaprojects.aaronandporter.Psdbalpha.services.PoliticianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jeffryporter on 6/2/17.
 */

@RestController
public class PSDBRestController
{
    @Autowired
    PoliticianRepository politicians;

    @Autowired
    BillRepository bills;

    public static final String RAW_DATA_FILE_LOCATION = "rawFile.dat";
    public static final String SORTED_DATA_FILE_LOCATION = "builtData.dat";


    //***************************************************************************************
    //
    //               Politicians Routes
    //
    //***************************************************************************************
    @RequestMapping(path = "/politician", method = RequestMethod.GET)
    public Iterable<Politician> getPolitician(@PathVariable("region") String region, @PathVariable("level") Enum level)
    {
        return politicians.findPoliticianByLevelAndRegion(level, region);
    }

    @RequestMapping(path = "/politician", method = RequestMethod.POST)
    public Politician addPolitician(@RequestBody Politician politician)
    {
        politicians.save(politician);
        return politician;
    }

    @RequestMapping(path = "/politician", method = RequestMethod.PUT)
    public Politician editPolitician(@RequestBody Politician politician)
    {
        politicians.save(politician);
        return politician;
    }

    @RequestMapping(path = "/politician/{id}", method = RequestMethod.DELETE)
    public Politician deletePolitician(@PathVariable("id") int id)
    {
        Politician politician = politicians.findOne(id);
        politicians.delete(id);
        return politician;
    }

    @RequestMapping(path = "/politician/{id}", method = RequestMethod.GET)
    public Politician getPolitician(@PathVariable("id") int id)
    {
        return politicians.findOne(id);
    }



    //***************************************************************************************
    //
    //               Bills Routes
    //
    //***************************************************************************************
    @RequestMapping(path = "/bills", method = RequestMethod.GET)
    public Iterable<Bill> getBills(@PathVariable("region") String region, @PathVariable("level") Enum level)
    {
        return bills.findBillByLevelAndRegion(level, region);
    }

    @RequestMapping(path = "/bills", method = RequestMethod.POST)
    public Bill addBill(@RequestBody Bill bill)
    {
        bills.save(bill);
        return bill;
    }

    @RequestMapping(path = "/bills", method = RequestMethod.PUT)
    public Bill editBill(@RequestBody Bill bill)
    {
        bills.save(bill);
        return bill;
    }

    @RequestMapping(path = "/bill/{id}", method = RequestMethod.DELETE)
    public Bill deleteBill(@PathVariable("id") int id)
    {
        Bill bill = bills.findOne(id);
        bills.delete(id);
        return bill;
    }

    @RequestMapping(path = "/bill/{id}", method = RequestMethod.GET)
    public Bill getBill(@PathVariable("id") int id)
    {
        return bills.findOne(id);
    }
}
