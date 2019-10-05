
public class Node<K,T> {
    public T value;
    public K key;
    public Node<K,T> left, right;
    public int count;
    public String s;
    public Node(K key,T value ){
    	this.key = key;
        this.value = value;
        left = null;
        right = null;
    }

    public T value() {
    	return this.value;
    }
    
    public Node<K,T> left(){
		return this.left;   	
    }
    
    public Node<K,T> right(){
    	return this.right;
    }  
    public int count(int count) {
    	this.count = count;
    	return count;
    }
    public String str(String str) {
    	this.s = str;
    	return s;
    }
}
    
