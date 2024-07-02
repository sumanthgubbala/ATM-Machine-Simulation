import java.util.*;

class ATM {
    int PIN = 5678; //inital PIN
    float Balance;
    List<String> Transactions=new ArrayList<>(); //list to store transaction history
    Scanner sc = new Scanner(System.in);

    // method to Check the pin is correct or not
    public void checkPIN() {
        System.out.println("Enter your PIN: ");

        int enterpin = sc.nextInt(); //read user input
        if (enterpin == PIN) {
            menu(); //if pin is correct , show menu

        } else {
            System.out.println("Wrong PIN");
        }

    }

    //Method to display menu options
    public void menu() {

        System.out.println("1. check Account Balance");
        System.out.println("2. Cash Withdraw");
        System.out.println("3. Cash Deposit");
        System.out.println("4. PIN change");
        System.out.println("5. Transaction history ");
        System.out.println("6. Exit");
        System.out.println("Enter your choice: "); //read user input for menu option

        //switch case to handle menu options 
        int option = sc.nextInt();
        switch (option) {
            case 1:
                CheckBalance();
            case 2:
                Withdraw();
            case 3:
                Deposit();
            case 4:
                ChangePIN();
            case 5:
                Transactionhistory();
            case 6:
                System.exit(0);//exit program
            default:
                System.out.println("Invalid option");
                menu();//show menu again
                break;
        }

    }

    // method to Check and display the account balance
    public void CheckBalance() {
        System.out.println("Your balance is: " + Balance);
        menu();//show menu again

    }

    // Method to check and WithDraw Cash
    public void Withdraw() {
        System.out.println("Enter the amount you want to withdraw: ");
        float withdrawAmount = sc.nextFloat(); //read amount to withdraw
        if (withdrawAmount > Balance) { //if insufficient balance ,show error message
            System.out.println("Insufficient Balance");
        } else {
            Balance = Balance - withdrawAmount; //debit amount from balance 
            System.out.println("Withdraw Successful");
            Transactions.add("Withdraw :" + Balance); //add record to the transaction history

        }
        menu(); //show menu again

    }

    //method to Deposit Cash
    public void Deposit() {
        System.out.println("Enter the amount : ");
        float deposit = sc.nextFloat(); //read amoutn to deposit
        Balance = Balance + deposit;  //add amount to balance
        System.out.println("Your new balance is: " + Balance);
        Transactions.add("Deposit :" + Balance);  //add record transaction history
        menu(); // show menu again
    }

    // method to Change pin
    public void ChangePIN() {
        System.out.println("Enter your new PIN: ");
        int newPIN = sc.nextInt(); //read new PIN
        if (newPIN == PIN) {  //if new PIN is same as old PIN , shows a error message
            System.out.println("PIN can not be same as old PIN");
        } else {
            PIN = newPIN; //change PIN
            System.out.println("PIN changed successfully...");
        }
        menu(); //Show menu again

    }

    // method to Display the Transaction History
    public void Transactionhistory() {
        System.out.println("Transaction history : ");
        if(Transactions.isEmpty()){   //if no transactions ,shows error message
            System.out.println("No transactions..");
        }
        for (int i = 0; i < Transactions.size(); i++) {
            System.out.println(Transactions.get(i)); // display each transaction
        }
        menu(); //show menu again

    }

}

public class ATMMachine {
    public static void main(String[] args) {
        ATM atm = new ATM(); //create ATM object
        atm.checkPIN();  //start the ATM by chechking the PIN

    }
}