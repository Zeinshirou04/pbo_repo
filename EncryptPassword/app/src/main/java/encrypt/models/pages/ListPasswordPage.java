package encrypt.models.pages;

import encrypt.models.components.HLine;
import encrypt.models.components.Input;
import encrypt.models.components.Label;
import encrypt.models.components.Space;
import encrypt.models.data.DataPassword;
import encrypt.models.dataHandling.PasswordStore;

public class ListPasswordPage extends BasePage {

    public ListPasswordPage(int width) {
        super("Aplikasi Penyimpanan Password", width);
        this.width = width;

        this.hline = new HLine(width);
        this.space = new Space(width);
        this.label = new Label(title, width);
    }

    @Override
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
}
