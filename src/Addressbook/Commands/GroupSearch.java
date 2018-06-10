package Addressbook.Commands;

import Addressbook.Entries.*;
import Addressbook.*;

import java.util.*;

/**
 * Searches in all the addressBookEntries for a match based on the keyword
 * 'group'.
 */
public class GroupSearch extends SearchCommands {

    private List<IEntry> matches = new LinkedList<IEntry>();

    public GroupSearch(String searchTerm, AddressBook addressBook){
        super(searchTerm, addressBook);
        search();
    }

    @Override
    public void search() {
        for (IEntry e : (addressBook.getAddressBookEntries())) {
            if (e.getGroupName().toLowerCase().contains(searchTerm)) {
                matches.add(e);
            }
        }
    }

    @Override
    public List<IEntry> getMatches() {
        return matches;
    }
}
