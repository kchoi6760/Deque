package deque;

public class ArrayDeque<T> implements Deque<T> {

    private T[] array;
    private int nextLast; // location of last number + 1
    private int nextStart; // location of first number - 1
    private int length;

    public ArrayDeque(){
        this.length = 8;
        this.array = (T[]) new Object[this.length];
        this.nextLast = 4;
        this.nextStart = 3;

    }

    private void addResize(){
        if (this.nextStart == this.nextLast){
            int newLength = this.length * 2;
            T[] newArray = (T[]) new Object[newLength];
            for (int i = 0; i < this.nextLast; i++) {
                newArray[i] = this.array[i];
            }
            for (int j = 1; j < this.length - this.nextStart; j++) {
                newArray[(newLength - this.length) + (j + this.nextStart)] = this.array[j + this.nextStart];
            }
            this.nextStart = newLength - this.length + this.nextStart;
            this.array = newArray;
            this.length = newLength;
        }
    }
    private void removeResize(){
        if (this.length <= 16){
            return;
        }
        if (this.size() == this.length / 4){
            int newLength = this.length/2;
            T[] newArray = (T[]) new Object[newLength];
            if (this.nextStart >= this.nextLast){
                for (int i = 0; i < this.nextLast; i++) {
                    newArray[i] = this.array[i];
                }
                for (int j = 1; j < this.length - this.nextStart; j++) {
                    newArray[(newLength - this.length) + (j + this.nextStart)] = this.array[j + this.nextStart];
                }
                this.nextStart = newLength - this.length + this.nextStart;
                this.array = newArray;
                this.length = newLength;
            } else {
                for (int i = this.nextStart+1; i<this.nextLast; i++){
                    newArray[i - this.nextStart] = this.array[i];
                }
                this.nextLast = this.nextLast - this.nextStart;
                this.nextStart = 0;
                this.array = newArray;
            }

        }
    }

    @Override
    public void addFirst(T item) {
        this.addResize();
        this.array[this.nextStart] = item;
        if(this.nextStart == 0){
            this.nextStart = this.length-1;
        } else {
            this.nextStart -= 1;
        }
    }

    @Override
    public void addLast(T item) {
        this.addResize();
        this.array[this.nextLast] = item;
        if(this.nextLast == this.length-1){
            this.nextLast = 0;
        } else {
            this.nextLast += 1;
        }
    }

//    public boolean isEmpty() {
//        return this.nextStart + 1 == this.nextLast || (this.nextStart==this.length-1 && this.nextLast==0);
//    }

    @Override
    public int size() {
        if (this.nextStart >= this.nextLast){
            return this.length + this.nextLast - this.nextStart - 1;
        } else {
            return this.nextLast - this.nextStart - 1;
        }
    }

    @Override
    public void printDeque() {
        if (this.nextStart >= this.nextLast){
            for (int i = this.nextStart + 1; i<this.length; i++){
                System.out.print(this.array[i]);
                System.out.print(" ");
            }
            for (int i = 0; i<this.nextLast; i++){
                System.out.print(this.array[i]);
                System.out.print(" ");
            }
        } else {
            for (int i = this.nextStart + 1; i<this.nextLast; i++){
                System.out.print(this.array[i]);
                System.out.print(" ");
            }
        }

        System.out.println();

    }

    private void printNo(){
        for (int i=0; i<this.length; i++){
            System.out.print(this.array[i]);
            System.out.print(" ");
        }
        System.out.println();
        System.out.println(this.nextStart);
        System.out.println(this.nextLast);
    }

    @Override
    public T removeFirst() {
        if(isEmpty()){
            return null;
        }
        this.removeResize();
        T a;
        if(this.nextStart == this.length-1){
            a = this.array[0];
            this.array[0] = null;
        } else {
            a = this.array[this.nextStart+1];
            this.array[this.nextStart+1] = null;
        }

        if(this.nextStart == this.length-1){
            this.nextStart = 0;
        } else {
            this.nextStart += 1;
        }
        return a;
    }

    @Override
    public T removeLast() {
        if(isEmpty()){
            return null;
        }
        this.removeResize();
        T a;
        if(this.nextLast == 0){
            a = this.array[this.length - 1];
            this.array[this.length-1] = null;
        } else {
            a = this.array[this.nextLast - 1];
            this.array[this.nextLast-1] = null;
        }

        if(this.nextLast == 0){
            this.nextLast = this.length - 1;
        } else {
            this.nextLast -= 1;
        }
        return a;
    }

    @Override
    public T get(int index) {
        if(isEmpty()){
            return null;
        }
        if (this.nextStart + index + 1 < this.length){
            return this.array[this.nextStart + index + 1];
        } else {
            return this.array[this.nextStart + index + 1 - this.length];
        }
    }

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
