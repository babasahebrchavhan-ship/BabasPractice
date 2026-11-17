package BasicsDemo;

public class OopsConceptsDemo {

    int a;
    int b;

    OopsConceptsDemo(int a, int b) {
        this.a = 9;
        this.b = b;
        System.out.println("Value of a in constructor: " + a);
    }

    public void display() {
        System.out.println("Value of a in display funtion: " + this.a);
        System.out.println("Value of b: " + this.b);

    }

    public static void main(String[] args) {
        OopsConceptsDemo obj = new OopsConceptsDemo(10, 20);
        obj.display();
    }

}
