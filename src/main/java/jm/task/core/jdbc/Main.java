package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        //toDo Закрыть соединения
        //toDo Обработка всех исключений, связанных с работой с базой данных должна находиться в dao

        //toDo  Создание таблицы User(ов)
        //toDo Добавление 4 User(ов) в таблицу с данными на свой выбор. После каждого добавления должен быть вывод в консоль ( User с именем – name добавлен в базу данных )
        //toDo Получение всех User из базы и вывод в консоль ( должен быть переопределен toString в классе User)
        //toDo Очистка таблицы User(ов)
        //toDo Удаление таблицы
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.dropUsersTable();
    }
}
