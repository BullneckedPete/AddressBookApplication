package Addressbook;
import Addressbook.Entries.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Reads the given csv file line by line by iterating over it. 
 * His main responsibilities are parsing the input file and 
 * creating objects out of the lines. Every line is either a
 * Contact or Group object.
 */

public class AddressFileReader implements Container {

    private List<IEntry> addressEntries;
    private List<String> inputLine = new LinkedList<String>();
    private BufferedReader text;
    
    public AddressFileReader(){
        this.addressEntries = new LinkedList<>();
        parseInputFields();
        invariant();
    }
    
    private boolean invariant() {
    	return this.addressEntries.size() != 0;
    }
    
    @Override 
    public Iterator getIterator() {
    	return new FileIterator();
    }
    
    /**
     * Reads line by line the csv file from the source.
     * @param path where file lies
     * @return lines of csv file in a list
     */
    private List<String> readFile(String path) {
    	assert path.length() != 0;
    	try{
    		FileIterator iterator = new FileIterator();
    	    text = new BufferedReader(new FileReader(path));
    	    while (iterator.hasNext()) {
    	        inputLine.add(iterator.next());
    	    }  
    	}catch(FileNotFoundException e){
    		System.out.println("Adapt file path in parseInputFiels() method located in AddressFileReader.java!");
    		System.out.println("After that, run the application again.");
    	    System.exit(1);
    	}
    	return inputLine;
    }
    
    /**
     * Takes the input data, cleans it, and stores every element in a field.
     */
    private void parseInputFields() {

    	readFile("../exercise_08/files/testData.csv");
    	for (String line : inputLine) {
            if(line.contains("\"")) {
                String temp = line.replace("\"", "");
                line = temp;
            }
    		parseLine(line);
    	}	
    }

    /**
     * Parses the line and creates an array with all the different entry Parameters of a contact or group.
     * @param entry, has a length > 0
     */
    private void parseLine(String entry) {
    	assert entry.length() > 0;
    	String[] entryParameters = entry.split(";");
    	createObjects(entryParameters);
    }

    /**
     * Gets the entryParameters and creates an Object of the right type.
     * @param entryParameters
     */
    private void createObjects(String[] entryParameters){
    	assert entryParameters.length != 0;

            if (entryParameters.length == 2) {
                IEntry entry = new Group(entryParameters[0], Integer.parseInt(entryParameters[1]));
                addressEntries.add(entry);
            }
            if (entryParameters.length == 3) {
                IEntry entry = new Group(entryParameters[0], Integer.parseInt(entryParameters[1]), entryParameters[2]);
                addressEntries.add(entry);
            }
            if (entryParameters.length == 4) {
                IEntry entry = new Contacts(entryParameters[0], entryParameters[1], entryParameters[2], entryParameters[3]);
                addressEntries.add(entry);
            }
            if (entryParameters.length == 5) {
                IEntry entry = new Contacts(entryParameters[0], entryParameters[1], entryParameters[2], entryParameters[3], entryParameters[4]);
                addressEntries.add(entry);
            }
	}
    
    /**
     * The inner class FileIterator serves, as his name implies, to iterate over each line
     * from a source file.
     */
    private class FileIterator implements Iterator {
    	
    	@Override 
    	public boolean hasNext() {
    		boolean hasNext = false;
    		try {
    			 if (text.ready()) {
					hasNext = true;
    			 }
    		} catch (IOException e){
    			e.getMessage();
    		}
			return hasNext;
    	}
    	
    	@Override
    	public String next() {
    		String next = "";
    		try {
				next = text.readLine();
			} catch (IOException e) {
				e.getMessage();
			}
    		return next;
    	}
    }

    public List<IEntry> getAddressBookEntries() {
        return this.addressEntries;
    }


}

