package eric.hork;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import eric.hork.WorkoutClasses.WorkoutTop;


public class AddWorkout extends ActionBarActivity {

        private Button mButton;
        private EditText mEdit;
        private WorkoutTop workoutTop = new WorkoutTop();
        private Context context;
        private Gson gson = new Gson();
        SharedPreferences sharedPref;
        private String json;


    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_add_workout);

            mButton = (Button) findViewById(R.id.addButton);
            mEdit = (EditText) findViewById(R.id.addEditText);
            context = this;
            sharedPref = getSharedPreferences("eric.hork.myPrefs", MODE_PRIVATE);

            mButton.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        workoutTop.setName(mEdit.getText().toString());
                        SharedPreferences.Editor editor = sharedPref.edit();
                        json = gson.toJson(workoutTop);
                        editor.putString("eric.hork.workoutName",json);
                        editor.commit();
                    }
                }
            );


        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_workout, menu);
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
