package lib.action;

import lib.Parser;
import model.Cinema;
import model.CinemaHall;
import model.Film;
import model.FilmSession;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

import static controller.FilmSessionController.*;
import static lib.Application.filmSessionList;
import static lib.Application.filmList;
import static lib.Application.cinemaList;
import static lib.Application.isAdmin;
import static lib.Application.lang;
import static lib.Lang.print;
import static lib.Parser.getUserStringWhileIsNotValid;
import static lib.Parser.parseStringToDate;
import static view.FilmSessionView.*;
import static lib.Validator.isRowDateStringValid;
import static lib.action.FilmAdminAction.printFilmList;
import static lib.action.CinemaHallAdminAction.printCinemaHallListAction;

public class FilmSessionAdminAction
{
	public static void startFilmSessionAdminAction()
	{
		print(lang.getMessage("APPLICATION_ADMIN_FILM_SESSION_COMMAND_LIST"));

		String command = getUserStringWhileIsNotValid(true);

		switch (Parser.parseRawStringToInt(command))
		{
			case (1):
				printFilmSessionListAction();
				return;
			case (2):
				addNewFilmSessionAction();
				return;
			case (3):
				printFilmSessionListAction();
				deleteFilmSessionAction();
				return;
			case (0):
				return;
			default:
				print(lang.getMessage("APPLICATION_COMMAND_NOT_FOUND"));
		}
	}

	public static void printFilmSessionListAction()
	{
		print(lang.getMessage("APPLICATION_FILM_SESSION_LIST"));

		if (filmSessionList.isEmpty())
		{
			print(lang.getMessage("APPLICATION_EMPTY_LIST"));
			return;
		}

		print(prepareFilmSessionListToPrint(filmSessionList));
	}

	private static void addNewFilmSessionAction()
	{
		if (!isAdmin)
		{
			return;
		}

		printFilmList();

		if (filmList.isEmpty())
		{
			return;
		}

		print(lang.getMessage("APPLICATION_FILM_SESSION_GET_FILM_INDEX"));

		int filmIndex = Parser.parseRawStringToInt(getUserStringWhileIsNotValid(true)) - 1;

		if (filmIndex < 0 || filmIndex >= filmList.size())
		{
			print(lang.getMessage("APPLICATION_INDEX_IS_NOT_VALID"));
			return;
		}

		ArrayList<CinemaHall> cinemaHallList = printCinemaHallListAction();

		print(lang.getMessage("APPLICATION_FILM_SESSION_GET_CINEMAHALL_INDEX"));

		int cinemaHallIndex = Parser.parseRawStringToInt(getUserStringWhileIsNotValid(true)) - 1;

		if (cinemaHallIndex < 0 || cinemaHallIndex >= cinemaHallList.size())
		{
			print(lang.getMessage("APPLICATION_INDEX_IS_NOT_VALID"));
			return;
		}

		print(lang.getMessage("APPLICATION_FILM_SESSION_GET_DATE"));

		String rowDate = getUserStringWhileIsNotValid(false);

		if (!isRowDateStringValid(rowDate))
		{
			print(lang.getMessage("APPLICATION_FILM_SESSION_DATE_FORMAT_IS_NOT_VALID"));
			return;
		}

		Date date = parseStringToDate(rowDate);

		if (date.before(new Date(System.currentTimeMillis())))
		{
			print(lang.getMessage("APPLICATION_FILM_SESSION_DATE_ERROR"));
			return;
		}

		filmSessionList.add(createNewFilmSession(filmList.get(filmIndex), date, cinemaHallList.get(cinemaHallIndex)));
	}

	private static void deleteFilmSessionAction()
	{
		if (!isAdmin)
		{
			return;
		}

		if (filmSessionList.isEmpty())
		{
			return;
		}

		print(lang.getMessage("APPLICATION_GET_FILM_SESSION_INDEX_TO_DELETE"));
		int index = Parser.parseRawStringToInt(getUserStringWhileIsNotValid(true)) - 1;

		if (index >= 0 && index < filmSessionList.size())
		{
			filmSessionList.remove(index);
			return;
		}

		print(lang.getMessage("APPLICATION_INDEX_IS_NOT_VALID"));
	}
}
