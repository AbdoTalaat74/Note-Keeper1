package com.example.notekeeper;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notekeeper.databinding.ActivityNoteListActivtyBinding;

import java.util.List;

public class NoteListActivity extends AppCompatActivity {
    private noteRecyclerAdapter adapter;

//    private ArrayAdapter<NoteInfo> notesAdapter;

    public void onClick(View view){
        Intent fabIntent = new Intent(NoteListActivity.this, NoteActivity.class);
        startActivity(fabIntent);
    }

    private ActivityNoteListActivtyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNoteListActivtyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);


        initializeDisplayContent();

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fabIntent = new Intent(NoteListActivity.this, NoteActivity.class);
                startActivity(fabIntent);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
//        notesAdapter.notifyDataSetChanged();
        adapter.notifyDataSetChanged();
    }

    private void initializeDisplayContent(){



        final RecyclerView recyclerNotes =(RecyclerView) findViewById(R.id.list_notes);
        final LinearLayoutManager notesLayoutManager = new LinearLayoutManager(this);
        recyclerNotes.setLayoutManager(notesLayoutManager);
        List<NoteInfo> notes = DataManager.getInstance().getNotes();
        adapter = new noteRecyclerAdapter(this,notes);
        recyclerNotes.setAdapter(adapter);

    }


}