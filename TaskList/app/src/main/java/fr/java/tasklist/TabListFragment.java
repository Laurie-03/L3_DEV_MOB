package fr.java.tasklist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabListFragment extends Fragment {

    public static ArrayList<Task> tasksList = new ArrayList<>();
    private RecyclerView tasks_recycler_view;
    private RecyclerView.LayoutManager layoutManager;
    private TaskAdapter taskAdapter;



    public TabListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_list, container, false);
        tasks_recycler_view = view.findViewById(R.id.tasks_recycler_view);

        Log.i("Affiche tableau :", tasksList.toString());

        layoutManager = new LinearLayoutManager(getContext());
        tasks_recycler_view.setLayoutManager(layoutManager);

        taskAdapter = new TaskAdapter(tasksList);
        tasks_recycler_view.setAdapter(taskAdapter);

        return view;
    }
}
