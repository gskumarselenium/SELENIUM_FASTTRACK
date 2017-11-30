package iostreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.testng.annotations.Test;

public class Fileiostreams {
  @Test
  public void step2() throws Exception{
	  //1. Print input data on the console
	  //2.Create xls and add printed data on the create result file
FileInputStream fi=new FileInputStream("D:\\seasoftautomation\\automation\\Test Data\\LOGIN.xls");// to read the data from login.xls file
	Workbook w=Workbook.getWorkbook(fi);// to get the file login.xls 
	Sheet s=w.getSheet(0);	//to get the sheet 1 information
FileOutputStream fo=new FileOutputStream("D:\\seasoftautomation\\automation\\Results\\LogRes.xls");
	WritableWorkbook wb=Workbook.createWorkbook(fo);
	WritableSheet ws=wb.createSheet("Results", 0);
	
	for (int i = 0; i < s.getRows(); i++) 
	{
		for (int j = 0; j <s.getColumns(); j++) {
			System.out.println(s.getCell(j, i).getContents());	
		Label un=new Label(j, i, s.getCell(j, i).getContents());
			ws.addCell(un);
		}
	}
	
	wb.write();
	wb.close();
	
	  
  }
}












