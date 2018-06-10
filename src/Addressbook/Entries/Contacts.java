package Addressbook.Entries;


/**
 * A contact is a kind of Entry that gets created when 
 * a line from the input file has the structure of a Contact.
 * His main responsibilities are establishing the connection
 * between his corresponding Group Objects and provide a pre-
 * tty printed version of himself.
 */

public class Contacts extends Entry {

    private String name;
    private String address;
    private String phoneNumber;
    private String mailAddress;
   
    /**
     * Creates an new instance of Contacts with 4 parameters in case the optional parameter groups 
     * does not exist in the file to read in.
     */

    public Contacts(String name, String address, String phoneNumber, String mailAddress){
        super();
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.mailAddress = mailAddress;
        invariant();
    }
    
    private boolean invariant() {
    	return (this.name.length() > 0 &&
    				this.address.length() > 0 &&
    					this.phoneNumber.length() > 0 &&
    						this.mailAddress.length() > 0);
    	
    }
    
    /**
     * Creates an new instance of Contacts with 5 parameters in case the optional parameter groups 
     * exists in the file to read in.
     */
    public Contacts(String name, String address, String phoneNumber, String mailAddress, String groups){
        super(groups);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.mailAddress = mailAddress;
        invariant2();
    }
    
    private boolean invariant2() {
    	return (this.name.length() > 0 &&
    				this.address.length() > 0 &&
    					this.phoneNumber.length() > 0 &&
    						this.mailAddress.length() > 0);    	
    }

    @Override
    public boolean isContact(){
        return true;
    }

    @Override
    public boolean isGroup(){
        return false;
    }

    @Override
    public String getGroupName(){
        return "";
    }

    @Override
    public String membersToString(){
        return "";
    }

    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public String getAddress() {
        return this.address;
    }
    @Override
    public String getEmail () {
        return this.mailAddress;
    }
    @Override
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    @Override
    public String subGroupsToString(){
        return "";
    }

    @Override
    public String toString(){
        return "Name:" + this.name + "\n" +
                "Address: " + this.address + "\n" +
                "Phone Number: " + this.phoneNumber + "\n" +
                "E-mail Address: " + this.mailAddress + "\n"
                + "Groups: " + groupNamesToString() + "\n";
    }
    
    @Override
    public String toStringForExport() {
    	return this.name + ";" +  this.address + ";" + this.phoneNumber +";" + this.mailAddress +";" + groupString;
    }


}