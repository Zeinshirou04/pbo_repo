package encrypt.models.components;

public class Label {
    public String text;
    public int width;

    public Label(String text, int width) {
        this.text = text;
        this.width = width;
    }
        
    public void draw() {
        System.out.print("| " + this.text);
        for(int i = 0; i < this.width - 1 - this.text.length(); i++) {
            System.out.print(" ");
        }
        System.out.println("|");
    }
}
