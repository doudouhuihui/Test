package base;

public class MethodClassTest {
    private String a = "123";
    private static void show() {
        int a = 2;
        class Inner {

            private String a = "789";
            private void show() {
                System.out.println(a);
                System.out.println(new MethodClassTest().a);
            }
        }
        Inner inner = new Inner();
        inner.show();
    }
    public static void main(String[] args) {
        MethodClassTest test = new MethodClassTest();
        test.show();
    }
}
