package encrypt;

import encrypt.models.PasswordStore;

public class App {

    public static void main(String[] args) {

        // Create a new PasswordStore object
        PasswordStore pass1 = new PasswordStore("Akun Instagram", "Zeinshirou", "IsThisEvenAPassword?");
        pass1.setCategory(PasswordStore.CAT_MOBILEAPP);
        System.out.println(pass1);
        System.out.println("Username: "+ pass1.username +" Password: " + pass1.getPassword());

    }
}
