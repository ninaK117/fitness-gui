import java.util.ArrayList; // We choose ArrayList over Vector because...?


public class Workouts {
  private final ArrayList<Workout> workoutList = new ArrayList<Workout>();

  public static int size;

  public final int size()
  {
  	return size; 
  }
  
  public final void addWorkout(String name, Config.Equipment equipment, Config.Muscle primaryMuscle, Config.Muscle secondaryMuscle, String desc, String reminders)
  {
    Workout newWorkout = new Workout(name, equipment, primaryMuscle, secondaryMuscle, desc, reminders);
    
	  for (int i = 0; i < workoutList.size(); i++)
	  {
		  if (workoutList.get(i).match(newWorkout))
		  {
			  return;
		  }
	  }
    workoutList.add(newWorkout);
    size++;
  }
  
  public final void addWorkout(Workout workout)
  {
	  for (int i = 0; i < workoutList.size(); i++)
	  {
		  if (workoutList.get(i).match(workout))
		  {
			  return;
		  }
	  }
    workoutList.add(workout);
    size++;
  }
  
  public final Workouts getWorkoutsByMuscle(Config.Muscle m, boolean includeSecondary)
  {
    Workouts retval = new Workouts();
    for(Workout w : workoutList) {
      if(w.hasPrimaryMuscle(m)) {
        retval.addWorkout(w);
      }
      else if (includeSecondary && w.hasSecondaryMuscle(m)) { // Why did I put the includeSecondary first?
        retval.addWorkout(w);
      }
    }
    return retval;
  }
  
  public final Workouts getWorkoutsByMuscle(ArrayList<Config.Muscle> m, boolean includeSecondary)
  {
	  Workouts retval = new Workouts(); 
	  for (Workout w: workoutList)
	  {
		  if(w.hasPrimaryMuscle(m))
		  {
			  retval.addWorkout(w);
		  }
		  else if (includeSecondary && w.hasSecondaryMuscle(m))
		  {
			  retval.addWorkout(w);
		  }
	  }
	   
	return retval;  
  }
  
  
  public final Workouts getWorkoutsByEquipment(Config.Equipment e)
  {
    Workouts retval = new Workouts();
    for(Workout w : workoutList) {
      if(w.hasEquipment(e)) {
        retval.addWorkout(w);
      }
    }
    return retval;
  }
  
  public final Workouts getWorkoutsByEquipment(ArrayList<Config.Equipment> e)
  {
    Workouts retval = new Workouts();
    for(Workout w : workoutList) {
      if(w.hasEquipment(e)) {
        retval.addWorkout(w);
      }
    }
    return retval;
  }

  
  public final Workout getWorkout(int index) 
  {
	  Workout workout = workoutList.get(0);
	  try 
	  {
		  workout = workoutList.get(index);
	  }
	  
	  catch (IndexOutOfBoundsException exception)
	  {
		  System.out.println("The index entered is greater than the size of the list. Use an index that is within"
		  + " the bounds of 0 to " + workoutList.size());
	  }
	  return workout; 
  }

  public final String getWorkoutEquipment(int index) 
  {
	  Workout workout = workoutList.get(0);
	  String workoutName = "";
	  try 
	  {
		  workout = workoutList.get(index);
		  workoutName = workout.getEquipment();
	  }
	  catch (IndexOutOfBoundsException exception)
	  {
		  System.out.println("The index entered is greater than the size of the list. Use an index that is within"
		  + " the bounds of 0 to " + workoutList.size());
	  }
	  return workoutName;
  }

 
  public final int findWorkoutByName(String name) 
  {
	  
	  for (int i = 0; i< workoutList.size(); i++)
	  {
		  if (workoutList.get(i).getName().equals(name))
		  {
			  return i;
		  }
	  }
	  return -1; 

  }

 
  public final ArrayList<String> getEquipment() 
  {
	  ArrayList<String> retval = new ArrayList<String>();
	  for(Workout w: workoutList)
	  {
		  retval.add(w.getEquipment());
	  }
	  return retval;
  }
  
  
  public final ArrayList<String> getNames()
  {
    ArrayList<String> retval = new ArrayList<String>();
    for(Workout w : workoutList) {
      retval.add(w.getName());
    }
    return retval;
  }
 
  public final ArrayList<String[]> getFullInformation()
  {
    ArrayList<String[]> retval = new ArrayList<String[]>();
    for(Workout w : workoutList) {
      String[] info = new String[6];
      info[0] = w.getName();
      info[1] = w.getEquipment();
      info[2] = w.getPrimaryMuscle();
      info[3] = w.getSecondaryMuscle();
      info[4] = w.getDesc();
      info[5] = w.getReminders();
      retval.add(info);
    }
    return retval; 
  }
}
