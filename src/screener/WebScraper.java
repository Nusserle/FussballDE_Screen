package screener;

import java.io.File;
import java.nio.file.Paths;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.google.common.io.Files;

public class WebScraper {
	
	String path_base = Paths.get(".").toAbsolutePath().normalize().toString();
	
	String jahr = "1920";

	String svd_1_homepage = "http://www.fussball.de/mannschaft/sv-denkingen-sv-denkingen-suedbaden/-/saison/" + jahr
			+ "/team-id/011MIFD4J4000000VTVG0001VTR8C1K7#!/";
	String svd_1_liga = "http://www.fussball.de/spieltagsuebersicht/landesliga-3-suedbaden-landesliga-herren-saison1920-suedbaden/-/staffel/027L3KLH4S000003VS5489B3VVRDDT7H-G#!/";

	String svd_2_homepage = "http://www.fussball.de/mannschaft/sv-denkingen-2-sv-denkingen-suedbaden/-/saison/" + jahr
			+ "/team-id/011MIEMTKO000000VTVG0001VTR8C1K7#!/";
	String svd_2_liga = "http://www.fussball.de/spieltagsuebersicht/kreisliga-a-staffel-3-bodensee-kreisliga-a-herren-saison1920-suedbaden/-/staffel/027JEQ1OIS00000BVS5489B4VU9HDBC9-G";

	String svd_3_homepage = "http://www.fussball.de/mannschaft/sv-denkingen-3-sv-denkingen-suedbaden/-/saison/" + jahr
			+ "/team-id/01HD2O7RKS000000VV0AG811VSJI13A5#!/";
	String svd_3_liga = "http://www.fussball.de/spieltagsuebersicht/kreisliga-c-staffel-4-bodensee-kreisliga-c-herren-saison1920-suedbaden/-/staffel/027L6FQJQK000000VS5489B4VTN1DS1I-G#!/";

	String svd_damen_homepage = "http://www.fussball.de/mannschaft/sv-denkingen-sv-denkingen-suedbaden/-/saison/" + jahr
			+ "/team-id/01L37UK7MO000000VV0AG80NVVQMG8U7#!/";
	String svd_damen_liga = "http://www.fussball.de/spieltagsuebersicht/frauen-bezirksliga-bodensee-bezirk-bodensee-frauen-bezirksliga-frauen-saison1920-suedbaden/-/staffel/027JEPS7N400000CVS5489B4VU9HDBC9-G#!/";

	String svd_A_homepage = "http://www.fussball.de/mannschaft/sg-denkingen-sv-denkingen-suedbaden/-/saison/" + jahr
			+ "/team-id/023PJ83GNS000000VS548984VVIKHNJO#!/";
	String svd_B1_homepage = "http://www.fussball.de/mannschaft/sg-denkingen-sv-denkingen-suedbaden/-/saison/" + jahr
			+ "/team-id/011MICE2H4000000VTVG0001VTR8C1K7#!/";
	String svd_B2_homepage = "http://www.fussball.de/mannschaft/sg-denkingen-2-sv-denkingen-suedbaden/-/saison/" + jahr
			+ "/team-id/023PHU89G8000000VS548985VT5V9K59#!/";
	String svd_C1_homepage = "http://www.fussball.de/mannschaft/sg-aach-linz-tsv-aach-linz-suedbaden/-/saison/" + jahr
			+ "/team-id/01L23UFULO000000VV0AG811VV4PB99G#!/";
	String svd_C2_homepage = "http://www.fussball.de/mannschaft/sg-aach-linz-2-tsv-aach-linz-suedbaden/-/saison/" + jahr
			+ "/team-id/01L23V1FRO000000VV0AG811VV4PB99G#!/";
	String svd_D_homepage = "http://www.fussball.de/mannschaft/sg-denkingen-sv-denkingen-suedbaden/-/saison/" + jahr
			+ "/team-id/011MIA57T0000000VTVG0001VTR8C1K7#!/";
	String svd_E_homepage = "http://www.fussball.de/mannschaft/sv-denkingen-sv-denkingen-suedbaden/-/saison/" + jahr
			+ "/team-id/023P8EQ2LO000000VS548984VVIKHNJO#!/";

