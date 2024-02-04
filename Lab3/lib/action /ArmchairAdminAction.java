package lib.action;

import controller.ArmchairController;
import lib.Parser;
import model.Armchair;
import model.Cinema;
import view.ArmchairView;

import java.util.ArrayList;

import static lib.Application.armchairTemplateList;
import static lib.Application.isAdmin;
import static lib.Application.lang;
import static lib.Lang.print;
import static lib.Parser.getUserStringWhileIsNotValid;

public class ArmchairAdminAction
{
	public static void startArmchairAdminAction()
	{
		print(lang.getMessage("APPLICATION_ADMIN_ARMCHAIR_COMMAND_LIST"));

		String command = getUserStringWhileIsNotValid(true);

		switch (Parser.parseRawStringToInt(command))
		{
			case (1):
				printArmchairTemplateList();
				return;
			case (2):
				createNewArmchairTemplateAction();
				return;
			case (3):
				printArmchairTemplateList();
				deleteArmchairTemplateAction();
				return;
			case (0):
				return;
			default:
				print(lang.getMessage("APPLICATION_COMMAND_NOT_FOUND"));
		}
	}

	public static void printArmchairTemplateList()
	{
		print(lang.getMessage("APPLICATION_ARMCHAIR_LIST"));

		if (armchairTemplateList.isEmpty())
		{
			print(lang.getMessage("APPLICATION_EMPTY_LIST"));
			return;
		}

		print(ArmchairView.prepareArmchairTemplateListToPrint(armchairTemplateList));
	}

	private static void createNewArmchairTemplateAction()
	{
		if (!isAdmin)
		{
			return;
		}

		print(lang.getMessage("APPLICATION_GET_ARMCHAIR_TITLE"));
		String title = getUserStringWhileIsNotValid(false);

		print(lang.getMessage("APPLICATION_GET_ARMCHAIR_DESCRIPTION"));
		String description = getUserStringWhileIsNotValid(false);

		print(lang.getMessage("APPLICATION_GET_ARMCHAIR_TYPE"));
		String type = getUserStringWhileIsNotValid(false, 5);

		armchairTemplateList.add(ArmchairController.createNewArmchair(title, description, type));
	}

	private static void deleteArmchairTemplateAction()
	{
		if (!isAdmin)
		{
			return;
		}

		if (armchairTemplateList.isEmpty())
		{
			return;
		}

		print(lang.getMessage("APPLICATION_GET_ARMCHAIR_INDEX_TO_DELETE"));
		int index = Parser.parseRawStringToInt(getUserStringWhileIsNotValid(true)) - 1;

		if (index >= 0 && index < armchairTemplateList.size())
		{
			armchairTemplateList.remove(index);
			return;
		}

		print(lang.getMessage("APPLICATION_INDEX_IS_NOT_VALID"));
	}
}
