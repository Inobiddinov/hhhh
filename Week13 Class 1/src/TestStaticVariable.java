public class TestStaticVariable {
    public static void main(String []args){
        myVar m1 = new myVar();
        m1.num =10;
        m1.num2 =100;

        myVar m2 = new myVar();
        m2.num=20;
        m2.num2=200;

        System.out.printf("M1:  num:%d,  num2:%d\n",m1.num, m1.num2);
        System.out.printf("M2:  num:%d,  num2:%d\n",m2.num, m2.num2);

        m1.num2 = 300;
        System.out.printf("M1:  num:%d,  num2:%d\n",m1.num, m1.num2);
        System.out.printf("M2:  num:%d,  num2:%d\n",m2.num, m2.num2);

        myVar.num2 = 1000;
        //MyVar.num =1000; //syntax error bcos num is not a static variable
        System.out.printf("M1:  num:%d,  num2:%d\n",m1.num, m1.num2);
        System.out.printf("M2:  num:%d,  num2:%d\n",m2.num, m2.num2);
        System.out.println(myVar.num2);
    }
}

class myVar {
    int num=0;
    static int num2=0;
}