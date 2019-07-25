import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


//Write code to load the workouts from the provided workouts.csv file. 
//The function should return a Workouts object.

public class FileAccess {

public static Workouts loadWorkouts() {
 // What is a try/catch block and why do we need one?
		
 // What is an exception?
	
	Workouts w = new Workouts();  
	
	String fileName = Config.WORKOUTFILE;
	
	

	//Need a try/catch block because the file could not exist
	try {
		File file = new File(fileName); //Creates a new file --
		Scanner inputStream = new Scanner(file);// --
		
		while(inputStream.hasNext()) {
			String col = inputStream.nextLine(); //gets a whole line
			String[] values = col.split(","); //split function splits row into an array of values
			String name = values[0]; 
			String equipment  = values[1]; 
			String primaryMuscle = values[2]; 
			String secondaryMuscle = values[3]; 
			String desc = values[4]; 
			String reminders = values[5]; 
			
			w.addWorkout(name, Workouts.Equipment.valueOf(equipment), Workouts.Muscle.valueOf(primaryMuscle), Workouts.Muscle.valueOf(secondaryMuscle), desc, reminders);
			
		}
		inputStream.close();
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return w;
	
}

}
