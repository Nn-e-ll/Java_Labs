package controller;

import static controller.CinemaHallController.getCopy;
import static lib.Application.filmSessionList;

import model.Cinema;
import model.CinemaHall;
import model.Film;
import model.FilmSession;

import java.util.ArrayList;
import java.util.Date;

public class FilmSessionController
{
	public static FilmSession createNewFilmSession(Film film, Date startTime, CinemaHall cinemaHall)
	{
		return new FilmSession(film, getCopy(cinemaHall), startTime);
	}

	public static void deleteAllFimlSessionsInCinemaHall(int cinemaHallId)
	{
		for (int filmSessionIndex = 0; filmSessionIndex < filmSessionList.size(); filmSessionIndex++)
		{
			CinemaHall cinemaHall = filmSessionList.get(filmSessionIndex).getCinemaHall();

			if (cinemaHall.getId() == cinemaHallId)
			{
				filmSessionList.remove(filmSessionIndex);
			}
		}
	}

	public static void deleteAllFimlSessionsWithFilm(int filmId)
	{
		for (int filmSessionIndex = 0; filmSessionIndex < filmSessionList.size(); filmSessionIndex++)
		{
			Film film = filmSessionList.get(filmSessionIndex).getFilm();

			if (film.getId() == filmId)
			{
				filmSessionList.remove(filmSessionIndex);
			}
		}
	}
}
