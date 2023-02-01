package com.example.pragraplex.validation;

import com.example.pragraplex.entity.Customer;
import com.example.pragraplex.exceptions.UnsupportedLoginEmailException;
import com.example.pragraplex.exceptions.UnsupportedLoginNameException;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;

import java.util.regex.Pattern;

public class CustomerValidation {
    public static boolean customerValidation(Customer customer){
        if(customer.getLogin() == null){
            throw new UnsupportedLoginNameException("Login Name can't be null");
        }
        if(!Pattern.matches("[a-zA-Z0-9_]+@[a-z]+[.][a-z]{2,3}", customer.getEmail())){
            throw new UnsupportedLoginEmailException("Please enter a valid email address!");
        }
        if(customer.getFirstName() != null){
            customer.setFirstName(customer.getFirstName().trim());
        }
        if(customer.getLastName() != null){
            customer.setLastName(customer.getLastName().trim());
        }
        customer.setEmail(customer.getEmail().trim());
        customer.setLogin(customer.getLogin().trim());
        System.out.println("|" +customer.getLogin()+"|\n"
                + "|" +customer.getEmail() + "|\n"
                + "|" +customer.getFirstName() + "|\n"
                + "|" +customer.getLastName() + "|\n");
        return true;
    }
    /*
    public static void stringTrim(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    */
}
