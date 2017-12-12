
/**
 * Write a description of class UserLogin here.
 * 
 * @author Jyh-woei Yang 
 * @version 25/09/2017
 */

// instance variables - replace the example below with your own
import java.lang.*;
import java.util.*;
import java.io.*;

public class UserLogin
{
    // instance variables - replace the example below with your own
    private String username;
    private String password;
    private String usertype;
    private UserDatabase newUserLogin = new UserDatabase();
    
    /**
     * Default Constructor for objects of class User System
     */
    public UserLogin()
    {
        // initialise instance variables
        username = "";
        password = "";
        usertype = "";
        newUserLogin = new UserDatabase();
    }   

    /**
     * A method to add user to the database system
     * 
     * @param
     * @return 
     */
    private void addUser()
    {
        //input
        Scanner input = new Scanner(System.in);

        System.out.println("=== Add User ===");
        System.out.println("Please insert user name :");        
        String newUserName = input.nextLine();

        //valid addUserName if existed , Error message
        while (validUserName(newUserName))
            newUserName = input.nextLine();                  

        //valid addUser if blank , Error message    
        while (validBlank(newUserName,"User Name"))
        {
            newUserName = input.nextLine();
            //valid addUserName if existed , Error message
            while (validUserName(newUserName))
                newUserName = input.nextLine(); 
        }        
        System.out.println("Please insert password :");

        //input User's newPassword
        String newPassword = input.nextLine();

        while (validBlank(newPassword,"Password"))
            newPassword = input.nextLine();

        System.out.println("Please insert Usertype :");

        //input User's Usertype
        String newUsertype = input.nextLine();

        while (validBlank(newUsertype,"User type"))
            newUsertype = input.nextLine();
        
        //add user to the list
        User newUser = new User(); 
        newUser.setUsername(newUserName);
        newUser.setPassword(newPassword);
        newUser.setUsertype(newUsertype);
        
        //outprint to testing
        newUser.displayUserRecord();

        //add to User List
        newUserLogin.addUser(newUser);
    }
    
    /**
     * A method to display Menu
     * 
     * @param
     * @return 
     */

    private void displayMenu()
    {
        //interface
        System.out.println("");
        System.out.println("=====================");
        System.out.println("(1) User login");
        System.out.println("(2) User registration");
        System.out.println("(3) Exit System");
        System.out.print("Choose an option :");
    }
    
    private void displayAdminMenu()
    {
        //interface
        System.out.println("");
        System.out.println("=====================");
        System.out.println("(1) User login");
        System.out.println("(2) User administration");
        System.out.println("(3) Exit System");
        System.out.print("Choose an option :");
    }
    
    /**
     * A method to exit the system
     * 
     * @param
     * @return a boolean to make isOperating = false and break the while loop
     */
    private boolean exitSystem()
    {
        System.out.println("Exit System");

        //reset all the attributes
        newUserLogin = new UserDatabase();

        return false;
    }
    
    /**
     * A method to read from file
     * 
     * @param  
     * @return
     * @throws FileNotFoundException if file is not found
     * @throws IOException while exception during I/O actions
     */
    private void readFile()
    {
        String filename = ("myUser.txt");
        String staff;
        User loadFromFile;
        // try catch to handle FileNotFoundException and IOException
        try
        {
            FileReader inputFile = new FileReader(filename);
            Scanner parser = new Scanner(inputFile);
            int linecount = 0;
            while (parser.hasNextLine())
            {
                loadFromFile = new User(); 
                staff = parser.nextLine();
                String[] attribute = staff.split(",");

                for (int i = 0 ; i < attribute.length ; i++)
                {
                   System.out.println (attribute[i]);
                
                   //numbers of Users
                   //for (int k = 0 ; k < loadFromFile.getNumbersOfElements() ; k++)
                   //{
                   //attributes of Users
                   //}
                }

                System.out.println ("User"+ linecount);
                loadFromFile.setUsername(attribute[0]);
                loadFromFile.setPassword(attribute[1]);
                loadFromFile.setUsertype(attribute[2]);
                
                //add user to the list
                User newUser = new User();                               

                loadFromFile.displayUserRecord();
                newUserLogin.addUser(loadFromFile);
                linecount++;
            }
            inputFile.close();
        }
        catch(FileNotFoundException exception)
        {
            System.out.println(filename + " not found");
        }
        catch(IOException exception)
        {
            System.out.println("Unexpected I/O error occured");
        }
    }
    
