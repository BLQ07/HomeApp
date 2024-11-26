package com.example.home.Settings;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.ViewHolder> {
    private List<String> data;
    private List<String> originalData;
    private EditText editText;
    private Stack<List<String>> undoStack = new Stack<>();

    public TableAdapter(List<String> data) {
        this.data = data;
        this.originalData = new ArrayList<>(data);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(new EditText(parent.getContext()));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(data.get(position), position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public  void undo() {
        if (!undoStack.isEmpty()) {
            data = undoStack.pop();
            notifyDataSetChanged();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {


        ViewHolder(View itemView) {
            super(itemView);
           editText=(EditText) itemView;
            editText.setOnFocusChangeListener((v, hasFocus) -> {
                if (!hasFocus) {
                    saveState();
                }
            });
        }

        void bind(String value, int position) {
            editText.setText(value);
            editText.setOnEditorActionListener((v, actionId, event) -> {
                data.set(position, editText.getText().toString());
                return true;
            });
        }
    }

    private void saveState() {
        undoStack.push(new ArrayList<>(data));
    }
    public List<String> getData() {
        editText.clearFocus();
        saveState();
        editText.setVisibility(View.GONE);
        return data;
    }
    public void visible() {
        editText.setVisibility(View.VISIBLE);
    }
}

