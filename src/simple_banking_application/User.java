
package simple_banking_application;

import java.util.ArrayList;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 *
 * @author Mawada Nagi
 */

public class User{
    
    private String firstname;
    
    private String lastname;
    
    private String uuid;    //unique universal identifier
    
    private byte pinHash[]; //pin of the user (using MD5 Hash as to not store the actual pin value)
    
    private ArrayList<Account> accounts; //list of accounts for this user

    /**
     * create a new user
     * @param firstname user's first name
     * @param lastname  user's last name
     * @param pin       user's account pin number
     * @param theBank   bank object that the user is a customer of
     */
    public User(String firstname, String lastname,String pin, Bank theBank) {
        this.firstname = firstname;
        this.lastname = lastname;
        
        //the pin's MD5 Hash, rather than the original value for security reasons
        // the pin is stored as a string
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");        //MessageDigest is an engine class designed to provide the functionality of cryptographically secure message
            this.pinHash = md.digest(pin.getBytes());                      //getting the bytes of the pin object and digesting them through our MD5 algorithm to store in pinHash              
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error, caught NoSuchAlgorithmException");
            e.printStackTrace();
            System.exit(1);
        }
        
        this.uuid = theBank.getNewUserUUID();     //get a new uuid for the user
        this.accounts = new ArrayList<Account>();  //empty list of accounts
        System.out.printf("New User %s, %s with ID %s created. \n", lastname, firstname, this.uuid);
        
        
        
    }

//    public String getFirstname() {
//        return firstname;
//    }
//
//    public void setFirstname(String firstname) {
//        this.firstname = firstname;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }
//
//    public String getUuid() {
//        return uuid;
//    }
//
//    public void setUuid(String uuid) {
//        this.uuid = uuid;
//    }
//
//    public byte[] getPinHash() {
//        return pinHash;
//    }
//
//    public void setPinHash(byte[] pinHash) {
//        this.pinHash = pinHash;
//    }
//
//    public ArrayList<Account> getAccounts() {
//        return accounts;
//    }
//
//    public void setAccounts(ArrayList<Account> accounts) {
//        this.accounts = accounts;
//    }
//    
    
}
