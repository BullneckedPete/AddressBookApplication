package Addressbook.Commands;

import Addressbook.Entries.*;
import Addressbook.*;

import java.util.LinkedList;
import java.util.List;

/**
 * This class handles all the Search Commands, stores the matches in a List.
 */

public class Search {

    private static List<IEntry> searchHistory = new LinkedList<IEntry>();
    private List<IEntry> matches = new LinkedList<IEntry>();
    private LinkedList<ISearchCommands> searchCommands = new LinkedList<>();
    protected List<IEntry> tempMatches = new LinkedList<IEntry>();
    public AddressBook addressBook;

    public Search(String input, AddressBook addressbook){
        this.addressBook = addressbook;
        fillTempMatches();
        parseSearchCommand(input);
        invariant();
    }

    private boolean invariant(){
       return this.addressBook != null &&
                  this.tempMatches != null;
    }
    
    /**
     * Parses the search command depending on the number of key
     * words the user typed in after search. If a keyword matches, 
     * a new object of that keyword is created.
     * @param input from the user, must have length > 0
     */
    private void parseSearchCommand(String input){
    	assert input.length() > 0;
        input = input.replace(": ",":").toLowerCase();
        String[] parsedInput = input.split(" ");

        for(int i = 0; i < parsedInput.length; i ++){
            if(parsedInput[0].equals("search") && parsedInput.length == 1){
                fillMatches();
            }
            if(parsedInput[i].contains(":")){
                String[] command = parsedInput[i].split(":");
                String keyWord = command[0].toLowerCase().trim();
                String searchTerm = command[1].trim();
                createSearchCommand(keyWord, searchTerm);
                if (!searchCommands.isEmpty()) {
                	logicalAndOnSearch(searchCommands.getLast());
                }
            }
        }
        addToSearchHistory();
    }
    
    /**
     * Fills in a list of the temporary matches from the search of the user.
     * No matching entries based on e.g later keywords will be removed later.
     */
    private void fillTempMatches(){
       for(IEntry a: (this.addressBook.getAddressBookEntries())){
           this.tempMatches.add(a);
        }

    }
    
    /**
     * Created new Search Objects based on the keyword the methods above
     * extract out of the input from the user. (-->Is only public becuase of Tests
     */
    public void createSearchCommand(String keyWord, String searchTerm){
    	    assert keyWord.length() > 0;
    		assert searchTerm.length() > 0;
    		if(keyWord.equals("name")){
    			ISearchCommands searchcommand = new NameSearch(searchTerm, this.addressBook);
                searchCommands.add(searchcommand);
    		}
    		
    		if(keyWord.equals("address")){
    			ISearchCommands searchcommand = new AddressSearch(searchTerm, addressBook);
                searchCommands.add(searchcommand);
    		}
    		
    		if(keyWord.equals("email")){
    			ISearchCommands searchcommand = new EmailSearch(searchTerm, addressBook);
                searchCommands.add(searchcommand);
    		}
        
    		if(keyWord.equals("phone")){
    			ISearchCommands searchcommand = new PhoneSearch(searchTerm, addressBook);
                searchCommands.add(searchcommand);
    		}
    		
    		if(keyWord.equals("group")){
    			ISearchCommands searchcommand = new GroupSearch(searchTerm, addressBook);
                searchCommands.add(searchcommand);
    		}	
    		
    		if(keyWord.equals("any")){
    			ISearchCommands searchcommand = new AnySearch(searchTerm, addressBook);
                searchCommands.add(searchcommand);
    		}
    		
    		if (noKeyWordMatch(keyWord)) {
    			System.out.println("Please, use a valid keyword from the list above.");
    		}
    }
    
    /**
     * Checks if the user used one of the given keywords to search for.
     * @param keyWord
     * @return true, if it is a valid keyword, false otherwise
     */
    private boolean noKeyWordMatch(String keyWord) {
    	assert keyWord.length() > 0;
    	return (!keyWord.equals("name") &&
    				!keyWord.equals("address") &&
    					!keyWord.equals("email") &&
    			   			!keyWord.equals("phone") &&
    			   				!keyWord.equals("group") &&
    			   					!keyWord.equals("any"));
    		
    }
    
    private void fillMatches(){
        this.matches = addressBook.getAddressBookEntries();
    }
    
    /**
     * Searches based on logical AND if the user used more than one
     * keyword when searching.
     * @param lastSearchTerm
     */
    public void logicalAndOnSearch(ISearchCommands lastSearchTerm){
    	assert lastSearchTerm != null;
        List<IEntry> lastSearchList = lastSearchTerm.getMatches();
        List<IEntry> tempTempList = new LinkedList<>(this.tempMatches);
        for (IEntry e : addressBook.getAddressBookEntries()) {
            if (lastSearchList.contains(e) && tempMatches.contains(e)) {
                this.matches.add(e);
            } else {
                    if (this.matches.contains(e)) {
                        this.matches.remove(e);
                    }
                    else {
                        tempTempList.remove(e);
                    }
                }
            }
            tempMatches = tempTempList;
    }
    
    /**
     * Adds the current entry to the search history.
     */
    public void addToSearchHistory(){
        for(IEntry e: matches){
            searchHistory.add(e);
        }
    }

    public List<IEntry> getSearchHistory(){
        return this.searchHistory;
    }

    public List<IEntry> getMatches(){

        return this.matches;
    }

    public LinkedList<ISearchCommands> getSearchCommands(){
        return this.searchCommands;
    }

}
