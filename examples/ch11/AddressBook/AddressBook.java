import java.util.*;
interface AbstractAddressBook {
  public void add(Person newPerson);
  public boolean delete(String searchName);
  public Person search(String searchName) ;
  public Person[] sort(int attribute);
}

class AddressBook implements AbstractAddressBook{
  private static final int DEFAULT_SIZE = 25;
  private Map<String, Person> entry;
  //Inner class for comparing age
  class AgeComparator implements Comparator<Person> {
    private final int LESS = -1;
    private final int EQUAL = 0;
    private final int MORE = 1;

    public int compare(Person p1, Person p2) {
      int comparisonResult;
      int p1age = p1.getAge( );
      int p2age = p2.getAge( );
      if (p1age < p2age) {
        comparisonResult = LESS;
      } else if (p1age == p2age) {
        comparisonResult = EQUAL;
      } else {
        assert p1age > p2age;
        comparisonResult = MORE;
      }
      return comparisonResult;
    }
  }

  //Inner class for comparing name
  class NameComparator implements Comparator<Person> {
    public int compare(Person p1, Person p2) {
      String p1name = p1.getName( );
      String p2name = p2.getName( );
      return p1name.compareTo(p2name);
    }
  }
  private Comparator<Person> getComparator(int attribute) {
    Comparator<Person> comp = null;
    if (attribute == Person.AGE) {
      comp = new AgeComparator();
    } else {
      assert attribute == Person.NAME: "Attribute not recognized for sorting";
      comp = new NameComparator( );
    }
    return comp;
  }
  public AddressBook(){
    this(DEFAULT_SIZE);
  }
  public AddressBook(int size){
    entry = new HashMap<String, Person>(size);
  }
  public void add(Person newPerson){
    entry.put(newPerson.getName(), newPerson);
  }
  public boolean delete(String searchName){
    return  !(entry.remove(searchName) == null);
  }
  public Person search(String searchName){
    return entry.get(searchName);
  }
  public Person[] sort(int attribute){
    if (!(attribute == Person.NAME || attribute == Person.AGE))
      throw new IllegalArgumentException();
    Person[] persons = new Person[entry.size()];
    entry.values().toArray(persons);
    Arrays.sort(persons, getComparator(attribute));
    return persons;
  }
}
