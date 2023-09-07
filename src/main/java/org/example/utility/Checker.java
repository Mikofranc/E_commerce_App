package org.example.utility;

import org.example.exception.InvalidInputException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checker {

    public static boolean usernameAndPassword(String username, String password){
        if(checkUsername(username) && checkPassword(password) )return true;
        throw new InvalidInputException("Invalid input");
    }
    public static  boolean checkStringInput(String input){
        if(checkName(input))return true;
        throw new InvalidInputException("Invalid input");
    }


    private static boolean checkUsername(String input){
        String regex = "^[a-z0-9]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return  matcher.matches();
    }
    private static  boolean checkName(String input){
        String regex ="[A-z]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return  matcher.matches();
    }

    private static boolean checkPassword(String password){
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return  matcher.matches();
    }




}
