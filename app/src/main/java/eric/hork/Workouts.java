package eric.hork;

import java.util.ArrayList;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import com.google.gson.Gson;

import eric.hork.WorkoutClasses.WorkoutTop;
import eric.hork.expandListView.Adapter.ExpandListAdapter;
import eric.hork.expandListView.Classes.ExpandListChild;
import eric.hork.expandListView.Classes.ExpandListGroup;


public class Workouts extends ActionBarActivity {




    private Gson gson = new Gson();
    private String json;
    private WorkoutTop workoutTop = new WorkoutTop();
    private ExpandListAdapter ExpAdapter;
    private ArrayList<ExpandListGroup> ExpListItems;
    private ExpandableListView ExpandList;
    SharedPreferences sharedPref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workouts_old);


       //get object from sharedPref
        sharedPref = getSharedPreferences("eric.hork.myPrefs",MODE_PRIVATE);
        json = sharedPref.getString("eric.hork.workoutName", "");
        workoutTop = gson.fromJson(json,WorkoutTop.class);

        ArrayList<ExpandListGroup> list = new ArrayList<>();
        ArrayList<ExpandListChild> listChild = new ArrayList<>();
        ExpandListChild childGroup1 = new ExpandListChild();
        ExpandListGroup group1 = new ExpandListGroup();
        childGroup1.setName("day's here");
        listChild.add(childGroup1);
        group1.setItems(listChild);
        group1.setName(workoutTop.getName());
        list.add(group1);
        ExpandList = (ExpandableListView) findViewById(R.id.expandableListView);
        //ExpListItems = SetStandardGroups();
        ExpListItems = list;
        ExpAdapter = new ExpandListAdapter(Workouts.this, ExpListItems);
        ExpandList.setAdapter(ExpAdapter);
    }


    public ArrayList<ExpandListGroup> SetStandardGroups() {
        ArrayList<ExpandListGroup> list = new ArrayList<ExpandListGroup>();
        ArrayList<ExpandListChild> list2 = new ArrayList<ExpandListChild>();
        ExpandListGroup gru1 = new ExpandListGroup();
        gru1.setName("Comedy");
        ExpandListChild ch1_1 = new ExpandListChild();
        ch1_1.setName("A movie");
        ch1_1.setTag(null);
        list2.add(ch1_1);
        ExpandListChild ch1_2 = new ExpandListChild();
        ch1_2.setName("An other movie");
        ch1_2.setTag(null);
        list2.add(ch1_2);
        ExpandListChild ch1_3 = new ExpandListChild();
        ch1_3.setName("And an other movie");
        ch1_3.setTag(null);
        list2.add(ch1_3);
        gru1.setItems(list2);
        list2 = new ArrayList<ExpandListChild>();

        ExpandListGroup gru2 = new ExpandListGroup();
        gru2.setName("Action");
        ExpandListChild ch2_1 = new ExpandListChild();
        ch2_1.setName("A movie");
        ch2_1.setTag(null);
        list2.add(ch2_1);
        ExpandListChild ch2_2 = new ExpandListChild();
        ch2_2.setName("An other movie");
        ch2_2.setTag(null);
        list2.add(ch2_2);
        ExpandListChild ch2_3 = new ExpandListChild();
        ch2_3.setName("And an other movie");
        ch2_3.setTag(null);
        list2.add(ch2_3);
        gru2.setItems(list2);
        list.add(gru1);
        list.add(gru2);
        return list;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}