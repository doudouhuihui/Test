package base;

public class MethodParamTest {
    public static void main(String[] args) {
        int a = 5;
        System.out.println(a);
        change1(a);
        System.out.println(a);

        User user = new User();
        user.setName("chen");
        System.out.println(user);
        change2(user);
        System.out.println(user);

        String str = "chenwz";
        System.out.println(str);
        change3(str);
        System.out.println(str);

    }

    private static void change1(int a){
        a = 10;
    }
    private static void change2(final User user){
        user.setName("shan");
    }
    private static void change3(String str){
        str += "shan";
    }
}
class User{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}

