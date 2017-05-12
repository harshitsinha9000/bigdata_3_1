import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class Assignment33 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		if(args.length>=1)
		{
			ArrayList<Path> multiple_path = new ArrayList<Path>();
			for(String arg1:args)
			{
				multiple_path.add(new Path(arg1));
			}
			
			int size1 = multiple_path.size();
			Iterator al =multiple_path.iterator();
			
			
			while(al.hasNext())
			{
				printRecursively_2((Path)al.next());	
			}
			
			}


	}		
	private static void printRecursively_2(Path path2) throws IOException 
	{
	FileSystem filesystem_mul;
	Configuration conf2 = new Configuration();
	filesystem_mul  = FileSystem.get(path2.toUri(),conf2);
	FileStatus[] filestatus_mul = filesystem_mul.listStatus(path2);


	for(FileStatus filestatus_mul1:filestatus_mul)
		{
			if(filestatus_mul1.isDirectory())
			{
				System.out.println(filestatus_mul1.getPath());
				printRecursively_2(filestatus_mul1.getPath());
			}
			else if(filestatus_mul1.isFile())
			{
				System.out.println(filestatus_mul1.getPath());
			}
		}

	}//end of method
				
}//end of entire class




