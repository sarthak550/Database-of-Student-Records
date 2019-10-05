import java.io.*;


public class Assignment3 {

	public static void main(String[] args) throws Exception {
		if(args[1].compareTo("DH")==0) {
			HashTable_DH<String,Student> hashtable = new HashTable_DH<String,Student>(Integer.valueOf(args[0]));
			FileReader fr=new FileReader(args[2]);    
	        BufferedReader br=new BufferedReader(fr); 
			String line = null;
			while((line = br.readLine())!= null) {
				String[] words = line.split(" ");
								
				if(words[0].compareTo("insert")==0) {
					
					Pair<String> pair = new Pair<String>(words[1],words[2]);
					Student obj = new Student(words[1],words[2],words[3],words[4],words[5]);
					int k = hashtable.insert(pair.toString(), obj);

						System.out.println(k);

				}
				else if(words[0].compareTo("update")==0) {
					Pair<String> pair = new Pair<String>(words[1],words[2]);
					Student obj = new Student(words[1],words[2],words[3],words[4],words[5]);
					int k = hashtable.update(pair.toString(), obj);
					if(k!=-1) {
						System.out.println(k);
					}
					else {
						System.out.println("E");
					}
				}
				else if(words[0].compareTo("delete")==0) {
					Pair<String> pair = new Pair<String>(words[1],words[2]);
					int k = hashtable.delete(pair.toString());
					if(k!=-1) {
						System.out.println(k);
					}
					else {
						System.out.println("E");
					}
				}
				else if(words[0].compareTo("contains")==0) {
					Pair<String> pair = new Pair<String>(words[1],words[2]);
					boolean x = hashtable.contains(pair.toString());
					if(x) {
						System.out.println("T");
					}
					else {
						System.out.println("F");
					}
				}
				else if(words[0].compareTo("get")==0) {
					
					Pair<String> pair = new Pair<String>(words[1],words[2]);
					Student objt = hashtable.get(pair.toString());
					if(objt!=null) {
					System.out.println(objt.fname()+" "+objt.lname()+" "+objt.hostel()+" "+objt.department()+" "+objt.cgpa());
					}
					else {
						System.out.println("E");
					}
					}
				else if(words[0].compareTo("address")==0) {
					Pair<String> pair = new Pair<String>(words[1],words[2]);
					try {
					String k = hashtable.address(pair.toString());
					System.out.println(k);
					}
					catch (NotFoundException e) {
						System.out.println("E");
					}
				}
			}
			br.close();
			
		}
		
		if(args[1].compareTo("SCBST")==0) {
			HashTable_BST<Pair<String>,Student> hashtable1 = new HashTable_BST<Pair<String>,Student>(Integer.valueOf(args[0]));
			FileReader fr=new FileReader(args[2]);    
	        BufferedReader br=new BufferedReader(fr);
			String line1 = null;
			while((line1 = br.readLine())!= null) {
				String[] words = line1.split(" ");
				
				
				if(words[0].compareTo("insert")==0) {
					Pair<String> pair = new Pair<String>(words[1],words[2]);
					Student obj = new Student(words[1],words[2],words[3],words[4],words[5]);
					int k = hashtable1.insert(pair, obj);
					if(k!=-1) {
						System.out.println(k);
					}
					else {
						System.out.println("E");
					}
				}
				else if(words[0].compareTo("update")==0) {
					Pair<String> pair = new Pair<String>(words[1],words[2]);
					Student obj = new Student(words[1],words[2],words[3],words[4],words[5]);
					int k = hashtable1.update(pair, obj);
					if(k!=-1) {
						System.out.println(k);
					}
					else {
						System.out.println("E");
					}
				}
				else if(words[0].compareTo("delete")==0) {
					Pair<String> pair = new Pair<String>(words[1],words[2]);
					int k = hashtable1.delete(pair);
					if(k!=-1) {
						System.out.println(k);
					}
					else {
						System.out.println("E");
					}
				}
				else if(words[0].compareTo("contains")==0) {
					Pair<String> pair = new Pair<String>(words[1],words[2]);
					boolean x = hashtable1.contains(pair);
					if(x) {
						System.out.println("T");
					}
					else {
						System.out.println("F");
					}
				}
				else if(words[0].compareTo("get")==0) {
					
					try {
						Pair<String> pair = new Pair<String>(words[1],words[2]);
						Student objt = hashtable1.get(pair);
						if(objt!=null) {
							System.out.println(objt.fname()+" "+objt.lname()+" "+objt.hostel()+" "+objt.department()+" "+objt.cgpa());
						}
						else {
							System.out.println("E");
						}
						
					}
					catch (NotFoundException e) {
						System.out.println("E");
					}
				}
				else if(words[0].compareTo("address")==0) {
					try {
						Pair<String> pair = new Pair<String>(words[1],words[2]);
					String k = hashtable1.address(pair);
					System.out.println(k);
					}
					catch (NotFoundException e) {
						System.out.println("E");
					}
				}
			}
			br.close();
			
		}
		
	}

}
