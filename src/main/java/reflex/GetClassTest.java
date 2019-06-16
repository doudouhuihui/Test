package reflex;

/**
 *
 */
public class GetClassTest {
    public static void main(String[] args) {
        dotClass1();
        reflex();
    }

    public static void dotClass1(){
        System.out.println("first:" + Person.class);
    }

    public static void getClass2(){
        System.out.println("second:" + new Person().getClass());
    }

    public static void reflex(){
        try {
            System.out.println("third:" + Class.forName("reflex.Person"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
class Person{}
