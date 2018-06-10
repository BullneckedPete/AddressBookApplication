import Addressbook.AddressBook;
//import Addressbook.AddressBookEntries.Contacts;
import Addressbook.Entries.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestGroup {

    public Group testgroup;
    public AddressBook testAddressBook;
    public IEntry testContact;
    public IEntry testContact2;
    public IEntry testSubGroup;


    @Before
    public void setUp() {

        this.testgroup = new Group("Best People", 1, "2,3");
    }

    @Test
    public void makeGroupWithNoName(){


        this.testgroup = new Group("", 1, "");
        assertEquals(false,testgroup.invariant2());

    }
    @Test
    public void testAddMultipleMembers(){

        testContact = new Contacts("Livia Künzi", "Moserstrasse 23", "123456789", "testmail@livia.com", "3,1,2");
        testContact2 = new Contacts("Jonas Schwery", "strasse 2", "123456789", "testmail@gmail.com", "1");
        testSubGroup = new Group("People", 2, "1");

        testgroup.addMember(testContact);
        testgroup.addMember(testContact2);
        testgroup.addMember(testSubGroup);

        assertEquals(testContact, testgroup.getGroupMembers().get(0));
        assertEquals(testContact2, testgroup.getGroupMembers().get(1));
        assertEquals(testSubGroup, testgroup.getGroupMembers().get(2));
    }


}