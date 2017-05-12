import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class Assignmet31 {
	//assignment 3 part 1//assignment 3 part 1
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		if(args.length !=1)
		{
			System.out.println("Please Enter One Argument");
			System.exit(1);
		}

		Path path = new Path(args[0]);		
		Configuration conf = new Configuration();
		URI uri = URI.create(args[0]);
		FileSystem filesystem = FileSystem.get(path.toUri(),conf); 
		FileStatus[] filestatus = filesystem.listStatus(path);  

		
		
	
	if(args.length==1)
	{
		for(FileStatus filestatus1:filestatus)
		{
			if(filestatus1.isDirectory())
			{
				System.out.println("Directory : "+filestatus1.getPath());
			}
			else if(filestatus1.isFile())
			{
				System.out.println("File : "+filestatus1.getPath());
			}
		}//end of for
	 }//end of if
	}//end of main
	
}//end of class				
	

	
			

	

	


