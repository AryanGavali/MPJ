import java.io.*;
import java.util.*;


class CIDRangeException extends Exception 
{
    CIDRangeException(String message) 
    {
        super(message);
    }
}


class NegativeAmountException extends Exception 
{
    NegativeAmountException(String message) 
    {
        super(message);
    }
}


class MinimumBalanceException extends Exception 
{
    MinimumBalanceException(String message) 
    {
        super(message);
    }
}


class BalanceLowException extends Exception {

    BalanceLowException(String message) 
    {
        super(message);
    }
}


class Customer 
{
    int cid;
    String cname;
    double amount;

    Customer(int cid, String cname, double amount) 
    {
        this.cid = cid;
        this.cname = cname;
        this.amount = amount;
    }

    void showRecord() 
    {
        System.out.println("Customer ID   : " + cid);
        System.out.println("Customer Name : " + cname);
        System.out.println("Balance       : " + amount);
        System.out.println("-----------------------------");
    }

    String fileFormat() 
    {
        return cid + "," + cname + "," + amount;
    }
}


public class BankingSystem 
{

    static ArrayList<Customer> records = new ArrayList<>();
    static final String FILE_PATH = "bankdata.txt";

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        readFromFile();

        int option;

        do {
            System.out.println("\n====== Banking Menu ======");
            System.out.println("1. Create Account");
            System.out.println("2. Withdraw Amount");
            System.out.println("3. Display All Customers");
            System.out.println("4. Search Customer");
            System.out.println("5. Save and Exit");
            System.out.print("Enter your choice: ");
            option = sc.nextInt();

            try {
                switch (option) {
                    case 1:
                        addCustomer(sc);
                        break;

                    case 2:
                        withdrawAmount(sc);
                        break;

                    case 3:
                        displayCustomers();
                        break;

                    case 4:
                        searchCustomer(sc);
                        break;

                    case 5:
                        writeToFile();
                        System.out.println("Records saved successfully.");
                        System.out.println("Exiting program...");
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (Exception e) 
            {
                System.out.println("Exception: " + e.getMessage());
            }

        } while (option != 5);

        sc.close();
    }

    
    static void addCustomer(Scanner sc)
            throws CIDRangeException, NegativeAmountException, MinimumBalanceException {

        System.out.print("Enter Customer ID (1 to 20): ");
        int id = sc.nextInt();

        if (id < 1 || id > 20) {
            throw new CIDRangeException("CID must be between 1 and 20 only.");
        }

        if (findCustomer(id) != null) {
            System.out.println("Customer with this CID already exists.");
            return;
        }

        System.out.print("Enter Customer Name: ");
        String name = sc.next();

        System.out.print("Enter Initial Amount: ");
        double amt = sc.nextDouble();

        if (amt <= 0) {
            throw new NegativeAmountException("Amount must be positive.");
        }

        if (amt < 1000) {
            throw new MinimumBalanceException("Account must be opened with minimum Rs. 1000.");
        }

        Customer obj = new Customer(id, name, amt);
        records.add(obj);

        System.out.println("Account created successfully.");
    }

    
    static void withdrawAmount(Scanner sc)
            throws NegativeAmountException, BalanceLowException {

        System.out.print("Enter Customer ID: ");
        int id = sc.nextInt();

        Customer c = findCustomer(id);

        if (c == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.print("Enter withdrawal amount: ");
        double wamt = sc.nextDouble();

        if (wamt <= 0) {
            throw new NegativeAmountException("Withdrawal amount must be positive.");
        }

        if (wamt > c.amount) {
            throw new BalanceLowException("Withdrawal amount is greater than available balance.");
        }

        c.amount = c.amount - wamt;
        System.out.println("Withdrawal successful.");
        System.out.println("Remaining Balance: " + c.amount);
    }

    
    static void displayCustomers() {
        if (records.isEmpty()) {
            System.out.println("No customer records available.");
            return;
        }

        System.out.println("\n--- Customer Records ---");
        for (Customer c : records) {
            c.showRecord();
        }
    }

    
    static void searchCustomer(Scanner sc) {
        System.out.print("Enter Customer ID to search: ");
        int id = sc.nextInt();

        Customer c = findCustomer(id);

        if (c == null) {
            System.out.println("Customer record not found.");
        } else {
            System.out.println("\nCustomer Found:");
            c.showRecord();
        }
    }

    
    static Customer findCustomer(int id) {
        for (Customer c : records) {
            if (c.cid == id) {
                return c;
            }
        }
        return null;
    }

    
    static void writeToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Customer c : records) {
                bw.write(c.fileFormat());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("File writing error: " + e.getMessage());
        }
    }

    
    static void readFromFile() {
        File f = new File(FILE_PATH);

        if (!f.exists()) {
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String str;

            while ((str = br.readLine()) != null) {
                String[] arr = str.split(",");

                int id = Integer.parseInt(arr[0]);
                String name = arr[1];
                double amt = Double.parseDouble(arr[2]);

                records.add(new Customer(id, name, amt));
            }

        } catch (IOException e) {
            System.out.println("File reading error: " + e.getMessage());
        }
    }
}