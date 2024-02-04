package lib.action;

import controller.CinemaController;
import controller.CinemaHallController;
import lib.Parser;
import model.CinemaHall;
import view.CinemaHallView;

import java.util.ArrayList;

import static controller.FilmSessionController.deleteAllFimlSessionsInCinemaHall;
import static lib.Application.cinemaList;
import static lib.Application.armchairTemplateList;
import static lib.Application.isAdmin;
import static lib.Application.lang;
import static lib.Lang.print;
import static lib.Parser.getUserStringWhileIsNotValid;
import static lib.action.CinemaAdminAction.printCinemaList;
import static lib.action.ArmchairAdminAction.printArmchairTemplateList;

public class CinemaHallAdminAction
{
	public static void startCinemaHallAdminAction()
	{
		print(lang.getMessage("APPLICATION_ADMIN_CINEMAHALL_COMMAND_LIST"));

		String command = getUserStringWhileIsNotValid(true);

		switch (Parser.parseRawStringToInt(command))
		{
			case (1):
				printCinemaHallListAction();
				return;
			case (2):
				ArrayList<CinemaHall> cinemaHallList = printCinemaHallListAction();
				printCinemaHallSchemeAction(cinemaHallList);
				return;
			case (3):
				createNewCinemaHallAction();
				return;
			case (4):
				deleteCinemaHallAction();
				return;
			case (5):
				addArmchairToCinemaHallAction();
				return;
			case (6):
				deleteArmchairInRowAction();
				return;
			case (0):
				return;
			default:
				print(lang.getMessage("APPLICATION_COMMAND_NOT_FOUND"));
		}
	}

	public static ArrayList<CinemaHall> printCinemaHallListAction()
	{
		printCinemaList();

		if (cinemaList.isEmpty())
		{
			return new ArrayList<>();
		}

		print(lang.getMessage("APPLICATION_GET_CINEMAHALL_CINEMA_ID"));
		int index = Parser.parseRawStringToInt(getUserStringWhileIsNotValid(true)) - 1;

		if (index < 0 || index >= cinemaList.size())
		{
			print(lang.getMessage("APPLICATION_INDEX_IS_NOT_VALID"));
			return new ArrayList<>();
		}

		print(lang.getMessage("APPLICATION_CINEMAHALL_LIST"));
		ArrayList<CinemaHall> cinemaHallList = cinemaList.get(index).getCinemaHallList();

		if (cinemaHallList.isEmpty())
		{
			print(lang.getMessage("APPLICATION_EMPTY_LIST"));
			return new ArrayList<>();
		}

		print(CinemaHallView.prepareCinemaHallListToPrint(cinemaList.get(index).getCinemaHallList()));
		return cinemaHallList;
	}

	public static int printCinemaHallSchemeAction(ArrayList<CinemaHall> cinemaHallList)
	{
		if (cinemaHallList.isEmpty())
		{
			return -1;
		}

		print(lang.getMessage("APPLICATION_GET_CINEMAHALL_ID_TO_PRINT_SCHEME"));

		int index = Parser.parseRawStringToInt(getUserStringWhileIsNotValid(true)) - 1;

		if (index < 0 || index >= cinemaHallList.size())
		{
			print(lang.getMessage("APPLICATION_INDEX_IS_NOT_VALID"));
			return -1;
		}

		String scheme = CinemaHallView.prepareCinemaHallScheme(cinemaHallList.get(index));
		if (!scheme.isEmpty())
		{
			print(scheme);
			return index;
		}

		print(lang.getMessage("APPLICATION_EMPTY_LIST"));
		return index;
	}


	private static void createNewCinemaHallAction()
	{
		if (!isAdmin)
		{
			return;
		}

		if (cinemaList.isEmpty())
		{
			print(lang.getMessage("APPLICATION_GET_CINEMAHALL_EMPTY_CINEMA_LIST"));
			return;
		}

		print(lang.getMessage("APPLICATION_GET_CINEMAHALL_TITLE"));
		String title = getUserStringWhileIsNotValid(false);

		print(lang.getMessage("APPLICATION_GET_CINEMAHALL_ROW_COUNT"));
		int rowCount = Parser.parseRawStringToInt(getUserStringWhileIsNotValid(true));

		if (rowCount == 0)
		{
			print(lang.getMessage("APPLICATION_GET_CINEMAHALL_ROW_COUNT_NOT_VALID"));
			return;
		}

		printCinemaList();

		print(lang.getMessage("APPLICATION_GET_CINEMAHALL_CINEMA_ID_TO_ADD"));
		int index = Parser.parseRawStringToInt(getUserStringWhileIsNotValid(true)) - 1;

		if (index < 0 || index >= cinemaList.size())
		{
			print(lang.getMessage("APPLICATION_INDEX_IS_NOT_VALID"));
			return;
		}

		CinemaController.addCinemaHallToCinema(index, CinemaHallController.createNewCinemaHall(title, rowCount));
	}

