package examples;

import com.groupdocs.cloud.parser.client.Configuration;

public class Common{
	// TODO: Get your AppSID and AppKey at https://dashboard.groupdocs.cloud (free
	// registration is required).

	public static String MyAppSID = "xxxxxxxxxxxxx";
	public static String MyAppKey = "xxxxxxxxxxxxx";
	public static String MyStorage = "xxxxxxxxxxx";
	
	public static Configuration GetConfiguration()
	{
		Configuration cfg = new Configuration(Common.MyAppSID, Common.MyAppKey);		
		cfg.setTimeout(120000);
		return cfg;
	}
}
