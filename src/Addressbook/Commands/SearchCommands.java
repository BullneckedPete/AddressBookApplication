package Addressbook.Commands;
import Addressbook.Entries.*;
import Addressbook.*;

import java.util.*;

public abstract class SearchCommands implements ISearchCommands {

    protected String searchTerm;
    protected List<IEntry> matches = new LinkedList<IEntry>();
    public AddressBook addressBook;


    public SearchCommands(String searchTerm, AddressBook addressBook) {

        this.searchTerm = searchTerm.toLowerCase();
        this.addressBook = addressBook;
        invariant();
    }
    private boolean invariant(){
        return this.addressBook != null;
    }

    public void search() {

    }

    public List<IEntry> getMatches() {

        return this.matches;

    }

    public void logicalAnd(){

    }



}
