package iostreams;

import java.io.FileOutputStream;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.testng.annotations.Test;

public class CreateExcel_Step1 {
  @Test
  public void f() throws Exception{
FileOutputStream fo=new FileOutputStream("D:\\seasoftautomation\\LoginResults.xls"); //path declaration
	
WritableWorkbook wb=Workbook.createWorkbook(fo); //creation of excel workbook
	WritableSheet ws=wb.createSheet("Results1", 0); // creation of worksheet and renaming
	Label un=new Label(0,0,"Username"); // creation of labels and // label(column value,row value)
	Label pw=new Label(1,0,"Password");
	Label rs=new Label(2,0,"Results");
	Label sc=new Label(3,0,"score");
	Label hi=new Label(4,0,"marks");
	//Label bye=new Label(5,0,"hello");
	ws.addCell(un); // to add username to the cell	
	ws.addCell(pw); // to add password to the cell
	ws.addCell(rs); // to add result to the cell
	ws.addCell(sc); // to add score to the cell
	ws.addCell(hi); // to add marks to the cell
	//ws.addCell(bye);
	
	wb.write(); //to write all the data to the excel
	wb.close(); // to close the excel file
	
  }
}











