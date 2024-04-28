package encrypt.models.components;

public class Space implements Components {
    
    public int length;

    public Space(int length) {
        this.length = length;
    }

    @Override
    public void draw() {
        System.out.print("|");
        for(int i = 0; i < this.length; i++) {
            System.out.print(" ");
        }
        System.out.println("|");
    }
}
