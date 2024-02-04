package lib;

import java.util.HashMap;
import java.util.Map;

public class Lang
{
	Map<String, String> messageList;

	public Lang()
	{
		this.messageList = new HashMap<String, String>();

		this.init();
	}

	private void init()
	{
		this.messageList.put("APPLICATION_TITLE",
			"""
			████─█──█───██─███─███─█──█─████─████────████─█──█─████─███─███─█───█─████────████─████
			█────█──█──█─█─█────█──█──█─█──█─█──█────█──█─█──█─█──█──█──█───██─██─█──█────█──█─█──█
			████─█─██─█──█─███──█──████─████─████────█────█─██─█─────█──███─█─█─█─████────█──█─█──█
			█──█─██─█─█──█─█────█──█──█─█──█──█─█────█──█─██─█─█──█──█──█───█───█─█──█────█──█─█──█
			████─█──█─█──█─███──█──█──█─█──█──█─█────████─█──█─████──█──███─█───█─█──█────█──█─█──█ (первый прототип)
					   
						
			Для перехода по вкладкам укажите номер пункта меню.
						
			Войти как:
			1. Посетитель
			2. Администратор
						
			0. Выйти из приложения
			"""
		);
		this.messageList.put("APPLICATION_LOGIN_AS_ADMIN", "Вы вошли как администратор.");
		this.messageList.put("APPLICATION_LOGIN_AS_USER", "Вы вошли как посетитель.");
		this.messageList.put("APPLICATION_COMMAND_IS_NOT_VALID", "Данные введены некорректно.");
		this.messageList.put("APPLICATION_COMMAND_NOT_FOUND", "Введенная команда не найдена.");
		this.messageList.put("APPLICATION_INDEX_IS_NOT_VALID", "Номер введен некорректно.");
		this.messageList.put("APPLICATION_EMPTY_LIST", "Запрашиваемый список пуст.");
		this.messageList.put("APPLICATION_USER_INPUT", "--> ");

		this.messageList.put("APPLICATION_ADMIN_COMMAND_LIST",
  			"""
			Доступные команды для администратора:
			1. Кинотеатры
			2. Кинозалы
			3. Фильмы
			4. Сеансы
			5. Кресла
			
			0. Выйти в меню выбора роли
			"""
		);
		this.messageList.put("APPLICATION_ADMIN_CINEMA_COMMAND_LIST",
			"""
			Доступные команды для кинотеатров:
			1. Посмотреть текущий список
			2. Создать
			3. Удалить
			
			0. Выйти в меню выбора команд
			"""
		);
		this.messageList.put("APPLICATION_GET_CINEMA_TITLE", "Введите название кинотеатра.");
		this.messageList.put("APPLICATION_GET_CINEMA_INDEX_TO_DELETE", "Введите номер кинотеатра, который хотите удалить.");
		this.messageList.put("APPLICATION_CINEMA_LIST", "Текущий список кинотеатров:");
		this.messageList.put("APPLICATION_USER_COMMAND_LIST",
			"""
			Доступные команды для посетителя:
			1. Фильмы
			2. Кинотеатры
			3. Кинозалы
			
			0. Выйти в меню выбора роли
			"""
		);

		this.messageList.put("APPLICATION_FILM_COMMAND_LIST",
			"""
			Доступные команды для фильмов:
			1. Посмотреть текущий список фильмов
			2. Посмотреть текущие сеансы
			3. Купить билет на фильм
			
			0. Выйти в меню выбора команд
			"""
		);
		this.messageList.put("APPLICATION_GET_FILM_SESSION_INDEX", "Введите номер сеанса, на который хотите приобрести билет.");
		this.messageList.put("APPLICATION_GET_FILM_SESSION_ROW_INDEX", "Введите номер ряда, на который хотите приобрести билет.");
		this.messageList.put("APPLICATION_GET_FILM_SESSION_SEAT_INDEX", "Введите номер кресла, на который хотите приобрести билет.");
		this.messageList.put("APPLICATION_BOOKING_FILM_SESSION_SEAT_SUCCES", "Вы успешно приобрели билет.");
		this.messageList.put("APPLICATION_BOOKING_FILM_SESSION_SEAT_ERROR", "Данное место уже выкуплено.");

		this.messageList.put("APPLICATION_CINEMAHALL_LIST", "Текущий список кинозалов:");
		this.messageList.put("APPLICATION_ADMIN_CINEMAHALL_COMMAND_LIST",
			"""
			Доступные команды для кинозалов:
			1. Посмотреть текущий список для конкретного кинотеатра
			2. Посмотреть схему кинозала
			3. Создать
			4. Удалить
			5. Добавить кресла по шаблону в кинозал
			6. Очистить ряд кресел
			
			0. Выйти в меню выбора команд
			"""
		);
		this.messageList.put("APPLICATION_GET_CINEMAHALL_CINEMA_ID", "Введите номер кинотеатра, для которого хотите увидеть список кинозалов.");
		this.messageList.put("APPLICATION_GET_CINEMAHALL_ID_TO_PRINT_SCHEME", "Введите номер кинозала, для которого хотите увидеть схему.");
		this.messageList.put("APPLICATION_GET_CINEMAHALL_ID_TO_ADD_ARMHAIRS", "Введите номер кинозала, в который хотите добавить кресла.");
		this.messageList.put("APPLICATION_GET_CINEMAHALL_EMPTY_CINEMA_LIST", "Для создания нового кинозала необходимо, чтобы был создан хотя бы один кинотеатр.");
		this.messageList.put("APPLICATION_GET_CINEMAHALL_TITLE", "Введите название кинозала.");
		this.messageList.put("APPLICATION_GET_CINEMAHALL_ROW_COUNT", "Введите количество рядов кинозала.");
		this.messageList.put("APPLICATION_GET_CINEMAHALL_ROW_COUNT_NOT_VALID", "Количество рядов кинозала не может быть равным нулю.");
		this.messageList.put("APPLICATION_GET_CINEMAHALL_CINEMA_ID_TO_ADD", "Введите номер кинотеатра, в который хотите добавить этот кинозал.");
		this.messageList.put("APPLICATION_GET_CINEMAHALL_INDEX_TO_DELETE", "Введите номер кинозала, который хотите удалить.");
		this.messageList.put("APPLICATION_CINEMAHALL_DESCRIPTION_FOR_USER", "(_) - место свободно.\n(X) - место занято.");
		this.messageList.put("APPLICATION_CINEMAHALL_EMPTY_SEAT_ERROR", "На данный сеанс не были добавлены места, обратитесь к администратору по данному вопросу.");
		this.messageList.put("APPLICATION_CINEMAHALL_EMPTY_ROW_ERROR", "Выбран пустой ряд, обратитесь к администратору по данному вопросу.");

		this.messageList.put("APPLICATION_ADMIN_FILM_COMMAND_LIST",
			"""
			Доступные команды для фильмов:
			1. Посмотреть текущий список фильмов
			2. Создать
			3. Удалить
			
			0. Выйти в меню выбора команд
			"""
		);
		this.messageList.put("APPLICATION_FILM_LIST", "Текущий список фильмов:");
		this.messageList.put("APPLICATION_FILM_GET_TITLE", "Введите название фильма.");
		this.messageList.put("APPLICATION_FILM_GET_DESCRIPTION", "Введите короткое описание фильма (не более 256 символов).");
		this.messageList.put("APPLICATION_FILM_GET_DURATION", "Введите продолжительность фильма в минутах.");
		this.messageList.put("APPLICATION_FILM_INPUT_DURATION_ERROR", "Продолжительность не может быть отрицательной");
		this.messageList.put("APPLICATION_GET_FILM_INDEX_TO_DELETE", "Введите номер фильма, который хотите удалить.");

		this.messageList.put("APPLICATION_ADMIN_FILM_SESSION_COMMAND_LIST",
			"""
			Доступные команды для сеансов:
			1. Посмотреть текущий список сеансов
			2. Создать
			3. Удалить
			
			0. Выйти в меню выбора команд
			"""
		);
		this.messageList.put("APPLICATION_FILM_SESSION_LIST", "Текущий список сеансов:");
		this.messageList.put("APPLICATION_FILM_SESSION_GET_FILM_INDEX", "Введите номер фильма, для которого хотите создать сеанс.");
		this.messageList.put("APPLICATION_FILM_SESSION_GET_CINEMAHALL_INDEX", "Введите номер кинозала, в котором хотите создать сеанс.");
		this.messageList.put("APPLICATION_FILM_SESSION_GET_DATE", "Введите дату проведения сеанса в формате \"ММ/дд/гггг ЧЧ:мм\" (месяц/день/год час:минуты).");
		this.messageList.put("APPLICATION_FILM_SESSION_DATE_FORMAT_IS_NOT_VALID", "Дата проведения сеанса записана в неверном формате.");
		this.messageList.put("APPLICATION_GET_FILM_SESSION_INDEX_TO_DELETE", "Введите номер сеанса, который хотите удалить.");
		this.messageList.put("APPLICATION_FILM_SESSION_DATE_ERROR", "Дата не может быть позже текущего времени.");

		this.messageList.put("APPLICATION_ADMIN_ARMCHAIR_COMMAND_LIST",
			"""
			Доступные команды для кресел:
			1. Посмотреть текущий список шаблонов
			2. Создать
			3. Удалить
			
			0. Выйти в меню выбора команд
			"""
		);
		this.messageList.put("APPLICATION_ARMCHAIR_LIST", "Текущий список шаблонов кресел:");
		this.messageList.put("APPLICATION_GET_ARMCHAIR_TITLE", "Введите название кресла.");
		this.messageList.put("APPLICATION_GET_ARMCHAIR_DESCRIPTION", "Введите описание кресла.");
		this.messageList.put("APPLICATION_GET_ARMCHAIR_TYPE", "Введите тип кинотеатра (до 5 символов), который будет выводиться при показе схемы кинозала.");
		this.messageList.put("APPLICATION_GET_ARMCHAIR_INDEX_TO_DELETE", "Введите номер шаблона, который хотите удалить.");
		this.messageList.put("APPLICATION_GET_ARMCHAIR_INDEX_TO_ADD_TO_CINEMAHALL", "Введите номер шаблона, по которому хотите добавить кресла.");
		this.messageList.put("APPLICATION_GET_ARMCHAIR_ROW_TO_ADD_TO_CINEMAHALL", "Введите номер ряда. Количество рядов в выбранном кинозале: ");
		this.messageList.put("APPLICATION_GET_ARMCHAIR_COUNT_TO_ADD_TO_CINEMAHALL", "Введите количество кресел, которое хотите добавить.");
		this.messageList.put("APPLICATION_GET_ARMCHAIR_COUNT_NOT_VALID", "Количество кресел не может быть равным нулю.");
		this.messageList.put("APPLICATION_ARMCHAIR_LIST_IS_EMPTY", "Список шаблонов кресел пуст.");
		this.messageList.put("APPLICATION_GET_ARMCHAIR_ROW_TO_DELETE", "Введите номер ряда, который нужно очистить. Количество рядов в выбранном кинозале: ");

	}

	public String getMessage(String messageCode)
	{
		if (this.messageList.isEmpty() || !this.messageList.containsKey(messageCode))
		{
			return "";
		}

		return this.messageList.get(messageCode);
	}

	public static void print(String message)
	{
		System.out.println(message);
	}

	public static void print(String message, boolean isOnSameLine)
	{
		if (isOnSameLine)
		{
			System.out.print(message);
			return;
		}

		System.out.println(message);
	}
}
