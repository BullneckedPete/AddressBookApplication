package Addressbook.Commands;

import Addressbook.Entries.*;

import java.util.LinkedList;
import java.util.List;

import Addressbook.*;

/**
 * Print the entries that the user searches via the command line
 * in a pretty listing.
 */
public class Print {

    private Search search;
    private AddressBook addressbook;

    public Print(Search search, AddressBook addressBook){
        this.search = search;
        this.addressbook = addressBook;
        prettyPrint(this.search);
        invariant();
    }
    
    private boolean invariant() {
    	return this.search != null &&
    				this.addressbook != null;
    }

    /**
     * Gets the matches via the search class and prints them in the command line.
     */
    public void prettyPrint(Search search){
    	assert search != null;
        if(search == null || search.getSearchCommands().isEmpty()) {
            for (IEntry e : addressbook.getAddressBookEntries()) {
                System.out.println(e);
            }
        } else {
        	if (search.getMatches().isEmpty()) {
        		System.out.println("No matches found. Please, try again!");
        	} else {
        		List<IEntry> matchesPrinted = new LinkedList<>();
        		for(IEntry e: (search.getMatches())) {
        			if (!matchesPrinted.contains(e)) {
        			matchesPrinted.add(e);
        				System.out.println(e);
        			}
        		}
        	}
        }
    }
}
