package com.example.mytd;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mytd.TodoAdapter;
import com.example.mytd.TodoItem;
import java.util.Collections;
import java.util.Comparator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<TodoItem> todoList;
    private TodoAdapter todoAdapter;
    private ListView listView;
    private EditText editText;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todoList = new ArrayList<>();
        todoAdapter = new TodoAdapter(this, todoList);
        listView = findViewById(R.id.listView);
        listView.setAdapter(todoAdapter);

        editText = findViewById(R.id.editText);
        addButton = findViewById(R.id.addButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = editText.getText().toString();
                if (!task.isEmpty()) {
                    todoList.add(new TodoItem(task));
                    todoAdapter.notifyDataSetChanged();
                    editText.setText("");
                }
            }
        });
    }
}