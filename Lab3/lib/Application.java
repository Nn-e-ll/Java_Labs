package lib;

import model.*;

import java.util.Scanner;
import java.util.ArrayList;

import static lib.Lang.print;
import static lib.Parser.getUserStringWhileIsNotValid;

import static lib.action.CinemaAdminAction.*;
import static lib.action.CinemaHallAdminAction.*;
import static lib.action.FilmAction.*;
import static lib.action.FilmAdminAction.*;
import static lib.action.ArmchairAdminAction.*;
import static lib.action.FilmSessionAdminAction.*;

public class Application
{
	public static final ArrayList<Cinema> cinemaList = new ArrayList<>();
	public static final ArrayList<Armchair> armchairTemplateList = new ArrayList<>();
	public static final ArrayList<FilmSession> filmSessionList = new ArrayList<>();
	public static final ArrayList<Film> filmList = new ArrayList<>();

	public static Lang lang;
	public static Scanner inScanner;
	private boolean running;
	public static boolean isAdmin;

	public Application()
	{
		running = true;
		isAdmin = false;

		lang = new Lang();
		inScanner = new Scanner(System.in);
	}

	public void start()
	{
		startMessage();

		while (running)
		{
			if (isAdmin)
			{
				print(lang.getMessage("APPLICATION_ADMIN_COMMAND_LIST"));
			}
			else
			{
				print(lang.getMessage("APPLICATION_USER_COMMAND_LIST"));
			}

			String command = getUserStringWhileIsNotValid(true);

			switch (Parser.parseRawStringToInt(command))
			{
				case (1):
					if (isAdmin)
					{
						startCinemaAdminAction();
						break;
					}

					startFilmAction();

					break;

				case (2):
					if (isAdmin)
					{
						startCinemaHallAdminAction();
						break;
					}

					printCinemaList();

					break;

				case (3):
					if (isAdmin)
					{
						startFilmAdminAction();
						break;
					}

					ArrayList<CinemaHall> cinemaHallList = printCinemaHallListAction();
					printCinemaHallSchemeAction(cinemaHallList);

					break;

				case (4):
					if (isAdmin)
					{
						startFilmSessionAdminAction();
					}

					break;

				case (5):
					if (isAdmin)
					{
						startArmchairAdminAction();
					}

					break;

				case (0):
					startMessage();

					break;

				default:
					print(lang.getMessage("APPLICATION_COMMAND_NOT_FOUND"));

					break;
			}
		}
	}

	private void startMessage()
	{
		print(lang.getMessage("APPLICATION_TITLE"));

		String command = getUserStringWhileIsNotValid(true);

		switch (Parser.parseRawStringToInt(command))
		{
			case (1):
				print(lang.getMessage("APPLICATION_LOGIN_AS_USER"));
				isAdmin = false;
				return;
			case (2):
				print(lang.getMessage("APPLICATION_LOGIN_AS_ADMIN"));
				isAdmin = true;
				return;
			case (0):
				running = false;
				return;
			default:
				print(lang.getMessage("APPLICATION_COMMAND_NOT_FOUND"));
				break;
		}
	}
}
