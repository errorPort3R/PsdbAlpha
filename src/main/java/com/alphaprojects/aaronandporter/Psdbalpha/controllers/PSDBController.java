package com.alphaprojects.aaronandporter.Psdbalpha.controllers;

import com.alphaprojects.aaronandporter.Psdbalpha.entities.*;
import com.alphaprojects.aaronandporter.Psdbalpha.services.BillRepository;
import com.alphaprojects.aaronandporter.Psdbalpha.services.PoliticianRepository;
import com.alphaprojects.aaronandporter.Psdbalpha.services.UserRepository;
import com.alphaprojects.aaronandporter.Psdbalpha.utilities.PasswordStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by jeffryporter on 6/2/17.
 */
@Controller
public class PSDBController
{
    @Autowired
    BillRepository bills;

    @Autowired
    PoliticianRepository politicians;

    @Autowired
    UserRepository users;

    //***************************************************************************************
    //
    //                  BILL ROUTES
    //
    //***************************************************************************************

    //creates a bill and saves it to the database
    @RequestMapping(path = "/bill-create", method = RequestMethod.POST)
    public String updateBill(String referenceNumber, String name, Date dateSubmitted, Date dateUpForVote, ArrayList<String> creators, String body, String synopsis, String region, Bill.Level level, ArrayList<Amendment> amendments)
    {
        Bill bill = new Bill(referenceNumber, name, dateSubmitted, dateUpForVote, creators, body, synopsis, region, level, amendments);
        bills.save(bill);
        return "redirect:/user-profile";
    }

    //shows a particular bill by id
    @RequestMapping(path = "/bill-read", method = RequestMethod.GET)
    public Bill getBill(int id)
    {
        Bill bill = bills.findOne(id);
        return bill;
    }

    //shows all bills
    @RequestMapping(path = "/bill-read", method = RequestMethod.GET)
    public Iterable<Bill> getBill()
    {
        Iterable<Bill> billList = bills.findAll();
        return billList;
    }

    //updates a bill
    @RequestMapping(path = "/bill-update", method = RequestMethod.POST)
    public String updateBill(int id, String referenceNumber, String name, Date dateSubmitted, Date dateUpForVote, ArrayList<String> creators, String body, String synopsis, String region, Bill.Level level, ArrayList<Amendment> amendments)
    {
        Bill bill = new Bill(id, referenceNumber, name, dateSubmitted, dateUpForVote, creators, body, synopsis, region, level, amendments);
        bill.setId(id);
        bills.save(bill);
        return"";
    }

    //"deletes" a bill.  bill is kept in database, but is not visible anymore.
    @RequestMapping(path = "/bill-delete", method = RequestMethod.POST)
    public String deleteBill (int id, HttpServletRequest request)
    {
        bills.delete(id);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    //***************************************************************************************
    //
    //                  POLITICIAN ROUTES
    //
    //***************************************************************************************

    //creates a politician and saves it to the database
    @RequestMapping(path = "/politician-create", method = RequestMethod.POST)
    public String createPolitician(String name, String profilePictureLocation, String partyAffiliation, boolean currentlyHoldingOffice, String position, ArrayList<String> previousPositions, int age, int yearsInPolitics, HashMap<String, Boolean> votingRecord,  String region, Politician.Level level)
    {
        Politician politician = new Politician(name, profilePictureLocation, partyAffiliation, currentlyHoldingOffice, position, previousPositions, age, yearsInPolitics, votingRecord, region, level);
        politicians.save(politician);
        return "";
    }

    //shows a particular politician by id
    @RequestMapping(path = "/politician-read", method = RequestMethod.GET)
    public Politician getPolitician(int id)
    {
        Politician politician = politicians.findOne(id);
        return politician;
    }

    //shows all politician
    @RequestMapping(path = "/politician-read", method = RequestMethod.GET)
    public Iterable<Politician> getPolitician()
    {
        Iterable<Politician> politicianList = politicians.findAll();
        return politicianList;
    }

    //updates a politician
    @RequestMapping(path = "/politician-update", method = RequestMethod.POST)
    public String updatePolitician(int id, String name, String profilePictureLocation, String partyAffiliation, boolean currentlyHoldingOffice, String position, ArrayList<String> previousPositions, int age, int yearsInPolitics, HashMap<String, Boolean> votingRecord, String region, Politician.Level level)
    {
        Politician politician = new Politician(name, profilePictureLocation, partyAffiliation, currentlyHoldingOffice, position, previousPositions, age, yearsInPolitics, votingRecord, region, level);
        politician.setId(id);
        politicians.save(politician);
        return"";
    }

    //"deletes"  a politician.  item is kept in database, but is not visible anymore.
    @RequestMapping(path = "/politician-delete", method = RequestMethod.POST)
    public String deletePolitician (int id, HttpServletRequest request)
    {
        politicians.delete(id);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    //***************************************************************************************
    //
    //             USER ROUTES
    //
    //***************************************************************************************

    //action for account creation page
    //checks that entered username is not already taken and creates account if it's valid
    @RequestMapping(path = "/account-create", method = RequestMethod.POST)
    public String createAccount(HttpSession session, String username, String password, Address address, String facebookId) throws PasswordStorage.CannotPerformOperationException
    {
        User user = users.findByUsername(username);
        if (user != null) {
            System.err.printf("User Already Exists!");
            return "redirect:/";
        }
        else {
            HashMap<Integer, Boolean> pollingAnswers = null;
            user = new User(username, PasswordStorage.createHash(password), address, facebookId, pollingAnswers);
            users.save(user);
            session.setAttribute("username", username);
            return "redirect:/";
        }
    }

    //allows you to change your username.  not implemented as yet.
    @RequestMapping(path = "/account-update", method = RequestMethod.POST)
    public String editAccount(HttpSession session, String password, String newUsername, String newPassword) throws Exception {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            throw new Exception("Not logged in.");
        }
        User user = users.findByUsername(username);
        if (!PasswordStorage.verifyPassword(password, user.getPassword())) {
            throw new Exception("Wrong password.");
        }
        user.setUsername(newUsername);
        user.setPassword(PasswordStorage.createHash(newPassword));
        users.save(user);
        return "redirect:/user-profile";
    }

    //deletes a user account and all affiliated items/messages.  not implemented yet.
    @RequestMapping(path = "/account-delete", method = RequestMethod.POST)
    public String deleteAccount(HttpSession session) throws Exception {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            throw new Exception("Not logged in.");
        }
        User user = users.findByUsername(username);
        //delete associated objects here

        //delete user
        users.delete(user.getId());
        return "redirect:/";
    }

    //Login route that keeps you on the same page you're on.
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String username, String password, HttpServletRequest request) throws Exception {
        User userFromDB = users.findByUsername(username);
        if (userFromDB == null)
        {
            return "redirect:/account-create";
        }
        else if (!PasswordStorage.verifyPassword(password, userFromDB.getPassword()))
        {
            throw new Exception("Wrong password.");
        }
        session.setAttribute("username", username);

        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    //logout route sends you back to home
    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }



}
