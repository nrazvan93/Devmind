package Main;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here


//        System.out.println(Postfix.toPostfix("((1+3+2"));
//        System.out.println(Postfix.fromInfix("1+3+2"));
//        System.out.println(Postfix.fromInfix("4*4+5+3-2+1"));
//        System.out.println(Postfix.fromInfix("1+3^2"));
        System.out.println(Postfix.eval("3 2 1 + 2 3 2 ^ ^ * + 8 5 1 2 * 2 / - / -"));

    }
}
