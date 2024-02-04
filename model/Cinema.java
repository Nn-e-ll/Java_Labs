package model;

import java.util.ArrayList;

public final class Cinema
{
	private String title;
	private ArrayList<CinemaHall> cinemaHallList;

	public Cinema(String title)
	{
		this.title = title;
		this.cinemaHallList = new ArrayList<>();
	}

	public String getTitle()
	{
		return title;
	}

	public ArrayList<CinemaHall> getCinemaHallList()
	{
		return cinemaHallList;
	}

	public void addCinemaHall(CinemaHall cinemaHall)
	{
		this.cinemaHallList.add(cinemaHall);
	}

	public void setTitle(String title)
	{
		this.title = title;
	}
}