    /**
     * A method to search password by username and valid login sucessfully or not
     * 
     * @param
     * @return 
     */
    private void userLogin() //not case-sensitive source.toLowerCase().contains(target.toLowerCase())
    {
        System.out.println("=== User login ===");
        //input
        Scanner input = new Scanner(System.in);
        System.out.println("Username:");
        String loginUserName = input.nextLine();

        while(validBlank(loginUserName,"Username"))
            loginUserName = input.nextLine();
        
        System.out.println("Password:");
        String loginPassword = input.nextLine();
        
        while(validBlank(loginPassword,"Password"))
            loginPassword = input.nextLine();

        //searchUser()
        Boolean loginState = newUserLogin.validUserPassword(loginUserName,loginPassword);

        if (loginState == true)
        {
            System.out.println("Hello " + loginUserName + " !");
            System.out.println("(" +  newUserLogin.getUsertype(loginUserName,loginPassword) + ")" );        
        }
        //display User details
        //System.out.println("Search Result");
        //for (int j = 0 ; j < resultList.size() ; j++)
        //{
        //    resultList.get(j).displayUserRecord();
            //resultList.get(j).getPassword();
        //}

        if (loginState == false)
            System.out.println("Login failed");
    }
    
    /**
     * A method to start operating the system
     * 
     * @param
     * @return 
     */
    public void start()
    {
        //Scanner
        Scanner input = new Scanner(System.in);
        Boolean isOperating = true;
        
        //read from file
        readFile();

        while (isOperating)
        {                        
            //display menu 
            if (this.usertype.equals("Admin"))
                displayAdminMenu();
            else
                displayMenu();

            //insert case
            String iobuffer = input.nextLine(); 
            System.out.println("");
            //check console.nextLine() is not null or blank
            if (validBlank(iobuffer,"Option"))
            { 
                char option = iobuffer.charAt(0);

                //if option not in 1,2,3,4,5 Error message: please insert from (1) to (5)!
                if (validOption(option))
                {
                    switch (option)
                    {
                        case '1':
                        //User login
                        userLogin();
                        break;
                        case '2':
                        //User registeration (CRUD)
                        UserRegistrationSystem UR = new UserRegistrationSystem();
                        UR.start();
                        break;
                        case '3':
                        //Exit system, and reset variables
                        isOperating = exitSystem();
                        break;
                    }
                }

                if (!isOperating)
                {
                    System.out.println("");
                    System.out.println("Thank you for using User Database System, Goodbye!");
                }
            }
        }
    }
    
    /**
     * Method to check insert any emptys or blank
     * 
     * @param iobuffer the iobuffer
     * @param subject the subject
     * @return the boolean of checkBlank
     */
    private boolean validBlank(String iobuffer,String subject) //method to check insert any empties or blanks
    {
        if (subject.equals("Option"))
        {
            //if iobuffer isEmpty or iobuffer.length() > 1 , Error : please insert from (1) to (5)! and return false to break if condition
            if (iobuffer.isEmpty() || iobuffer.length() > 1)
            {
                System.out.println("Error : please insert from (1) to (3)!");
                return false;
            }
            return true;
        }
        else
        {    
            //iobuffer.trim().isEmpty(), "Error: subject's name shouldn't be blank! Please enter the name again:" and return true to keep while condition
            if (iobuffer.trim().isEmpty())
            {
                System.out.println("Error: " + subject + " shouldn't be blank! Please enter the name again:");
                return true;
            }
        }
        return false;
    }

    /**
     * Method to check User Name repeatation
     * 
     * @param UserName the Name
     * @return the boolean of User Name repeatation
     */
    private boolean validUserName(String userName) //method to check User Name repeatation
    {
        //check if user title is not in database , and return false to break while loop
        boolean isRepeated = newUserLogin.validUserName(userName);
        if (isRepeated)
        {
            System.out.println("Error : User name existed , please insert another User Name!");
            return isRepeated;
        }
        return false;
    }

    /**
     * Method to check char option
     * 
     * @param option the option
     * @return the boolean of checkOption
     */
    private boolean validOption(char option) //method to check char option
    {
        //check if option is in 1,2,3 , and return false to break if condition
        if (option < '1' || option > '3')
        {
            System.out.println("Error : please insert from (1) to (3)!");
            return false;
        }
        return true;        
    }

    /**
     * Method to check insert any space
     * 
     * @param iobuffer the iobuffer
     * @return the boolean of checkBlank
     */
    private boolean validSpace(String iobuffer) //method to check insert any space characters only on Actor2 or Actor3
    {
        //Actor2 or Actor3.charAt(0) == ' ', "Error: subject's name shouldn't be space only! Please enter the name again:" and return true to keep while condition
        if (iobuffer.isEmpty())
            return false;
        else if (iobuffer.charAt(0) == ' ')
        {
            System.out.println("Error: Input shouldn't be space only or start by space character! Please enter the name again:");
            return true;
        }
        return false;
    }
}