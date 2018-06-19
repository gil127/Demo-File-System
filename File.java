package com.company;

import java.text.SimpleDateFormat;

/**
 * Created by gild on 5/27/18.
 */
public class File implements IFile {

    private String name;
    private int size;
    private SimpleDateFormat createdDate;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
        this.createdDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public SimpleDateFormat getCreatedDate() {
        return null;
    }

    public void setCreatedDate(SimpleDateFormat createdDate) {
        this.createdDate = createdDate;
    }
}
