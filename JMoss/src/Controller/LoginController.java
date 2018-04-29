package Controller;

import Util.LoginFileReading;

import java.io.IOException;

public class LoginController {


    public boolean checkLogin(String uName,String password) throws IOException {
        LoginFileReading uLoginFileReading=new LoginFileReading();
        return uLoginFileReading.auth(uName,password);


    }
}
