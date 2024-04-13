package encrypt.models.components;

public class HLine {
    public int width;

    public HLine() {
        
    }

    public HLine(int width) {
        this.width = width;
    }

    public void draw() {
        System.out.print("|");
        for(int i = 0; i < this.width; i++) {
            System.out.print("=");
        }
        System.out.println("|");
    }
}
