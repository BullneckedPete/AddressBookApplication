package Addressbook;

import Addressbook.Entries.*;
import java.util.*;

/**
 * Represents the AddressBook with his Entries which can be of type
 * Contact or of type Group and establishes a connection between the 
 * if the group matches.
 */

public class AddressBook {

    private AddressFileReader fileReader;
    private List<IEntry> addressBookEntries = new LinkedList<>();
    private List<Contacts> contactList = new LinkedList<>();
    private List<Group> groupList = new LinkedList<>();

    public AddressBook() {
        this.fileReader = new AddressFileReader();
        makeAddressBook();
        connectEntries();
        invariant();
    }
    
    private boolean invariant() {
    	return this.fileReader != null;
    }

    /**
     * Creates the addressBook that is read by the file and creates two lists 
     * out of it depending if the entry is of type Contact or of type Group.
     */
    private void makeAddressBook(){
        addressBookEntries = (fileReader.getAddressBookEntries());
        for(IEntry e: addressBookEntries){
            if(e.isContact()){
                contactList.add((Contacts) e);
            } else {
                groupList.add((Group) e);
            }
        }
    }
    
    /**
     * Connects Entries depending which have something in common (e.g. group).
     */
    private void connectEntries(){
        for(IEntry e: getAddressBookEntries()){
            e.parseSubGroupsString();
            e.connect(this);
        }
    }

    public List<Group> getGroupList(){
        return this.groupList;
    }

    public List<IEntry> getAddressBookEntries(){
        return addressBookEntries;
    }

}
