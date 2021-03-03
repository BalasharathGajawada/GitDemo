package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentreporterNG {
	static ExtentReports ep;
	
	public static ExtentReports geReportObject()
	{
		String Path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter esp = new ExtentSparkReporter(Path);
		esp.config().setReportName("Automation");
		esp.config().setDocumentTitle("Results");
		
		 ep =new ExtentReports();
		ep.attachReporter(esp);
		ep.setSystemInfo("Tester", "Balasharath Gajawada");
		
		return ep;
		
	}

}
