package Addressbook.Commands;

import Addressbook.Entries.*;
import Addressbook.*;

import java.util.*;

/**
 * Searches in all the addressBookEntries for a match based on the keyword
 * 'phone'.
 */
public class PhoneSearch extends SearchCommands {

    private List<IEntry> matches = new LinkedList<IEntry>();

    public PhoneSearch(String searchTerm, AddressBook addressBook) {
        super(searchTerm, addressBook);
        search();
    }

    @Override
    public void search() {
        for (IEntry e : (addressBook.getAddressBookEntries())) {
            if (e.getPhoneNumber().contains(searchTerm)) {
                this.matches.add(e);
            }
        }
    }

    @Override
    public List<IEntry> getMatches() {

        return this.matches;

    }
}
