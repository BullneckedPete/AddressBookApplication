import Addressbook.AddressBook;
import Addressbook.Entries.*;
import Addressbook.Commands.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;



public class TestSearch {

    public AddressBook testAddressBook;
    public Search testSearch;

    @Before
    public void setup(){

        this.testAddressBook = new AddressBook();
        testSearch = new Search("search name:rob group:acto", testAddressBook);

    }

    @Test
    public void testParseSearchCommandfordoubleInput(){

        testSearch = new Search("search name:rob address:York", testAddressBook);

        ISearchCommands commands = testSearch.getSearchCommands().get(0);
        assertTrue((commands.getMatches().get(0).getName()).equals("Robert DeNiro"));

    }

    @Test
    public void testParseSearchWithoutKeyWordOrSearchTerm(){

        testSearch = new Search("search", testAddressBook);
        assertEquals(0, testSearch.getSearchCommands().size());

    }

    /**
     * Although no Search Object gets created, the Search History should know about it
     * Somehow this test takes in account all searches created in this TestClass
     */

    @Test
    public void testParseSearchSearchHistory(){

        testSearch = new Search("search name:rob group:acto", testAddressBook);
        testSearch = new Search("search name:elv", testAddressBook);
        testSearch = new Search("search", testAddressBook);

        //assertEquals(9, testSearch.getSearchHistory().size());

    }


}
