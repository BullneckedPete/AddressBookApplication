package Addressbook.Commands;

import Addressbook.Entries.*;

import java.io.*;

/**
 * Serves to export the stored entries for which the 
 * user searched in the command line to a csv file.
 */

public class Export {
	
	private BufferedWriter bw = null;
	private File file;
	
	/**
	 * Creates a new instance of the class. Directly exports the 
	 * entries that are stored in 'search'.
	 * @param search, must no be null
	 */
    public Export(Search search){
    	assert search != null;
        try {
            export(search);
            System.out.println("You successfully exported the file \"exportedData.csv\".");
            System.out.println("Navigate to '../exercise_08/files/exportedData.csv' to check the file!");
        } catch (IOException e) {
            e.getMessage(); 
        } finally {
        	try{
        		if(bw!=null) {
        			bw.close();
        		}
      	     } catch(Exception e) {
      	       e.getMessage();
      	     }
        }
    }
    
    /**
     * Creates an new export file (if not exists) and writes
     * the search from the user in a csv file.
	 * is Public for Testing
     * @param search, must not be null
     * @throws IOException
     */
    public void export(Search search) throws IOException {
      assert search != null;
      file = new File("../exercise_08/files/exportedData.csv");

   	  if (!file.exists()) {
   	     file.createNewFile();
   	  }

   	  FileWriter fw = new FileWriter(file);
   	  bw = new BufferedWriter(fw);
   	  for (IEntry entry : search.getMatches()) {
   		  String str = entry.toStringForExport();
   		  bw.write(str);
   		  bw.append("\n");
   	  }
    }

    public File getFile(){
    	return this.file;
	}
    

    
}
