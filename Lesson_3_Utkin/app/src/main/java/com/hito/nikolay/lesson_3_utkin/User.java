package com.hito.nikolay.lesson_3_utkin;

public class User {
    public String name;
    public String surname;
    public String email;
    public String login;
    public String region;
    public int cardNumber;

    public User (String _name, String _surname, String _email, String _login, String _region, int _cardNumber)
    {
        name = _name;
        surname = _surname;
        email = _email;
        login = _login;
        region = _region;
        cardNumber = _cardNumber;
    }
}
