package model;

import java.util.Date;

public final class FilmSession
{
	private Film film;
	private CinemaHall cinemaHall;
	private Date startTime;

	public FilmSession(Film film, CinemaHall cinemaHall, Date startTime)
	{
		this.film = film;
		this.cinemaHall = cinemaHall;
		this.startTime = startTime;
	}

	public Date getStartTime()
	{
		return startTime;
	}

	public void setStartTime(Date startTime)
	{
		this.startTime = startTime;
	}

	public Film getFilm()
	{
		return film;
	}

	public void setFilm(Film film)
	{
		this.film = film;
	}

	public CinemaHall getCinemaHall()
	{
		return cinemaHall;
	}

	public void setCinemaHallIndex(CinemaHall cinemaHall)
	{
		this.cinemaHall = cinemaHall;
	}
}
