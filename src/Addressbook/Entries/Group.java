package Addressbook.Entries;


import java.util.*;


/**
 * A Group is a kind of Entry that gets created when 
 * a line from the input file has the structure of a Group.
 * His main responsibilities are establishing the connection
 * between his corresponding Contact Objects and provide a pre-
 * tty printed version of himself.
 */

public class Group extends Entry {

    private String groupName;
    private int groupNumber;
    private List<IEntry> groupMembers = new LinkedList<>();


    /**
     * Constructor that takes 2 argument, in case line to read in has no subgroups.
     */
    public Group(String groupName, int groupNumber){
        super();
        this.groupName = groupName;
        this.groupNumber = groupNumber;
        invariant();
    }
    
    public boolean invariant() {
    	return this.groupName.length() > 0 &&
    				this.groupNumber != 0;
    }
    
    /**
     * Constructor that takes 3 arguments, in case line to read in has different subgroups.
     * Note that the subgroup will be parsed to a linked list.
     */
    public Group(String groupName, int groupNumber, String groups) {

        super(groups);
    	this.groupName = groupName;
    	this.groupNumber = groupNumber;
    	invariant2();
    }
    
    public boolean invariant2() {
    	return this.groupName.length() > 0 &&
    				this.groupNumber != 0;
    }


    /**
     * To add a member to a group, since groups are instanciated without members
     * @param member, must not be null
    */
    public void addMember(IEntry member){
    	assert member != null;
        if(!groupMembers.contains(member)){
            this.groupMembers.add(member);
        }
    }

    public List<IEntry> getGroupMembers(){
        return this.groupMembers;
    }


    public int getGroupNumber(){
        return this.groupNumber;
    }

    @Override
    public String getName(){
        return this.groupName;
    }

    @Override
    public String getAddress(){
        return "";
    }

    @Override
    public String getEmail (){
        return "";
    }

    @Override
    public String getPhoneNumber(){
        return "";
    }
    
    @Override
    public boolean isContact(){
        return false;
    }
    
    @Override
    public boolean isGroup(){
        return true;
    }

    /**
     * The following three toString Method are to prettyPrint.
     * ToString prints out the groupName as well as all the Members with the helper methods of membersToString and
     * subGroupsToString.
     * @return
     */
    @Override
    public String toString(){
        return "Group: " + this.groupName + "\n" +
                "\t" + "Members:" + this.membersToString();
    }
    /**
     * This Method distinguishes between how to print if the member is a contact or a subgroup. if it's the lather
     * it calls the Method subGroupsToString that handels the formatting of the subgrouprepresentation.
     * @return
     */
    public String membersToString(){

        String member = "";
        for(IEntry e: this.groupMembers){
            member = member + "\n"  +(e.isContact()? "\t- " + e.getName() : e.subGroupsToString());
        }
        return member;
    }

    /**
     * Except for the tabs this method is very similar to the toString method. It prints out the
     * members that are groups in a pretty way.
     * @return
     */
    public String subGroupsToString(){
        return "\t" + "- Group: " + this.groupName + "\n" +
                "\t" + " Members:" + "\t" + this.membersToString() + "\n";
    }

    @Override
    public String getGroupName() {
    	return this.groupName;
    }
   
    @Override
    public String toStringForExport() {
    	return this.groupName +";" + this.groupNumber +";" + groupString;
    }

}
