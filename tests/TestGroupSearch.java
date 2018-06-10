import Addressbook.AddressBook;
import Addressbook.AddressBook;
//import Addressbook.AddressBookEntries.Contacts;
import Addressbook.Commands.*;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestGroupSearch {

    ISearchCommands testGroupSearch;
    AddressBook addressBook;

    @Before
    public void setUp(){

        addressBook = new AddressBook();
    }

    @Test
    public void testSearchForEmptySearchTerm(){

        testGroupSearch = new GroupSearch("",addressBook);
        assertEquals(false, testGroupSearch.getMatches().isEmpty());
    }
    @Test
    public void testSearchForCapitalLetters(){

        testGroupSearch = new GroupSearch("aMoUS",addressBook);
        assertEquals(false, testGroupSearch.getMatches().isEmpty());
        assertTrue(testGroupSearch.getMatches().get(0).getGroupName().equals("Famous people"));
    }

    @Test
    public void testSearchForGroupNumber(){

        testGroupSearch = new GroupSearch("2",addressBook);
        assertEquals(true, testGroupSearch.getMatches().isEmpty());


    }

}