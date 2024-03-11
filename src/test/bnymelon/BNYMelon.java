package test.bnymelon;

import java.util.LinkedHashMap;

import static org.junit.Assert.*;


public class BNYMelon {

    public static void main(String[] args) throws Exception {
        Bank bank = new Bank();
        Person person1ameliaPond = new Person("Amelia", "Pond", 1);
        Long ameliaPond = bank.openConsumerAccount(person1ameliaPond, 1111, 0.0);

        Transaction transaction1 = new Transaction(bank, ameliaPond, 1111);
        double beforeDeposit1 = transaction1.getBalance();
        System.out.println("--->"+beforeDeposit1);
        double amount = 23452.43;
        transaction1.credit(amount);
        assertEquals(beforeDeposit1 + amount, transaction1.getBalance(), 0);
        assertTrue("Debit was unsuccessful.", transaction1.debit(amount));
        assertFalse("This transaction should have overdrawn the account.", transaction1.debit(amount));
        assertEquals(beforeDeposit1, transaction1.getBalance(), 0);
        assertEquals(transaction1.getBalance(), bank.getBalance(ameliaPond), 0);
    }

}

 class Transaction {
    private Long accountNumber;
    private Bank bank;

    public Transaction(Bank bank, Long accountNumber, int attemptedPin) throws Exception {
        this.bank = bank;
        if(bank.authenticateUser(accountNumber, attemptedPin)){
            this.accountNumber = accountNumber;
        }else{
            throw new Exception();
        }

    }

    public double getBalance() {
        return this.bank.getBalance(this.accountNumber);
    }

    public void credit(double amount) {
        this.bank.credit(this.accountNumber, amount);
    }

    public boolean debit(double amount) {
        return this.bank.debit(this.accountNumber, amount);
    }
}


 class Bank {
    private LinkedHashMap<Long, Account> accounts;

    public Bank() {
        // complete the function
        accounts = new LinkedHashMap<>();
    }

    private Account getAccount(Long accountNumber) {
        if(accounts.containsKey(accountNumber)){
            return accounts.get(accountNumber);
        }else{
            return null;
        }

    }


    public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
        // complete the function
        long  accountNumber = accounts.size();
        Account consumerAccount = new ConsumerAccount(person, accountNumber, pin, startingDeposit);
        accounts.put(accountNumber,consumerAccount);
        return accountNumber;
    }

    public boolean authenticateUser(Long accountNumber, int pin) {
        // complete the function
        return true;
    }

    public double getBalance(Long accountNumber) {
        return accounts.get(accountNumber).getBalance();
    }

    public void credit(Long accountNumber, double amount) {
        accounts.get(accountNumber).creditAccount(amount);
    }

    public boolean debit(Long accountNumber, double amount) {
        return accounts.get(accountNumber).debitAccount(amount);
    }
}


 abstract class AccountHolder {
    private int idNumber;

    /**
     * @param idNumber The government-issued ID used during account setup.
     */
    public AccountHolder(int idNumber){
        this.idNumber = idNumber;
    }

    /**
     * @return private int {@link AccountHolder#idNumber}
     */
    public int getIdNumber() {
        return this.idNumber;
    }
}

 class Person extends AccountHolder{
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName, int idNumber) {
        super(idNumber);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
}


abstract class Account {
    private AccountHolder accountHolder;
    private Long accountNumber;
    private int pin;
    private double balance;

    protected Account(AccountHolder accountHolder, Long accountNumber, int pin, double startingDeposit) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = startingDeposit;
    }

    public AccountHolder getAccountHolder() {
        return this.accountHolder;
    }

    public boolean validatePin(int attemptedPin) {
        if(this.pin == attemptedPin){
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public Long getAccountNumber() {
        return this.accountNumber;
    }

    public void creditAccount(double amount) {
        balance = balance + amount;
    }

    public boolean debitAccount(double amount) {
        if(amount > balance){
            return false;
        }
        balance = balance - amount;
        return true;
    }
}

class ConsumerAccount extends Account{
    public ConsumerAccount(Person person, Long accountNumber, int pin, double currentBalance) {
        super(person,accountNumber,pin,currentBalance);
    }

}

