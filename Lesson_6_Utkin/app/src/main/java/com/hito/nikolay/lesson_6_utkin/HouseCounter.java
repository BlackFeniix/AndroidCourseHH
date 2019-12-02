package com.hito.nikolay.lesson_6_utkin;

public class HouseCounter {
    public String name;
    public String barCode;
    public String latestDate;
    public int image;
    public boolean isDateExpired;

    public HouseCounter(String _name, String _barCode, String _latestDate, int _image, boolean _isDateExpired) {
        name = _name;
        barCode = _barCode;
        latestDate = _latestDate;
        image = _image;
        isDateExpired = _isDateExpired;
    }
}
