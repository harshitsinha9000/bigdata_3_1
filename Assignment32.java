import java.io.IOException;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;


//assignment 3 part 2

public class Assignment32 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		Path path = new Path(args[0]);
		
		Configuration conf = new Configuration();
		URI uri = URI.create(args[0]);
		
		FileSystem filesystem = FileSystem.get(path.toUri(),conf); 
		
		FileStatus[] filestatus = filesystem.listStatus(path);
		
		if(args.length==1)
		{
			printRecursively(path);
			
		}	

		}//end 0f main
	
	private static void printRecursively(Path path1) throws IOException 
	{
		
		Configuration conf1 = new Configuration();
		FileSystem filesystem_2 = FileSystem.get(path1.toUri(),conf1);
		
		FileStatus[] filestatus = filesystem_2.listStatus(path1);
		
				for(FileStatus filestatus1:filestatus)
				{
					if(filestatus1.isDirectory())
					{
						System.out.println(filestatus1.getPath());
						printRecursively(filestatus1.getPath());
					}
					else
					{
						System.out.println(filestatus1.getPath());
					}
				
				}			
					
					
					
		}//end of method
	}
