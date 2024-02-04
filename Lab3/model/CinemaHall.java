package model;

import java.util.ArrayList;

public final class CinemaHall
{
	private static int autoincrement = 0;

	private int id;
	private String title;
	private int rowCount;
	private ArrayList<ArrayList<Armchair>> seatsMatrix;

	public CinemaHall(String title, int rowCount)
	{
		id = autoincrement++;
		this.title = title;
		this.rowCount = rowCount;
		this.seatsMatrix = new ArrayList<>(rowCount);
		for (int i = 0; i < rowCount; i++)
		{
			this.seatsMatrix.add(new ArrayList<>());
		}
	}

	public CinemaHall(int id, String title, int rowCount)
	{
		this.id = id;
		this.title = title;
		this.rowCount = rowCount;
		this.seatsMatrix = new ArrayList<>(rowCount);
		for (int i = 0; i < rowCount; i++)
		{
			this.seatsMatrix.add(new ArrayList<>());
		}
	}

	public String getTitle()
	{
		return title;
	}

	public int getRowCount()
	{
		return rowCount;
	}

	public ArrayList<ArrayList<Armchair>> getSeatsMatrix()
	{
		return seatsMatrix;
	}

	public void setSeatsMatrix(ArrayList<ArrayList<Armchair>> seatsMatrix)
	{
		this.seatsMatrix = seatsMatrix;
	}

	public void setSeat(int row, Armchair armchair)
	{
		this.seatsMatrix.get(row).add(armchair);
	}

	public void setPurchasedSeat(int row, int seat)
	{
		this.seatsMatrix.get(row).get(seat).setStatus(true);
	}

	public void setFreeSeat(int row, int seat)
	{
		this.seatsMatrix.get(row).get(seat).setStatus(false);
	}

	public int getId()
	{
		return id;
	}
}
