package controller;

import model.Armchair;
import model.CinemaHall;

import java.util.ArrayList;

import static controller.ArmchairController.getMatrixCopy;

public class CinemaHallController
{
	static public CinemaHall createNewCinemaHall(int id, String title, int rowCount)
	{
		return new CinemaHall(id, title, rowCount);
	}

	static public CinemaHall createNewCinemaHall(String title, int rowCount)
	{
		return new CinemaHall(title, rowCount);
	}

	static public void addArmchairToCinemaHall(CinemaHall cinemaHall, int rowIndex, Armchair armchairTemplate, int count)
	{
		addArmchairToListFromTemplate(cinemaHall.getSeatsMatrix().get(rowIndex), armchairTemplate, count);
	}

	static private void addArmchairToListFromTemplate(ArrayList<Armchair> armchairList, Armchair armchairTemplate, int count)
	{
		for (int armchairIndex = 0; armchairIndex < count; armchairIndex++)
		{
			Armchair newArmchair = new Armchair(
				armchairTemplate.getTitle(),
				armchairTemplate.getDescription(),
				armchairTemplate.getType()
			);

			newArmchair.setNumber(armchairList.size() + 1);

			armchairList.add(newArmchair);
		}
	}

	static public void deleteArmchairRow(CinemaHall cinemaHall, int rowIndex)
	{
		cinemaHall.getSeatsMatrix().set(rowIndex, new ArrayList<>());
	}

	static public CinemaHall getCopy(CinemaHall cinemaHall)
	{
		CinemaHall cinemaHallCopy = createNewCinemaHall(cinemaHall.getId(), cinemaHall.getTitle(), cinemaHall.getRowCount());

		cinemaHallCopy.setSeatsMatrix(getMatrixCopy(cinemaHall.getSeatsMatrix()));

		return cinemaHallCopy;
	}

	public static boolean isEmptySeatMatrix(CinemaHall cinemaHall)
	{
		boolean isNotEmpty = false;

		for (ArrayList<Armchair> armchairList: cinemaHall.getSeatsMatrix())
		{
			isNotEmpty = isNotEmpty || !armchairList.isEmpty();
		}

		return !isNotEmpty;
	}
}
