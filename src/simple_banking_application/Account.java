
package simple_banking_application;

import java.util.ArrayList;

/**
 *
 * @author Mawada Nagi
 */
public class Account {
    private String name;   //name of the account
    
    private double balance; // current balance of the account
    
    private String uuid;  //account ID number
    
    private User holder;  //user who owns this account
    
    private ArrayList<Transaction> transactions;  //list of transactions for this account.

    public Account(String name, User holder, Bank theBank) {
        this.name = name;
        this.holder = holder;
        
        this.uuid = theBank.getNewAccountUUID(); //get new account uuid
        
        this.transactions = new ArrayList<Transaction>(); //initialise transactions
        
//        holder.addAccount(this);
//        theBank.addAccount(this);
        
        
    }
    
    
    
}
