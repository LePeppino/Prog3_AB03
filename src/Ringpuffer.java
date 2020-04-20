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

    //CONSTRUCTOR
    public Ringpuffer(int head, int tail, int size, int capacity){
        setHead(head);
        setTail(tail);
        setSize(size);
        setCapacity(capacity);
        elements = new ArrayList<>(capacity);
    }

    //SETTER AND GETTER
    private void setHead(int head){ this.head = head; }
    public int getHead(){ return head; }

    private void setTail(int tail){ this.tail = tail; }
    public int getTail(){ return tail; }

    private void setSize(int size){ this.size = size; }
    public int getSize(){ return size; }

    private void setCapacity(int capacity){ this.capacity = capacity; }
    public int getCapacity(){ return capacity; }

    //HELPERS
    public void changeCapacity(int capIn){
        if(capIn > elements.size()){
            //set new increased size
            elements.ensureCapacity(capIn);
            capacity = capIn;
            System.out.println("Ringbuffer capacity is now " + getCapacity());
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
        return size == capacity; // 'head == (tail + 1) % capacity' does not work
    }

    public void addToRing(T element){
        if(isFull()){
            //check for cases
            if(discarding && fixedCapacity){ //case 1
                elements.set(head, element);
                tail = (tail + 1) % capacity;
                head = (head + 1) % capacity;
                System.out.println("Overwritten existing element");
            }else if(!discarding && fixedCapacity){ //case 2
                System.out.println("Buffer is full and not taking new elements!");
            }else if(!fixedCapacity && !discarding){ //case 3
                capacity += 1;
                elements.ensureCapacity(capacity);
                elements.add(element);
                size += 1;
                tail = (tail + 1) % capacity;
                System.out.println("Increased max capacity, adding " + element);
            }
        }else{ //add element normally
            elements.add(element);
            size += 1;
            tail = (tail + 1) % capacity;
            System.out.println("Added " + element + ".");
        }
    }

    public T readLikeFIFO(){
        if(isEmpty()){
            System.out.println("Ringbuffer is empty!");
        }else{
            head = (head + 1) % capacity;
            return elements.get(head - 1);
        }
        return null;
    }

    public T readLikeLIFO(){
        if(isEmpty()){
            System.out.println("Ringbuffer is empty!");
        }else{
            tail = (tail - 1) % capacity;
            return elements.get(tail + 1);
        }
        return null;
    }

    public void getPosition(){
        System.out.println("Position of head: " + head + " and tail: " + tail);
    }

    public void getNoOfElements(){
        System.out.println("No of Elements in Ringbuffer: "
                + size);
    }

    //CLONEABLE
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    //DEQUE
    @Override
    public boolean isEmpty() {
        return !isFull() && head == tail;
    }

    @Override
    public boolean add(T element) {
        elements.add(element);
        return true;
    }

    @Override
    public void clear() {
        head = 0;
        tail = 0;

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
