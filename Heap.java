/*
Sophie Pyott

2/9/26

Implement heap using an array.
Allows to add and delete items in log(n) time
Always result with every node’s children being smaller than itself
*/

public class Heap {

//the actual storage structure for your heap
private int[] arr;
private int size;

//constructor for your heap
//feel free to make one that takes in an array if you prefer for your testing purposes.
//note that we will not be inserting more than 100 elements into our array so you need not worry about re-sizing
//the array
public Heap() {

arr = new int[100];
size = 0;

}

//create this function to add elements to your heap
//all heap properties must be preserved
public void add(int toAdd) {

    arr[size] = toAdd;
    siftUp(size);

}

//remove the largest element of the heap (the root) and re-heapafy
public int removeMax() {

    if(size==0) throw new IllegalStateException("Heap is empty");

    int max = arr[0];
    arr[0] = arr[size - 1];
    siftDown(0);

    return max;
}

 

//this should check and alter the tree after an item is inserted
private void siftUp(int index) {

    while(index > 0){
        int parent = (index - 1) / 2; //parent index

        if(arr[index] > arr[parent]){
            int temp = arr[index];
            arr[index] = arr[parent];
            arr[parent] = temp; //swap
            index = parent;

        } else {
            break;
        }
    }
}

 

//this should check and alter the tree after an item is deleted.
private void siftDown(int index) {

    while(index * 2 + 1 < size){
        int left = index * 2 +1;
        int right = index * 2 + 2;
        int bigger = left;

        if(right < size && arr[right] >= arr[left]){
            bigger = right;
        }

        if(arr[index] < arr[bigger]){
            int temp = arr[index];
            arr[index] = arr[bigger];
            arr[bigger] = temp; //swap
            index = bigger;

        } else{
            break;
        }
    }
}

public void printHeap(){

    for(int i = 0; i < size; i++){
        System.out.print(arr[i] + " ");
    }
    System.out.println();
}

public static void main(String[] args){

    Heap h = new Heap();

    int[] val = {50,30,20,15,10,8,16,60,1};

    System.out.println("Adding values:");
    for(int v : val){
        h.add(v);
        h.printHeap();
    }

    System.out.println("Removing values:");
    while(h.size > 0){
        System.out.println("Removed: " + h.removeMax());
        h.printHeap();
    }
}

//syntax conventions.
}