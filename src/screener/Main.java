package screener;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws InterruptedException, SecurityException, IOException {
		
		if (System.getProperty("webdriver.firefox.bin") == null) {
			  System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			}
		
		ScreenView myGui = new ScreenView();
		WebScraper w = new WebScraper();
		ScreenController controller = new ScreenController(myGui, w);
		
//		WebScraper w = new WebScraper();
//		w.getVereinsspielplan("", "");
	}

}
