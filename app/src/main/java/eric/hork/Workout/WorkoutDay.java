package eric.hork.Workout;

import java.util.ArrayList;

/**
 * Created by eric on 4/29/15.
 */
public class WorkoutDay {
    private String dayName;
    private ArrayList<Exercise> Exercises;

    public String getDayName(){
        return dayName;
    }

    public void setDayName(String thisName){
        dayName = thisName;
    }


    public ArrayList<Exercise> getExercises(){
        return Exercises;
    }

    public Boolean addExercise(Exercise exercise){
        return Exercises.add(exercise);
    }
}