	private static void deleteCinemaHallAction()
	{
		if (!isAdmin)
		{
			return;
		}

		if (cinemaList.isEmpty())
		{
			print(lang.getMessage("APPLICATION_EMPTY_LIST"));
			return;
		}

		ArrayList<CinemaHall> cinemaHallList = printCinemaHallListAction();

		if (cinemaHallList.isEmpty())
		{
			return;
		}

		print(lang.getMessage("APPLICATION_GET_CINEMAHALL_INDEX_TO_DELETE"));

		int index = Parser.parseRawStringToInt(getUserStringWhileIsNotValid(true)) - 1;

		if (index < 0 || index >= cinemaList.size())
		{
			print(lang.getMessage("APPLICATION_INDEX_IS_NOT_VALID"));
			return;
		}

		deleteAllFimlSessionsInCinemaHall(cinemaHallList.get(index).getId());

		cinemaHallList.remove(index);
	}

	private static void addArmchairToCinemaHallAction()
	{
		if (!isAdmin)
		{
			return;
		}

		if (cinemaList.isEmpty())
		{
			print(lang.getMessage("APPLICATION_EMPTY_LIST"));
			return;
		}

		if (armchairTemplateList.isEmpty())
		{
			print(lang.getMessage("APPLICATION_ARMCHAIR_LIST_IS_EMPTY"));
			return;
		}

		ArrayList<CinemaHall> cinemaHallList = printCinemaHallListAction();

		if (cinemaHallList.isEmpty())
		{
			return;
		}

		int cinemaHallIndex = printCinemaHallSchemeAction(cinemaHallList);

		if (cinemaHallIndex == -1)
		{
			return;
		}

		CinemaHall cinemaHall = cinemaHallList.get(cinemaHallIndex);

		print(lang.getMessage("APPLICATION_GET_ARMCHAIR_ROW_TO_ADD_TO_CINEMAHALL") + cinemaHall.getRowCount() + '.');

		int row = Parser.parseRawStringToInt(getUserStringWhileIsNotValid(true)) - 1;

		if (row < 0 || row >= cinemaHall.getRowCount())
		{
			print(lang.getMessage("APPLICATION_INDEX_IS_NOT_VALID"));
			return;
		}

		printArmchairTemplateList();

		print(lang.getMessage("APPLICATION_GET_ARMCHAIR_INDEX_TO_ADD_TO_CINEMAHALL"));

		int armchairIndex = Parser.parseRawStringToInt(getUserStringWhileIsNotValid(true)) - 1;

		if (armchairIndex < 0 || armchairIndex >= armchairTemplateList.size())
		{
			print(lang.getMessage("APPLICATION_INDEX_IS_NOT_VALID"));
			return;
		}

		print(lang.getMessage("APPLICATION_GET_ARMCHAIR_COUNT_TO_ADD_TO_CINEMAHALL"));

		int count = Parser.parseRawStringToInt(getUserStringWhileIsNotValid(true));

		if (count == 0)
		{
			print(lang.getMessage("APPLICATION_GET_ARMCHAIR_COUNT_NOT_VALID"));
			return;
		}

		CinemaHallController.addArmchairToCinemaHall(cinemaHall, row, armchairTemplateList.get(armchairIndex), count);
	}

	private static void deleteArmchairInRowAction()
	{
		if (!isAdmin)
		{
			return;
		}

		if (cinemaList.isEmpty())
		{
			print(lang.getMessage("APPLICATION_EMPTY_LIST"));
			return;
		}

		ArrayList<CinemaHall> cinemaHallList = printCinemaHallListAction();

		int cinemaHallIndex = printCinemaHallSchemeAction(cinemaHallList);

		if (cinemaHallIndex == -1)
		{
			return;
		}

		CinemaHall cinemaHall = cinemaHallList.get(cinemaHallIndex);

		print(lang.getMessage("APPLICATION_GET_ARMCHAIR_ROW_TO_DELETE") + cinemaHall.getRowCount() + '.');

		int row = Parser.parseRawStringToInt(getUserStringWhileIsNotValid(true)) - 1;

		if (row < 0 || row >= cinemaHall.getRowCount())
		{
			print(lang.getMessage("APPLICATION_INDEX_IS_NOT_VALID"));
			return;
		}

		CinemaHallController.deleteArmchairRow(cinemaHall, row);
	}
}
