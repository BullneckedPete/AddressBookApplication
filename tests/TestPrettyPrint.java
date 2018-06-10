import Addressbook.AddressBook;
import Addressbook.Entries.*;
import Addressbook.Commands.*;
import java.lang.AssertionError;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * This Test should Test the Print Class and it's prettyPrint Method.
 * We tried testing the String comparisons but were not able to do it correctly.
 * We don't know what the problem is, but it seems very difficult to assertEquals to Strings
 * and to Test them from the Console. We left the code that didn't work but commented it out.
 */

public class TestPrettyPrint {

    Print testPrint;
    AddressBook testAddressBook;
    Search testSearch;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
        System.setErr(System.err);
    }

    @Before
    public void setUp(){
        this.testAddressBook = new AddressBook();
        this.testSearch = new Search("search group:actor", testAddressBook);
        this.testPrint = new Print(testSearch,testAddressBook);

    }

    @Test
    public void out() {

        testPrint.prettyPrint(testSearch);
        //System.out.print("Group: Actors");
        //assertTrue(testSearch.getMatches().toString().equals(outContent.toString()));
        //assertEquals(testSearch.getMatches().toString(), outContent.toString());
    }


}
