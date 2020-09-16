package nl.novi.bvs.course_javaprogr.ch2;

public class TestConcat {
    public static void main (String[]args){
        String a ="The result is " + 12 + 23;
        String B = "jjjjj";
        System.out.println(a);//1223
        a ="But now the result is " + (12 + 23);//35
        System.out.println(a);
    }
}
