package base;

public class StaticClassTest {
    public static class Inner {
        private static String name = "456";
        public void show() {
            System.out.println(name);
            System.out.println(StaticClassTest.name);
        }
    }
    private static String name = "123";
    public static void main(String[] args) {
        new StaticClassTest.Inner().show();
    }
}
