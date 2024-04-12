package encrypt;

import encrypt.models.components.HLine;
import encrypt.models.components.Input;
import encrypt.models.components.Label;
import encrypt.models.components.SelectInput;
import encrypt.models.components.Space;
import encrypt.models.data.DataPassword;
import encrypt.models.dataHandling.PasswordStore;

public class App {

    public static void testGUI() {    
        try {
            System.out.println(System.in.available());
        } catch (Exception e) {
            e.printStackTrace();
        }

        int width = 50, length = 50;

        new HLine(width).draw();
        new Space(length).draw();
        new Label("Uji coba komponen yang dibuat", width).draw();
        new Space(length).draw();
        new HLine(width).draw();
        new Space(length).draw();
        Input input = new Input("Masukkan nama");
        input.draw();
        Input input2 = new Input("Usia anda");
        input2.draw();
        String nama = input.getValue();
        int usia = input2.getIntValue();
        new Space(length).draw();
        String [] pilihan = {"Pilihan 1", "Pilihan 2", "Pilihan 3", "Pilihan 4"};
        SelectInput pilSelect = new SelectInput("Inputkan pilihan anda:", pilihan, width);
        pilSelect.draw();
        int value = pilSelect.getValue();
        new Space(length).draw();
        new HLine(width).draw();
        new Space(length).draw();
        new Label("Nama anda: "+nama, width).draw();
        new Label("Usia anda: "+usia, width).draw();
        new Label("Anda memilih menu: "+value, width).draw();
        new Space(length).draw();
        new HLine(width).draw();
    }

    public static void main(String[] args) {
        testGUI();

        // Create a new PasswordStore object
        PasswordStore passwordStore = new PasswordStore("Akun Instagram", "Zeinshirou", "IsThisEvenAPassword?", 2);
        DataPassword.passData.add(passwordStore);

        // Add the PasswordStore object to the passData ArrayList
        DataPassword.saveCSVData();
        DataPassword.loadCSVData();
    }
}
