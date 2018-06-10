package Addressbook;

import java.util.*;
import Addressbook.Commands.*;


/**
 * Serves for running a search session by reading the input from the
 * user, that is, interacting with the user depending on the parsed 
 * lines typed in by the user.
 */
public class Parser {

    private Scanner scanUserInput = new Scanner(System.in);
    private AddressBook addressBook;
    private String input = "";
    private boolean session = true;
    private LinkedList<Search> searchList= new LinkedList<Search>();
    private Search search;
    private static Parser instanceOfParser = new Parser();
    
    /**
     * Private constructor since the Parser can't be instantiated.
     */
    private Parser() {
        this.addressBook = new AddressBook();
        readUserInput();
        invariant();
    }
    
    private boolean invariant() {
    	return this.addressBook != null;
    }
    
    /**
     * Getter method to retrieve the only Parser object that is available.
     */
    public static Parser getInstance(){
	      return instanceOfParser;
	   }
    
    /**
     * Reads the input from the user from the command line.
     */
    public void readUserInput() {
        System.out.println("Please enter search term for your contact or group:");
        System.out.println("When searching, you can use the following keywords after 'search': " + "\n" +
                           " - name: "    + "\n" +
        		           " - address: " + "\n" +
                           " - phone: "   + "\n" +
        		           " - email: "   + "\n" +
                           " - group: "   + "\n" +
        		           " - any: ");
        System.out.println("Type 'Abort' to finish search session!");
        while (session) {
            input = scanUserInput.nextLine();
            if (input.toLowerCase().equals("Abort".toLowerCase())) {
                session = false;
            } else if (noValidUserInput())    {
            	System.out.println("No valid input! Use 'search', 'print', 'export' or 'abort");
            } else if (input.toLowerCase().equals("export") && search == null) {
                System.out.println("Before export you need to search!");
            } else {
            	parseInput(input);
            }
        }
    }
    
    private boolean noValidUserInput() {
    	return !input.toLowerCase().equals("Abort".toLowerCase()) &&
     		   		!input.toLowerCase().startsWith("Search".toLowerCase()) &&
     		   			!input.toLowerCase().equals("Export".toLowerCase()) &&
     		   				!input.toLowerCase().equals("Print".toLowerCase());
    }
    
    /**
     * Parses the input from the user in order to extract the information if the user
     * wants to search, print or export addresses. Out of this a Search, Print or Export
     * object is created.
     * @param input that the user types in the command line, length must be > 0
     */
    public void parseInput(String input){
    	assert input.length() > 0;
        String[] splittedInput = input.split(" ");
        if (splittedInput[0].toLowerCase().equals("search")) {
            search = new Search(input, this.addressBook);
            searchList.add(search);
        }
        if (splittedInput[0].toLowerCase().equals("print")) {
            Print print = new Print(this.search, this.addressBook);
        }
        if (splittedInput[0].toLowerCase().equals("export")) {
            Export export = new Export(searchList.getLast()); 
        }
    }
    
    /**
     * Runs the application. Note that we implemented the Singleton
     * Pattern so there is only one Parser object available in the 
     * whole application.
     */
    public static void main(String args[]) {
        Parser parser = Parser.getInstance();
    }

}
