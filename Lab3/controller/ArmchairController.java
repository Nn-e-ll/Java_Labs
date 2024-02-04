package controller;

import model.Armchair;

import java.util.ArrayList;

public class ArmchairController
{
    static public Armchair createNewArmchair(String title, String description, String type)
    {
        return new Armchair(title, description, type);
    }

	static public Armchair createNewArmchair(String title, String description, String type, int number)
	{
		return new Armchair(title, description, type, number);
	}

	static public ArrayList<ArrayList<Armchair>> getMatrixCopy(ArrayList<ArrayList<Armchair>> seatMatrix)
	{
		ArrayList<ArrayList<Armchair>> copy = new ArrayList<>();

		for (ArrayList<Armchair> row: seatMatrix)
		{
			ArrayList<Armchair> tempRow = new ArrayList<>();

			for (Armchair armchair: row)
			{
				tempRow.add(createNewArmchair(armchair.getTitle(), armchair.getDescription(), armchair.getType(), armchair.getNumber()));
			}

			copy.add(tempRow);
		}

		return copy;
	}

	static public boolean bookigArmchair(ArrayList<Armchair> selectedRow, int armchairSeat)
	{
		if (selectedRow.get(armchairSeat).isStatus())
		{
			return false;
		}

		selectedRow.get(armchairSeat).setStatus(true);
		return true;
	}
}
