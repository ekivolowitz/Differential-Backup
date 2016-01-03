import java.io.File;
import static java.nio.file.StandardCopyOption.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
public class Directory
{
	//Creates a java file (folder) 
	File folder;
	
	
	//Constructor putting the file in the java project. 
	Directory(String filePath)
	{
		folder = new File(filePath);
	}
	
	/* Description - This method creates two String[] of the contents inside of each
	 * Directory folder. It the compares the two String[] together and and appends
	 * the file names that are not in common with source and target to an ArrayList 
	 * that is returned. 
	 * @param Directory target - takes the other folder directory
	 * @return ArrayList<String> - list of file names that are not in common with each other. 
	 */
	public ArrayList<String> compareWith(Directory target)
	{
		ArrayList<String> notContained = new ArrayList<String>();
		String[] namesOfSource = this.folder.list();
		String[] namesOfTarget = target.folder.list();
		for(int i = 0; i < namesOfSource.length; i++)
		{
			boolean contains = compareLists(namesOfSource[i], namesOfTarget);
			if(!contains)
			{
				notContained.add(namesOfSource[i]); 
			}
		}
		
		
		return notContained;
	}
	
	/*
	 * Description - This method is used to compare the String[] of the target
	 * source to with the current word in the Source String[]
	 * @param String n - Current file name in the Source String[] from the compareWith method.
	 * @param String[] target - the target list of file names.
	 * @return Boolean contains - true if there is a match for the file name, false if there is not.
	 */
	private boolean compareLists(String n, String[] target)
	{
		boolean contains = false;
		for(int i = 0; i < target.length; i++)
		{
			if(n.equals(target[i]))
			{
				contains = true;
			}
		}
		return contains;
	}
	/*
	 * Description - This method moves files from the Source Directory that's filenames are in the 
	 * fileNames ArrayList to the target directory.
	 * @param Directory target - the desired location that files should be moved to.
	 * @param ArrayList<String> fileNames - ArrayList of names that are uncommon from source to target.
	 * @return void
	 */
	public void moveFiles(Directory target, ArrayList<String> fileNames)
	{
		for(int i = 0; i < fileNames.size(); i++)
		{
			File otherFile = target.getFile(fileNames.get(i));
			File file = this.getFile(fileNames.get(i));
			Path p1 = file.toPath();
			Path p2 = otherFile.toPath();
			try {
				Files.copy( p1, p2, COPY_ATTRIBUTES);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * Description - this method is used in the moveFiles method. It returns a pointer to the file
	 * in the directory called upon it, with the name of the File. 
	 * @param String name - filename that the program is looking for.
	 * @return File filePath - the file with the specified name. 
	 */
	private File getFile(String name)
	{
		File filePath = new File(this.folder.getAbsoluteFile() + "\\" + name);
		return filePath;
	}	
}
