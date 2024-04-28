package encrypt.models.pages;

import encrypt.models.components.Components;
import encrypt.models.components.Space;
import encrypt.models.components.Label;
import encrypt.models.components.SelectInput;

public class MainPage extends BasePage{
    
    public String errMsg;

    SelectInput pageSelect;

    public MainPage(int width) {
        super("Aplikasi Penyimpanan Password", width);
        this.components.add(new Label("Aplikasi Penyimpanan Password", width));
        this.components.add(new Label("Simpan password anda dengan aman di sini", this.width));
        this.components.add(new Space(this.width));

        String [] pagesList = {
            "Register Data",
            "View Saved Data",
            "Exit Application"
        };

        String [] pages = {"Input Password", "Tampil Password", "Keluar Aplikasi"};
        this.pageSelect = new SelectInput("Pilih halaman berikut:", pages, this.width);
        this.components.add(pageSelect);
    }

    public void drawContent() {
        
        if(this.errMsg != null) {
            new Label(this.errMsg, this.width).draw();
            this.space.draw();
        }

        for(Components widget: this.components) {
            widget.draw();
        }

        int value = pageSelect.getValue();

        switch(value) {
            case 00:
                this.errMsg = "Invalid Input (Input must be a number, text given)";
                break;
            case 1:
                new InputPage(this.width).draw();
                break;
            case 2:
                new ListPasswordPage(this.width).draw();
                break;
            case 3:
                this.drawFooter();
                this.space.draw();
                new Label("Exiting Application...", this.width);
                this.label.draw();
                this.drawFooter();
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                System.exit(0);
                break;
            default:
                this.errMsg = String.format("Invalid Input (Input must be a number between 1 and 3, %d given)", value);
                break;
        }
        new MainPage(70).draw();
    }

    public void drawFooter() {
        this.space.draw();
        this.hline.draw();
    }
}
