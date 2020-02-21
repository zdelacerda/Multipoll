package edu.wwu.csci412.multipoll.Controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import edu.wwu.csci412.multipoll.Model.Controller;
import edu.wwu.csci412.multipoll.Model.Group;
import edu.wwu.csci412.multipoll.Model.User;
import edu.wwu.csci412.multipoll.R;


public class PollResults extends AppCompatActivity {

    public static Controller controller;
    private static User user;
    private static Group currentGroup;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.poll_results);

        controller = MainActivity.getController();
        user = controller.getUser();
        currentGroup = user.getCurrentGroup();

        getSupportActionBar().setTitle(user.getCurrentPoll().getName());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



        // Connect GroupSelected activity to this fragment somehow
        ArrayAdapter<String> arrayAdapter;
        ListView lv = findViewById(R.id.pollOptions);

//        arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, user.getCurrentPoll().getOptions());
//        lv.setAdapter(arrayAdapter);

//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String TempListViewClickedValue = currentGroup.listPolls().get(position);
//                if (TempListViewClickedValue.equals("Categories")) {
//                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CatFragment()).addToBackStack(null).commit();
//                }
//                if (TempListViewClickedValue.equals("Theme")) {
//                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ThemeFragment()).addToBackStack(null).commit();
//                }
//
//            }
//        });
    }

    @Override public boolean onSupportNavigateUp() {
        onBackPressed();
        return true; }

}
