package ua.com.mamedov.crud;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        userDao.create(
                new User("5", "Nikita", "Antonov", "Nikita Antonov", "nikita@mail.com"));
        userDao.create(
                new User("6", "Dimka", "Petrov", "Dimka Petrov", "email3@mail.com"));
        userDao.create(
                new User("7", "Andrew", "Filimonov", "Andrew Filimonov", "email12@mail.com"));

        userDao.remove("2");
        System.out.println(userDao.getById("3"));
        System.out.println(userDao.getAll());
        System.out.println(userDao.users);

        userDao.writeUser();
        userDao.readUser();
    }
}
