package fr.java.smsstats;

import android.content.ContentResolver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QuickMessageAdapter extends RecyclerView.Adapter<QuickMessageAdapter.QuickMessageViewHolder> {

    ArrayList<QuickMessage> quickMessageList;

    public static class QuickMessageViewHolder extends RecyclerView.ViewHolder {

        TextView quick_message;

        public QuickMessageViewHolder(@NonNull View itemView) {
            super(itemView);
            quick_message = itemView.findViewById(R.id.quick_message);
        }

    }

    public QuickMessageAdapter(ArrayList<QuickMessage> quickMessageList) {
        this.quickMessageList = quickMessageList;
    }

    @NonNull
    @Override
    public QuickMessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quick_message_item, parent, false);
        QuickMessageViewHolder quickMessageViewHolder = new QuickMessageViewHolder(view);
        return quickMessageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull QuickMessageViewHolder holder, int position) {
        QuickMessage quickMessage = quickMessageList.get(position);
        holder.quick_message.setText(quickMessage.getMessage());
    }

    @Override
    public int getItemCount() {
        return quickMessageList.size();
    }
}
