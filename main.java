///////////////////////////////////////////////////////////////////////////////
// Title:           External Organizer - subject to be renamed.

// Files:            
//					Main.java
//					Directory.java
//					FileManager.java
//					 
// Author: 			Evan Kivolowitz
// Date: 			12-29-15
//////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
/*
 * This class is the main point of entry into the program. It calls
 * upon other objects which constructs the program for the user to use. 
 * 
 * <p>Bugs: Cannot copy contents of subdirectories to other directories.
 * 
 * @author Evan Kivolowitz
 */
public class Main {
	/*
	 * This method is the point of entry for the program.
	 * @param String args[] - unused
	 * @return void
	 */
	public static void main(String args[])
	{
		FileManager f = new FileManager();
		Directory n = new Directory(f.getSourcePath());
		Directory w = new Directory(f.getTargetPath());
		//ArrayList to hold the contents of the filenames NOT in common. 
		ArrayList<String> contains = n.compareWith(w);
		n.moveFiles(w, contains);
	}
}
