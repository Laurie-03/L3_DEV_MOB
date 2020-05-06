package fr.java.taskslist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabAddFragment extends Fragment {
    
    private EditText task_name_input, task_description_input, task_duration_input_int, task_duration_input_string;
    private DatePicker task_date_input;
    private Button task_add_button;

    TabListFragment tabListFragment = new TabListFragment();

    public TabAddFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_add, container, false);
        
        task_name_input = view.findViewById(R.id.task_name_input);
        task_description_input = view.findViewById(R.id.task_description_input);
        task_date_input = view.findViewById(R.id.task_date_input);
        task_duration_input_int = view.findViewById(R.id.task_duration_input_int);
        task_duration_input_string = view.findViewById(R.id.task_duration_input_string);
        task_add_button = view.findViewById(R.id.task_add_button);
        
        task_add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* ----- Récupération des valeurs saisies dans le formulaire ----- */
                String taskName = task_name_input.getText().toString();
                String taskDescription = task_description_input.getText().toString();
                String taskDurationInt = task_duration_input_int.getText().toString();
                String taskDurationString = task_duration_input_string.getText().toString();

                int taskDay = task_date_input.getDayOfMonth();
                int taskMonth = task_date_input.getMonth();
                int taskYear = task_date_input.getYear();

                /* ----- Initialisation du calendrier ----- */
                Calendar calendar = Calendar.getInstance();
                calendar.set(taskYear, taskMonth,taskDay);

                /* ----- Placer le curseur du calendrier à la date voulue ----- */
                Date taskDate = calendar.getTime();

                /* ----- Création d'une nouvelle tâche ----- */
                Task task = new Task("", "");

                /* ----- Conditions de validation du formulaire ----- */
                if (TextUtils.isEmpty(taskName) && TextUtils.isEmpty(taskDescription)) {
                    Toast.makeText(getContext(), "Veuillez saisir un nom et une description", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(taskName)) {
                    Toast.makeText(getContext(), "Veuillez saisir le nom de votre nouvelle tâche", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(taskDescription)) {
                    Toast.makeText(getContext(), "Veuillez saisir la description de votre nouvelle tâche", Toast.LENGTH_SHORT).show();
                } else {

                    task.setTaskName(taskName);
                    task.setTaskDescription(taskDescription);

                    /* ----- Conditions de validation si une date est saisie ainsi qu'une durée ----- */
                    if (!TextUtils.isEmpty(taskDurationInt) && !TextUtils.isEmpty(taskDurationString) && taskDate != null) {
                        if (!TextUtils.isDigitsOnly(taskDurationInt)) {
                            Toast.makeText(getContext(), "La duée doit être un chiffre ou un nombre", Toast.LENGTH_SHORT).show();
                            return;
                        } else if (!TextUtils.equals(taskDurationString, "heures") && !TextUtils.equals(taskDurationString, "jours") && !TextUtils.equals(taskDurationString, "semaines")) {
                            Toast.makeText(getContext(), "La durée doit être en \"heures\", \"jours\" ou en \"semaines\" ", Toast.LENGTH_SHORT).show();
                            return;
                        } else {
                            String taskDuration = taskDurationInt + "/" + taskDurationString;
                            task.setTaskDuration(taskDuration);
                            task.setTaskDate(taskDate);
                        }
                    }

                    tabListFragment.tasks_list.add(task);
                    Toast.makeText(getContext(), "Création de la tâche réussie", Toast.LENGTH_SHORT).show();

                    task_name_input.getText().clear();
                    task_description_input.getText().clear();

                    task_duration_input_int.getText().clear();
                    task_duration_input_string.getText().clear();
                }
            }
        });
        
        return view;
    }
}
