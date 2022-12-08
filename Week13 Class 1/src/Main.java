public class Main {
    public static void main(String[] args) {

    }
}

class MyClass { }
// static class MyClass2{}  //syntax error

class People {
    class Eye {   //inner class
    }

   static class Ear { //inner class
    }

    static class Hand { //inner class
    }

}

class Variable {
    int num;
    static int mum2; //valid => static instance variable

    void sub() {
        int num3;
       // static int num4; //syntax error
    }
}


class Methods {
   //public static void main (String [] args){
   static public void main (String[]args){
    }
    void sub() {}
    static void sub2() {}
    public static void sub3() {} //valid
    static public void sub4() {} //valid
}

