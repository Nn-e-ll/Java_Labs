package lib.action;

import static controller.ArmchairController.bookigArmchair;
import static view.FilmSessionView.*;

import lib.Parser;
import model.Armchair;
import model.FilmSession;

import java.util.ArrayList;

import static lib.Application.*;
import static lib.action.FilmAdminAction.printFilmList;
import static lib.action.FilmSessionAdminAction.printFilmSessionListAction;
import static lib.action.ArmchairAdminAction.printArmchairTemplateList;
import static controller.CinemaHallController.isEmptySeatMatrix;
import static lib.Lang.print;
import static lib.Parser.getUserStringWhileIsNotValid;

public class FilmAction
{
	public static void startFilmAction()
	{
		print(lang.getMessage("APPLICATION_FILM_COMMAND_LIST"));

		String command = getUserStringWhileIsNotValid(true);

		switch (Parser.parseRawStringToInt(command))
		{
			case (1):
				printFilmList();
				return;
			case (2):
				printFilmSessionListAction();
				return;
			case (3):
				printFilmSessionListAction();
				buyTicketAction();
				return;
			case (0):
				return;
			default:
				print(lang.getMessage("APPLICATION_COMMAND_NOT_FOUND"));
		}
	}

	private static void buyTicketAction()
	{
		if (filmSessionList.isEmpty())
		{
			return;
		}

		print(lang.getMessage("APPLICATION_GET_FILM_SESSION_INDEX"));
		int filmSessionIndex = Parser.parseRawStringToInt(getUserStringWhileIsNotValid(true)) - 1;

		if (filmSessionIndex < 0 || filmSessionIndex >= filmSessionList.size())
		{
			print(lang.getMessage("APPLICATION_INDEX_IS_NOT_VALID"));
			return;
		}

		FilmSession selectedFilmSession = filmSessionList.get(filmSessionIndex);

		if (isEmptySeatMatrix(selectedFilmSession.getCinemaHall()))
		{
			print(lang.getMessage("APPLICATION_CINEMAHALL_EMPTY_SEAT_ERROR"));
			return;
		}

		ArrayList<ArrayList<Armchair>> seatMatrix = selectedFilmSession.getCinemaHall().getSeatsMatrix();

		print(prepareFilmSessionToPrintForUser(selectedFilmSession));
		printArmchairTemplateList();

		print(lang.getMessage("APPLICATION_GET_FILM_SESSION_ROW_INDEX"));

		int rowIndex = Parser.parseRawStringToInt(getUserStringWhileIsNotValid(true)) - 1;

		if (rowIndex < 0 || rowIndex >= seatMatrix.size())
		{
			print(lang.getMessage("APPLICATION_INDEX_IS_NOT_VALID"));
			return;
		}

		ArrayList<Armchair> selectedRow = seatMatrix.get(rowIndex);

		if (selectedRow.isEmpty())
		{
			print(lang.getMessage("APPLICATION_CINEMAHALL_EMPTY_ROW_ERROR"));
			return;
		}

		print(lang.getMessage("APPLICATION_GET_FILM_SESSION_SEAT_INDEX"));

		int seatIndex = Parser.parseRawStringToInt(getUserStringWhileIsNotValid(true)) - 1;

		if (seatIndex < 0 || seatIndex >= selectedRow.size())
		{
			print(lang.getMessage("APPLICATION_INDEX_IS_NOT_VALID"));
			return;
		}

		if (bookigArmchair(selectedRow, seatIndex))
		{
			print(lang.getMessage("APPLICATION_BOOKING_FILM_SESSION_SEAT_SUCCES"));
			return;
		}

		print(lang.getMessage("APPLICATION_BOOKING_FILM_SESSION_SEAT_ERROR"));
	}
}
