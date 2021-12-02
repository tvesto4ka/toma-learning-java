package helpers;

public class Greeting {
    private String hi = "Hello";
    private String bye = "Goodbye";

    public Greeting (){
        hi = "Hello";
        bye = "Goodbye";
    }

    public void sayHi () {
        System.out.println(hi);
    }

    public void sayBye() {
        System.out.println(bye);
    }
}
