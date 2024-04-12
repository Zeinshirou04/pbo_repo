package encrypt.models.components;

public class SelectInput {

    public String label;
    public int width;
    public String [] selection;
    public int value;
    public Input input;
    
    public SelectInput(String label, String [] selection, int width) {
        this.label = label;
        this.width = width;
        this.selection = selection;
        this.input = new Input(label);
    }

    public void draw() {
        for(int i = 0; i < this.selection.length; i++) {
            System.out.print("| ");
            System.out.println("[" + (i + 1) + "]" + this.selection[i]);
        }
        System.out.print("| Pilihan: ");
        this.value = this.input.input.nextInt();
    }

    public int getValue() {
        return this.value;
    }
}
