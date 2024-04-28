package encrypt.models.pages;

import encrypt.models.components.HLine;
import encrypt.models.components.Input;
import encrypt.models.components.Label;
import encrypt.models.components.SelectInput;
import encrypt.models.components.Space;
import encrypt.models.data.DataPassword;
import encrypt.models.dataHandling.PasswordStore;

public class InputPage extends BasePage {

    public int width;

    Input nameInput;
    Input usernameInput;
    Input passInput;
    SelectInput catInput;
    PasswordStore passStr;

    public InputPage(int width) {
        super("Aplikasi Penyimpanan Password", width);
        this.width = width;

        this.hline = new HLine(width);
        this.space = new Space(width);
        this.label = new Label(title, width);
    }

    @Override
    public void drawContent() {
        String [] pagesList = {
            "Uncategorized",
            "Web Application",
            "Mobile Application",
            "Another Account"
        };
        
        nameInput = new Input("Data Label: ");
        nameInput.draw();
        usernameInput = new Input("Username: ");
        usernameInput.draw();
        passInput = new Input("Password: ");
        passInput.draw();
        catInput = new SelectInput("Select Category: ", pagesList, this.width);
        catInput.draw();
        PasswordStore data = new PasswordStore(nameInput.getValue(), usernameInput.getValue(), passInput.getValue(), catInput.getValue() - 1);
        try {
            DataPassword.loadCSVData();
            DataPassword.passData.add(data);
            DataPassword.saveCSVData();
            this.label = new Label("---- ----", this.width);
            this.label.draw();
            this.space.draw();
            this.label = new Label("Data saved successfully", this.width);
            this.label.draw();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
