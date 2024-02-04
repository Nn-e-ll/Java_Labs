package lib.action;

import lib.Parser;
import model.Cinema;
import view.CinemaView;

import java.util.ArrayList;

import static lib.Application.cinemaList;
import static lib.Application.isAdmin;
import static lib.Application.lang;
import static lib.Lang.print;
import static lib.Parser.getUserStringWhileIsNotValid;

public class CinemaAdminAction
{
	public static void startCinemaAdminAction()
	{
		print(lang.getMessage("APPLICATION_ADMIN_CINEMA_COMMAND_LIST"));

		String command = getUserStringWhileIsNotValid(true);

		switch (Parser.parseRawStringToInt(command))
		{
			case (1):
				printCinemaList();
				return;
			case (2):
				createNewCinemaAction();
				return;
			case (3):
				printCinemaList();
				deleteCinemaAction();
				return;
			case (0):
				return;
			default:
				print(lang.getMessage("APPLICATION_COMMAND_NOT_FOUND"));
		}
	}

	public static void printCinemaList()
	{
		print(lang.getMessage("APPLICATION_CINEMA_LIST"));

		if (cinemaList.isEmpty())
		{
			print(lang.getMessage("APPLICATION_EMPTY_LIST"));
			return;
		}

		print(CinemaView.prepareCinemaListToPrint(cinemaList));
	}

	private static void createNewCinemaAction()
	{
		if (!isAdmin)
		{
			return;
		}

		print(lang.getMessage("APPLICATION_GET_CINEMA_TITLE"));
		String title = getUserStringWhileIsNotValid(false);

		cinemaList.add(new Cinema(title));
	}

	private static void deleteCinemaAction()
	{
		if (!isAdmin)
		{
			return;
		}

		if (cinemaList.isEmpty())
		{
			return;
		}

		print(lang.getMessage("APPLICATION_GET_CINEMA_INDEX_TO_DELETE"));
		int index = Parser.parseRawStringToInt(getUserStringWhileIsNotValid(true)) - 1;

		if (index >= 0 && index < cinemaList.size())
		{
			cinemaList.remove(index);
			return;
		}

		print(lang.getMessage("APPLICATION_INDEX_IS_NOT_VALID"));
	}
}
