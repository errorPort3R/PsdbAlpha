****************************** VARIABLES ********************************

Amendment
{
    int id;

    String title;

    String body;

    String synopsis;

    ArrayList<String> creators;
}

Bill
{
    public enum Level
    {
        FEDERAL,
        STATE,
        LOCAL
    }

    int id;

    String referenceNumber;

    String name;

    Date dateSubmitted;

    Date dateUpForVote;

    ArrayList<String> creators;

    String body;

    String synopsis;

    String region;

    Level level;

    ArrayList<Amendment> amendments;
}

Politician
{
    public enum Level
    {
        FEDERAL,
        STATE,
        LOCAL
    }

    int id;

    String name;

    String profilePictureLocation;

    String partyAffiliation;

    boolean currentlyHoldingOffice;

    String position;

    ArrayList<String> previousPositions;

    int age;

    int yearsInPolitics;

    HashMap<String, Boolean> votingRecord;

    String region;

    Level level;
}

PollQuestion
{
    int id;

    String question;

    int inFavor;

    int against;

    HashMap<String, Integer> forByState;

    HashMap<String, Integer> againstByState;

    HashMap<String, Integer> forByLocal;

    HashMap<String, Integer> againstByLocal;
}

User
{
    int id;

    String username;

    String password;

    Address address;

    String facebookId;

    HashMap<Integer, Boolean> pollingAnswers;
}


******************************** ROUTES *********************************


    //***************************************************************************************
    //
    //               Politicians Routes
    //
    //***************************************************************************************

    path = ROOT_URL/politicians      GET
        Takes a Level and Region.
        Returns all Politician that meet the Region and Level.

    path = ROOT_URL/politicians      SAVE(POST)
        Takes a Politician(without ID).
        Saves new Politician in the database.
        Returns Politician.

    path = ROOT_URL/politicians      SAVE(PUT)
        Takes a Politician(with ID).
        Edits Politician in the database.
        Returns Politician.

    path = ROOT_URL/politician/{id}  DELETE
        Takes an integer ID of a Politician.
        Deletes a specific Politician.

    path = ROOT_URL/politician/{id}  GET
        Takes an integer ID of a Politician.
        Returns a specific Politician.



    //***************************************************************************************
    //
    //               Bills Routes
    //
    //***************************************************************************************

    path = ROOT_URL/bills      GET
        Takes a Level and Region.
        Returns all Bills that meet the Region and Level.

    path = ROOT_URL/bills      SAVE(POST)
        Takes a Bill(without ID).
        Saves new Bill in the database.
        Returns Bill.

    path = ROOT_URL/bills      SAVE(PUT)
        Takes a Bill(with ID).
        Edits Bill in the database.
        Returns Bill.

    path = ROOT_URL/bill/{id}  DELETE
        Takes an integer ID of a Bill
        Deletes a specific Bill.

    path = ROOT_URL/bill/{id}  GET
        Takes an integer ID of a Bill
        Returns a specific Bill.







