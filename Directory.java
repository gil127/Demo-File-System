package com.company;

import java.text.SimpleDateFormat;

/**
 * Created by gild on 5/27/18.
 */
public class Directory implements IFile {

    private String name;
    private SimpleDateFormat createdDate;

    public Directory(String name) {
        this.name = name;
        this.createdDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    }


    @Override
    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = name;
    }

    @Override
    public SimpleDateFormat getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(SimpleDateFormat createdDate) {
        this.createdDate = createdDate;
    }
}
