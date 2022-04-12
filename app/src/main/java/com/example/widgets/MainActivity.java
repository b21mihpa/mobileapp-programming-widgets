package com.example.widgets;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private NoteAdapter noteAdapter;
    private List<Note> notes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.notes);
        noteAdapter = new NoteAdapter(notes);
        recyclerView.setAdapter(noteAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText noteInput = findViewById(R.id.note_input);
                final String text = noteInput.getText().toString();

                if (!text.isEmpty()) {
                    notes.add(new Note(text));
                    noteAdapter.notifyDataSetChanged();
                    noteInput.getText().clear();
                }
            }
        });
    }
}
