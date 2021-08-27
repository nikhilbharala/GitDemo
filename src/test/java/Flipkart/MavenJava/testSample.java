package Flipkart.MavenJava;

import java.io.IOException;
import java.util.ArrayList;

public class testSample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ExcelSheet e = new ExcelSheet();
	ArrayList data=	e.getData("Purchase");
		
	System.out.println(data.get(0));
	System.out.println(data.get(1));
	System.out.println(data.get(2));
	System.out.println(data.get(3));
	
	}

}
