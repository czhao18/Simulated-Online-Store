/*This is a class declaration for GenericList 
 * Xiaoyu Qian & Chengnan Zhao
 * CS201  Spring2014
 * Final Project 2014028
 * 
 */
public class QianX_ZhaoC_GenericList <T>{

	final int MAX_SIZE = 300;
	protected Object [] arr;
	protected int index;
	protected int pointer;
	
	//default constructor
	public QianX_ZhaoC_GenericList() {
		arr = new Object[MAX_SIZE];
		index = 0;
		pointer = 0;
	}
	
	//nondefault constructor
	public QianX_ZhaoC_GenericList(int size){
		arr =  new Object[size];
		index = 0;
		pointer = 0;
	}

	//accessor
	public  T [] getArray(){
		Object [] arrayCopy =  new Object[arr.length];
		for (int i=0; i < arr.length;i++){
			T arrayObj = (T) getElement(i); 
			arrayCopy [i]= arrayObj;
		}
		T [] tempT = (T[])arrayCopy;
		return  tempT;
	}
	
	public int getIndex(){
		return index;
	}
	
	public int getPointer(){
		return pointer;
	}
	
	public int getLength(){
		return arr.length;
	}
	
	public T getElement(int a){
		return (T)arr[a];
	}
	
	//mutator
	public void setArray(T[] anArr){
		Object[] anArrCopy = new Object[anArr.length];
		for (int i = 0;i<anArr.length;i++){
			anArrCopy [i]= anArr[i];
		}
		arr=anArrCopy;
	}
	
	public void setIndex(int anIndex){
		index = anIndex;
	}
	
	public void setPointer(int aPointer){
		pointer = aPointer;
	}
	
	public String toString(){
		String aToString ="";
		for (int i =0; i < index; i++){
			aToString += arr[i].toString()+"\n";
		}
		return aToString;	
	}
	
	
	
	public void add(T aObject){
		arr[index] = aObject;
		index++;
	}
	
	//deletes the object at pos and moves all elements up
	public void delete(int pos) {
		if (pos != -1) {
			for (int i = pos; i < index - 1; i++) {
				arr[i] = arr[i + 1];
			}
			index--;
		}
	}
	
	//inserts the object at pos and moves all elements down
	public void insert(int pos,T aObject){
		for (int i = index; i > pos ;i--){
			arr [i]= arr [i-1];
		}
		arr [pos] = aObject;
		index++;
	}
	
	public int isThere(T aObject){
		int k =-1;
		for(int i = 0; i < index; i++){
			if (((T)arr[i]).equals(aObject)){
				k = i;
			}
		}
		return k;
	}
	
	public int delete(T aObject){
		int k = isThere(aObject);
		if (k!=-1){
			delete(k);
		}
		return k;
	}
	
	//returns true if array is full, false if array is not
	public boolean isFull(){
		if (arr.length == index){
			return true;
		}
		else 
			return false;
	}
	
	//returns true if array is empty, false if array is not
	public boolean isEmpty(){
		if(index == 0){
			return true;
		}
		else
			return false;
		
	}
	
	public void clear(){
		for (int i=0;i<index; i++){
			arr[i]=null;
		}
		index = 0;
	}
	
	public void trim(){
		if (!isFull()){
			Object[] newArr = new Object[index];
			for (int i =0;i<index;i++){
				newArr[i]=arr[i];
			}
			arr = newArr;
		}
	}
	
	public void moreCapacity(int more){
		Object[] newArr = new Object[arr.length*more];
		for (int i =0;i<index;i++){
			newArr[i]=arr[i];
		}
		arr = newArr;
	}
	
	public void reset(){
		pointer = 0;
	}
	
	public boolean hasNext(){
		if (pointer <index){
			return true;
		}
		else 
			return false;
	}
	
	public T getNext(){
		
		pointer++;
		return (T) arr[pointer-1];
	}
}
