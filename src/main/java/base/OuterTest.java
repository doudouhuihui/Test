package base;

public class OuterTest {
    private String str = "123";
    private void show(){
        System.out.println(str);
        System.out.println(new Inner().str);
        new Inner().show();
    }
    class Inner {
        private String str = "456";
        private void show() {
            System.out.println(str);
            System.out.println(OuterTest.this.str);
        }
    }
    public static void main(String[] args) {
        OuterTest.Inner inner = new OuterTest().new Inner();
        inner.show();
        new OuterTest().show();
    }
}

