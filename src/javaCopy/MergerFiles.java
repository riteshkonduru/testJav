package javaCopy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
public class MergerFiles {
	public static void main(String[] args) {
		//String sourceFile1Path = "/home/programcreek/Desktop/s1";
		//String sourceFile2Path = "/home/programcreek/Desktop/s2";
		//String mergedFilePath = "/home/programcreek/Desktop/m";
		
		String sourceFolder = "C://Src//hit";//"C://Src";//"C://Users//rkonduru//workspace//classes";
		String mergedFilePath = "C://Src//Copied//classOnl.txt";
		
		File sFile = new File(sourceFolder);
		
	File[] sourceFiles = sFile.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				if(name.endsWith(".cls") && name.startsWith("Jiu_")) {// change this to your extension
					return true;
				}else {
					return false;
				}
			}
		});
		
		//File[] files = new File[2];
		//files[0] = new File(sourceFile1Path);
		//files[1] = new File(sourceFile2Path);
		File mergedFile = new File(mergedFilePath);
		mergeFiles(sourceFiles, mergedFile);
	}
	public static void mergeFiles(File[] files, File mergedFile) {
		FileWriter fstream = null;
		BufferedWriter out = null;
		try {
			fstream = new FileWriter(mergedFile, true);
			out = new BufferedWriter(fstream);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		for (File f : files) {
			System.out.println("merging: " + f.getName());
			FileInputStream fis;
			try {
				fis = new FileInputStream(f);
				BufferedReader in = new BufferedReader(new InputStreamReader(fis));
				String aLine;
				while ((aLine = in.readLine()) != null) {
					out.write(aLine);
					out.newLine();
				}
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}