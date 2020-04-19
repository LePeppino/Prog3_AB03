/*
 * Titel: Programmieren 3, AB03
 * Autor: Giuseppe Buccellato
 * Semester: SoSe2020
 */

import java.io.Serializable;
import java.util.*;

public class Ringpuffer<T> implements Deque<T>, RandomAccess, Serializable, Cloneable {

    ArrayList<T> elements;

    private int head, tail, size, capacity = 0;
    private boolean fixedCapacity, discarding = false;

    //Constructor
    public Ringpuffer(int head, int tail, int size, int capacity){
        setHead(head);
        setTail(tail);
        setSize(size);
        setCapacity(capacity);
        elements = new ArrayList<>(capacity);
    }
    //Setter/Getter
    private void setHead(int head){ this.head = head; }
    public int getHead(){ return head; }

    private void setTail(int tail){ this.tail = tail; }
    public int getTail(){ return tail; }

    private void setSize(int size){ this.size = size; }
    public int getSize(){ return size; }

    private void setCapacity(int capacity){ this.capacity = capacity; }
    public int getCapacity(){ return capacity; }

    //Helpers
    public void changeCapacity(Ringpuffer ringpuffer, int capIn){
        if(capIn > ringpuffer.elements.size()){
            //set new increased size
            ringpuffer.elements.ensureCapacity(capIn);
            ringpuffer.capacity = capIn;
            System.out.println("Ringbuffer capacity is now " + ringpuffer.getCapacity());
        }else{
            System.out.println("Remove elements first?");
            //ringpuffer.elements.trimToSize();
        }
    }

    public void enableOverwrite(){
        fixedCapacity = true;
        discarding = true;
    }
    public void disableNewElements(){
        fixedCapacity = true;
        discarding = false;
    }
    public void autoIncreaseCap(){
        fixedCapacity = false;
        discarding = false;
    }

    public boolean isFull() {
        return head == (tail + 1) % capacity;
    }

    public void addToRing(T element){
        if(isFull()){
            //check for cases
            if(discarding && fixedCapacity){ //case 1
                tail = (tail + 1) % capacity;
                System.out.println("Overwriting existing element at position " + getTail() + "...");
                elements.add(element);
            }else if(!discarding && fixedCapacity){ //case 2
                System.out.println("Buffer is full and not taking new elements!");
            }else if(!fixedCapacity && !discarding){ //case 3
                System.out.println("Increasing max capacity, adding new element...");
                capacity += 1;
                elements.ensureCapacity(capacity);
                elements.add(element);
            }
        }else{ //add element normally
            tail = (tail + 1) % capacity;
            elements.add(element);
        }
    }

    //Cloneable
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    //Deque
    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public void addFirst(T t) {

    }

    @Override
    public void addLast(T t) {

    }

    @Override
    public boolean offerFirst(T t) {
        return false;
    }

    @Override
    public boolean offerLast(T t) {
        return false;
    }

    @Override
    public T removeFirst() {
        return null;
    }

    @Override
    public T removeLast() {
        return null;
    }

    @Override
    public T pollFirst() {
        return null;
    }

    @Override
    public T pollLast() {
        return null;
    }

    @Override
    public T getFirst() {
        return null;
    }

    @Override
    public T getLast() {
        return null;
    }

    @Override
    public T peekFirst() {
        return null;
    }

    @Override
    public T peekLast() {
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean offer(T t) {
        return false;
    }

    @Override
    public T remove() {
        return null;
    }

    @Override
    public T poll() {
        return null;
    }

    @Override
    public T element() {
        return null;
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public void push(T t) {

    }

    @Override
    public T pop() {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public Iterator<T> descendingIterator() {
        return null;
    }
}
