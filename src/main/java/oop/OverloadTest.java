package oop;

public final class OverloadTest {
}

final class OverLoad{
    //这三个都是重载, 方法名相同，参数列表不同，其他都随意
    public void get(){}
    private void get(int a){}
    protected String get(String b) throws Exception{ return null;}
}
