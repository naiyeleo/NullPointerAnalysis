package util;

import internal.MethodPlus;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Scanner;

import soot.Type;


public class FileParser {
	public static boolean isLineInMethod(String fileName,String className, int lineNumber, MethodPlus methodPlus) throws ClassNotFoundException, FileNotFoundException{
		boolean isLineInMethod = false;
		Class<?> classType = Class.forName(className);
		String packageName = classType.getPackage().getName();
		File file = new File(System.getProperty("user.dir")+"\\src\\"+packageName+"\\"+fileName);
		Scanner scanner = new Scanner(file);
		int lineNumberInFile= 0;
		while(!isLineInMethod&&scanner.hasNext()&&lineNumberInFile<=lineNumber){
			String line = scanner.next();
			lineNumberInFile++;
			if(line.contains(methodPlus.getMethodName())){
				isLineInMethod = true;
				for(Type type:methodPlus.getParameterSootTypes()){
					if(!line.contains(type.toString())){
						isLineInMethod = false;
					}
				}
			}
		}
		scanner.close();
		while(scanner.hasNext()){
			
		}
		return isLineInMethod;
	}
	

	
	public static void main(String args[]){
		System.out.println(System.getProperty("user.dir"));
		
	}
}
