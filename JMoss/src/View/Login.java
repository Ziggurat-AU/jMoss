package View;

import Controller.LoginController;

import java.io.IOException;
import java.util.Scanner;

public class Login {

    public static void main(String args[]) throws IOException {

        LoginController uLoginController=new LoginController();
        String uName=null;
        String password=null;
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to jMOSS- Java based Movie Search System");

        do {
        System.out.println("Enter your username");
        uName=sc.next();
        System.out.println("Enter your Password");
        password=sc.next();
        if(uLoginController.checkLogin(uName,password))
        {

        }
        else
        {
            System.out.println("Wrong Credentials.Try Again");
        }
        }while(!uLoginController.checkLogin(uName,password));
        do {

            System.out.println();

        }
        while (true);
    }
}
