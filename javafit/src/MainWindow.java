import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
// Bonus points: Create an icon (or find a public domain icon. Keep in mind federal Copyright law and TAMU's plagiarism policy and add it to the home screen window.
public class MainWindow extends JPanel {
  
  private final JFrame mainFrame = new JFrame(Config.APPLICATIONNAME);
  private final JDialog selectWorkout = new JDialog(mainFrame, "Select Workout");
  private JComboBox<String> cboType, cboGoal;
  private JSpinner spnDuration;
  private final Workouts workouts;
  private final EnumMap<Config.MuscleGroup, ArrayList<Config.Muscle>> muscleGroups;
  
  private JButton JIcon = new JButton(new ImageIcon("data/home.png")); //creates the button icon
  private JButton JButton1 = new JButton("Upper Body Workout"); 
  private JButton JButton2 = new JButton("Lower Body Workout");
  private JButton JButton3 = new JButton("Whole Body Workout");
  private Iterator<Config.MuscleGroup> itr;
  private ArrayList<Config.Muscle> upperBody;
  private ArrayList<Config.Muscle> lowerBody;
  private ArrayList<Config.Muscle> wholeBody;
  
  //This is a constructor for the class MainWindow. 
  MainWindow(Workouts workouts, EnumMap<Config.MuscleGroup, ArrayList<Config.Muscle>> muscleGroups) {
	    // Code goes here.
	    this.workouts = workouts;
	    this.muscleGroups = muscleGroups;
		itr = muscleGroups.keySet().iterator();
		upperBody =  muscleGroups.get(itr.next());
		lowerBody =  muscleGroups.get(itr.next());
		wholeBody =  muscleGroups.get(itr.next());
		
		launchHomeScreen(); 
  }
  
  public JPanel createHome()
  {  
	    JPanel homeScreen = new JPanel();
	    homeScreen.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
	    //homeScreen.setLayout(new GridLayout (3,1));
	    homeScreen.setLayout(new GridLayout (4,1));
		ButtonListener listen = new ButtonListener();
		
		//JIcon.set
		JButton1.addActionListener(listen);
		JButton2.addActionListener(listen);
		JButton3.addActionListener(listen);
	
		homeScreen.add(JIcon);
		homeScreen.add(JButton1);
		homeScreen.add(JButton2);
		homeScreen.add(JButton3);
		homeScreen.setPreferredSize(new Dimension(600,400));
		return homeScreen;
  }
  private void launchHomeScreen() {
    // Code goes here.
	  mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	  JPanel homeScreen = createHome();
	  
	  mainFrame.getContentPane().add(homeScreen);
	  mainFrame.pack();
	  mainFrame.setVisible(true);
	
  }
  
  private class ButtonListener implements ActionListener 
  {

       public void actionPerformed(ActionEvent e) 
       {
      	 String actionCommand = e.getActionCommand(); 
      	 
      	 if (actionCommand.equals("Upper Body Workout"))
      	 {
      		 showWorkouts(upperBody);
      		 return;
      	 }
      	 else if (actionCommand.equals("Lower Body Workout"))
      	 {
      		 showWorkouts(lowerBody);
      		 return;
      	 }
      	 else 
      	 {
      		 showWorkouts(wholeBody);
      		 return;
      	 }
       }
  }

  
  // This is the method your actionlistener should call. It should create and display a WorkoutsPanel.
  private void showWorkouts(ArrayList<Config.Muscle> muscles) {
    
  // Code goes here.
	 
	  JFrame workoutFrame = new JFrame();
	  WorkoutsPanel workoutPanel = new WorkoutsPanel(muscles, this.workouts);
	  workoutPanel.setPreferredSize(new Dimension(600,400));
	  workoutFrame.getContentPane().add(workoutPanel);
	  workoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  workoutFrame.pack();
	  workoutFrame.setVisible(true);
 
  }
}
