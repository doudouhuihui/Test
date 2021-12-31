package base;

public class NoNameTest {
    public static void main(String[] args) {
        final String str = "haha";
        new Person(){
            @Override
            public void say() {
                System.out.println(str);
            }
        }.say();
    }
}
interface Person{
   void say();
}