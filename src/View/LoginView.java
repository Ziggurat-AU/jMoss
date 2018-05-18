package View;

import Controller.LoginController;
import java.util.Scanner;

public class LoginView {
    public LoginView() throws Exception {
        LoginController loginController=new LoginController();
        String userName=null;
        String password=null;
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to jMOSS- Java based Movie Search System");

        do {
        System.out.println("Enter your username");
            userName=sc.next();
        System.out.println("Enter your Password");
        password=sc.next();
        if(loginController.auth(userName,password))
        {
            MainMenuView mainMenuView = new MainMenuView();
        }
        else
        {
            System.out.println("Wrong Credentials.Try Again");
        }
        }while(!loginController.auth(userName,password));
    }
}
