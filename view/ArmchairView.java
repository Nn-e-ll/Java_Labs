package view;

import model.Armchair;
import model.Film;

import java.util.ArrayList;

public class ArmchairView
{
	public static String prepareArmchairToPrint(Armchair armchair)
	{
		return armchair.getTitle() + " (" + armchair.getType() + ")" + " - " + armchair.getDescription();
	}

	static public String prepareArmchairTemplateListToPrint(ArrayList<Armchair> armchairTemplateList)
	{
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < armchairTemplateList.size(); i++)
		{
			Armchair armchair = armchairTemplateList.get(i);
			result.append(i + 1).append(". ").append(prepareArmchairToPrint(armchair)).append('\n');
		}

		return result.toString();
	}
}
