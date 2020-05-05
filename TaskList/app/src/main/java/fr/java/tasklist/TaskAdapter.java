package fr.java.tasklist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    ArrayList<Task> tasks_list;

    public static class TaskViewHolder extends RecyclerView.ViewHolder {

        TextView task_name, task_description;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);

            task_name = itemView.findViewById(R.id.task_name);
            task_description = itemView.findViewById(R.id.task_description);
        }
    }

    public TaskAdapter(ArrayList<Task> tasks_list) {
        this.tasks_list = tasks_list;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item, parent, false);
        TaskViewHolder taskViewHolder = new TaskViewHolder(view);
        return taskViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = tasks_list.get(position);
        holder.task_name.setText(task.getTaskName());
        holder.task_description.setText(task.getTaskDescription());

    }

    @Override
    public int getItemCount() {
        return tasks_list.size();
    }
}
