package com.example.mytd;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mytd.TodoItem;

import java.util.ArrayList;

public class TodoAdapter extends ArrayAdapter<TodoItem> {
    private ArrayList<TodoItem> todoItems;
    private Context context;

    public TodoAdapter(Context context, ArrayList<TodoItem> todoItems) {
        super(context, 0, todoItems);
        this.todoItems = todoItems;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TodoItem todoItem = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.todo_item, parent, false);
        }
        TextView taskTextView = convertView.findViewById(R.id.taskTextView);
        CheckBox checkBox = convertView.findViewById(R.id.checkBox);
        Button deleteButton = convertView.findViewById(R.id.deleteButton);
        Button editButton = convertView.findViewById(R.id.editButton);

        taskTextView.setText(todoItem.getTask());
        checkBox.setChecked(todoItem.isCompleted());

        if (todoItem.isCompleted()) {
            taskTextView.setPaintFlags(taskTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        } else {
            taskTextView.setPaintFlags(taskTextView.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
        }

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                todoItem.setCompleted(isChecked);
                if (isChecked) {
                    taskTextView.setPaintFlags(taskTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                } else {
                    taskTextView.setPaintFlags(taskTextView.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                }
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                todoItems.remove(position);
                notifyDataSetChanged();
            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEditDialog(todoItem);
            }
        });

        return convertView;
    }

    private void showEditDialog(TodoItem todoItem) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("할 일을 수정합니다.");

        final EditText input = new EditText(context);
        input.setText(todoItem.getTask());
        builder.setView(input);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String editedTask = input.getText().toString();
                if (!editedTask.isEmpty()) {
                    todoItem.setTask(editedTask);
                    notifyDataSetChanged();
                }
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
}
