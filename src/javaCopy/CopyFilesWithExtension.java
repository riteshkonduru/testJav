package javaCopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.io.OutputStream;

/**
* Copy all the files in a folder with specific extension to another folder. 
* Both the folders are specified on the command line. 
* The program currently uses .java extension as filter.
**/
public class CopyFilesWithExtension {
	
	public static void main(String[] args) {
		
		String sourceFolder = "C://Users//rkonduru//workspace//LOC//src//classes";
		String targetFolder = "C://Src";
		
		File sFile = new File(sourceFolder);
		// Find files with specified extension
		File[] sourceFiles = sFile.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				if(name.endsWith(".cls") && name.startsWith("LOC_")) {// change this to your extension
					return true;
				}else {
					return false;
				}
			}
		});
		
		// let us copy each file to the target folder
		for(File fSource:sourceFiles) {
			File fTarget = new File(new File(targetFolder), fSource.getName());
			copyFileUsingStream(fSource,fTarget);
			// fSource.delete(); // Uncomment this line if you want source file deleted
		}
		
		
	}
	
	/**
	 * Copies a file using the File streams
	 * @param source
	 * @param dest
	 */
	private static void copyFileUsingStream(File source, File dest)  {
	    InputStream is = null;
	    OutputStream os = null;
	    try {
	        is = new FileInputStream(source);
	        os = new FileOutputStream(dest);
	        byte[] buffer = new byte[1024];
	        int length;
	        while ((length = is.read(buffer)) > 0) {
	            os.write(buffer, 0, length);
	        }
	    }catch(Exception ex) {
	    	System.out.println("Unable to copy file:"+ex.getMessage());
	    }	
	    finally {
	    	try {
	    		is.close();
	    		os.close();
	    	}catch(Exception ex) {}
	    }
	}

}
