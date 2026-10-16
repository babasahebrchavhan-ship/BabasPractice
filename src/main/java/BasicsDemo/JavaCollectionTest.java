package BasicsDemo;

import org.apache.commons.collections4.functors.WhileClosure;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class JavaCollectionTest {
    @Test
    public void iterateDemo() {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
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
    public void listIteratorTest() {
        List<String> list=new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        System.out.println("List Before removal elements are:" + list);

        ListIterator<String> listItr=list.listIterator();//ListIterator is used to traverse the collection
        //Traversing the list in forward direction
        System.out.println("Traversing the list in forward direction");
        while(listItr.hasNext()){
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
            System.out.println("Index:"+listItr.nextIndex()+" Element:"+listItr.next());
        }
        //Traversing list with Index in backward direction
        System.out.println("Traversing list with Index in backward direction");
        while(listItr.hasPrevious()){
            System.out.println("Index: "+listItr.previousIndex()+" Element: "+listItr.previous());
        }
        while(listItr.hasNext()){
            if(listItr.next().equals("C")){
                listItr.add("C-1");//We can do this because we are using ListIterator
            }
        }
        System.out.println("List after adding C-1: "+list);
        while(listItr.hasPrevious()){
            System.out.println("Iterator after add previous: "+listItr.previous());
        }
        //Removing the element from the list
        while(listItr.hasNext()){
            if(listItr.next().equals("B")){
                listItr.remove();//removing the element from the list"
            }
        }
        while (listItr.hasPrevious()) {
            System.out.println("Iterator after remove previous: " + listItr.previous());
        }
        System.out.println("List after removing B: "+list);
    }
}
