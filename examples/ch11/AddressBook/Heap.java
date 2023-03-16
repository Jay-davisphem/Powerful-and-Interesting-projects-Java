import java.util.*;
class Heap{
  private Object[] heap, sortedList;
  public Heap(Object[] data) {
    setData(data, 0, data.length-1);
  }

  public void setData(Object[] data, int start, int end) {
    assert end >= start: "Error: Inconsistent endpoints.";
    heap = new Object[data.length];
    sortedList = new Object[data.length];
    for (int i = 0; i < data.length; i++)
      heap[i] = data[i];
  }
  private Object max(Object obj1, Object obj2){
    if(obj1.compareTo(obj2) == 1) return obj1;
    return obj2;
  }
  private boolean isValidHeap(Object[] heap, int start, int end){
    for(int i =  start; i < end/2; i++)
      if(heap[i].compareTo(max(heap[2*i+1], heap[2*i+2])) == -1)
        return false;
    return true;
  }

  private int maxChild(int loc, int end){
    int rightIndex = 2*loc + 2;
    int leftIndex = 2*loc + 1;

    assert leftIndex <= end: "Error: node at position " + loc + "has no children";
    
    if(rightIndex <= end && (heap[leftIndex].compareTo(heap[rightIndex]) == -1)) return rightIndex;
    else return leftIndex;
  }
  private void swap(int loc1, int loc2){
    Object tmp;
    tmp = heap[loc1];
    heap[loc1] = heap[loc2];
    heap[loc2] = tmp;
  }
  public void print(int lim){
    for (int i = 0; i < lim; i++)
      System.out.print(" " + heap[i].toString());
    System.out.println("    ");
  };
  public void print(){
    for (int i = 0; i < heap.length; i++)
      System.out.print(" " + heap[i]);
    System.out.println("    ");
  };
  public Object[] sort(){
    heapify();
    extract();
    return sortedList;
  }
  public void printSort(){
    for(int i = 0; i < sortedList.length; i++)
      System.out.print(sortedList[i].toString()+" ");
    System.out.println();
  }
  public void heapify(){
    int cur, maxIndex;
    boolean done;

    for(int i = (heap.length-2) / 2; i >= 0; i--){
      cur =  i;
      done = false;

      while(!done){
        if(2*cur+1 >  heap.length-1)
          done = true;
        else{
          maxIndex = maxChild(cur, heap.length-1);
          if(heap[leftIndex].compareTo(heap[rightIndex]) == -1){
            swap(cur, maxIndex);
            cur = maxIndex;
          }else
            done = true;
        }
      }
      assert isValidHeap(heap, i, heap.length-1): "Error: Construction phase is not working correctly";
    }
  }

  public Object heapPop(){
    Object val = heap[0];
    System.out.println("It's here");
    Object[] newHeap = new Object[heap.length-1];
    for(int i = 1; i < heap.length; i++)
      newHeap[i] = heap[i];
    heap = newHeap;
    heapify();
    return val;
  }
  public void heapPush(int val){
    Object[] newHeap = new Object[heap.length+1];
    for(int i = 0; i < heap.length+1; i++)
      newHeap[i] = heap[i];
    heap = newHeap;
    heapify();
  }
  private void extract(){
    int cur, maxIndex;
    boolean done;

    for(int size = heap.length-1; size >= 0; size--){
      sortedList[size] = heap[0];
      heap[0] = heap[size];

      cur = 0;
      done = false;
      while(!done){
        if(2*cur+1 > size)
          done = true;
        else{
          maxIndex = maxChild(cur, size);
          if(heap[cur].compareTo(heap[maxIndex]) == -1){
            swap(cur, maxIndex);
            cur = maxIndex;
          }else
            done = true;
        }
      }
      assert isValidHeap(heap, size, heap.length-1): "Error: Construction phase is not working correctly";
      print(size);
    }
  }

  public static void main(String[] args){
    Object list[] = {23, 17, 5, 90, 12, 44, 38, 84, 77};
    Object persons[] = new Person[4];
    persons[0] = new Person("David Oluwafemi", 25, 'M');
    persons[0] = new Person("Oyebadejo Michael", 21, 'M');
    persons[0] = new Person("Olatunji Michael", 22, 'M');
    persons[0] = new Person("Adeaga David", 26, 'M');
    Heap heap = new Heap(list);
    Heap heap2 = new Heap(persons);
    heap.print();
    heap.heapify();
    heap.print();
    heap.sort();
    heap.printSort();

    heap2.print();
    heap2.heapify();
    heap2.print();
    heap2.sort();
    heap2.printSort();
  }
}
