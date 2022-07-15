package com.techelevator;

import javax.sql.DataSource;

import com.techelevator.model.Campground;
import com.techelevator.model.Park;
import com.techelevator.model.Reservation;
import com.techelevator.model.Site;
import com.techelevator.view.Menu;
import com.techelevator.dao.*;
import org.apache.commons.dbcp2.BasicDataSource;
import com.techelevator.dao.ParkDao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class CampgroundCLI {

	private static final String MAIN_MENU_OPTION_PARKS = "Parks";
	private static final String MAIN_MENU_OPTION_RESERVATION = "Reservation";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";

	private static final String[] MAIN_MENU_OPTIONS = new String[]{
			MAIN_MENU_OPTION_PARKS,
			MAIN_MENU_OPTION_RESERVATION,
			MAIN_MENU_OPTION_EXIT};

	private static final String DEPT_MENU_OPTION_ALL_RESERVATIONS = "Show all reservations";
	private static final String DEPT_MENU_OPTION_ALL_CAMPGROUNDS = "Show all campgrounds";

	private static final String OPTION_VIEW_CAMPGROUNDS = "View campgrounds";
	private static final String OPTION_SEARCH_FOR_RESERVATIONS = "Search for reservation";
	private static final String RETURN_TO_PREVIOUS_SCREEN = "Return to previous screen";
	private static final String[] SELECT_A_COMMAND_OPTIONS = new String[]{OPTION_VIEW_CAMPGROUNDS, OPTION_SEARCH_FOR_RESERVATIONS, RETURN_TO_PREVIOUS_SCREEN};


	private static final String[] CAMPGROUNDS_MENU_OPTIONS = new String[]{DEPT_MENU_OPTION_ALL_CAMPGROUNDS};
	private static final String[] RESERVATIONS_MENU_OPTIONS = new String[]{DEPT_MENU_OPTION_ALL_RESERVATIONS};

	private final Menu menu;
	private final CampgroundDao campgroundDao;
	private final ParkDao parkDao;
	private final ReservationDao reservationDao;
	private final SiteDao siteDao;

	public static void main(String[] args) {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/campground");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");

		CampgroundCLI application = new CampgroundCLI(dataSource);
		application.run();

	}

	public CampgroundCLI(DataSource dataSource) {
		this.menu = new Menu(System.in, System.out);
		campgroundDao = new JdbcCampgroundDao(dataSource);
		parkDao = new JdbcParkDao(dataSource);
		reservationDao = new JdbcReservationDao(dataSource);
		siteDao = new JdbcSiteDao(dataSource);
	}

	public void run() {
		boolean running = true;
		while (running) {
			printHeading("Main Menu");
			displayApplicationBanner();
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if (choice.equals(MAIN_MENU_OPTION_PARKS)) {
				handleParks();
			}

			else if (choice.equals(MAIN_MENU_OPTION_RESERVATION)) {
				List<Campground> campgrounds = campgroundDao.getAllCampgrounds();
				manageParkSelectionCommand(campgrounds); //shows all campgrounds
				handleReservation(campgrounds);

			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				running = false;
			}

		}
	}

	private void handleParks() {
		printHeading("Select a Park");

		int counter = 1;

		List<Park> parks = parkDao.getAllAvailableParks();
		System.out.println();
		if (parks.size() > 0) {
			for (Park park : parks) {
				System.out.println(counter + ") " + park.getName());
				counter++;
			}
		}

		String parkSelectionRaw = getUserInput(" \n");
		int parkSelectionInt = Integer.parseInt(parkSelectionRaw);
		Park selectedPark = parks.get(parkSelectionInt - 1);

		System.out.println(" ");
		System.out.println(selectedPark.getName());
		System.out.println("Location: " + selectedPark.getLocation());
		System.out.println("Established: " + selectedPark.getEstablish_date());
		System.out.println("Area " + selectedPark.getArea());
		System.out.println("Annual Visitors: " + selectedPark.getVisitors());
		System.out.println(selectedPark.getDescription());
		System.out.println(" ");

		List<Campground> campgrounds = campgroundDao.getAllCampgroundsOfPark(selectedPark.getPark_id());
		manageParkSelectionCommand(campgrounds); //shows all campgrounds

		String campgroundSelectionCommand = getUserInput("Select A Command \n 1) Search for Available Reservation" +
				"\n 2) Return to Previous Screen \n"); //if 2 is chosen, must go back to park information screen

		int campgroundCommand = Integer.parseInt(campgroundSelectionCommand);

		if (campgroundCommand == 1) {
			parkCampgroundsDisplay(campgrounds);
			handleReservation(campgrounds);

		}
	}

	private void manageParkSelectionCommand(List<Campground> campgrounds){
		while (true){
			String parkSelectionChoice=(String)menu.getChoiceFromOptions(SELECT_A_COMMAND_OPTIONS);
			if (parkSelectionChoice.equals(OPTION_VIEW_CAMPGROUNDS)){
				parkCampgroundsDisplay(campgrounds);
				break;

			}
			else if( parkSelectionChoice.equals(OPTION_SEARCH_FOR_RESERVATIONS)){
				parkCampgroundsDisplay(campgrounds);
				handleReservation(campgrounds);
			}
			else if ( parkSelectionChoice.equals(RETURN_TO_PREVIOUS_SCREEN)){
				return;
			}
		}
	}

	private void handleReservation(List<Campground> campgrounds){
		String userChoiceCampground = getUserInput("Which campground? (Enter 0 to cancel)");
		int campgroundSelectionInt = Integer.parseInt(userChoiceCampground);
		if(campgroundSelectionInt == 0){return;}
		Campground campground = campgrounds.get(campgroundSelectionInt - 1);

		String userChoiceArrival = getUserInput("What is the arrival date? (YYYY-MM-DD)");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d", Locale.ENGLISH);
		LocalDate userFromDate = LocalDate.parse(userChoiceArrival, formatter);

		String userChoiceDeparture = getUserInput("What is the end date? (YYYY-MM-DD)");
		LocalDate userToDate = LocalDate.parse(userChoiceDeparture, formatter);

		List<Site> sites = siteDao.getAvailableSites(campground.getCampground_id(),userFromDate,userToDate);

		Long duration = ChronoUnit.DAYS.between(userFromDate,userToDate);
		double visit_duration = duration.doubleValue();

		double daily_cost = campground.getDaily_fee().doubleValue(); // The double you want

		campgroundSitesDisplay(sites,daily_cost*visit_duration);

		String userChoiceSite = getUserInput("Which site should be reserved (enter 0 to cancel)?");
		int siteSelectionInt = Integer.parseInt(userChoiceSite);
		if(siteSelectionInt == 0){return;}
		Site userSite = sites.get(siteSelectionInt - 1);

		String userName = getUserInput("What name should the reservation be made under?");

		Reservation userReservation = new Reservation();
		userReservation.setName(userName);
		userReservation.setSite_id(userSite.getSite_id());
		userReservation.setFrom_date(userFromDate);
		userReservation.setTo_date(userToDate);
		userReservation.setCreate_date(LocalDate.now()); //create date is current date user is making reservation

		userReservation = reservationDao.createReservation(userReservation);
		System.out.println("The reservation has been made and the confirmation id is " + userReservation.getReservation_id());
	}

	private void parkCampgroundsDisplay(List<Campground> campgrounds){
			System.out.println();
			int campgroundCounter = 1;
			if(campgrounds.size() > 0) {
				System.out.println("Name \t\t\tOpen \tClose \tDaily Fee");
				for(Campground campground : campgrounds) {
					System.out.println(campgroundCounter + ") " + campground.getName() + " \t"+ campground.getOpenMonth() + " \t"+ campground.getCloseMonth() + " \t$" +campground.getDaily_fee());
					campgroundCounter++;
				}
			}
			else {
				System.out.println("\n*** No results ***");
			}
	}

	private void campgroundSitesDisplay(List<Site> sites, Double total_cost){
			System.out.print("Results Matching Your Search Criteria: ");
			//make cost variable to replace XX.XX placeholder for 3d

			System.out.println();

			if(sites.size() > 0) {
				System.out.println("Site No. \tMax Occup. \tAccessible? \tMax RV Length \tUtility \tCost");
				for(Site site : sites) {
					System.out.println(site.getSite_number() + " \t \t \t \t"+ site.getMax_occupancy() + " \t \t \t"+ site.isAccessible()+ " \t \t \t" +site.getMax_rv_length() + " \t \t \t"+site.isUtilities() +" \t \t$"+total_cost);
				}
			}
			else {
				System.out.println("\n*** No results ***");
			}
		}

	private String getUserInput(String prompt) {
		System.out.print(prompt + " >>> ");
		return new Scanner(System.in).nextLine();
	}

	private void printHeading(String headingText) {
		System.out.println("\n"+headingText);
		for(int i = 0; i < headingText.length(); i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	private void displayApplicationBanner() {
		System.out.println(" _   _       _   _                   _  ______          _      _____                           _ _        ______                               _   _               _____                 _                   ");
		System.out.println("| \\ | |     | | (_)                 | | | ___ \\        | |    /  __ \\                         (_) |       | ___ \\                             | | (_)             /  __ \\               | |                  ");
		System.out.println("|  \\| | __ _| |_ _  ___  _ __   __ _| | | |_/ /_ _ _ __| | __ | /  \\/ __ _ _ __ ___  _ __  ___ _| |_ ___  | |_/ /___  ___  ___ _ ____   ____ _| |_ _  ___  _ __   | /  \\/ __ _ _ __  ___| |_ ___  _ __   ___ ");
		System.out.println("| . ` |/ _` | __| |/ _ \\| '_ \\ / _` | | |  __/ _` | '__| |/ / | |    / _` | '_ ` _ \\| '_ \\/ __| | __/ _ \\ |    // _ \\/ __|/ _ \\ '__\\ \\ / / _` | __| |/ _ \\| '_ \\  | |    / _` | '_ \\/ __| __/ _ \\| '_ \\ / _ \\");
		System.out.println("| |\\  | (_| | |_| | (_) | | | | (_| | | | | | (_| | |  |   <  | \\__/\\ (_| | | | | | | |_) \\__ \\ | ||  __/ | |\\ \\  __/\\__ \\  __/ |   \\ V / (_| | |_| | (_) | | | | | \\__/\\ (_| | |_) \\__ \\ || (_) | | | |  __/");
		System.out.println("\\_| \\_/\\__,_|\\__|_|\\___/|_| |_|\\__,_|_| \\_|  \\__,_|_|  |_|\\_\\  \\____/\\__,_|_| |_| |_| .__/|___/_|\\__\\___| \\_| \\_\\___||___/\\___|_|    \\_/ \\__,_|\\__|_|\\___/|_| |_|  \\____/\\__,_| .__/|___/\\__\\___/|_| |_|\\___|");
		System.out.println("                                                                                    | |                                                                                       | |                            ");
		System.out.println("                                                                                    |_|                                                                                       |_|                            ");

		System.out.println();

		System.out.println("______           ___                              _____            _   _                                                                                                                                     ");
		System.out.println("| ___ \\         |_  |                     ___    |  __ \\          | | | |                                                                                                                                    ");
		System.out.println("| |_/ /_   _      | |_   _  __ _ _ __    ( _ )   | |  \\/ ___ _ __ | |_| | ___                                                                                                                                ");
		System.out.println("| ___ \\ | | |     | | | | |/ _` | '_ \\   / _ \\/\\ | | __ / _ \\ '_ \\| __| |/ _ \\                                                                                                                               ");
		System.out.println("| |_/ / |_| | /\\__/ / |_| | (_| | | | | | (_>  < | |_\\ \\  __/ | | | |_| |  __/                                                                                                                               ");
		System.out.println("\\____/ \\__, | \\____/ \\__,_|\\__,_|_| |_|  \\___/\\/  \\____/\\___|_| |_|\\__|_|\\___|                                                                                                                               ");
		System.out.println("        __/ |                                                                                                                                                                                                ");
		System.out.println("       |___/                                                                                                                                                                                                 ");

	}
}

