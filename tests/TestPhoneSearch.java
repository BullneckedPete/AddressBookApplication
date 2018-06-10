import Addressbook.AddressBook;
import Addressbook.AddressBook;
//import Addressbook.AddressBookEntries.Contacts;
import Addressbook.Commands.*;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class TestPhoneSearch {

    ISearchCommands testPhoneSearch;
    AddressBook addressBook;

    @Before
    public void setUp(){

        addressBook = new AddressBook();
    }

    @Test
    public void testSearchForEmptySearchTerm(){

        testPhoneSearch = new PhoneSearch("",addressBook);
        assertEquals(false, testPhoneSearch.getMatches().isEmpty());
    }
    @Test
    public void testSearchFordoubleDigit(){

        testPhoneSearch = new PhoneSearch("11",addressBook);
        assertEquals(true, testPhoneSearch.getMatches().isEmpty());
        assertEquals(0, testPhoneSearch.getMatches().size());
    }

    @Test
    public void testSearchForWord(){

        testPhoneSearch = new PhoneSearch("elvis",addressBook);
        assertEquals(true, testPhoneSearch.getMatches().isEmpty());
        assertEquals(0, testPhoneSearch.getMatches().size());
    }




}