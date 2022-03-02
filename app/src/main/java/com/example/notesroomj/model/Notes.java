package com.example.notesroomj.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Notes {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "date_column")
    private String date;
    private String note;

    public Notes() {
    }

    public Notes(String date, String note) {
        this.date = date;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
            return date;
        }

    public void setDate(String date) {
        this.date = date;
    }

}
