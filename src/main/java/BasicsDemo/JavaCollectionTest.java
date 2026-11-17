package BasicsDemo;

import org.apache.commons.collections4.functors.WhileClosure;
import org.testng.annotations.Test;

import java.util.*;

public class JavaCollectionTest {
    @Test
    public void stackOps(){
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        System.out.println("Stack elements are: "+stack);
        System.out.println("Stack peek element is: "+stack.peek());
        System.out.println("Stack pop element is: "+stack.pop());
        System.out.println("Stack elements after pop operation are: "+stack);
        System.out.println("Stack element size is: "+stack.size());
    }
    @Test
    public void listOperations(){
        int[] a =new int[4];
        a[0]=1;
        a[1]=2;
        a[2]=3;
        a[3]=4;
        for(int i:a){
            System.out.println(i);
        }


            //1. Checking if an element is present in the list using containsAll() method
        List<String> list1=new ArrayList<>();
        list1.add("one");
        list1.add("two");
        list1.add("three");
        List<String> list2=new ArrayList<>();
        list2.add("two");
        list2.add("three");

        //RetainAll() method is used to retain the elements of list1 which are present in list2
        list1.retainAll(list2);
        System.out.println("List after retainAll operation: "+list1);
        System.out.println("List1:"+list1);
        System.out.println("List2:"+list2);

        //containsAll() method is used to check if all the elements of list2 are present in list1
        boolean listCheck=list1.containsAll(list2);
        System.out.println("List contains all elements of list2: "+listCheck);

        //Checking if two list are equal using equals() method
        boolean equalListCheck=list1.equals(list2);
        System.out.println("List is equal to list2: "+equalListCheck);

        //Return HashCode of the list using hashCode() method
        System.out.println("HashCode of list1: "+list1.hashCode());

        //Check Hashcode of the a each element of list using hashCode() method
        Iterator<String> itr=list1.iterator();
        while(itr.hasNext()){
            String value=itr.next();
            System.out.println("HashCode of element "+value+" is: "+value.hashCode());
        }

        //size() method is used to get the size of the list
        System.out.println("Size of list1: "+list1.size());

        //parallelStream() method is used to get the parallel stream of the list
        list1.parallelStream().forEach(System.out::println);
        System.out.println("Count of elements in list1: "+list1.stream().count());

        list1.parallelStream().filter(e->e.length()>3).forEach(System.out::println);
        list1.parallelStream().filter(e->e.startsWith("t")).forEach(System.out::println);
        list1.parallelStream().map(e->e.toUpperCase()).forEach(System.out::println);

    }
    @Test
    public void iterateDemo() {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        boolean numbers=list.contains("three");
        System.out.println("List contains three: "+numbers);
        System.out.println("List Before removal elements are:" + list);
        Iterator<String> itr = list.iterator();//Iterator is used to traverse the collection
        while (itr.hasNext()) {                     //checking the next element is present or not
            if (itr.next().equals("three")) {       //checking the next element is equal to three or not
                itr.remove();                       //removing the element from the list
                //list.add("three-A");//We can not do this because it will throw ConcurrentModificationException
                //for this we can use listIterator() method
            }
            //System.out.println("Element: " + itr.next());//printing the next element
        }
        System.out.println("After removal, List elements are:" + list);
    }

    @Test
    public void combineTwoList() {
        List<String> list = new ArrayList<>();
        list.add("Babasaheb");
        list.add("Rajaram");
        list.add("Chavhan");
        list.add(3,"Pune");
        Iterator<String> itr = list.iterator();
        System.out.println("Elements of first list are:");
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        List<String> list1 = new ArrayList<>();
        list1.add("one");
        list1.add("two");
        list1.add("three");
        Iterator<String> itr1 = list1.iterator();

        System.out.println("Elements of second list are:");
        while (itr1.hasNext()) {
            System.out.println(itr1.next());
        }

        list.addAll(list1);
        System.out.println("After combining two list elements are:");
        Iterator<String> itr2 = list.iterator();
        while (itr2.hasNext()) {
            System.out.println(itr2.next());
        }
        System.out.println(list);
        list1.clear();
        System.out.println("After clearing second list elements are:"+list1);

}

@Test
public void listIteratorTest() {
    List<String> list = new ArrayList<>();
    list.add("A");
    list.add("B");
    list.add("C");
    list.add("D");
    System.out.println("List Before removal elements are:" + list);

    ListIterator<String> listItr = list.listIterator();//ListIterator is used to traverse the collection
    //Traversing the list in forward direction
    System.out.println("Traversing the list in forward direction");
    while (listItr.hasNext()) {
        System.out.println(listItr.next());
    }
    //Traversing the list in backward direction
    System.out.println("Traversing the list in backward direction");
    while (listItr.hasPrevious()) {
        System.out.println(listItr.previous());
    }
    //Traversing list with Index
    System.out.println("Traversing list with Index");
    while (listItr.hasNext()) {
        System.out.println("Index:" + listItr.nextIndex() + " Element:" + listItr.next());
    }
    //Traversing list with Index in backward direction
    System.out.println("Traversing list with Index in backward direction");
    while (listItr.hasPrevious()) {
        System.out.println("Index: " + listItr.previousIndex() + " Element: " + listItr.previous());
    }
    while (listItr.hasNext()) {
        if (listItr.next().equals("C")) {
            listItr.add("C-1");//We can do this because we are using ListIterator
        }
    }
    System.out.println("List after adding C-1: " + list);
    while (listItr.hasPrevious()) {
        System.out.println("Iterator after add previous: " + listItr.previous());
    }
    //Removing the element from the list
    while (listItr.hasNext()) {
        if (listItr.next().equals("B")) {
            listItr.remove();//removing the element from the list"
        }
    }
    while (listItr.hasPrevious()) {
        System.out.println("Iterator after remove previous: " + listItr.previous());
    }
    System.out.println("List after removing B: " + list);
}
}
