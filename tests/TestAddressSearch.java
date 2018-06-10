import Addressbook.AddressBook;
import Addressbook.Entries.*;
import Addressbook.Commands.*;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestAddressSearch {

    ISearchCommands testAddressSearch;
    AddressBook addressBook;

    @Before
    public void setUp(){

        addressBook = new AddressBook();

    }

    @Test
    public void testSearchForEmptySearchTerm(){

        testAddressSearch = new AddressSearch("",addressBook);
        assertEquals(false, testAddressSearch.getMatches().isEmpty());
    }
    @Test
    public void testSearchForCapitalLetters(){

        ISearchCommands testAddressSearch1 = new AddressSearch("ECker",addressBook);
        assertEquals(false, testAddressSearch1.getMatches().isEmpty());
        assertEquals("Robert DeNiro", testAddressSearch1.getMatches().get(0).getName());
    }
    @Test
    public void testSearchForNumbers(){

        testAddressSearch = new AddressSearch("38116",addressBook);
        assertEquals(false, testAddressSearch.getMatches().isEmpty());
        assertEquals("Elvis Presley", testAddressSearch.getMatches().get(0).getName());
    }
    @Test
    public void testSearchWithSymbols(){

        testAddressSearch = new AddressSearch("%&çNND",addressBook);
        assertEquals(true, testAddressSearch.getMatches().isEmpty());
    }
}
