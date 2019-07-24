import java.util.ArrayList; // We choose ArrayList over Vector because...? 

/**
* Use the provided enumerations and code framework to create our workouts class.
* This class should contain all the functionality we need to interact with our workout list.
* Minimize duplication of code by writing helper functions as needed.
* 
* Do not change any of the provided code, although you can, and should, add to it as needed. 
* (E.G. Do not make private attributes public, or change the parameters of a function.)
*/

public class Workouts {

  //Why didn't I have to declare this static? 
  // Use the Refactor functionality in Eclipse to rename "muscle" to "Muscle" to match our naming convention.
  public enum Muscle {ABS, BACK, BICEPS, CHEST, FOREARM, GLUTES, LOWERLEG, SHOULDER, TRICEPS, UPPERLEG, NONE}
  public enum Equipment {BARBELL, BODYWEIGHT, DUMBBELL, CABLE, HAMMERSTRENGTH}

  private final ArrayList<Workout> workoutList = new ArrayList<Workout>(); //Allows for access to the inner class Workout

	
	
	// This is a nested class, also known as an inner class. Why do we use a nested class?
 
	// You will need to create a number of methods for the inner class. You are not limited to 
	// only the methods listed inside this class.

	private class Workout {
	  private String name;
	  private Equipment equipment;
		private Muscle primaryMuscle;
		private Muscle secondaryMuscle;
		private String desc;
		private String reminders;
	
    Workout (String name, Equipment equipment, Muscle primaryMuscle, Muscle secondaryMuscle, String desc, String reminders) {
    	//Code added at 4:34 PM
    	this.name = name;
    	this.equipment = equipment;
    	this.primaryMuscle = primaryMuscle;
    	this.secondaryMuscle = secondaryMuscle;
    	this.desc = desc;
    	this.reminders = reminders;
    }

    
    public String getName() {
    	return name;
    }
    
    public Equipment getEquipment() {
    	return equipment;
    }
    
    public Muscle getprimaryMuscle() {
    	return primaryMuscle;
    }
    public Muscle getsecondaryMuscle() {
    	return secondaryMuscle;	
    }
    
    public String getDesc() {
    	return desc;
    }
    
    public String getReminders() {
    	return reminders;
    }
    
    //How do we get the name of an enumeration value?

	}

  
  // This function adds a new workout to the Workouts object.
  public final void addWorkout(String name, Equipment equipment, Muscle primaryMuscle, Muscle secondaryMuscle, String desc, String reminders)
  {
	  //CODE ADDED AT 5:17 PM
	  Workout w = new Workout (name,equipment,primaryMuscle, secondaryMuscle, desc, reminders);
	  workoutList.add(w);
  }
  
  // This function adds a workout to the Workouts object.
  public final void addWorkout(Workout workout)
  {
	  workoutList.add(workout);
  }
  
  // This list returns a new Workouts object that contains only the workouts that contain the
  // Equipment value that is provided as an argument. The programmer has an option to get
  // Workouts that only have the Muscle in the primary muscle attribute, or to also look
  // in the secondaryMuscle category.
	public final Workouts getWorkoutsByMuscle(Muscle m, boolean includeSecondary)
	{
	  // What is short-circuit evaluation? 
		
		Workouts w = new Workouts();
		
		if (includeSecondary == false) {
			for (int i = 0; i < workoutList.size(); i++)
			{
				if ((workoutList.get(i)).getprimaryMuscle() == m)
				{
					String name1 = (workoutList.get(i)).getName();
					Equipment equipment1 = (workoutList.get(i)).getEquipment();
			    	Muscle primaryMuscle1 = (workoutList.get(i)).getprimaryMuscle();
			    	Muscle secondaryMuscle1 = (workoutList.get(i)).getsecondaryMuscle();
			    	String desc1 = (workoutList.get(i)).getDesc();
			    	String reminders1 = (workoutList.get(i)).getReminders();
					
			    	w.addWorkout(name1, equipment1, primaryMuscle1, secondaryMuscle1, desc1, reminders1);
				}
			}
		}
		else 
		{
			for (int i = 0; i < workoutList.size(); i++)
			{
				if (((workoutList.get(i)).getprimaryMuscle() == m) || ((workoutList.get(i)).getsecondaryMuscle() == m))
				{
					String name1 = (workoutList.get(i)).getName();
					Equipment equipment1 = (workoutList.get(i)).getEquipment();
			    	Muscle primaryMuscle1 = (workoutList.get(i)).getprimaryMuscle();
			    	Muscle secondaryMuscle1 = (workoutList.get(i)).getsecondaryMuscle();
			    	String desc1 = (workoutList.get(i)).getDesc();
			    	String reminders1 = (workoutList.get(i)).getReminders();
					
			    	w.addWorkout(name1, equipment1, primaryMuscle1, secondaryMuscle1, desc1, reminders1);
				}
			}
		}
		
		return w;
	}
	
