package view;

import model.Cinema;
import model.CinemaHall;

import java.util.ArrayList;

public class CinemaView
{
	static public void printCinema(Cinema cinema)
	{
		ArrayList<CinemaHall> cinemaHallList =  cinema.getCinemaHallList();
		System.out.println(cinema.getTitle());
		for (CinemaHall cinemaHall : cinemaHallList)
		{
			System.out.println(cinemaHall);
		}
	}

	static public String prepareCinemaListToPrint(ArrayList<Cinema> cinemaList)
	{
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < cinemaList.size(); i++)
		{
			Cinema cinema = cinemaList.get(i);
			result.append(i + 1).append(". ").append(cinema.getTitle()).append('\n');
		}

		return result.toString();
	}
}
