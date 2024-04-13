package encrypt.models.components;

public class HLine {
    public int width;
    public String line = "=";
    
    public HLine() {

    }

    public HLine(String line, int width) {
        this.line = line;
        this.width = width;
    }

    public HLine(int width) {
        this.width = width;
    }

    public void draw() {
        System.out.print("|");
        for(int i = 0; i < this.width; i++) {
            System.out.print(this.line);
        }
        System.out.println("|");
    }
}
