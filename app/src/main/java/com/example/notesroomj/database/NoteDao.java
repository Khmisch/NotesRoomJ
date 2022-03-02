package com.example.notesroomj.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.notesroomj.model.Notes;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveNote(Notes note);

    @Query("select * from note_table")
    List<Notes> getNotes();

}
