

public class MyTest {
    public static void main(String[] args) throws Exception{
        // 0 1 1 2 3 5 8

     Integer a = 188;
     Integer c = 188;
     String b = "188";
     System.out.println(a.equals(b));
        System.out.println(b.equals(a.toString()));
        System.out.println(a==c);
        System.out.println(a.equals(c));
        System.out.println(Integer.valueOf(b).equals(a));


    }

    private static int fino(int a) throws Exception  {
        if (a <= 0) {
            return 0;
        }
        if (a < 3) {
            return 1;
        }
        int i = 1;  //��һ��
        int j = 1;  //�ڶ���
        int s = 0;
        for (int k = 2; k < a; k++) {
            s = i + j;
            i = j;
            j = s;
        }
        return s;
    }


    //ֻ��������
    private static int sort(int a) throws Exception {
        if (a < 0) {
            throw new Exception("");
        }
        if (a < 2) {
            return a;
        }


        return sort(a - 1) + sort(a - 2);



    }
}
