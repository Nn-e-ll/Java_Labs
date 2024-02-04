package model;

public final class Film
{
	private static int autoincrement = 0;

	private int id;
	private String title;
	private String description;
	private int duration;


	public Film(String title, String description, int duration)
	{
		this.id = autoincrement++;
		this.title = title;
		this.description = description;
		this.duration = duration;
	}

	public String getTitle()
	{
		return title;
	}

	public String getDescription()
	{
		return description;
	}

	public int getDuration()
	{
		return duration;
	}

	public int getId()
	{
		return this.id;
	}

}
