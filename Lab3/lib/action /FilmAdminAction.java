package lib.action;

import lib.Parser;
import model.Film;
import view.FilmView;

import static controller.FilmSessionController.deleteAllFimlSessionsWithFilm;
import static lib.Application.filmList;
import static lib.Application.isAdmin;
import static lib.Application.lang;
import static lib.Lang.print;
import static lib.Parser.getUserStringWhileIsNotValid;

public class FilmAdminAction
{
	public static void startFilmAdminAction()
	{
		print(lang.getMessage("APPLICATION_ADMIN_FILM_COMMAND_LIST"));

		String command = getUserStringWhileIsNotValid(true);

		switch (Parser.parseRawStringToInt(command))
		{
			case (1):
				printFilmList();
				return;
			case (2):
				createNewFilmAction();
				return;
			case (3):
				printFilmList();
				deleteFilmAction();
				return;
			case (0):
				return;
			default:
				print(lang.getMessage("APPLICATION_COMMAND_NOT_FOUND"));
		}
	}

	public static void printFilmList()
	{
		print(lang.getMessage("APPLICATION_FILM_LIST"));

		if (filmList.isEmpty())
		{
			print(lang.getMessage("APPLICATION_EMPTY_LIST"));
			return;
		}

		print(FilmView.prepareFilmListToPrint(filmList));
	}

	private static void createNewFilmAction()
	{
		if (!isAdmin)
		{
			return;
		}

		print(lang.getMessage("APPLICATION_FILM_GET_TITLE"));
		String title = getUserStringWhileIsNotValid(false);

		print(lang.getMessage("APPLICATION_FILM_GET_DESCRIPTION"));
		String description = getUserStringWhileIsNotValid(false);

		print(lang.getMessage("APPLICATION_FILM_GET_DURATION"));
		int duration = Parser.parseRawStringToInt(getUserStringWhileIsNotValid(true));

		if (duration == 0)
		{
			print(lang.getMessage("APPLICATION_FILM_INPUT_DURATION_ERROR"));
		}

		filmList.add(new Film(title, description, duration));
	}


	private static void deleteFilmAction()
	{
		if (!isAdmin)
		{
			return;
		}

		if (filmList.isEmpty())
		{
			return;
		}

		print(lang.getMessage("APPLICATION_GET_FILM_INDEX_TO_DELETE"));
		int index = Parser.parseRawStringToInt(getUserStringWhileIsNotValid(true)) - 1;

		if (index < 0 || index >= filmList.size())
		{
			print(lang.getMessage("APPLICATION_INDEX_IS_NOT_VALID"));

			return;
		}

		deleteAllFimlSessionsWithFilm(filmList.get(index).getId());

		filmList.remove(index);
	}
}
