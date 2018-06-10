import Addressbook.AddressBook;
import Addressbook.Entries.*;
import Addressbook.Commands.*;
import Addressbook.AddressFileReader;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestAddressFileReader {

    AddressFileReader testAddressFileReader;

    @Before
    public void setUp(){
        this.testAddressFileReader = new AddressFileReader();
    }

}
