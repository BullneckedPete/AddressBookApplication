package Addressbook.Commands;

import Addressbook.Entries.*;
import Addressbook.*;

import java.util.*;

/**
 * Searches in all the addressBookEntries for a match based on the keyword
 * 'any'.
 */

public class AnySearch extends SearchCommands{

    private List<IEntry> matches = new LinkedList<IEntry>();

    public AnySearch(String searchTerm, AddressBook addressBook){
        super(searchTerm, addressBook);
        search();
    }

    @Override
    public void search() {
        for (IEntry e : (addressBook.getAddressBookEntries())) {
            if (containSearchTerm(e) ){
                    matches.add(e);
            }
        }
    }
    
    @Override
    public List<IEntry> getMatches() {
        return matches;
    }


    private boolean containSearchTerm(IEntry e) {
    	return (e.getAddress().toLowerCase().contains(searchTerm)||
                	e.getName().toLowerCase().contains(searchTerm)||
                		e.getPhoneNumber().contains(searchTerm)||
                			e.getEmail().toLowerCase().contains(searchTerm)||
                				e.getGroupName().toLowerCase().contains(searchTerm));
    }

}
