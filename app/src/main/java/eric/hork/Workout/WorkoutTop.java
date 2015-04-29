package eric.hork.Workout;

import java.util.ArrayList;

/**
 * Created by eric on 4/29/15.
 */
public class WorkoutTop {
    private String name;
    private ArrayList<WorkoutDay> workoutDays;

    public String getName(){
        return name;
    }

    public void setName(String workoutName){
        name = workoutName;
    }

    public ArrayList<WorkoutDay> getWorkoutDays(){
        return workoutDays;
    }

    public Boolean addWorkoutDay(WorkoutDay workoutDay){
       return workoutDays.add(workoutDay);
    }

}
