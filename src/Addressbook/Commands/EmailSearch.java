package Addressbook.Commands;

import Addressbook.Entries.*;
import Addressbook.*;

/**
 * Searches in all the addressBookEntries for a match based on the keyword
 * 'email'.
 */
import java.util.*;

public class EmailSearch extends SearchCommands {

    private List<IEntry> matches = new LinkedList<IEntry>();

    public EmailSearch(String searchTerm, AddressBook addressBook){

        super(searchTerm, addressBook);
        search();
    }

    @Override
    public void search() {

        for (IEntry e : (addressBook.getAddressBookEntries())) {
            if (e.getEmail().toLowerCase().contains(searchTerm)) {
                matches.add(e);
            }
        }
    }

    @Override
    public List<IEntry> getMatches() {

        return matches;

    }


}
