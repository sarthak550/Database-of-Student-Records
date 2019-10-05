import java.lang.Math;


public class HashTable_DH<Pair,T> implements MyHashTable_<Pair,T> {
	
	Student[] hashArray;
	int hashtableSize;
	
	public HashTable_DH(int N) {
		
			hashArray = new Student[N];
			hashtableSize = N;
		
		
	}

	
	public static long djb2(String str, int hashtableSize) {
		long hash = 5381; 
	    for (int i = 0; i < str.length(); i++) { 
	        hash = ((hash << 5) + hash) + str.charAt(i); 
	    } 
	    return Math.abs(hash) % hashtableSize;
	}

	public static long sdbm(String str, int hashtableSize) { 
	    long hash = 0; 
	    for (int i = 0; i < str.length(); i++) { 
	        hash = str.charAt(i) + (hash << 6) + (hash << 16) - hash; 
	    } 
	    return Math.abs(hash) % (hashtableSize - 1) + 1; 
	}
	
	public Pair key;
	public T obj;
	public HashTable_DH(Pair key,T obj) {
		this.key = key;
		this.obj = obj;
	}
	
	public int index(Pair key) {
		long hash = djb2(key.toString(),hashtableSize)-sdbm(key.toString(),hashtableSize);
		int index =0;
		for(int i = 0 ; i<hashtableSize;i++) {
			hash+=sdbm(key.toString(),hashtableSize);		
			long k = hash%hashtableSize;
			index = (int)k;
			if(hashArray[index]==null) {
				hashArray[index]=(Student)obj;
				break;
			}
					
		}
		return index;
	}

	public int insert(Pair key, T obj) {

		int num =1;
		long hash = djb2(key.toString(),hashtableSize)-sdbm(key.toString(),hashtableSize);
		int index =0;
		for(int i = 0 ; i<hashtableSize;i++) {
			hash+=sdbm(key.toString(),hashtableSize);		
			long k = hash%hashtableSize;
			index = (int)k;
			if(hashArray[index]==null) {
				hashArray[index]=(Student)obj;
				num+=i;
				break;
			}
					
		}
		return num;
	}
	
	public int update(Pair key, T obj) {
		if(contains(key)) {
		int num =1;
		long hash = djb2(key.toString(),hashtableSize)-sdbm(key.toString(),hashtableSize);
		int index =0;
		int i =0;
		while(hashtableSize>i) {
			hash+=sdbm(key.toString(),hashtableSize);		
			long k = hash%hashtableSize;
			index = (int)k;
			if(hashArray[index]==null) {
				i++;
				
			}
			else if(key.toString().compareTo(hashArray[index].fname()+hashArray[index].lname())==0) {
				hashArray[index]=(Student)obj;
				
				num+=i;
				break;
			}
			else {
				i++;
			}
					
		}
		return num;
		}
		else {
			return -1;
		}
	}

	public int delete(Pair key) {
		if(contains(key)) {
		return update(key,null);
		}
		else {
			return -1;
		}
	}

	public boolean contains(Pair key) {
		long hash = djb2(key.toString(),hashtableSize)-sdbm(key.toString(),hashtableSize);
		int index =0;
		int i =0;
		while(hashtableSize>i) {
			hash+=sdbm(key.toString(),hashtableSize);		
			long k = hash%hashtableSize;
			index = (int)k;
			if(hashArray[index]==null) {
				i++;
				
			}
			else if(key.toString().compareTo(hashArray[index].fname()+hashArray[index].lname())==0) {
				
				return true;
			}
			else {
				i++;
			}
					
		}
		return false;
	}

	public T get(Pair key) {
		
		if(contains(key)) {
			long hash = djb2(key.toString(),hashtableSize)-sdbm(key.toString(),hashtableSize);
			int index =0;
			int i = 0;
			while(hashtableSize>i) {
				hash+=sdbm(key.toString(),hashtableSize);		
				long k = hash%hashtableSize;
				index = (int)k;
				if(hashArray[index]==null) {
					i++;
				}
				else if(key.toString().compareTo(hashArray[index].fname()+hashArray[index].lname())==0) {
					break;
				}
				else {
					i++;
				}
			}
			return (T)hashArray[index];
		}
		

		return null;
	}

	public java.lang.String address(Pair key) throws NotFoundException{
		
		if(contains(key)) {
			long hash = djb2(key.toString(),hashtableSize)-sdbm(key.toString(),hashtableSize);
			int index =0;
			int i = 0 ;
			while(hashtableSize>i) {
				hash+=sdbm(key.toString(),hashtableSize);		
				long k = hash%hashtableSize;
				index = (int)k;
				if(hashArray[index]==null) {
					i++;
				}
				else if(key.toString().compareTo(hashArray[index].fname()+hashArray[index].lname())==0) {
					break;
				}
				else {
					i++;
				}
						
			}
			return String.valueOf(index);
		}
		else {
		return "E";
	}
	}

}
