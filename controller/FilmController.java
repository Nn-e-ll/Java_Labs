package controller;

import model.Film;
public class FilmController
{
    public static Film createNewFilm(String title, String description, int duration)
    {
        return new Film(title, description, duration);
    }
}
