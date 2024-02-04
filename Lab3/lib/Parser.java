package lib;

import static config.Config.DATE_FORMAT;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static lib.Lang.print;
import static lib.Application.*;

public class Parser
{
	public static DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

    public static int parseRawStringToInt(String rowString)
    {
        return Integer.parseInt(rowString);
    }

	public static String getUserStringWhileIsNotValid(boolean isNumber)
	{
		return getUserStringWhileIsNotValid(isNumber, 256);
	}

    public static String getUserStringWhileIsNotValid(boolean isNumber, int maxLen)
    {
        while (true)
        {
            print(lang.getMessage("APPLICATION_USER_INPUT"), true);
            String command = inScanner.nextLine();

            if (Validator.isStringValid(command, maxLen) && (!isNumber || Validator.isNumeric(command) >= 0))
            {
                return command;
            }

            print(lang.getMessage("APPLICATION_COMMAND_IS_NOT_VALID"));
        }
    }

	public static String parseDateToString(Date date)
	{
		return dateFormat.format(date);
	}

	public static Date parseStringToDate(String rowString)
	{
		try
		{
			return dateFormat.parse(rowString);
		}
		catch (ParseException exception)
		{
			return null;
		}
	}
}