	String svd_damen_B_homepage = "http://www.fussball.de/mannschaft/sv-denkingen-sv-denkingen-suedbaden/-/saison/"
			+ jahr + "/team-id/011MIFA7S4000000VTVG0001VTR8C1K7#!/";
	String svd_damen_C_homepage = "http://www.fussball.de/mannschaft/sv-denkingen-7er-sv-denkingen-suedbaden/-/saison/"
			+ jahr + "/team-id/023P882NEO000000VS548984VVIKHNJO#!/";

	String svd_verein = "http://www.fussball.de/verein/sv-denkingen-suedbaden/-/id/00ES8GN9CG0000AJVV0AG08LVUPGND5I#!/";

	public WebScraper() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", path_base + "/lib/geckodriver.exe");
		// Main.getTabelleAndSpielplan(svd_1_homepage, "svd1");
		// Main.getTabelleAndSpielplan(svd_2_homepage, "svd2");
		// Main.getTabelleAndSpielplan(svd_3_homepage, "svd3");
		// Main.getTabelleAndSpielplan(svd_A_homepage, "svdA");
		// Main.getTabelleAndSpielplan(svd_B1_homepage, "svdB1");
		// Main.getTabelleAndSpielplan(svd_B2_homepage, "svdB2");
		// WebScraper.getTabelleAndSpielplan(svd_C1_homepage, "svdC1");
		// Main.getTabelleAndSpielplan(svd_C2_homepage, "svdC2");
		// Main.getTabelleAndSpielplan(svd_D_homepage, "svdD");
		// Main.getTabelleAndSpielplan(svd_E_homepage, "svdE");
		// WebScraper.getTabelleAndSpielplan(svd_damen_homepage, "svdDamen1");
		// WebScraper.getTabelleAndSpielplan(svd_damen_B_homepage, "svdDamenB");
		//// Main.getTabelleAndSpielplan(svd_damen_C_homepage, "svdDamenC");
		//
		// WebScraper.getStaffelpielplan(svd_1_liga, "svd1");
		// WebScraper.getStaffelpielplan(svd_2_liga, "svd2");
		// WebScraper.getStaffelpielplan(svd_3_liga, "svd3");
		// WebScraper.getStaffelpielplan(svd_damen_liga, "svdDamen");
		//
		// WebScraper.getVereinsspielplan(svd_verein, "vereinsspielplan");

	}

	/**
	 * Retrieves SV Denkingen club match plan
	 * 
	 * @param url
	 *            link to SV Denkingen club
	 * @param string
	 * @throws InterruptedException
	 */
	public void getVereinsspielplan(String url, String mannschaft, String output_path) throws InterruptedException {
		ScreenController.log.log(Level.INFO, "Init driver");
		// Create a new instance of the Firefox driver
		WebDriver driver = new FirefoxDriver();
		ScreenController.log.log(Level.INFO, "Done");
		driver.manage().window().setSize(new Dimension(1920, 1080));
		
		ScreenController.log.log(Level.INFO, "Get URL");
		driver.get(url);
		// Scroll to matchplan because of lazy-load of images
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		acceptCookies(driver, jse);
		ScreenController.log.log(Level.INFO, "Accept Cookies");
		jse.executeScript("document.body.style.webkitTransform = 'scale(2.5)'", new String[0]);
		driver.manage().window().setSize(new Dimension(3000, 2000));
		editTable(driver, "verein");
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight);", new String[0]);
		// jse.executeScript("document.getElementById('id-club-matchplan-table').scrollIntoView();",
		// new String[0]);
		Thread.sleep(3000);
		// jse.executeScript("document.getElementById('clubProfile').scrollIntoView();",
		// new String[0]);
		Thread.sleep(2000);
		jse.executeScript("window.scrollTo(0,0)", new String[0]);
		ScreenController.log.log(Level.INFO, "Output");
		try {

			WebElement spielplan_verein_legende = driver.findElement(By.id("id-club-matchplan-table"));
			WebElement spielplan_verein = spielplan_verein_legende.findElement(By.className("table"));

			File spielplanScreen = (File) ((TakesScreenshot) spielplan_verein).getScreenshotAs(OutputType.FILE);
			File f = new File(output_path + mannschaft + ".png");
			if (f.exists()) {
				f.delete();
			}
			Files.copy(spielplanScreen, new File(output_path + "\\" + mannschaft + ".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.close();
	}

	/**
	 * Retrieves Denkingen match plan and leaderbord
	 * 
	 * @param url
	 *            Fussball.de Link to Denkingen 1
	 */
	private void getTabelleAndSpielplan(String url, String mannschaft) throws InterruptedException {
		// Create a new instance of the Firefox driver
		WebDriver driver = new FirefoxDriver();
		driver.get(url);
		// Scroll to matchplan because of lazy-load of images

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.body.style.webkitTransform = 'scale(2.5)'", new String[0]);
		driver.manage().window().setSize(new Dimension(3000, 2000));
		acceptCookies(driver, jse);
		editTable(driver, "svd");
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight);", new String[0]);
		// jse.executeScript("document.getElementById('id-team-matchplan-table').scrollIntoView();",
		// new String[0]);
		Thread.sleep(3000);
		jse.executeScript("window.scrollTo(0,0)", new String[0]);

		try {

			WebElement tabelle_denkingen_legende = driver.findElement(By.id("team-fixture-league-tables"));
			WebElement tabelle_denkingen = tabelle_denkingen_legende.findElement(By.className("table"));

			WebElement spielplan_denkingen_legende = driver.findElement(By.id("id-team-matchplan-table"));
			WebElement spielplan_denkingen = spielplan_denkingen_legende.findElement(By.className("table"));

			File spielplanScreen = (File) ((TakesScreenshot) spielplan_denkingen).getScreenshotAs(OutputType.FILE);
			File f = new File(path_base + mannschaft + "_spielplan.png");
			if (f.exists()) {
				f.delete();
			}
			Files.copy(spielplanScreen, new File(path_base + mannschaft + "_spielplan.png"));

			File tabelleScreen = (File) ((TakesScreenshot) tabelle_denkingen).getScreenshotAs(OutputType.FILE);
			File f2 = new File(path_base + mannschaft + "_tabelle.png");
			if (f2.exists()) {
				f2.delete();
			}
			Files.copy(tabelleScreen, new File(path_base + mannschaft + "_tabelle.png"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			editTable(driver, "past");
			jse.executeScript("window.scrollTo(0,document.body.scrollHeight);", new String[0]);
			// jse.executeScript("document.getElementById('id-team-matchplan-table').scrollIntoView();",
			// new String[0]);
			Thread.sleep(1000);
			jse.executeScript("window.scrollTo(0,0)", new String[0]);
			WebElement vergangene_spiele_mit_legende = driver.findElement(By.id("id-team-matchplan-table"));
			WebElement vergangene_spiele = vergangene_spiele_mit_legende.findElement(By.className("table"));

			File spielplanScreen = (File) ((TakesScreenshot) vergangene_spiele).getScreenshotAs(OutputType.FILE);
			File f = new File(path_base + mannschaft + "_letzte_spiele.png");
			if (f.exists()) {
				f.delete();
			}
			Files.copy(spielplanScreen, new File(path_base + mannschaft + "_letzte_spiele.png"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		driver.close();
	}

	/**
	 * Retrieves liga match plan
	 * 
	 * @param url
	 *            Fussball.de Link to Landesliga 3
	 * @throws InterruptedException
	 */
	private void getStaffelpielplan(String url, String mannschaft) throws InterruptedException {
		// Create a new instance of the Firefox driver
		WebDriver driver = new FirefoxDriver();
		driver.get(url);

		// Scroll to matchplan because of lazy-load of images
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		acceptCookies(driver, jse);
		editTable(driver, "liga");
		jse.executeScript("document.body.style.webkitTransform = 'scale(2.5)'", new String[0]);
		driver.manage().window().setSize(new Dimension(3000, 2000));
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight);", new String[0]);
		Thread.sleep(3000);
		jse.executeScript("window.scrollTo(0,0)", new String[0]);

		try {

			WebElement spielplan_landesliga_legende = driver.findElement(By.id("matches"));
			WebElement spielplan_landesliga = spielplan_landesliga_legende.findElement(By.className("table-container"));
			WebElement table_spielplan_landesliga = spielplan_landesliga.findElement(By.className("table"));

			File spielplanScreen = (File) ((TakesScreenshot) table_spielplan_landesliga)
					.getScreenshotAs(OutputType.FILE);
			File f = new File(path_base + mannschaft + "_liga_spielplan.png");
			if (f.exists()) {
				f.delete();
			}
			Files.copy(spielplanScreen, new File(path_base + mannschaft + "_liga_spielplan.png"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		driver.close();
	}

	@SuppressWarnings("all")
	private void editTable(WebDriver driver, String tag) throws InterruptedException {
		// Create a new instance of the Firefox driver

		// Scroll to matchplan because of lazy-load of images
		if (tag.equals("liga")) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript(
					"el = document.getElementById('matches'); node = el.querySelectorAll('[href]'); node[1].click(); ",
					new String[0]);
			Thread.sleep(4500);
			// jse.executeScript(
			// "el = document.getElementById('matches'); next =
			// el.getElementsByClassName('fixtures-matches-table'); node =
			// next[0].getElementsByClassName('nav-next'); n =
			// node[0].querySelectorAll('[href]'); n[0].click();",
			// new String[0]);
			Thread.sleep(2500);
			jse.executeScript(
					"el = document.getElementsByClassName('table').item(0); head = el.rows[0]; head.deleteCell(4); head.deleteCell(4); head.deleteCell(4); head.deleteCell(4); rem = el.getElementsByClassName('column-detail'); while(rem[0]) {rem[0].parentNode.removeChild(rem[0])}",
					new String[0]);
			Thread.sleep(2500);
		} else if (tag.equals("svd")) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript(
					"focus = document.getElementById('id-team-matchplan-table'); el = focus.getElementsByClassName('table').item(0); for (var i = 0, row; row = el.rows[i]; i++) { if (i==0) { row.deleteCell(2);} else if ((i+1) % 3 == 0) {row.deleteCell(2);} else if (i % 3 == 0) {row.deleteCell(4); row.deleteCell(4);}}",
					new String[0]);
		} else if (tag.equals("past")) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript(
					"el = document.getElementById('id-team-matchplan'); node = el.querySelectorAll('[data-tracking-name]'); node[1].click(); ",
					new String[0]);
			Thread.sleep(500);

			jse.executeScript(
					"el = document.getElementById('id-team-matchplan'); table = el.getElementsByClassName('table').item(0); for (var i = 0, row; row = table.rows[i]; i++) { if ((i+1) % 3 == 0) {row.deleteCell(2);}}; rem = table.getElementsByClassName('column-detail'); while(rem[0]) {rem[0].parentNode.removeChild(rem[0])}; for (var i=0, row; row=table.rows[i]; i++) { if (i > 14) { table.deleteRow(i) }} ",
					new String[0]);
			Thread.sleep(500);

		} else if (tag.equals("verein")) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript(
					"focus = document.getElementById('id-club-matchplan-table'); el = focus.getElementsByClassName('table').item(0); for (var i = 0, row; row = el.rows[i]; i++) { if ((i+1)% 3 == 0) { row.deleteCell(2) } else if (i%3 == 0 && i != 0) {row.deleteCell(5)}};",
					new String[0]);
		}
	}

	private void acceptCookies(WebDriver driver, JavascriptExecutor jse) {
		if (driver.findElement(By.className("content")).isDisplayed()) {
			jse.executeScript("document.getElementsByClassName('cookie-advise-accept').item(0).click()", new String[0]);
		}
	}

	// el = document.getElementsByClassName('table').item(0)
	// TABLE

}