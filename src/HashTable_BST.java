import java.lang.Math;

public class HashTable_BST<K extends Comparable<K> ,T> implements MyHashTable_<K,T> {

	Node<K,T>[] hashArray;
	int hashtableSize;
	public HashTable_BST(int N) {
		hashtableSize = N;
		hashArray = new Node[hashtableSize];
	}
	
	public static long djb2(String str, int hashtableSize) {
		long hash = 5381; 
	    for (int i = 0; i < str.length(); i++) { 
	        hash = ((hash << 5) + hash) + str.charAt(i); 
	    } 
	    return Math.abs(hash) % hashtableSize;
	}
	
	public Node<K,T> insert(Node<K,T> node,K key, T value)
    {
		
		int num = 1;
        if (node == null) {
        	//System.out.println("equals");
            node = new Node<K,T>(key,value);
        }
        
        else { 
        	if ((key).compareTo(node.key)<0) {
                num++;
                //System.out.println("left");
            	node.left = insert(node.left,key, value);    
            }
        	else {
                num++;
                //System.out.println("right");
            	node.right = insert(node.right,key, value);              	
            	
            } 
        }
        node.count = num;
		return node;
        
    }
	public Node<K,T> searchNode(Node<K,T> root,K key){
		if(root == null) {
			return null;
		}
		else {
			if(root.key!=null) {
				if(root.key.compareTo(key)==0){
					return root;
					
				}
				else if((root.key).compareTo(key)>0) {
					root = searchNode(root.left,key);
					
				}
				else if((root.key).compareTo(key)<0) {
					
					root = searchNode(root.right,key);
					
				}
			}


			
		}
		
		return root;
	}
	public String searchNode(Node<K,T> root,K key,String str){
		if(root == null) {
			return null;
		}
		else {
			if(root.key!=null) {
				if((root.key).compareTo(key)==0){
					return str;			
			}
			else if((root.key).compareTo(key)>0) {
				return searchNode(root.left,key,str+"L");
				
			}
			else if((root.key).compareTo(key)<0) {
				return searchNode(root.right,key,str+"R");
				
			}
			}
			
		}
		return str;
		
	}
	public int searchNode(Node<K,T> root,K key,int count){
		if(root == null) {
			return 0;
		}
		else {
			if(root.key!=null) {
				if((root.key).compareTo(key)==0){
					return count;			
			}
			else if((root.key).compareTo(key)>0) {
				return searchNode(root.left,key,count+1);
				
			}
			else if((root.key).compareTo(key)<0) {
				return searchNode(root.right,key,count+1);
				
			}
			}
			
		}
		return count;
		
	}
	public int insert(K key, T obj) {	
		if(contains (key)) {
			return -1;
		}
		int index = (int)djb2(key.toString(),hashtableSize);
		Node<K,T> root = hashArray[index];
		//System.out.println(key.toString());
		if(root!=null) {
			//System.out.println(root.key.toString());
		}
		
		root = insert(root,key,obj);
        hashArray[index] = root;
		return searchNode(hashArray[index],key,1);
	}

	public int update(K key, T obj) {
		if(contains(key)) {
			//System.out.println(contains(key));
			int index = (int)djb2(key.toString(),hashtableSize);
			Node<K,T> node = searchNode(hashArray[index],key);
			node.value = obj;
			return searchNode(hashArray[index],key,1);
		}
		return -1;
	}


