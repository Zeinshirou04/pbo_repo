package encrypt.models.pages;

import encrypt.models.components.HLine;
import encrypt.models.components.Space;
import encrypt.models.components.Label;
import encrypt.models.components.SelectInput;

public class MainPage {
    
    public String title;
    public int width;

    private Label label;
    private final HLine hline;
    private final Space space;

    public MainPage(String title, int width) {
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
        this.draw();
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
            "Register Data",
            "View Saved Data",
            "Exit Application"
        };

        SelectInput pageSelect = new SelectInput("Select Page: ", pagesList, this.width);

        int value;

        pageSelect.draw();
        value = pageSelect.getValue();
        switch(value) {
            case 1:
                InputPage inputPage = new InputPage("Data Registration", this.width);
                inputPage.draw();
                break;
            case 2:
                ListPasswordPage listPasswordPage = new ListPasswordPage("Saved Data", this.width);
                listPasswordPage.draw();
                break;
            case 3:
                this.drawFooter();
                this.space.draw();
                this.label = new Label("Exiting Application...", this.width);
                this.label.draw();
                this.drawFooter();
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                System.exit(0);
                break;
            default:
                this.label = new Label("Invalid Input", this.width);
                break;
        }
    }

    public void drawFooter() {
        this.space.draw();
        this.hline.draw();
    }
}
