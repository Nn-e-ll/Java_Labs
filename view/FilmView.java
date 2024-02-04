package view;

import model.Film;

import java.util.ArrayList;

public class FilmView
{
	public static String prepareFilmToPrint(Film film)
	{
		return film.getTitle() + " - " + film.getDescription() + " - " + film.getDuration() + "мин.";
	}

	public static String prepareFilmListToPrint(ArrayList<Film> filmList)
	{
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < filmList.size(); i++)
		{
			Film film = filmList.get(i);
			result.append(i + 1).append(". ").append(prepareFilmToPrint(film)).append("\n");
		}

		return result.toString();
	}
}