	// This list returns a new Workouts object that contains only the workouts that contain the
	// Equipment value that is provided as an argument.
  public final Workouts getWorkoutsByEquipment(Equipment e)
  {
	  Workouts w = new Workouts();
	  
		for (int i = 0; i < workoutList.size(); i++)
		{
			if ((workoutList.get(i)).getEquipment() == e)
			{
				String name1 = (workoutList.get(i)).getName();
				Equipment equipment1 = (workoutList.get(i)).getEquipment();
		    	Muscle primaryMuscle1 = (workoutList.get(i)).getprimaryMuscle();
		    	Muscle secondaryMuscle1 = (workoutList.get(i)).getsecondaryMuscle();
		    	String desc1 = (workoutList.get(i)).getDesc();
		    	String reminders1 = (workoutList.get(i)).getReminders();
				
		    	w.addWorkout(name1, equipment1, primaryMuscle1, secondaryMuscle1, desc1, reminders1);
			}
		}
		return w;
	  
  }
	
  // This returns a new Workouts object that contains only the workouts that contain an Equipment
  // value that is in the provided ArrayList of Equipment.
  public final Workouts getWorkoutsByEquipment(ArrayList<Equipment> e)
  {
	  Workouts w = new Workouts(); 
	  
	  for (int i = 0; i < workoutList.size(); i++)
	  {
		  for (int j = 0; j < e.size(); j++)
		  {
			  if ((workoutList.get(i)).getEquipment() == e.get(j))
			  {
				  w.addWorkout(workoutList.get(i));
			  }
		  }
	  }

	  return w;
  }
	
  // This method returns an ArrayList of Strings. Each String is a name of a workout in our Workouts list.
  public final ArrayList<String> getNames()
  {
	  ArrayList<String> workoutNames = new ArrayList<String>();
	  
		//try two different ways. inside this function and the external rremoveDuplicatesStrings function
		//w = removeDuplicatesString(w); and go back to the CONFIG CLASS AND FIX IT	 
	  
	  for (int i = 0; i < workoutList.size(); i++)
	  {
		  if (!workoutNames.contains(workoutList.get(i).getName()))
		  {
			  workoutNames.add(workoutList.get(i).getName());
		  }
	  }
	  
	  return workoutNames;
 
  }
 
  // This method returns all the information of the Workouts as an ArrayList of String arrays, 
  // one entry in the ArrayList per Workout. The String array should contain the workout's Name, 
  // Equipment, Primary and Secondary Muscles, Description, and Reminders. All of these should be strings.
  public final ArrayList<String[]> getFullInformation()
  {
	  ArrayList<String[]> workoutInfo= new ArrayList<String[]>();
	  
	  for (int i = 0; i<workoutList.size(); i++)
	  {
			String[] info = new String[6];
			workoutInfo.add(info);
			(workoutInfo.get(i))[0] = (workoutList.get(i)).getName();
			(workoutInfo.get(i))[1] = (workoutList.get(i)).getEquipment().name();
			(workoutInfo.get(i))[2] = (workoutList.get(i)).getprimaryMuscle().name();
			(workoutInfo.get(i))[3] = (workoutList.get(i)).getsecondaryMuscle().name();
			(workoutInfo.get(i))[4] = (workoutList.get(i)).getDesc();
			(workoutInfo.get(i))[5] = (workoutList.get(i)).getReminders();  	
	  }
	  
	  return workoutInfo; 
  }
  
  
}
