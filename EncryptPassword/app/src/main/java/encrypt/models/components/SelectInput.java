package encrypt.models.components;

import java.util.InputMismatchException;

public class SelectInput implements Components {

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

    @Override
    public void draw() {
        System.out.println("| " + this.label);
        for(int i = 0; i < this.selection.length; i++) {
            System.out.print("| ");
            System.out.println(" [" + (i + 1) + "]" + this.selection[i]);
        }
        System.out.print("| Pilihan: ");
        try {
            this.value = this.input.input.nextInt();
        } catch (InputMismatchException e) {
            this.value = 00;
        }
    }

    public int getValue() {
        return this.value;
    }
}
