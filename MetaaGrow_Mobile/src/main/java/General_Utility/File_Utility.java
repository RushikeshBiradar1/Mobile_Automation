package General_Utility;

import java.io.FileInputStream;
import java.util.Properties;

public class File_Utility {
	public String getpropertykeyvalue(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(iPathConstant.PropertyFilePath);
		Properties prop=new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
				
	}
  
}
