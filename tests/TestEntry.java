import Addressbook.AddressBook;
import Addressbook.Entries.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.util.LinkedList;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class TestEntry {


    public Entry testEntry;
    public AddressBook testAddressBook;

    public List<Group> testgroupList = new LinkedList<>();
    public Group group1;
    public Group group2;


    @Before
    public void setUp() {

        this.testEntry= new Contacts("Livia Künzi", "Moserstrasse 23", "123456789", "testmail@livia.com", "3,1,2");
        this.testAddressBook = new AddressBook();
    }
    @Before()
    public void setUpAddressBookListToMock(){

        //testaddressList.add(this.contact1 = new Contacts("Livia Künzi", "Moserstrasse 23", "123456789", "testmail@livia.com", "1"));
        //testaddressList.add(this.contact2 = new Contacts("Hans Müller", "strasse 23", "9876789876", "testmailhans@gmail.com", "2"));
        testgroupList.add(this.group1 = new Group("Tired", 1));
        testgroupList.add(this.group2 = new Group("Stupid", 2, "1"));


    }
    @Test
    public void TestParseSubGroupString(){

        testEntry.parseSubGroupsString();
        List<Integer> testGroupNumbers = new LinkedList<Integer>();
        testGroupNumbers = testEntry.getGroupNumberList();

        assertEquals((Integer)3,testGroupNumbers.get(0));
        assertEquals((Integer)1,testGroupNumbers.get(1));
        assertEquals((Integer)2,testGroupNumbers.get(2));

    }
    @Test
    public void TestParseSubGroupStringForEmptyString(){

        this.testEntry = new Contacts("Livia Künzi", "Moserstrasse 23", "123456789", "testmail@livia.com", "1");
        testEntry.parseSubGroupsString();
        List<Integer> testGroupNumbers = new LinkedList<Integer>();
        testGroupNumbers = testEntry.getGroupNumberList();
        assertEquals(false,testGroupNumbers.isEmpty());
    }
    @Test
    public void TestParseSubGroupStringForBiggerNumbers(){

        this.testEntry = new Contacts("Livia Künzi", "Moserstrasse 23", "123456789", "testmail@livia.com", "32,174,19,11998");
        testEntry.parseSubGroupsString();
        List<Integer> testGroupNumbers = new LinkedList<Integer>();
        testGroupNumbers = testEntry.getGroupNumberList();

        assertEquals((Integer)32,testGroupNumbers.get(0));
        assertEquals((Integer)174,testGroupNumbers.get(1));
        assertEquals((Integer)19,testGroupNumbers.get(2));
        assertEquals((Integer)11998,testGroupNumbers.get(3));
    }




}
