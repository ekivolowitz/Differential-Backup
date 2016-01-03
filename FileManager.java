import java.io.File;
import javax.swing.JFileChooser;
public class FileManager {
	JFileChooser fileChooser;
	
	FileManager()
	{
		fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	}
	
	
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
