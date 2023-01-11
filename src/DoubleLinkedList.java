import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DoubleLinkedList {
	public Node first;
	public Node last;
	public int size = 1;
	
	public boolean isEmpty() {
		return first == null;
	}
	public String storePath(String filename) {
		return filename;
	}
	
	public void readFile(String filename) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line;
			//line = reader.readLine(); 
			while((line = reader.readLine())!= null) {
				
				Node insertnode = new Node(line);
				insertLast(insertnode);//use insertLast function define below to construct Linked list
				//System.out.println(line);
				
			}reader.close();

		} catch (IOException e) {
			System.out.println("Wrong path. Please check your input.");
			System.out.println("If you still want to open a file. Please input O again.");
			//e.printStackTrace();
		}
		
	}
	
	public void saveFile(String filename) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
			Node current = first;
			writer.write(current.text);
			writer.write("\n");
			for(int i = 0; i <size-1; i++) {
				current = current.rnext;

				writer.write(current.text);
				writer.write("\n");
				
			}writer.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void print(int start, int end) {
		Node current = first;
		try {
			for (int i = 0; i <= start-1; i++) {
				current = current.rnext;
			}
			for (int i = start; i <= end; i++) {
				System.out.print("["+current.text+"]");
				current = current.rnext;
				System.out.println();
			}
		}catch(Exception e) {
			System.out.println("Your input is out of Range. This is the whole list.");
		}
	}
	
	public void find(String text) {
		try {
			Node current = first;
			if (current.text.contains(text)) {
				System.out.println(current.text);
				//continue;
			}
			for(int i = 0; i <size-1; i++) {
				current = current.rnext;
				
				if (current.text.contains(text)) {
					System.out.println(current.text);
					//continue;
				}
			}
		}catch(Exception e) {
			System.out.println("Wrong input. please check.");
			
		}
	}
//////////////////////////////////////////////////////////	
	public Node getLine(int index) {
		if (index < 0 || index > size){
			System.out.print("Out of Range");
		}
		
		Node current = first;
		for (int i = 0; i < index; i++) {
			current = current.rnext;
		}
		System.out.print(current.text);
		return current;
	}

	public void insertLast(Node newN) {//insert to tail

		if(this.isEmpty()) {

			first = newN;
			first.rnext = last;
			last = newN;
			last.lnext = first;
		}else {
				last.rnext = newN;
				newN.lnext = last;
				last = newN;
				size++;
		}
		
	}
	
	public void insertFirst(Node newN) {// insert to head
		
		if(this.isEmpty()) {

			first = newN;
			first.rnext = last;
			last = newN;
			last.lnext = first;
		}else{
				first.lnext = newN;
				newN.rnext = first;
				first = newN;
				size++;
			}
		
	}
////////////////////////////////////////////////////////////
	public void insertBefore(int index, Node newN) {
		try {
			if(this.isEmpty()) {

				first = newN;
				first.rnext = last;
				last = newN;
				last.lnext = first;
				
			}else if(index == 0) {//insert before head
				first.lnext = newN;
				newN.rnext = first;
				first = newN;
				size++;
				
			}else { //insert between
				Node before = first;
				
				for (int i = 0; i < index-1; i++) {
					before = before.rnext;
				}
				Node next = before.rnext;
				newN.rnext = next;
				newN.lnext = before;
				
				before.rnext = newN;
				next.lnext = newN;
			}size++;
		}catch(Exception e) {
			System.out.println("Out of range.");
		}
	}
	////
	
	////
	public void insertAfter(int index, Node newN) {
		
		try {
			if(this.isEmpty()) {
				
				
				first = newN;
				first.rnext = last;
				last = newN;
				last.lnext = first;
				
			}else if(index>size) {
				System.out.println("Out of range.");
			}
			else if(index == size -1) {
				last.rnext = newN;
				newN.lnext = last;
				last = newN;
				size++;
				
			}else { //insert between
				Node before = first;
				
				for (int i = 0; i < index; i++) {
					before = before.rnext;
				}
				Node next = before.rnext;
				newN.rnext = next;
				newN.lnext = before;
				
				before.rnext = newN;
				next.lnext = newN;
			}size++;
		}catch(Exception e) {
			System.out.println("Out of range.");
		}
	}
	//// the following part is integrate to deleteMultiple
	
	/*
	public void delete(int index) {
		//delete first element
		if(index == 0) {
			
			Node current = first;
			first = first.rnext;
			first.lnext = null;
			current.rnext = null;
			
			//delete last element(tail)
		}else if(index == size-1) {
			
			Node current = first;
			Node newtail;
			Node beforecurrent = null;
			for (int i = 0; i < index; i++) {
				beforecurrent = current;
				current = current.rnext;
			}
			newtail = beforecurrent;
			newtail.rnext = null;
			
		}else {

			Node current = first;
			Node beforecurrent = null;
			Node aftercurrent = null;
			for (int i = 0; i < index; i++) {
				
				current = current.rnext;
				beforecurrent = current.lnext;
				aftercurrent = current.rnext;
				System.out.print(current.text);
			}
			
			beforecurrent.rnext = aftercurrent;
			aftercurrent.lnext = beforecurrent;
			
			current.rnext = null;
			current.lnext = null;

		}
		size--;
	}
	*/
	
	
	
	public void deleteMultiple(int findex, int lindex) {
		int range = size -1;
		try {
			if (findex == 0 && lindex == size-1) {//delete all
				
				for (int i = 0; i <= 4; i++) {
					
					Node current = first;
					first = first.rnext;
					first.lnext = null;
					current.rnext = null;
					//System.out.print(current.text);
					
				}
				System.out.println("All nodes are delete.");
	
				first = null;
				
				//System.out.print(first.text);
				
			
			}
			else if (findex == 0) { //if deleteMultiple(0,x)happens 
				
				for (int i = 0; i <= lindex; i++) {
					
					Node current = first;
					first = first.rnext;
					first.lnext = null;
					current.rnext = null;
				}
			
			}else if(lindex == size-1) {//if deleteMultiple(x,last element)happens 
				Node current = first;
				for (int i = 0; i < findex-1; i++) {
					current = current.rnext;
				}
				current.rnext = null;
				current.lnext = null;
			}
			
			else {//delete between
			Node current = first;
			Node current2 = first;
			Node beforecurrent = null;
			Node aftercurrent = null;
			for (int i = 0; i < findex; i++) {
				current = current.rnext;
				beforecurrent = current.lnext;
				//System.out.print(current.text);
			}
			for (int i = 0; i < lindex; i++) {
				current2 = current2.rnext;
				aftercurrent = current2.rnext;
				//System.out.print(current2.text);
				//System.out.print(current.text);
			}
			
			beforecurrent.rnext = aftercurrent;
			aftercurrent.lnext = beforecurrent;
			for (int i = findex; i < lindex; i++) {
				current.rnext = null;
				current.lnext = null;
				current2.rnext = null;
				current2.lnext = null;
				}
			}
			size = size - (Math.abs(lindex-findex)+1 );
		
		}catch(Exception e) {
			System.out.println("wrong input range. Please input range betwwen 0 to "+range);
		}
	}
	////
	
	////
	public void replace(int index, String oldtext, String newtext) {
		try {
			Node current = first;
			if (index == 0) {
				String myStr = current.text;
				myStr.replace(oldtext, newtext);
	
			}else {
			
			for (int i = 0; i < index; i++) {
				current = current.rnext;
			}
			String myStr = current.text;
			current.text = myStr.replace(oldtext, newtext);
			System.out.println(current.text);
			}
		}catch(Exception e){
			System.out.println("Wrong input, please check.");
		}
	}
}
