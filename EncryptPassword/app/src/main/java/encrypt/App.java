package encrypt;

import encrypt.models.pages.MainPage;

public class App {
    public static void main(String[] args) {
        // System.out.println(System.getProperty("user.dir"));
        new MainPage("Password Store Application", 70).draw();
    }
}
