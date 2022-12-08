public class TestStaticMethod {
    public static void main(String[] args) {

     //    UseMethods.sub(); //syntax error
        UseMethods.sub2(); //valid
    }
}

class UseMethods {
    int num;
    static int num2;
    void sub(){}
    static void sub2 () {
      //  num = 10; //syntax error
       // num= 10; //syntax error
        num2 =20; //valid

      //  String str [] =
    }
    static void display (){
        for (int cnt=1; cnt<=30; cnt ++)
            System.out.println("=");

        System.out.println();


    }


    public static void main (String[]args){
    //    sub(); //syntax error
        sub2(); //valid
    }
}