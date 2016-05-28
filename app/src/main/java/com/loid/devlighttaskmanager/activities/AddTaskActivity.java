package com.loid.devlighttaskmanager.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.loid.devlighttaskmanager.R;

/**
 * Created by LOID on 28.05.2016.
 */
public class AddTaskActivity extends Activity implements View.OnClickListener {

    private EditText title;
    private EditText comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        title = (EditText) findViewById(R.id.editTextTitle);
        comment = (EditText) findViewById(R.id.editTextComment);
        Button save = (Button) findViewById(R.id.saveButton);
        Button exit = (Button) findViewById(R.id.exitButton);
        save.setOnClickListener(this);
        exit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.saveButton: {
                //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                Intent intent = new Intent();
                intent.putExtra("title", title.getText().toString());
                intent.putExtra("comment", comment.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
                break;
            }
            case R.id.exitButton: {
                finish();
                System.exit(0);
                break;
            }
        }
    }
}
