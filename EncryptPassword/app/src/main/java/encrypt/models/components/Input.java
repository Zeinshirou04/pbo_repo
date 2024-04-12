package encrypt.models.components;

import java.util.Scanner;

public class Input {

    public String label;
    public Scanner input;
    public String value;

    public Input(String label) {
        this.label = label;
        this.input = new Scanner(System.in);
    }

    public void draw() {
        System.out.print("| " + this.label + ": ");
        this.value = this.input.nextLine();
    }

    public String getValue() {
        return this.value;
    }

    public int getIntValue() {
        return Integer.parseInt(this.value);
    }

    public double getDoubleValue() {
        return Double.parseDouble(this.value);
    }
}
