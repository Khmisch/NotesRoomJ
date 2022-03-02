package com.example.notesroomj.database;

import android.app.Application;

import com.example.notesroomj.manager.RoomManager;
import com.example.notesroomj.model.Notes;

import java.util.ArrayList;
import java.util.List;


public class NoteRepository {
    private NoteDao noteDao;

    public NoteRepository(Application application) {
        RoomManager db = RoomManager.getDatabase(application);
        noteDao = db.noteDao();
    }

    public List<Notes> getNotes() {
        return noteDao.getNotes();
    }

    public void saveNote(Notes note) {
        noteDao.saveNote(note);
    }

}
