package fr.java.tasklist;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabAddFragment extends Fragment {

    private EditText task_name_input, task_description_input, task_date_input, task_duration_input;
    private Button task_add_button;

    TabListFragment tabListFragment = new TabListFragment();

    public TabAddFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_add, container, false);

        task_name_input = view.findViewById(R.id.task_name_input);
        task_description_input = view.findViewById(R.id.task_description_input);
        task_date_input = view.findViewById(R.id.task_date_input);
        task_duration_input = view.findViewById(R.id.task_duration_input);
        task_add_button = view.findViewById(R.id.task_add_button);

        task_add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = task_name_input.getText().toString();
                String description = task_description_input.getText().toString();

                if (TextUtils.isEmpty(name) && TextUtils.isEmpty(description)) {
                    Toast.makeText(getActivity(), "Veuillez saisir le nom et la description de la tâche", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(name)) {
                    Toast.makeText(getActivity(), "Veuillez saisir le nom de la tâche", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(description)) {
                    Toast.makeText(getActivity(), "Veuillez saisir la description de la tâche", Toast.LENGTH_SHORT).show();
                } else {
                    Task task = new Task(name, description);
                    tabListFragment.tasksList.add(task);

                    Toast.makeText(getActivity(), "Création réussie", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}
