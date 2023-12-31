package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists of generic methods related to property file
 * @author kavya
 *
 */
public class PropertyFileUtility {
	
	/**
	 * This method will read data from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException
	{
		//FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		FileInputStream fis = new FileInputStream(IConstantUtility.propertyFilePath);
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
		
	}

}
