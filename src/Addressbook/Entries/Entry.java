package Addressbook.Entries;

import Addressbook.AddressBook;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * Serves as an abstract class which implement the IEntry interface.
 * Both Contact as well as Group Objects extend this abstract class
 * since both are Entries.
 */

public abstract class Entry implements IEntry {

    protected List<Group> groupList = new LinkedList<>();
    protected String groupString = "";
    protected ArrayList<Integer> groupNumberList = new ArrayList<>();

    public Entry(){

    }

    public Entry(String groupString){
        this.groupString = groupString;
        invariant();
    }

    private boolean invariant(){
        return this.groupString.length() > 0;
    }

    /**
     * Parses a list of groupNumbers and for each groupNumber, the Group gets added to the
     * LinkedList called groupList.
     */
    public void parseSubGroupsString() {
        if(!this.groupString.equals("")) {
            String[] splittedGroupString = groupString.split(",");
            for (int i = 0; i < splittedGroupString.length; i++) {
                this.groupNumberList.add(Integer.parseInt(splittedGroupString[i]));
            }
        }
    }

    /**
     * For every Integer saved in the GroupNumberList the right Group is searched. This Contact adds the Group to it's own groupList
     * and the Group adds this Contact to it's members.
     * @param addressBook, must not be null
     */
    public void addMembersToGroup(AddressBook addressBook){

        assert addressBook != null;
        List<Group> allPossibleGroups = addressBook.getGroupList();
        for(Integer i: groupNumberList){
            for(Group g: allPossibleGroups){
                if(g.getGroupNumber() == i){
                    addToGroupList(g);
                    g.addMember(this);
                }
            }
        }
    }

    /**
     * Adds the Group to the GroupList of this Group, only if it's not already stored. Since Groups can also be part of
     * groups
     * @param group, must not be null
     */
    public void addToGroupList(Group group){
        assert group != null;
        if(!groupList.contains(group)) {
            this.groupList.add(group);
        }
    }

    public String groupNamesToString(){
        String groupNames = "";
        for(IEntry g: this.groupList){
            groupNames = groupNames + g.getGroupName() + (groupList.size() == 1 ? "" : ", ");
        }
        return groupNames;
    }

    /**
     * After the AddressBook is initialized the Addresses are connected to their Groups and Vice versa.
     * @param addressBook
     */
    public void connect(AddressBook addressBook) {
        assert addressBook != null;
        parseSubGroupsString();
        addMembersToGroup(addressBook);
    }

    public List<Integer> getGroupNumberList(){
        return this.groupNumberList;
    }

    public boolean isContact(){
        return false;
    }
    
    public boolean isGroup(){
        return false;
    }
    
    public void addMemberToGroup(AddressBook addressBook){
    }
    public String getName(){
    	return "";
    }

    public String toString(){
        return "";
    }

    public String getGroupName(){
        return "";
    }

    public String getPhoneNumber(){ return "";}

    public List<Group> getGroupListOfEntry(){
        return this.groupList;
    }





}
