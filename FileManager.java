import java.io.File;
import javax.swing.JFileChooser;
public class FileManager {
	//FileChooser field within the FileManager class. 
	JFileChooser fileChooser;
	/*
	 * Main constructor for a FileManager object
	 * @param none
	 * @return none
	 */
	FileManager()
	{
		fileChooser = new JFileChooser();
		//Only shows Directories, as to not allow the user to transfer single non-directory files.
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	}
	
	/*
	 * Description - this method is used to obtain the file path of the source directory chosen 
	 * by the user in the FileManager's JFileChooser. The only difference between this method and
	 * getTargetPath() is the setDialogTitle(); statement.
	 * @param none
	 * @return String filePath - a filepath to the selected source directory
	 */
	public String getSourcePath()
	{
		//0 means open file
		//1 means close page
		this.fileChooser.setDialogTitle("Please select a Source Directory:");
		int command = fileChooser.showOpenDialog(null);
		switch(command)
		{
		case 0:
			File name = this.fileChooser.getSelectedFile();
			return name.getAbsolutePath();
		
		default:
			return "";
			//making some changes to the program
		}
	}
	/*
	 * Description - this method is used to obtain the file path of the target directory chosen 
	 * by the user in the FileManager's JFileChooser. The only difference between this method and 
	 * getSourcePath() is the setDialogTitle(); statement. 
	 * @param none
	 * @return String filePath - a filepath to the selected target directory
	 */	
	public String getTargetPath()
	{
		//0 means open file
		//1 means close page
		this.fileChooser.setDialogTitle("Please select a Target Directory:");
		int command = fileChooser.showOpenDialog(null);
		switch(command)
		{
		case 0:
			File name = this.fileChooser.getSelectedFile();
			return name.getAbsolutePath();
		
		default:
			return "";
		}	
	}
}
