package deque;

public class LinkedListDeque<T> implements Deque<T> {
    private class IntListNode {
        public T item;
        public IntListNode next;
        public IntListNode prev;

        public IntListNode(IntListNode prev, T item, IntListNode next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    private IntListNode sentinel;
    private int size;

    public LinkedListDeque(){
        this.sentinel = new IntListNode(null, null, null);
        this.sentinel.prev = this.sentinel;
        this.sentinel.next = this.sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        if (sentinel.next == sentinel && sentinel.prev == sentinel){
            sentinel.next = new IntListNode(sentinel, item, sentinel);
            sentinel.prev = sentinel.next;
            size += 1;
        } else if (sentinel.next != sentinel){
            sentinel.next = new IntListNode(sentinel, item, sentinel.next);
            sentinel.next.next.prev = sentinel.next;
            size += 1;
        }
    }

    @Override
    public void addLast(T item) {
        if (sentinel.next == sentinel && sentinel.prev == sentinel){
            sentinel.next = new IntListNode(sentinel, item, sentinel);
            sentinel.prev = sentinel.next;
            size += 1;
        } else if (sentinel.prev != sentinel){
            sentinel.prev = new IntListNode(sentinel.prev, item, sentinel);
            sentinel.prev.prev.next = sentinel.prev;
            size += 1;
        }
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        IntListNode this_number = sentinel.next;
        while(this_number != sentinel) {
            System.out.print(this_number.item + " ");
            this_number = this_number.next;
        }
        System.out.println();
    }


    @Override
    public T removeFirst() {
        IntListNode here = sentinel.next;
        if(size == 0) {
            return null;
        } else{
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size -= 1;
            return here.item;
        }
    }

    @Override
    public T removeLast() {
        IntListNode here = sentinel.prev;
        if(size == 0) {
            return null;
        } else {
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size -= 1;
            return here.item;
        }
    }

    @Override
    public T get(int index) {
        IntListNode check = sentinel;
        if(index >= size) {
            return null;
        }
        for (int i = 0; i <= size; i++) {
            check = check.next;
            if (i == index) {
                return check.item;
            }
        }
        return null;
    }

    private T helper( int index, IntListNode check, int counter) {
        if (index == counter) {
            return check.item;
        }
        return helper(index, check.next, counter + 1);
    }
    public T getRecursive(int index) {
        int counter = 0;
        IntListNode check = sentinel.next;
        if(index < 0 || index > size){
            return null;
        }
        return helper(index, check, counter);
    }

    @Override
    public boolean equals(Object d){
        if (d instanceof Deque){
            Deque<T> c = (Deque<T>) d;
            if (c.size() == this.size()){
                for (int i=0; i<this.size();i++){
                    if (!c.get(i).equals(this.get(i))){
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
