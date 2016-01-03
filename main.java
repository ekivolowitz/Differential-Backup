///////////////////////////////////////////////////////////////////////////////
// Title:            External Organizer - subject to be renamed.
// Files:            main. java
//					 to be continued.
// Author: 			 Evan Kivolowitz
// Date: 			12-29-15
//////////////////////////////////////////////////////////////////////////////


import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class main {

	public static void main(String args[])
	{
		//creates a file manager for the user to use to select
		// various directories.
		FileManager f = new FileManager();
		Directory n = new Directory(f.getSourcePath());
		Directory w = new Directory(f.getTargetPath());
		//ArrayList to hold the contents of the filenames NOT in common. 
		ArrayList<String> contains = n.compareWith(w);
				
		//Reads out the contents of the list above.  
		/*
		for(int i = 0 ; i < contains.size(); i++)
		{
			System.out.println(contains.get(i));
		}
		*/
		n.moveFiles(w, contains);
	}
}
