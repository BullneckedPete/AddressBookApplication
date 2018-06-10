import Addressbook.AddressBook;
//import Addressbook.AddressBookEntries.Contacts;
import Addressbook.Entries.*;
import Addressbook.Commands.*;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class TestEmailSearch {

    ISearchCommands testEmailSearch;
    AddressBook addressBook;

    @Before
    public void setUp(){

        addressBook = new AddressBook();

    }

    @Test
    public void testSearchForEmptySearchTerm(){

        testEmailSearch = new EmailSearch("",addressBook);
        assertEquals(false, testEmailSearch.getMatches().isEmpty());
    }
    @Test
    public void testSearchForCapitalLetters(){

        testEmailSearch = new EmailSearch("lVis",addressBook);
        assertEquals(false, testEmailSearch.getMatches().isEmpty());
        assertEquals("Elvis Presley", testEmailSearch.getMatches().get(0).getName());
    }

    @Test
    public void testSearchForDotCom(){

        testEmailSearch = new EmailSearch(".com",addressBook);
        assertEquals(2, testEmailSearch.getMatches().size());
        assertEquals("Elvis Presley", testEmailSearch.getMatches().get(0).getName());
        assertEquals("Robert DeNiro", testEmailSearch.getMatches().get(1).getName());
    }

    @Test
    public void testSearchWithAtSymbol(){

        testEmailSearch = new EmailSearch("@",addressBook);
        assertEquals(2, testEmailSearch.getMatches().size());
    }
}