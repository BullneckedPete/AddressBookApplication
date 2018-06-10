package Addressbook.Commands;

import Addressbook.AddressBook;
import Addressbook.Entries.*;

import java.util.*;

public interface ISearchCommands {


    public List<IEntry> getMatches();

    void search();

    public void logicalAnd();
}
