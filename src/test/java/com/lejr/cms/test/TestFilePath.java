package com.lejr.cms.test;

import java.io.File;
import java.io.IOException;

public class TestFilePath {

	public static void main(String[] args) {
		// TODO Auto-generated methodstub

		System.out.println(System.getProperty("user.dir"));

		try {
			System.out.println("-----默认相对路径：取得路径不同------");
			File file1 = new File("contract\\first.html");
			System.out.println(file1.getPath());
			System.out.println(file1.getAbsolutePath());
			System.out.println(file1.getCanonicalPath());
			System.out.println("-----默认相对路径：取得路径不同------");
			File file = new File("\\contract\\first.html");
			System.out.println(file.getPath());
			System.out.println(file.getAbsolutePath());
			System.out.println(file.getCanonicalPath());

//			System.out.println("-----默认绝对路径:取得路径相同------");
//			File file2 = new File("D:\\workspace\\test\\test1.txt");
//			System.out.println(file2.getPath());
//			System.out.println(file2.getAbsolutePath());
//			System.out.println(file2.getCanonicalPath());
		} catch (IOException e) {
			// TODOAuto-generated catch block
			e.printStackTrace();
		}
	}

}
