package javaCopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;	
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
//hello
public class CopyFileContent {

	public static void main(String[] args) {

		/* Source file, from which content will be copied */
		File sourceFile = new File("data/logging-copy.properties");

		/* destination file, where the content to be pasted */
		File destFile = new File("file2.txt");
		
		/* if file not exist then create one */
		if (!destFile.exists()) {
			try {
				destFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		InputStream input = null;
		OutputStream output = null;

		try {

			/* FileInputStream to read streams */
			input = new FileInputStream(sourceFile);

			/* FileOutputStream to write streams */
			output = new FileOutputStream(destFile);

			byte[] buf = new byte[1024];
			int bytesRead;

			while ((bytesRead = input.read(buf)) > 0) {
				output.write(buf, 0, bytesRead);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			try {

				if (null != input) {
					input.close();
				}
				
				if (null != output) {
					output.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}