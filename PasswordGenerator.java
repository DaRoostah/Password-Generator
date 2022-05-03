/**
 * Created by Sean Maschek
 * 
 * Purpose: To explore the different writer library
**/
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Random;

public class PasswordGenerator {
    private static String lowerCaseCharacters = "abcdefghijklmnopqrstuvwxyz";
    private static String upperCaseCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String numberCharacters = "1234567890";
    private static String specialCharacters = "!@#$%^&*()";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many characters do you want?");
        String userInput = sc.nextLine();
        int characterNumber = Integer.parseInt(userInput);
        System.out.println("How many passwords do you want printed out?");
        userInput = sc.nextLine();
        int pwNumber = Integer.parseInt(userInput);
        LinkedList<String> listofPasswords = new LinkedList<String>();
        for(int numOfPass = 0; numOfPass < pwNumber;numOfPass++) {
          listofPasswords.add(numOfPass+1 + ". " + GeneratePasswordTwo(characterNumber) + "\n");
        }
        System.out.println("\n" + getListofPasswords(listofPasswords) + "\nChoose a password:");
        userInput = sc.nextLine();
        int intUserInput = Integer.parseInt(userInput);
        editFile(selectPassword(listofPasswords, intUserInput));
        sc.close();
    }
    
    private static String selectPassword(LinkedList<String> ListofPasswords, int userInput) {
        String selectedPassword = "";
        for(int i = 0;i < ListofPasswords.size();i++) {
            if(String.valueOf(userInput).equals(ListofPasswords.get(i).substring(0,1))) {
                selectedPassword = ListofPasswords.get(i).substring(3,ListofPasswords.get(i).length());
            }
        }
        return selectedPassword;
    }

    protected static String getListofPasswords(LinkedList<String> ListOfPasswords) {
        String ListofPasswords = "";
        for(String Passwords : ListOfPasswords) {
            ListofPasswords += Passwords;
        }
        return ListofPasswords;
    }

    public static char getSpecificRandomChar(int charactersList) {
        Random rand = new Random();
        char character = ' ';
        String[] characterChooser = new String[4];
        characterChooser[0] = lowerCaseCharacters;
        characterChooser[1] = upperCaseCharacters;
        characterChooser[2] = numberCharacters;
        characterChooser[3] = specialCharacters;
        int randChar = rand.nextInt(characterChooser[charactersList].length());
        character = characterChooser[charactersList].charAt(randChar);
        return character;
    }

    public static String GeneratePasswordTwo(int characterNumber) {
        String password = "";
        int intPWswitch = 0;
        for(int passwordChar = 0; passwordChar < characterNumber; passwordChar++) {
            password += getSpecificRandomChar(intPWswitch);
            intPWswitch++;
            if(intPWswitch == 4)
                intPWswitch = 0;
        }
        return scrambleWord(password);
    }

    public static String scrambleWord(String password){
        char[] oldPassword = password.toCharArray(), newPassword = password.toCharArray();
        Random random = new Random();
        int r = random.nextInt(oldPassword.length);
        for(int i = 0;i <= r;i++){
            newPassword[oldPassword.length -i-1] = oldPassword[i];
        }
        for (int j = r+1;j <= oldPassword.length -1;j++){
            newPassword[j-r-1] = oldPassword[j];
        }
        return String.valueOf(newPassword);
    }
    
    public static void editFile(String addPassword) {
        try {
            File ListofPasswords = new File("password.txt");
            ListofPasswords.createNewFile();
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(ListofPasswords.getName(), true)));
            writer.println(addPassword);
            writer.close();
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }
}