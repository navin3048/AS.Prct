package vtiger.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This is an implementation class for IRetryAnalyser Interface or TestNG 
 * @author kavya
 *
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer{

	int count = 0;
	int retryCount = 4;
	public boolean retry(ITestResult result) {
		while(count<retryCount)
		{
			count++;
			return true;
		}
		return false;
	}

}
