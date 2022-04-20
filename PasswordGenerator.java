import java.util.Scanner;
import java.util.Random;

public class PasswordGenerator {
    private static String allCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()";
    
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("How many characters do you want?");
        String userInput = sc.nextLine();
        int characterNumber = Integer.parseInt(userInput);
        System.out.println(GeneratePassword(characterNumber));

    }
    public static String GeneratePassword(int characterNumber) {
        Random rand = new Random();
        String password = "";
        for(int i = 0;i < characterNumber;i++) {
            int getRandomChar = rand.nextInt(allCharacters.length());
            password = allCharacters.substring(getRandomChar, getRandomChar+1);
        }
        
        for(int i = 0;i < 5; i++) {
            String newPassword = password;
            String oldPassword = newPassword;
            newPassword = oldPassword.substring(i, i+1);
        }
        return newPassword;
    }
}