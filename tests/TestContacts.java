import Addressbook.AddressBook;
//import Addressbook.AddressBookEntries.Contacts;
import Addressbook.Entries.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestContacts {

    public Contacts contact;
    public AddressBook testAddressBook;


    @Before
    public void setUp() {

        this.contact = new Contacts("Livia Künzi", "Moserstrasse 23", "123456789", "testmail@livia.com", "3,1,2");
        this.testAddressBook = new AddressBook();
    }

    @Test
    public void makeContactWithLittleInfos(){


        this.contact = new Contacts("Livi", "", "", "", "");
        assertEquals(false, this.contact == null);
        assertEquals("Livi", contact.getName());
        assertEquals(true, contact.getAddress().isEmpty());
    }


}
