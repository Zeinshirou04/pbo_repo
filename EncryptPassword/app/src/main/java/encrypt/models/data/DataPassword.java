package encrypt.models.data;

import java.util.ArrayList;
import java.io.FileWriter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import encrypt.models.dataHandling.PasswordStore;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class DataPassword {

    // Class untuk menyimpan variable static
    public static final ArrayList<PasswordStore> passData = new ArrayList<>();

    // Digunakan sebagai path file csv dan header pada file csv
    private static final String csvPath = "./app/src/main/java/encrypt/assets/data/dataPassword.csv";
    // private static final String csvPath = "./dataPassword.csv";
    private static final String [] csvHeader = {
        "name", "username", "password", "hashkey", "category", "score"
    }; 

    // Method untuk menyimpan data CSV
    public static void saveCSVData() {
        if(passData.isEmpty()) {
            System.out.println("Tidak ada yang disimpan");
        } else {
            try {
                FileWriter csvWriter = new FileWriter(csvPath);
                CSVFormat csvFormater = CSVFormat.DEFAULT.builder().setHeader(csvHeader).build();
                try (CSVPrinter csvPrinter = new CSVPrinter(csvWriter, csvFormater)) {
                    for(PasswordStore pass: passData) {
                        csvPrinter.printRecord(pass.name, pass.username, pass.getEncPassword(), pass.getHashkey(), pass.getCategoryCode(), pass.getScore());
                        // System.out.println("Data berhasil disimpan");
                    }
                    csvPrinter.flush();
                }
            } catch(Exception ex) {
                Logger.getLogger(DataPassword.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static ArrayList<PasswordStore> loadCSVData() {
        passData.clear();
        try {
            FileReader csvReader = new FileReader(csvPath);
            CSVFormat csvFormater = CSVFormat.DEFAULT.builder().setHeader(csvHeader).setSkipHeaderRecord(true).build();
            Iterable<CSVRecord> data = csvFormater.parse(csvReader);
            for(CSVRecord record: data) {
                PasswordStore newPass;
                if(record.get("hashkey") == null) {
                    newPass = new PasswordStore(
                        record.get("name"),
                        record.get("username"),
                        record.get("password"),
                        Integer.parseInt(record.get("category")));
                } else {
                    newPass = new PasswordStore(
                        record.get("name"),
                        record.get("username"),
                        record.get("password"),
                        Integer.parseInt(record.get("category")),
                        record.get("hashkey"),
                        Double.parseDouble(record.get("score")));
                }
                passData.add(newPass);
            }
        } catch(FileNotFoundException ex) {
            Logger.getLogger(DataPassword.class.getName()).log(Level.SEVERE, null, ex);
        } catch(Exception ex) {
            Logger.getLogger(DataPassword.class.getName()).log(Level.SEVERE, null, ex);
        }
        return passData;
    }
}
