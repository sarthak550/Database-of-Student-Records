
public class Pair<K> implements Comparable<Pair<K>> {
	 public K fname;
	 public K lname;
	 
	 public Pair(K fname,K lname){
		 
		 this.fname=fname;
		 this.lname=lname;
	 }
	 public String toString() {
		 return fname.toString()+lname.toString();
	 }
	 public String fname() {
		 return fname.toString();
	 }
	 public String lname() {
		 return lname.toString();
	 }
	public int compareTo(Pair<K> o) {
		if(o==null && fname()!=null) {
			return 1;
		}
		else if(o==null && fname==null) {
			return 0;
		}
		else if(o!=null && fname()==null) {
			return -1;
		}
		if(fname().compareTo(o.fname())==0) {
			if(lname().compareTo(o.lname())<0){
				return -1;
			}
			else if(lname().compareTo(o.lname())>0){
				return 1;
			}
			else {
				return 0;
			}
		}
		else if(fname().compareTo(o.fname())<0){
			return -1;
		}
		else {
			return 1;
		}
	}

	 
		  
		   
}