	public K minValue(Node<K,T> root) { 
		if(root == null) {
			return null;
		}
        K minv = root.key; 
        while (root.left != null) 
        { 
            minv = root.left.key; 
            root = root.left; 
        } 
        return minv; 
    }
	public K maxValue(Node<K,T> root) { 
		if(root == null) {
			return null;
		}
        K maxv = root.key; 
        while (root.right != null) 
        { 
            maxv = root.right.key; 
            root = root.right; 
        } 
        return maxv; 
    }
	
 
	
	
	public int delete(K key) {
		if(contains(key)) {
			
			int index = (int)djb2(key.toString(),hashtableSize);
			int k = searchNode(hashArray[index],key,1);
			
			Node<K,T> root =  searchNode(hashArray[index],key);
			Node<K,T> node = root;
			Node<K,T> parentnode=root;
			
			 while(node.key!=key) {
				   parentnode = node;
				   if(node.key.toString().compareTo(key.toString())<0) {
					   k++;
					   node=node.left;
				   }
				   else if(node.key.toString().compareTo(key.toString())>0){
					   k++;
					   node=node.right;
					  
				   }
				   if(node.key.toString().compareTo(key.toString())==0){
						break;
					}
				   
			   }
			
			 if(node.key==null && node.value==null) {
				 node=null;
			 }
			 
//				if(node==node.left)  {
//					parentnode=node.left;
//
//					node.key=null;
//					node.value=null;
//					node = null;
//				}
//				if(node==node.right){
//					parentnode=node.right;
//
//					node.key=null;
//					node.value=null;
//					node = null;
//				}
			
//			//System.out.println(node.left.key.toString());
			if(node.left==null && node.right == null) {
				//System.out.println("delete");
				node.key=null;
				node.value=null;
				node=null;
				return k;
			}
//			
//				//System.out.println("delete1");

			else if(node.left!=null && node.right == null && node.left.key!=null) {
				//	System.out.println("left");
				//	System.out.println(node.left.key.toString());
				k++;

					node.key  = node.left.key;
					node.value = node.left.value;
					node = node.left;
					parentnode.left=node.left;

					node.left=null;
					return k;
				}
			else if (node.right!=null && node.left == null && node.right.key!=null) {
				k++;

					node.key  = node.right.key;
					node.value = node.right.value;
					node = node.right;
					parentnode.right=node.right;
					node.right=null;
					return k;
				}
			


			else if (node.left!=null && node.left.key!=null) {
				//System.out.println("right");
				Node<K,T> nodet = searchNode(node.left,minValue(node.left));
				node.key  = nodet.key;
				node.value = nodet.value;
				k+=searchNode(node,node.key,1);
				parentnode.left=nodet;
				
			}
			
			else if(node.right!=null && node.right.key!=null) {
				//System.out.println("right");
				Node<K,T> nodet = searchNode(node.right,maxValue(node.right));
				node.key  = nodet.key;
				node.value = nodet.value;
				k+=searchNode(node,node.key,1);
				parentnode.right=nodet;
				
			}
			else {
				node.key=null;
				node.value=null;
				node=null;
				return k;
			}
			//System.out.println(minValue(node).toString());
		if(node!=null) {
			if(node==node.right) {
				node.right=null;
			}
			if(node==node.left) {
				node.left=null;
			}
		}
			
			
				//System.out.println(node.key.toString());

			return k;
		}
		else 
			return -1;
	}
	public boolean contains(Node<K,T> node,K key) {
//		Node<K,T> node = searchNode(hashArray[index],key);
//		if(node!=null) {
//			return true;
//		}
//		return false;
//	
		if(node==null) {
			//System.out.println("null");
			return false;
		}
		else {
			
			if(key.compareTo(node.key)==0) {
				//System.out.println(" ");
				return true;
			}
			else if(key.compareTo(node.key)<0) {
				//System.out.println("L");
				node = node.left;
				return contains(node,key);
			
			}
			else if(key.compareTo(node.key)>0) {
				//System.out.println("R");

				node = node.right;
				return contains(node,key);
			}


		}
		return false;
	}
	public boolean contains(K key) {
		int index = (int)djb2(key.toString(),hashtableSize);
//		Node<K,T> node = searchNode(hashArray[index],key);
//		if(node!=null) {
//			return true;
//		}
//		return false;
//	
		Node<K,T> node = hashArray[index];
		if(hashArray[index]==null) {
			//System.out.println("enter if");
			return false;
		}
		else {
			//System.out.println("enter else");

			return contains(node,key);
		}
		
	}
	
		
	public T get(K key) throws NotFoundException {
		T objt = null;
		if(contains(key)) {
			
			int index = (int)djb2(key.toString(),hashtableSize);
			objt = searchNode(hashArray[index],key).value;
		}
		else {
			return null;
		}
		return objt;
		
	}

	
	public String address(K key) throws NotFoundException {
		if(contains(key)) {
			
			int index = (int)djb2(key.toString(),hashtableSize)%hashtableSize;
			String s = searchNode(hashArray[index],key,"");
			s = String.valueOf(index)+"-"+s;
		return s;
		}
		else {
			return "E";
		}
	}
	
}
