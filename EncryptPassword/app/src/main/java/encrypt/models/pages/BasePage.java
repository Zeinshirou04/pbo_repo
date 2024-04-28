package encrypt.models.pages;

import java.util.ArrayList;

import encrypt.models.components.Components;
import encrypt.models.components.HLine;
import encrypt.models.components.Label;
import encrypt.models.components.Space;

abstract public class BasePage {
    public String title;
    public int width;

    HLine hline;
    Space space;
    Label label;
    ArrayList<Components> components = new ArrayList<>();

    public BasePage(String title, int width) {
        this.title = title;
        this.width = width;

        this.hline = new HLine(width);
        this.space = new Space(width);
        this.label = new Label(title, width);
    }

    public BasePage(int width) {
        this.width = width;

        hline = new HLine(width);
        space = new Space(width);
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

    abstract public void drawContent();

    public void drawFooter() {
        this.space.draw();
        this.hline.draw();
    }
}
