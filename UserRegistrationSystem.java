import java.lang.*;
import java.util.*;
import java.io.*;

/**
 * Create a class for Conference Information System.
 * 
 * @author Jyh-woei Yang 
 * @version 18/09/2017
 */
public class UserRegistrationSystem
{
    // instance variables - replace the example below with your own
    private UserDatabase newUserList;

    /**
     * Default Constructor for objects of class User System
     */
    public UserRegistrationSystem()
    {
        // initialise instance variables
        newUserList = new UserDatabase();
    }    

    /**
     * A method to add user to the database system
     * 
     * @param
     * @return 
     */
    public void addUser()
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
        newUserList.addUser(newUser);
    }

    /**
     * Method to convert from String to Integer
     * 
     * @param a String of input
     * @return the Integer of out
     * @throws NumberFormatException if input is a non-number format
     */
    private int convertStringtoInt(String input) //method to convert String to Integer
    {
        //intialised variables
        String S = input;
        int i = 0;
        //try catch to handle NumberFormatException
        try
        {
            // the String to int conversion happens here
            i = Integer.parseInt(input.trim());

            // print out the value after the conversion
            //System.out.println("int i = " + i);
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("NumberFormatException: " + nfe.getMessage() + ", please input an integer!");
        }
        return i;
    }
    
    /**
     * A method to delete user from the database system
     * if there are above two users appearing on the search result
     * provide choosing options
     * 
     * @param
     * @return 
     */
    private void deleteUser()
    {
        System.out.println("Delete User :");        
        //input
        Scanner input = new Scanner(System.in);

        //search by title
        System.out.println("=== Search User to delete : ===");
        System.out.println("Search User , please insert keyword of name:");

        String delKeyword = input.nextLine().toLowerCase();

        while (validBlank(delKeyword,"Name keyword"))
            delKeyword = input.nextLine().toLowerCase();

        ArrayList<User> delResultList = newUserList.searchUser(delKeyword);

        //display User details
        System.out.println("Search Result");
        for (int j = 0 ; j < delResultList.size() ; j++)
        {
            System.out.print( (j + 1) + ") ");
            delResultList.get(j).displayUserRecord();
        }

        int size = delResultList.size();

        //selection
        if (size != 0)
        {
            System.out.println("Please insert which option number you would select to delete, press 0 to quit :");
            String delUserSelection = input.nextLine();
            int index = convertStringtoInt(delUserSelection);

            if (index == 0)
                size = 0;
            //validDelSelection (index, delresultList.size());
            while (validDelSelection (index, size))
            {

                delUserSelection = input.nextLine();
                index = convertStringtoInt(delUserSelection);
                if (index == 0)
                    size = 0;
                while (validBlank(delUserSelection,"Selection"))
                {    
                    delUserSelection = input.nextLine();
                    index = convertStringtoInt(delUserSelection);
                    if (index == 0)
                        size = 0;
                }
            }
            System.out.println(delUserSelection);

            String delUserName;

            if (size != 0)
                delUserName = delResultList.get(index -1).getUsername();
            else
                delUserName = "";

            //System.out.println("Delete User , please insert delete title:");
            //String delUserName = input.nextLine();
            newUserList.deleteUser(delUserName);
        }
        else
            System.out.println("No matched users");
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
        System.out.println("(1) Search User");
        System.out.println("(2) Add User");
        System.out.println("(3) Delete User");
        System.out.println("(4) Edit User (Password and UserType)");
        System.out.println("(5) Exit System");
        System.out.print("Choose an option :");
    }

    /**
     * A method to edit user from the database system
     * if there are above two users appearing on the search result
     * provide choosing options
     * 
     * @param
     * @return 
     */
    private void editUser()
    {
        System.out.println("Edit User :");        
        //input
        Scanner input = new Scanner(System.in);

        //search by title
        System.out.println("=== Search User to edit : ===");
        System.out.println("Search User , please insert keyword of name:");

        String editKeyword = input.nextLine().toLowerCase();

        while (validBlank(editKeyword,"Name keyword"))
            editKeyword = input.nextLine().toLowerCase();

        ArrayList<User> editResultList = newUserList.searchUser(editKeyword);

        //display User details
        System.out.println("Search Result");
        for (int j = 0 ; j < editResultList.size() ; j++)
        {
            System.out.print( (j + 1) + ") ");
            editResultList.get(j).displayUserRecord();
        }

        int size = editResultList.size();

        //selection
        if (size != 0)
        {
            System.out.println("Please insert which option number you would select to delete, press 0 to quit :");
            String editUserSelection = input.nextLine();
            int index = convertStringtoInt(editUserSelection);

            if (index == 0)
                size = 0;
            //validDelSelection (index, delresultList.size());
            while (validDelSelection (index, size))
            {

                editUserSelection = input.nextLine();
                index = convertStringtoInt(editUserSelection);
                if (index == 0)
                    size = 0;
                while (validBlank(editUserSelection,"Selection"))
                {    
                    editUserSelection = input.nextLine();
                    index = convertStringtoInt(editUserSelection);
                    if (index == 0)
                        size = 0;
                }
            }
            System.out.println(editUserSelection);

            String editUserName;

            if (size != 0)
                editUserName = editResultList.get(index - 1).getUsername();
            else
                editUserName = "";

            if (size !=0)
            {
                System.out.println("==== Edit User ====");

                System.out.println("Please insert new password :");        
                //input newPassword
                String newPassword = input.nextLine();

                while (validBlank(newPassword,"user password"))
                    newPassword = input.nextLine();

                System.out.println("Please insert new User Type :");    
                //input newUserType
                String newUserType = input.nextLine();

                while (validSpace(newUserType))
                    newUserType = input.nextLine();

                ArrayList<String> editActorStringList = new ArrayList<String>();
                editActorStringList.add(newPassword);
                editActorStringList.add(newUserType);
               
                newUserList.editUser(editUserName,newPassword,newUserType);
               
            }
        }
        else
            System.out.println("No matched users");
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
        //write into file
        writeFile();

        //reset all the attributes
        newUserList = new UserDatabase();

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
                newUserList.addUser(loadFromFile);
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
     * A method to search user
     * 
     * @param
     * @return 
     */
    private void searchUser() //not case-sensitive source.toLowerCase().contains(target.toLowerCase())
    {
        System.out.println("=== Search User ===");
        //input
        Scanner input = new Scanner(System.in);
        System.out.println("Search User , please insert a keyword to search by name:");
        String newUserName = input.nextLine().toLowerCase();

        while(validBlank(newUserName,"User Name"))
            newUserName = input.nextLine().toLowerCase();

        //searchUser()
        ArrayList<User> resultList = newUserList.searchUser(newUserName);

        //display User details
        System.out.println("Search Result");
        for (int j = 0 ; j < resultList.size() ; j++)
        {
            resultList.get(j).displayUserRecord();
        }

        if (resultList.size() == 0)
            System.out.println("No matched result");
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
                        //search User from the list by username
                        searchUser();
                        break;
                        case '2':
                        //add User to the list
                        addUser();
                        break;
                        case '3':
                        //delete User from the list
                        deleteUser();
                        break;
                        case '4':
                        //Edit User from the list (Password and Usertype) (HD)
                        editUser();
                        break;
                        case '5':
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
                System.out.println("Error : please insert from (1) to (5)!");
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
     * Method to check Delete selection is from 1 to size
     * 
     * @param index the index to be validated, the size the size
     * @return the boolean of checkDelSelection
     */
    private boolean validDelSelection(int index, int size) //method to check int index
    {
        //check if rating is from 1 to size  and return false to break while loop
        if (index < 0 || index > size)
        {
            System.out.println("Error : please insert from (1) to (" + size +")!");
            System.out.print("Please insert :");
            return true;
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
        boolean isRepeated = newUserList.validUserName(userName);
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
        //check if option is in 1,2,3,4,5,6 , and return false to break if condition , 6 for (HD)
        if (option < '1' || option > '5')
        {
            System.out.println("Error : please insert from (1) to (5)!");
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
            System.out.println("Error: UserType shouldn't be space only or start by space character! Please enter the name again:");
            return true;
        }
        return false;
    }

    /**
     * A method to write to file
     * 
     * @param  
     * @return
     * @throws IOException while exception during I/O actions
     */
    private void writeFile()
    {
        String filename = ("myUser.txt");
        //use User.getNumbersOfElement() to replace 6
        String[] staff = new String[6];
        Scanner input = new Scanner(System.in);
        String line = "";
        int numberOfStaffs;
        UserDatabase toWriteUserList = new UserDatabase();
        
        //print the result of inserting
        System.out.println("How many users your want to insert :");
        //numberOfStaffs = convertStringtoInt(input.nextLine());
        numberOfStaffs = newUserList.getNumbersOfUsers();
        System.out.println(numberOfStaffs + "");
        //try catch to handle IOException
        try
        {
            PrintWriter outputFile = new PrintWriter (filename);

            for (int i = 0 ; i < numberOfStaffs ; i++ )
            {
                staff[0] = newUserList.getUserList().get(i).getUsername();
                staff[1] = newUserList.getUserList().get(i).getPassword();
                staff[2] = newUserList.getUserList().get(i).getUsertype();
               
                //combine elements into a line
                for (int k = 0 ; k < 3 ; k++ )
                {   
                    //line = staff[0] + "," + staff[1] + "," + staff[2] + "," + staff[3] + "," + staff[4] + "," + staff[5];
                    if (k != 3 - 1)
                        line = line + staff[k] + ",";
                    else
                        line = line + staff[k];
                }
                //display a message about write line
                System.out.println("");
                System.out.println("Write a message in line to a file");
                System.out.println("");

                outputFile.println(line);
                //reset line
                line = "";
            }
            outputFile.close();    
        }
        catch(IOException exception)
        {
            System.out.println("Unexpected I/O error occured");
        }
    }
}