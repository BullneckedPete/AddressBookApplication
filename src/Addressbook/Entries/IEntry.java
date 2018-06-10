package Addressbook.Entries;

import Addressbook.AddressBook;

/**
 * Serves as an API for Entries.
 */

public interface IEntry {

	/**
	 * Parses the subGroups of Contacts if the Object
	 * is part of more than one group.
	 */
    public void parseSubGroupsString();

    /**
     * Returns pretty printed representation of the group in the console.
     */
    public String toString();
    
    /**
     * Establishes a connection between the Contacts and the Groups 
     * concerning the groups.
     */
    public void connect(AddressBook addressBook);
    
    /**
     * Adds members to its specific group since every group can 
     * contain more than one member.
     */
    public void addMemberToGroup(AddressBook addressBook);

    
    /**
     * @return true, if the object is a Contact false otherwise
     */
    public boolean isContact();
    
    /**
     * @return true, if the object is a Group, false otherwise
     */
    public boolean isGroup();

    public String getName();

    public String getAddress();

    public String getEmail();

    public String getPhoneNumber();

    public String getGroupName();

    public String membersToString();
   
    public String subGroupsToString();
    
    public String toStringForExport();

    //public String groupNamesToString();

}