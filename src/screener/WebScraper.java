package screener;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.logging.Level;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.google.common.io.Files;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class WebScraper {

	private FirefoxDriver driver;

	public static void main(String[] args) throws InterruptedException, SecurityException, IOException {
		
		if (System.getProperty("webdriver.firefox.bin") == null) {
			  System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			}
		new WebScraper();
	}
	
	String proj_path = Paths.get(".").toAbsolutePath().normalize().toString();
	String path_base = "c:\\\\tmp\\";
	String jahr = "2021";
	String erste_homepage = "http://www.fussball.de/mannschaft/sv-denkingen-sv-denkingen-suedbaden/-/saison/" + jahr
			+ "/team-id/011MIFD4J4000000VTVG0001VTR8C1K7#!/";
	String erste_liga = "http://www.fussball.de/spieltagsuebersicht/landesliga-3-suedbaden-landesliga-herren-saison2122-suedbaden/-/staffel/02EV3HAGHS000004VS5489B3VUK1A2F6-G#!/";

	String zweite_homepage = "http://www.fussball.de/mannschaft/sv-denkingen-2-sv-denkingen-suedbaden/-/saison/" + jahr
			+ "/team-id/011MIEMTKO000000VTVG0001VTR8C1K7#!/";
	String zweite_liga = "http://www.fussball.de/spieltagsuebersicht/kreisliga-a-staffel-3-bodensee-kreisliga-a-herren-saison2122-suedbaden/-/staffel/02ETOCAUN800000BVS5489B4VT8SVH36-G#!/";

	String dritte_homepage = "http://www.fussball.de/mannschaft/sv-denkingen-3-sv-denkingen-suedbaden/-/saison/" + jahr
			+ "/team-id/01HD2O7RKS000000VV0AG811VSJI13A5#!/";
	String dritte_liga = "http://www.fussball.de/spieltagsuebersicht/kreisliga-c-staffel-3-bodensee-kreisliga-c-herren-saison2122-suedbaden/-/staffel/02ETOCDOB0000000VS5489B4VT8SVH36-G#!/";

	String damen_homepage = "http://www.fussball.de/mannschaft/sv-denkingen-sv-denkingen-suedbaden/-/saison/" + jahr
			+ "/team-id/01L37UK7MO000000VV0AG80NVVQMG8U7#!/";
	String damen_liga = "http://www.fussball.de/spieltagsuebersicht/frauen-bezirksliga-bodensee-bezirk-bodensee-frauen-bezirksliga-frauen-saison2122-suedbaden/-/staffel/02ETOC7EQ8000008VS5489B4VT8SVH36-G#!/";
	String A_homepage_temp = "https://www.fussball.de/mannschaft/sg-denkingen-sv-denkingen-suedbaden/-/saison/2122/team-id/023PJ83GNS000000VS548984VVIKHNJO#!/";
	String B_homepage = "http://www.fussball.de/mannschaft/sg-denkingen-sv-denkingen-suedbaden/-/saison/" + jahr
			+ "/team-id/011MICE2H4000000VTVG0001VTR8C1K7#!/";
	String C1_homepage = "http://www.fussball.de/mannschaft/sg-aach-linz-tsv-aach-linz-suedbaden/-/saison/" + jahr
			+ "/team-id/01L23UFULO000000VV0AG811VV4PB99G#!/";
	String C2_homepage = "http://www.fussball.de/mannschaft/sg-aach-linz-2-tsv-aach-linz-suedbaden/-/saison/" + jahr
			+ "/team-id/01L23V1FRO000000VV0AG811VV4PB99G#!/";
	String D1_homepage = "http://www.fussball.de/mannschaft/sg-denkingen-sv-denkingen-suedbaden/-/saison/" + jahr
			+ "/team-id/02BCT258HK000000VS5489B2VU21J0QC#!/";

	String D2_homepage = "http://www.fussball.de/mannschaft/sg-denkingen-sv-denkingen-suedbaden/-/saison/" + jahr
			+ "/team-id/02BCT3R5H0000000VS5489B2VU21J0QC#!/";

	String E1_homepage = "http://www.fussball.de/mannschaft/sg-denkingen-sv-denkingen-suedbaden/-/saison/" + jahr
			+ "/team-id/02BE3U1S0K000000VS5489B2VU21J0QC#!/";

	String E2_homepage = "http://www.fussball.de/mannschaft/sg-denkingen-sv-denkingen-suedbaden/-/saison/" + jahr
			+ "/team-id/02BE3UD9EC000000VS5489B2VU21J0QC#!/";

	String BDamen_homepage = "http://www.fussball.de/mannschaft/sg-denkingen-sv-denkingen-suedbaden/-/saison/" + jahr
			+ "/team-id/011MIFA7S4000000VTVG0001VTR8C1K7#!/";

	String DDamen_homepage = "http://www.fussball.de/mannschaft/sg-denkingen-sv-denkingen-suedbaden/-/saison/" + jahr
			+ "/team-id/02EQ2SPAEC000000VS5489B1VT0RKM5V#!/";



	String verein = "http://www.fussball.de/verein/sv-denkingen-suedbaden/-/id/00ES8GN9CG0000AJVV0AG08LVUPGND5I#!/";

	public WebScraper() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", proj_path  + "/lib/geckodriver.exe");
		FirefoxProfile profile = new FirefoxProfile(new File(proj_path + "/lib/firefox/ff_profile"));
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(profile);
		this.driver = new FirefoxDriver(options);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		acceptCookies(driver, jse);

		getTabelleAndSpielplan(erste_homepage, "svd1");
		getTabelleAndSpielplan(zweite_homepage, "svd2");
		getTabelleAndSpielplan(dritte_homepage, "svd3");
		getTabelleAndSpielplan(damen_homepage, "svdDamen");
		getTabelleAndSpielplan(A_homepage_temp, "svdA");
		getTabelleAndSpielplan(B_homepage, "svdB");
		getTabelleAndSpielplan(C1_homepage, "svdC1");
		getTabelleAndSpielplan(C2_homepage, "svdC2");
		getTabelleAndSpielplan(D1_homepage, "svdD1");
		getTabelleAndSpielplan(D2_homepage, "svdD2");
		getTabelleAndSpielplan(E1_homepage, "svdE1");
		getTabelleAndSpielplan(E2_homepage, "svdE2");
		getTabelleAndSpielplan(BDamen_homepage, "svdBDamen");
		getTabelleAndSpielplan(DDamen_homepage, "svdDDamen");

		getStaffelpielplan(erste_liga, "svd1");
		getStaffelpielplan(zweite_liga, "svd2");
		getStaffelpielplan(dritte_liga, "svd3");
		getStaffelpielplan(damen_liga, "svdDamen");

		getVereinsspielplan(verein, "vereinsspielplan");

		driver.quit();
	}

	/**
	 * Retrieves SV Denkingen club match plan
	 * 
	 * @param url
	 *            link to SV Denkingen club
	 * @param mannschaft output filename
	 * @throws InterruptedException
	 */
	public void getVereinsspielplan(String url, String mannschaft) throws InterruptedException {
		// Create a new instance of the Firefox driver
		driver.manage().window().setSize(new Dimension(1920, 1080));

		driver.get(url);
		// Scroll to matchplan because of lazy-load of images
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.body.style.webkitTransform = 'scale(2.5)'", (Object) new String[0]);
		driver.manage().window().setSize(new Dimension(3000, 2000));
		editTable(driver, "verein");
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight);", (Object) new String[0]);
		// jse.executeScript("document.getElementById('id-club-matchplan-table').scrollIntoView();",
		// new String[0]);
		Thread.sleep(3000);
		// jse.executeScript("document.getElementById('clubProfile').scrollIntoView();",
		// new String[0]);
		Thread.sleep(2000);
		jse.executeScript("window.scrollTo(0,0)", (Object) new String[0]);

		try {

			WebElement spielplan_verein_legende = driver.findElement(By.id("id-club-matchplan-table"));
			WebElement spielplan_verein = spielplan_verein_legende.findElement(By.className("table"));

			File spielplanScreen = (File) ((TakesScreenshot) spielplan_verein).getScreenshotAs(OutputType.FILE);
			File f = new File(path_base + mannschaft + ".png");
			if (f.exists()) {
				f.delete();
			}
			Files.copy(spielplanScreen, new File(path_base + "\\" + mannschaft + ".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retrieves Denkingen match plan and leaderbord
	 * 
	 * @param url
	 *            Fussball.de Link to Denkingen 1
	 */
	void getTabelleAndSpielplan(String url, String mannschaft) throws InterruptedException {
		driver.get(url);
		// Scroll to matchplan because of lazy-load of images

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.body.style.webkitTransform = 'scale(2.5)'", (Object) new String[0]);
		driver.manage().window().setSize(new Dimension(3000, 2000));
		Thread.sleep(3000);
		editTable(driver, "svd");
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight);", (Object) new String[0]);
		jse.executeScript("document.getElementById('id-team-matchplan-table').scrollIntoView();",
				(Object) new String[0]);
		jse.executeScript("document.body.style.webkitTransform = 'scale(1.0)'", (Object) new String[0]);
		Thread.sleep(2000);
		jse.executeScript("document.body.style.webkitTransform = 'scale(2.5)'", (Object) new String[0]);
		Thread.sleep(3000);
		jse.executeScript("window.scrollTo(0,0)", (Object) new String[0]);

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
			jse.executeScript("window.scrollTo(0,document.body.scrollHeight);", (Object) new String[0]);
			// jse.executeScript("document.getElementById('id-team-matchplan-table').scrollIntoView();",
			// new String[0]);
			Thread.sleep(1000);
			jse.executeScript("window.scrollTo(0,0)", (Object) new String[0]);
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
	}

	/**
	 * Retrieves liga match plan
	 * 
	 * @param url
	 * Fussball.de Link to Landesliga 3
	 */
	private void getStaffelpielplan(String url, String mannschaft) throws InterruptedException {
		driver.get(url);
		// Scroll to matchplan because of lazy-load of images
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		editTable(driver, "liga");
		jse.executeScript("document.body.style.webkitTransform = 'scale(2.5)'", (Object) new String[0]);
		driver.manage().window().setSize(new Dimension(3000, 2000));
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight);", (Object) new String[0]);
		Thread.sleep(3000);
		jse.executeScript("window.scrollTo(0,0)", (Object) new String[0]);

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
	}

	@SuppressWarnings("all")
	private void editTable(WebDriver driver, String tag) throws InterruptedException {
		// Create a new instance of the Firefox driver
		Thread.sleep(2500);
		// Scroll to matchplan because of lazy-load of images
		if (tag.equals("liga")) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;

			// href = el.getElementsByClassName('nav-next')[0]; href.children[0].click() 
			jse.executeScript(
					"el = document.getElementById('matches'); node = el.querySelectorAll('[href]'); node[1].click(); ",
					new String[0]);
			Thread.sleep(3000);
			
			// Comment the following script if past games should be screenshoted otherwise next week games are selected
			 jse.executeScript(
			 "el = document.getElementById('matches'); next = el.getElementsByClassName('fixtures-matches-table'); node = next[0].getElementsByClassName('nav-next'); n = node[0].querySelectorAll('[href]'); n[0].click();",
			 new String[0]);
			Thread.sleep(2500);
			
			// livetickers = el.getElementsByClassName('info-text sub'); function delLive() { for (i = 0; i < livetickers.length; i++) { livetickers[i].parentNode.removeChild(livetickers[i])} }; for (i=0; i<7; i++) {delLive(); }
			jse.executeScript(
					"el = document.getElementsByClassName('table').item(0); head = el.rows[0]; head.deleteCell(4); head.deleteCell(4); head.deleteCell(4); head.deleteCell(4); rem = el.getElementsByClassName('column-detail'); while(rem[0]) {rem[0].parentNode.removeChild(rem[0])};  ",
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
			Thread.sleep(3000);

			jse.executeScript(
					"el = document.getElementById('id-team-matchplan'); table = el.getElementsByClassName('table').item(0); for (var i = 0, row; row = table.rows[i]; i++) { if ((i+1) % 3 == 0) {row.deleteCell(2);}}; rem = table.getElementsByClassName('column-detail'); while(rem[0]) {rem[0].parentNode.removeChild(rem[0])}; for (var i=table.rows.length; i > 0; i--) { if (i > 25) { table.deleteRow(i-1) }}; el.getElementsByClassName('tab-group')[0].remove()",
					new String[0]);
			Thread.sleep(500);

		} else if (tag.equals("verein")) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("document.querySelectorAll('a.ng-scope')[2].click()", (Object) new String[0]);
			Thread.sleep(2000);
			jse.executeScript("tbl = document.querySelectorAll('table.ng-scope.ng-isolate-scope')[2];" +
					"date = new Date().getDate();" +
					"tbl.querySelectorAll('button.btn')[((date+5)%31)+6].click();", (Object) new String[0]);
			Thread.sleep(2000);
			jse.executeScript("document.querySelectorAll('button.button.button-primary')[11].click()", (Object) new String[0]);
			Thread.sleep(2000);
			jse.executeScript(
							"focus = document.getElementById('id-club-matchplan-table'); " +
							"el = focus.getElementsByClassName('table').item(0); " +
							"for (var i = 0, row; row = el.rows[i]; i++) { " +
							"if ((i+1)% 3 == 0) { row.deleteCell(2) } " +
							"else if (i%3 == 0 && i != 0) {row.deleteCell(5)}};" +
							"document.querySelector('table.table-striped.table-full-width').deleteTFoot();",  (Object) new String[0]);



		}
		Thread.sleep(1000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		adjustFont(driver, jse, 0.65);
	}

	private void acceptCookies(WebDriver driver, JavascriptExecutor jse) throws InterruptedException {
		driver.get("https://www.fussball.de");
		Thread.sleep(2000);
		String rmCookies = "document.getElementById('usercentrics-root').shadowRoot.querySelector('.bpwvLJ').click()";
		Thread.sleep(3000);
		jse.executeScript(rmCookies, (Object) new String[0]);
	}

	private void adjustFont(WebDriver driver, JavascriptExecutor jse, double percent) {
		jse.executeScript("document.body.style.fontSizeAdjust=" + percent + ";",  (Object) new String[0]);
	}
}
