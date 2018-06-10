import Addressbook.AddressBook;
import Addressbook.AddressBook;
//import Addressbook.AddressBookEntries.Contacts;
import Addressbook.Commands.*;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class TestNameSearch {

    ISearchCommands testNameSearch;
    AddressBook addressBook;

    @Before
    public void setUp(){

        addressBook = new AddressBook();
    }

    @Test
    public void testSearchForEmptySearchTerm(){

        testNameSearch = new NameSearch("",addressBook);
        assertEquals(false, testNameSearch.getMatches().isEmpty());
    }
    @Test
    public void testSearchForSearchTermWithSpaces(){

        testNameSearch = new NameSearch("Elvis Presley",addressBook);
        assertEquals(false, testNameSearch.getMatches().isEmpty());
        assertTrue(testNameSearch.getMatches().get(0).getName().equals("Elvis Presley"));
    }

    @Test
    public void testSearchForCapitalLetters(){

        testNameSearch = new NameSearch("pREsl",addressBook);
        assertTrue(testNameSearch.getMatches().get(0).getName().equals("Elvis Presley"));
    }

}
