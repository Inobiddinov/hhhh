public class TestStaticConstant {
    public static void main(String[] args) {

        MyVar2 mv = new MyVar2();

        System.out.println(mv.NUMBER);
        System.out.println(mv.COUNT);
        System.out.println(mv.VALUE);

        MyVar2 mv2 = new MyVar2();
        System.out.println(mv.NUMBER);
        System.out.println(mv.COUNT);
        System.out.println(mv.VALUE);


        System.out.println(MyVar2.COUNT);
        System.out.println(MyVar2.VALUE);
       // System.out.println(MyVar2.NUMBER);//Syntax error bcos NUmber is not static
    }
}


class MyVar2{
    final int NUMBER = 10;
    final static int  COUNT = 10;
    static final int VALUE =10;
}
