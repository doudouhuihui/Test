import java.util.*;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        ArrayList arrayList = new ArrayList();
       long a = System.currentTimeMillis();
       for (int i = 0; i < 2_000; i++) {
           int x = random.nextInt(i+1);
           arrayList.add(x,i);
       }
       long b = System.currentTimeMillis();
        System.out.println(b-a);

        LinkedList linkedList = new LinkedList();
        long c = System.currentTimeMillis();
        for (int i = 0; i<2_000;i++) {
            int x = random.nextInt(i+1);
            linkedList.add(x,i);
        }
        long d = System.currentTimeMillis();
        System.out.println(d-c);


    }
}
class A implements Comparable{
    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public A(){}
    public A(String name){this.name = name;}

    @Override
    public int compareTo(Object o) {
        A a = (A)o;
        return name.length()-a.getName().length();
    }
}
