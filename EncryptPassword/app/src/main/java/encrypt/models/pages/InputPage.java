package encrypt.models.pages;

import encrypt.models.components.HLine;
import encrypt.models.components.Input;
import encrypt.models.components.Label;
import encrypt.models.components.SelectInput;
import encrypt.models.components.Space;
import encrypt.models.data.DataPassword;
import encrypt.models.dataHandling.PasswordStore;

public class InputPage {

    public String title;
    public int width;

    private Label label;
    private final HLine hline;
    private final Space space;

    public InputPage(String title, int width) {
        this.title = title;
        this.width = width;

        this.hline = new HLine(width);
        this.space = new Space(width);
        this.label = new Label(title, width);
    }

    public void draw() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        this.drawHeader();
        this.space.draw();
        this.drawContent();
        this.drawFooter();
    }

    public void drawHeader() {
        this.hline.draw();
        this.space.draw();
        this.space.draw();
        this.label.draw();
        this.space.draw();
        this.space.draw();
        this.hline.draw();
    }

    public void drawContent() {
        String [] pagesList = {
            "Uncategorized",
            "Web Application",
            "Mobile Application",
            "Another Account"
        };
        
        Input name = new Input("Data Label: ");
        name.draw();
        Input username = new Input("Username: ");
        username.draw();
        Input password = new Input("Password: ");
        password.draw();
        SelectInput category = new SelectInput("Select Category: ", pagesList, this.width);
        category.draw();
        PasswordStore data = new PasswordStore(name.getValue(), username.getValue(), password.getValue(), category.getValue() - 1);
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

    public void drawFooter() {
        this.space.draw();
        this.hline.draw();
    }
}
