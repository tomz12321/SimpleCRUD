import java.util.*;

/**
 * Design a class Conference
 * 
 * @author Jyh-woei Yang 
 * @version 18/09/2017
 */
public class User
{
    // instance variables - replace the example below with your own
    private String username;
    private String password;
    private String usertype;

    /**
     * Default Constructor for objects of class Record
     */
    public User()
    {
        // initialise instance variables
        username = "";
        password = "";
        usertype = "";
    }
    
    /**
     * A method to test displaying object displayUserRecord attibutes
     * 
     * @param
     * @return 
     */
    public void displayUserRecord()
    {
        //method to test displaying attributes of the user
        System.out.print(username + ",");
        System.out.print(password + ",");
        System.out.print(usertype + "\n");
    }    
        
    /**
     * A method to return username
     * 
     * @param
     * @return username 
     */
    public String getUsername()
    {
        //method to get username
        return username;
    }
   
    /**
     * A method to return password 
     * 
     * @param
     * @return password  
     */
    public String getPassword()
    {
        //method to get password
        return password;
    }
    
    /**
     * A method to return usertype
     * 
     * @param
     * @return usertype 
     */
    public String getUsertype()
    {
        // method to get usertype
        return usertype;
    }
    
    /**
     * A method to set username
     * 
     * @param username the User username
     * @return 
     */
    public void setUsername(String userUsername)
    {
        //method to set userUsername
        username = userUsername;
    }
    
    /**
     * A method to set password
     * 
     * @param password the User password
     * @return  
     */
    public void setPassword(String userPassword)
    {
        //method to set a userPassword
        password = userPassword;
    }
    
    /**
     * A method to set usertype
     * 
     * @param  usertype the User usertype
     * @return      
     */
    public void setUsertype(String userUsertype)
    {
        //method to set userUsertype
        usertype = userUsertype;
    }
        
}
