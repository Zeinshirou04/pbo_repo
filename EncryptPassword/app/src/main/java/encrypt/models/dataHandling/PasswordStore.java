package encrypt.models.dataHandling;

import encrypt.models.encryptor.Encryptor;

public class PasswordStore {

    // Declaring Variables
    // Using protected instead of private to allow access from other classes
    public String name, username;
    private String password, hashkey;
    private double score;
    private int category;

    // Static Constant for Category
    public static final int UNCATEGORIZED = 0;
    public static final int CAT_WEBAPP = 1;
    public static final int CAT_MOBILEAPP = 2;
    public static final int CAT_OTHER = 3;

    // Call the Encryptor function
    Encryptor encryptor = new Encryptor();

    public PasswordStore(String name, String username, String plainPass) {
        
        try {
            this.hashkey = encryptor.generateKey();
        } catch(Exception e) {
            System.out.println(e);
        }

        // Receive the information
        this.name = name;
        this.username = username;
        setPassword(plainPass);
        setCategory(UNCATEGORIZED);; // Asigning Value 0 to category
    }

    public PasswordStore(String name, String username, String plainPass, int category) {

        try {
            this.hashkey = encryptor.generateKey();
        } catch(Exception e) {
            System.out.println(e);
        }
        
        // Receive the information
        this.name = name;
        this.username = username;
        setPassword(plainPass);
        setCategory(category);
    }

    public PasswordStore(String name, String username, String plainPass, int category, String hashKey, double score) {
        
        // Receive the information
        this.name = name;
        this.username = username;
        this.hashkey = hashKey;
        this.score = score;
        setPassword(plainPass);
        setCategory(category);
    }
    
    public void setPassword(String plainPass) {
        try {
            this.password = Encryptor.encrypt(plainPass, this.hashkey);
            calculateScore(plainPass);
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public String getPassword() {
        String plainPass = "";
        try {
            plainPass = Encryptor.decrypt(this.password, this.hashkey);
        } catch(Exception e) {
            System.out.println(e);
        }
        return plainPass;
    }

    public String getEncPassword() {
        return this.password;
    }

    public String getHashkey() {
        return this.hashkey;
    }

    public double getScore() {
        return this.score;
    }
    
    public void setCategory(int category) {
        this.category = UNCATEGORIZED; // Asigning Value 0 to category
        if (category >= 0 && category <= 3) this.category = category; // If category isn't between 0 and 3, then it'll remain UNCATEGORIZED or 0
    }

    public String getCategory() {
        String category = "";
        switch (this.category) {
            case UNCATEGORIZED:
                category = "Uncategorized";
                break;
            case CAT_WEBAPP:
                category = "Aplikasi Web";
                break;
            case CAT_MOBILEAPP:
                category = "Aplikasi Mobile";
                break;
            case CAT_OTHER:
                category = "Akun Lainnnya";
                break;

            default:
                break;
        }
        return category;
    }

    public int getCategoryCode() {
        return this.category;
    }
    
    public void calculateScore(String plainPass) {
        this.score = (plainPass.length() >= 15) ? 10 : (plainPass.length() * 10 / 15);
    }

    @Override
    public String toString() {
        return "Nama: " + this.name + "\n" +
                "Username: " + this.username + "\n" +
                "Password: " + this.password + "\n" +
                "HashKey: " + this.hashkey + "\n" +
                "Kategori: " + getCategory() + "\n" +
                "Skor: " + this.score;
    }
}
