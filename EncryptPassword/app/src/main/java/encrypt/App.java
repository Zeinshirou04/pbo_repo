package encrypt;

import encrypt.models.pages.MainPage;

public class App {

    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        // System.out.println(System.getProperty("user.dir"));
        new MainPage(70).draw();
    }
}
