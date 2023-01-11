import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		command();
		}
	public static void command() {
		DoubleLinkedList dl = new DoubleLinkedList();
		boolean done = false;
		boolean rai = false;//record for replace append insert
		boolean saved = true;
		Scanner input = new Scanner(System.in);
		String filename = null;
		
		
		while(!done) {
			
			String inputCommand = input.nextLine();
			String inputCommandUpper = inputCommand.toUpperCase().trim();
			switch(inputCommandUpper) {
			case "Q":
				if (rai = true && saved != true) {
					System.out.println("Please input a command:");
					System.out.println("File not save yet. If you still want to quit. Input QQ");
					System.out.println("If not, type any character to escape Q command");
					String quitOrStay = input.nextLine();
					String quitOrStayUpper = quitOrStay.toUpperCase().trim();
					if (quitOrStayUpper.equals("QQ")) {
						done = true;
						break;
					}else {
						System.out.println("And input command you want: ");
						break;
					}
				}else {
					System.out.println("ByeBye.");
					done = true;
					break;
				}
				//done = true;
				
			case "O":
				
				System.out.println("Input your file path:");
				System.out.println("If you want to use relative path,\nplease put your file in the same level as bin and src.");
				filename = input.nextLine();
				dl.readFile(filename);
				//dl.storePath(filename);
				//System.out.println(filename);
				break;
			case "S":
				
				if (filename == null) {
					//If no file was read in it will ask for a filename
					System.out.println("No file exsits. Input your file path:");
					String newfilename = input.nextLine();
					System.out.println(newfilename);
					dl.readFile(newfilename);
					filename = newfilename;
					break;
					
				}
				System.out.println("Input your file path: ");
				System.out.println("(If you want to writeback to original read in file, press Enter.)");
				String savepath = input.nextLine();
				if (savepath.equals("") && filename!=null) {
					//if no file is given //it saves to the file that was read in

					savepath = filename;
					dl.saveFile(savepath);
					saved = true;
					break;
				}else {
					try {
						dl.saveFile(savepath);
						saved = true;
						break;
					}catch(Exception e) {
						System.out.println("No file read in yet. Please use O to read.");
					}
				}
				
				
			case "P":
				System.out.println("Print lines from: (line index start from 0)");
				try {
					int start = Integer.parseInt(input.nextLine());
					System.out.println("To:");
					int end = Integer.parseInt(input.nextLine());
					dl.print(start, end);
				}catch(Exception e) {
					System.out.println("Please input a number.");
					System.out.println("If you want to print, please type P again.");
					System.out.println("Or you can use other command directly.");
				}
				break;
			case "F":
				System.out.println("Input the word you want to find:");
				String findword = input.nextLine();
				dl.find(findword);
				break;
			case "R":
				try {
					System.out.println("Which line you want to replace? (line index start from 0)");
					int lineIndex = Integer.parseInt(input.nextLine());
					System.out.println("Word you want to replace:");
					String oldword = input.nextLine();
					System.out.println("Type new word to replace the old one:");
					String newword = input.nextLine();
					dl.replace(lineIndex, oldword, newword);
					rai = true;
					saved = false;
					
				}catch(Exception e) {
					System.out.println("Please input a number.");
					System.out.println("If you want Replace, please type R again.");
					System.out.println("Or you can use other command directly.");
				}
				break;
			case "A":
				try {
					System.out.println("Which line you want to insert after? (line index start from 0)");
					int lineIndex = Integer.parseInt(input.nextLine());
					if (lineIndex > dl.size) {
						System.out.println("Out of range.");
						System.out.println("If you want insert after, please type A again.");
						System.out.println("Or you can use other command directly.");
						break;
					}
					System.out.println("Text you want to insert:");
					String newword = input.nextLine();
					Node insertnode = new Node(newword);
					dl.insertAfter(lineIndex, insertnode);
					rai=true;
					saved = false;
				}catch(Exception e) {
					System.out.println("Please input a number.");
					System.out.println("If you want insert after, please type A again.");
					System.out.println("Or you can use other command directly.");
				}
				break;
				
			case "I":
				try {
					System.out.println("Which line you want to insert before? (line index start from 0)");
					int lineIndex = Integer.parseInt(input.nextLine());
					if (lineIndex > dl.size) {
						System.out.println("Out of range.");
						System.out.println("If you want insert after, please type A again.");
						System.out.println("Or you can use other command directly.");
						break;
					}
					System.out.println("Text you want to insert:");
					String newword = input.nextLine();
					Node insertnode = new Node(newword);
					dl.insertBefore(lineIndex, insertnode);
					rai=true;
					saved = false;
				}catch(Exception e) {
					System.out.println("Please input a number.");
					System.out.println("If you want insert before, please type I again.");
					System.out.println("Or you can use other command directly.");
				}
				break;
				
			case "D":
				try {
					System.out.println("Line you want to delete from:? (line index start from 0)");
					int findex = Integer.parseInt(input.nextLine());
					System.out.println("Line you want to delete to:");
					int lindex = Integer.parseInt(input.nextLine());

					dl.deleteMultiple(findex, lindex);
					rai = true;
					saved = false;
					
				}catch(Exception e) {
					System.out.println("Please input a number.");
					System.out.println("If you want Delete, please type D again.");
					System.out.println("Or you can use other command directly.");
				}
				break;
				
			default:
				System.out.println("Input O, S, P, F, R, A, I, D only.");
				break;
			}

		}
		
	
	}

}
