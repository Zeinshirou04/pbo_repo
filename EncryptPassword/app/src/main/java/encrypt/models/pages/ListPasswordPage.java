package encrypt.models.pages;

import javax.xml.crypto.Data;

import encrypt.models.components.HLine;
import encrypt.models.components.Input;
import encrypt.models.components.Label;
import encrypt.models.components.Space;
import encrypt.models.data.DataPassword;
import encrypt.models.dataHandling.PasswordStore;

public class ListPasswordPage {
    public String title;
    public int width;

    private Label label;
    private final HLine hline;
    private final Space space;

    public ListPasswordPage(String title, int width) {
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
        DataPassword.loadCSVData();
        int size = this.width / 4;
        int length = DataPassword.passData.size();
        new Label(String.format("| Jumlah data terdapat sebanyak %d data", length), this.width).draw();
        this.space.draw();
        new HLine("-", this.width).draw();
        this.space.draw();
        String textFormat = "| %-" + size + "s | %-" + size + "s | %-" + size + "s |";
        for(PasswordStore data : DataPassword.passData) {
            this.label = new Label(String.format(textFormat, data.name, data.username, data.getCategory()), this.width);
            this.label.draw();
        }
        this.drawFooter();
        Input input = new Input("Press Enter to Continue");
        input.draw();
    }

    public void drawFooter() {
        this.space.draw();
        this.hline.draw();
    }
}
