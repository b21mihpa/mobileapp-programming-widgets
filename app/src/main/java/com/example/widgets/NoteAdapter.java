package com.example.widgets;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {
    private List<Note> notes;

    public NoteAdapter(List<Note> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public NoteAdapter.NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NoteViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.note, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.noteText.setText(notes.get(position).text);
        holder.noteCheckbox.setChecked(notes.get(position).isChecked);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {
        private TextView noteText;
        private CheckBox noteCheckbox;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);

            noteText = itemView.findViewById(R.id.note_text);
            noteCheckbox = itemView.findViewById(R.id.note_checkbox);
        }
    }
}
