package com.loid.devlighttaskmanager.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.loid.devlighttaskmanager.R;
import com.loid.devlighttaskmanager.adapters.Adapter;
import com.loid.devlighttaskmanager.models.Task;

import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener {

    private ListView listView;
    ArrayList<Task> useArray = new ArrayList<Task>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.tasksListView);
        Button addButton = (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, AddTaskActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {
            return;
        }
        String title = data.getStringExtra("title");
        String comment = data.getStringExtra("comment");
        useArray.add(new Task(title, comment));
        Adapter adapter = new Adapter(useArray, this);
        listView.setAdapter(adapter);
    }
}
