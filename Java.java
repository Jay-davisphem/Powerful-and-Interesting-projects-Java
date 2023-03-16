import java.util.*;

class UseHashMap{
  public static void main(String args[]){
    Set<String> hashset = new HashSet<String>(5);
    
    hashset.add("CSC/2018/071");
    hashset.add("CSC/2018/073");
    hashset.add("CSC/2018/075");
    hashset.add("CSC/2018/076");
    hashset.add("CSC/2018/077");
    hashset.add("CSC/2018/071");
    hashset.add("CSC/2018/073");
    hashset.add("CSC/2018/075");
    hashset.add("CSC/2018/072");
    hashset.add("CSC/2018/076");
    hashset.add("CSC/2018/077");
    System.out.println(hashset.toString());
  }
}
