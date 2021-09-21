package com.nick.todolist;

import com.nick.todolist.datamodel.TodoData;
import com.nick.todolist.datamodel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class DialogController {
    @FXML
    private TextField shortDescriptionField;

    @FXML
    private TextArea detailsArea;

    @FXML
    private DatePicker deadlinePicker;

    public TodoItem processResults(){
     return processResults(0);
    }

    public TodoItem processResults(int index){
        String shortDescription = shortDescriptionField.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate deadlineValue = deadlinePicker.getValue();
        if(deadlineValue == null){
            deadlineValue = LocalDate.now();
        }

        TodoItem newItem = new TodoItem(shortDescription, details, deadlineValue);


        TodoData.getInstance().addTodoItem(index, newItem);
        TodoData.getInstance().sortTodoItems();


        return newItem;
    }
    public void editATodoItemDialog(TodoItem item){
        shortDescriptionField.setText(item.getShortDescription());
        detailsArea.setText(item.getDetails());
        deadlinePicker.getEditor().setText(String.valueOf(LocalDate.now()));
//        deadlinePicker.setAccessibleText(String.valueOf(LocalDate.now()));

    }

}
