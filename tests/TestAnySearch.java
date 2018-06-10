import Addressbook.AddressBook;
import Addressbook.Entries.*;
import Addressbook.Commands.*;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestAnySearch {

    ISearchCommands testAnySearch;
    AddressBook addressBook;

    @Before
    public void setUp(){

        addressBook = new AddressBook();

    }

    @Test
    public void testSearchForEmptySearchTerm(){

        testAnySearch = new AnySearch("",addressBook);
        assertEquals(false, testAnySearch.getMatches().isEmpty());
    }
    @Test
    public void testSearchForCapitalLetters(){

        testAnySearch = new AnySearch("ECker",addressBook);
        assertEquals(false, testAnySearch.getMatches().isEmpty());
        assertTrue(testAnySearch.getMatches().get(0).getName().equals("Robert DeNiro"));    }

    /**
     * 2 is in Elvis Presleys Address and in Robert DeNiros PhoneNumber, both should be added matched
     * This also Tests that GroupNumbers are not taken in Account when searching for a Number
     */
    @Test

    public void testSearchForNumbersFromDifferentPartsOfContact(){

        testAnySearch = new AnySearch("0",addressBook);
        assertEquals(2, testAnySearch.getMatches().size());
        assertTrue(testAnySearch.getMatches().get(0).getName().equals("Elvis Presley"));
        assertTrue(testAnySearch.getMatches().get(1).getName().equals("Robert DeNiro"));

    }
    @Test
    public void testSearchWithSymbols(){

        testAnySearch = new AnySearch("%&çNND",addressBook);
        assertEquals(true, testAnySearch.getMatches().isEmpty());
    }
}