import java.util.Scanner;
 
class StackFinal2 {
 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		CapacityGetterSetter getset = new CapacityGetterSetter();
		int testcases = Integer.parseInt(scan.nextLine());
		int stacksize = Integer.parseInt(scan.nextLine());
		getset.setCapacity(stacksize);
		stack<Integer> S = new StackArray<Integer>();
		int inputs = Integer.parseInt(scan.nextLine());
 
		while (inputs >0) {
			String operation = scan.nextLine();
			String[] temp = operation.split(" ");
			if (temp[0].equals("S"))
				System.out.println(S.size());
			if (temp[0].equals("I"))
				System.out.println(S.isEmpty());
			if (temp[0].equals("P")){
				S.push(Integer.parseInt(temp[1]));
				//S.printStack();
				
			}
			if (temp[0].equals("O")){
				System.out.println(S.pop());
				S.printStack();
			}
			if (temp[0].equals("T"))
				System.out.println(S.top());
			inputs--;
			if (temp[0].equals("F")){
				System.out.println(S.getMid());
				
			}
		}
 
	}
}
 
interface stack<E> {
	int size();
 
	boolean isEmpty();
 
	void push(E e);
 
	E pop();
 
	E top();
	
	E getMid();
 
	void printStack();
}
 
class CapacityGetterSetter {
	private static int stackcap;
 
	public int getCapacity() {
		return this.stackcap;
	}
 
	public void setCapacity(int cap) {
		stackcap = cap;
	}
}
 
class StackArray<E> implements stack<E> {
	// public static final int CAPACITY=20;
	CapacityGetterSetter getset = new CapacityGetterSetter();
	private E[] data; // array container
	// enter index to top position
	int t=-1;
	// constructor
	int CAPACITY=0;
 
	public StackArray() {
		CAPACITY = getset.getCapacity();
		data = (E[]) new Object[CAPACITY];
		//initialize the data array
	}
 
	public int size() {
		// TODO Auto-generated method stub
		return t+1;
	}
 
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return t==-1;
	}
 
	public void push(E e) {
		// TODO Auto-generated method stub
		if (t+1==CAPACITY){
		System.out.println("StackFullException");
		}
		else{
		t+=1;
		data[t]=e;
		}
		printStack();
	}
 
	public E top() {
		// TODO Auto-generated method stub
		if(t==-1){
		System.out.println("StackEmptyException");
		}
		else{
		return data[t];
		}
		return null;
	}
 
	public E pop() {
		// TODO Auto-generated method stub
		if(t==-1){
		System.out.println("StackEmptyException");
		}
		else{
		E e = data[t];
		data[t]=null;
		t-=1;
		return e;
		}
		return null;
 
	}
 
	public void printStack() {
		if (isEmpty())
			System.out.println("Empty");
		else{
			for (int i = 0; i < CAPACITY; i++) {
				if(data[i]!=null)
					System.out.print(data[i] + " ");
			}
			System.out.println("  ");
		}
	}
 
	public E getMid() {
		int m= (t+1)/2;
		int count=0;
		E a[] = (E[])new Object[t];
		// TODO Auto-generated method stub
		E abc;
		for(int i=0;i<m;i++)
		{
			a[i]=pop();
			count++;	
		}
		abc=top();
		count--;
		for( int i=count; i>=0; i--)
		{
			push(a[i]);
		}
		return abc;
		
	}
}  
