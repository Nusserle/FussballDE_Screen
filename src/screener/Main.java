package screener;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		ScreenView myGui = new ScreenView();
		WebScraper w = new WebScraper();
		ScreenController controller = new ScreenController(myGui, w);
		
//		WebScraper w = new WebScraper();
//		w.getVereinsspielplan("", "");
	}

}
