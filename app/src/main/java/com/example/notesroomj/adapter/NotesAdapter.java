package com.example.notesroomj.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notesroomj.R;
import com.example.notesroomj.database.NoteRepository;
import com.example.notesroomj.model.Notes;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    private List<Notes> courseModalArrayList;
    private Context context;
    NoteRepository noteRepository;

    public NotesAdapter(List<Notes> courseModalArrayList, Activity context) {
        this.courseModalArrayList = courseModalArrayList;
        this.context = context;
        noteRepository = new NoteRepository(context.getApplication());

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notes_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        // setting data to our views of recycler view.
        Notes modal = courseModalArrayList.get(position);
        holder.tv_note.setText(modal.getNote());
        holder.tv_date.setText(modal.getDate());
        holder.iv_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                courseModalArrayList.remove(modal);
            }
        });

    }

    @SuppressLint("NotifyDataSetChanged")
    public Notes addNote(Notes note) {
        courseModalArrayList.add(note);
        noteRepository.saveNote(note);
        notifyDataSetChanged();
        return note;
    }

    @Override
    public int getItemCount() {
        // returning the size of array list.
        return courseModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our views.
        private TextView tv_note,tv_date;
        public ImageView iv_remove;
        public RelativeLayout view_background, view_foreground;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // initializing our views with their ids.
            tv_note = itemView.findViewById(R.id.tv_note);
            tv_date = itemView.findViewById(R.id.tv_date);
            iv_remove = itemView.findViewById(R.id.iv_remove);
            view_foreground = itemView.findViewById(R.id.view_foreground);
            view_foreground = itemView.findViewById(R.id.view_foreground);
        }
    }

}
