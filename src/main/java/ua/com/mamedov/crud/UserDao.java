package ua.com.mamedov.crud;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public List<User> users = new ArrayList<>(List.of(
            new User("1", "first1", "last1", "first1 last1", ("email@mail.com")),
            new User("2", "first2", "last2", "first2 last2", ("email2@mail.com")),
            new User("3", "first3", "last3", "first3 last3", ("email3@mail.com")),
            new User("4", "first4", "last4", "first4 last4", ("email4@mail.com"))));

    public void readUser() {
        Gson gson = new Gson();
        String usersString = gson.toJson(users);
        System.out.println("usersString = " + usersString);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Object usersConvert = objectMapper.readValue(usersString, new TypeReference<>() {
            });
            System.out.println("usersConvert = " + usersConvert);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void writeUser() {
        Gson gson = new Gson();
        String usersString = gson.toJson(users);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("users.json"));) {
            bufferedWriter.write(usersString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void create(User user) {
        int counter = 0;
        for (User value : users) {
            if (user.getEmail().equals(value.getEmail())) {
                counter++;
            }
        }
        if (counter < 1) {
            users.add(user);
        }
    }

    public void remove(String id) {
        users.removeIf(user -> user.getId().equals(id));
    }

    public User getById(String id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .get();
    }

    public List<User> getAll() {
        return users;
    }
}
