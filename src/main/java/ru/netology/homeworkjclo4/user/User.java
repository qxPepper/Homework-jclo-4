package ru.netology.homeworkjclo4.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {
    private String user;
    private String password;
}
