import java.util.*;
import java.io.*;

/**
 * Write a description of class UserDatabase here.
 * 
 * @author Jyhwoei Yang 
 * @version 18/09/2017
 */
public class UserDatabase
{    
    private ArrayList<User> userList; // should be private
    
    /** Default Constructor of Class UserDatabase
     * 
     */
    public UserDatabase()
    {
        //initialise the variables
        userList = new ArrayList<User>();
    }
    
    /**
     * A method to add User to the list
     * 
     * @param User the User Object
     * @return 
     */
    public void addUser(User newUser)
    {
        userList.add(newUser);
    } 
    
    /**
     * A method to delete User from the list
     * 
     * @param delUserName the name of delete user
     * @return 
     */
    public void deleteUser(String delUserName)
    {        
        //remove()
        boolean isDeleted = false;
        for (int i = 0 ; i < getNumbersOfUsers() ; i++)
        {
            if(getUserList().get(i).getUsername().equals(delUserName))
            {
                System.out.println(getUserList().get(i).getUsername() + " are deleted.");
                getUserList().remove(i);
                isDeleted = true;
            }                        
        }        
        if (! isDeleted)
        {
            System.out.println(" No matched users are deleted."); 
        }
    } 
    
    /**
     * A method to edit User from the list
     * 
     * @param editUserName,editPassword,editUserType the name of edit user
     * @return 
     */
    public void editUser(String editUserName, String editPassword, String editUserType)
    {        
        //set()
        boolean isEdited = false;
        for (int i = 0 ; i < getNumbersOfUsers() ; i++)
        {
            if(getUserList().get(i).getUsername().equals(editUserName))
            {
                System.out.println(getUserList().get(i).getUsername() + " are edited.");
                getUserList().get(i).setPassword(editPassword);
                getUserList().get(i).setUsertype(editUserType);
               
                isEdited = true;
            }                        
        }        
        if (! isEdited)
        {
            System.out.println(" No matched users are Edited."); 
        }
    }
    
    /**
     * A method to return elements from the user list
     * 
     * @param index the index
     * @return elements in the userList
     */
    public User getUser(int index)
    {
        return userList.get(index);
    }
    
    /**
     * A method to return the whole user list
     * 
     * @param 
     * @return the whole userList
     */
    public ArrayList<User> getUserList()
    {
        return userList;
    }
    
    /**
     * A method to return the size of user list
     * 
     * @param
     * @return count number of Users
     */
    public int getNumbersOfUsers()
    {
        return userList.size();
    }   
    
    /**
     * List all the users currently in the database on standard out.
     */
    public void listAll() 
    {
        for (int j = 0 ; j < userList.size() ; j++)
        
            userList.get(j).displayUserRecord();        
    }
    
    /**
     * A method to search user
     * 
     * @param searchTitle the searchTitle
     * @return resultList the resultList
     */
    public ArrayList<User> searchUser(String searchName) //not case-sensitive source.toLowerCase().contains(target.toLowerCase())
    {
        ArrayList<User> resultList = new ArrayList<User>();
        
        for (int i = 0 ; i < getNumbersOfUsers(); i++)
        {
            if(getUserList().get(i).getUsername().toLowerCase().contains(searchName))
                resultList.add(getUserList().get(i));
            
        }
                
        return resultList;
    }
    
    /**
     * A method to set user Name
     * 
     * @param userName the userName, index the index
     * @return 
     */
    public void setUser(User insertedUser, int index)
    {
        userList.set(index, insertedUser);
    }
    
    /**
    * Method to check User Name repeatation
    * 
    * @param UserName the Name
    * @return the boolean of User Name repeatation
    */
    public boolean validUserName(String userName) //method to check User Name repeatation
    {
        //check if user name is not in database , and return false to break while loop
        for (int i = 0 ; i < getNumbersOfUsers() ; i++ )
        {
            if (userName.equals(getUserList().get(i).getUsername()))
                return true;
        }
        
        return false;        
    }
}   
    