package model;

public final class Armchair
{
	private String title;
	private int number;
	private String description;
	private String type;
	private boolean status;

	public Armchair(String title, String description, String type)
	{
		this.title = title;
		this.description = description;
		this.type = type;
		this.status = false;
	}

	public Armchair(String title, String description, String type, int number)
	{
		this.title = title;
		this.description = description;
		this.type = type;
		this.number = number;
		this.status = false;
	}

	public String getTitle()
	{
		return title;
	}


	public String getDescription()
	{
		return description;
	}

	public String getType()
	{
		return type;
	}

	public int getNumber()
	{
		return number;
	}

	public void setNumber(int number)
	{
		this.number = number;
	}

	public boolean isStatus()
	{
		return status;
	}

	public void setStatus(boolean status)
	{
		this.status = status;
	}
}
