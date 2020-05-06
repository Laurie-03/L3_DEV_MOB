package fr.java.taskslist;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    ArrayList<Task> tasksList;

    public static class TaskViewHolder extends RecyclerView.ViewHolder {

        TextView task_name, task_description, task_date, task_duration;
        Button task_delete_button;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            task_name = itemView.findViewById(R.id.task_name);
            task_description = itemView.findViewById(R.id.task_description);
            task_date = itemView.findViewById(R.id.task_date);
            task_duration = itemView.findViewById(R.id.task_duration);
            task_delete_button = itemView.findViewById(R.id.task_delete_button);
        }
    }

    public TaskAdapter(ArrayList<Task> tasksList) {
        this.tasksList = tasksList;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item, parent, false);
        TaskViewHolder taskViewHolder = new TaskViewHolder(view);
        return taskViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, final int position) {
        Task task = tasksList.get(position);
        holder.task_name.setText(task.getTaskName());
        holder.task_description.setText(task.getTaskDescription());
        if (task.getTaskDate() != null && !TextUtils.isEmpty(task.getTaskDuration())) {
            holder.task_date.setText(task.getFormattedDate());
            holder.task_duration.setText(task.getTaskDuration().replace("/", " "));
        } else {
            holder.task_date.setText("Aucune date renseignée");
            holder.task_duration.setText("Aucune durée renseignée");
        }
        holder.task_delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tasksList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, tasksList.size());
            }
        });
    }

    @Override
    public int getItemCount() {
        return tasksList.size();
    }
}
