package com.hito.nikolay.lesson_4_utkin;

public class DetailInfo extends BaseInfo {
    protected String subTitle;
    protected boolean isMarked;

    public DetailInfo(String _title, int _image, String _subTitle, boolean mark) {
        title = _title;
        image = _image;
        subTitle = _subTitle;
        isMarked = mark;
    }
}
