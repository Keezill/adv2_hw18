package ua.com.mamedov.crud;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class User implements Serializable {
    private String id;
    private String firstName;
    private String lastName;
    private transient String fullName;
    private String email;
}
