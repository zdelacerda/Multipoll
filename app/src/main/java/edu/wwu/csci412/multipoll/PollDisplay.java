package edu.wwu.csci412.multipoll;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import Data.Controller;

public class PollDisplay extends Fragment {
    public static Controller controller;
    private static User user;
    private static Group currentGroup;
    //private static Poll currentPoll;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_poll_display, container, false);
        controller = MainActivity.getController();
        user = controller.getUser();
        currentGroup = user.getCurrentGroup();
        //currentPoll = user.getCurrentPoll();

        // Connect GroupSelected activity to this fragment somehow
        ArrayAdapter<String> arrayAdapter;
        ListView lv = view.findViewById(R.id.groupPolls);

        arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, currentGroup.listPolls());
        lv.setAdapter(arrayAdapter);
        
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String TempListViewClickedValue = currentGroup.listPolls().get(position);
                user.setCurrentPoll(currentGroup.getPoll(TempListViewClickedValue));
                Fragment results = new PollResults();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.displayPolls, results, "PollResults")
                        .addToBackStack(null)
                        .commit();
            }
        });
        return view;
    }
}
