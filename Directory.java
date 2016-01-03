import java.io.File;
import static java.nio.file.StandardCopyOption.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
	
	/*
	 * @param Directory target - takes the other folder directory
	 * @return ArrayList<String> - list of strings that are not in common with each other. 
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
	
		
		/* works but it deletes the source file and moves it to the target
		boolean success = file.renameTo(new File(target.folder, file.getName()));
		if (success) {
            System.out.println("File was successfully moved.\n");
        } else {
            System.out.println("File was not successfully moved.\n");
        }
        */
		//actually copies the selected objects.
		
		
	}
	
	
	private File getFile(String name)
	{
		File filePath = new File(this.folder.getAbsoluteFile() + "\\" + name);
		return filePath;
	}
	
	
	
	
}
