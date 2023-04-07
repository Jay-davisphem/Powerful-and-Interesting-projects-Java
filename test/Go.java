import libs.a.aa.*;
class Go extends A{
    public String toString(){
        return "I turned string";
    }

    public static void main(String[] args){
        A a = new Go();
        System.out.println(a.toString());
    }
}

