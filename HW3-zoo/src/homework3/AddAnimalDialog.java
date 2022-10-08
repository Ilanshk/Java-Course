package homework3;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * The class represents the window which allows the user to add animals to the zoo.
 * @author Ilan Shklover 206753550, Shira Cohen 211777834
 *
 */


public class AddAnimalDialog extends JDialog {
	/**
	 * Text field to enter the size of the animal the user wants to add(only values from 50 to 300 are allowed)
	 */
	private JTextField textField_size ;
	
	
	/**
	 * Text field to enter the horizontal speed of the animal(only values from 1-10 are allowed)
	 */
	private JTextField textField_speedHor ;
	
	
	/**
	 * Text field to enter the vertical speed of the animal(only values from 1-10 are allowed)
	 */
	private JTextField textField_speedVer ;
	
	/**
	 * Combo box to choose the type of animal to add to the zoo(Lion,Bear,Elephant,Giraffe,Turtle)
	 */
	private JComboBox comboBox_Type;
	
	
	/**
	 * Combo box to choose the color of the animal to add to the zoo(red,blue,natural)
	 */
	private JComboBox comboBox_Color;
	
	
	/**
	 * Button to save the type of animal chosen.
	 */
	private JButton bType;
	
	
	/**
	 * Button to save the size of the animal chosen.
	 */
	private JButton bSize;
	
	
	/**
	 * Button to save the horizontal speed of the animal chosen.
	 */
	private JButton bSpeedHor;
	
	
	/**
	 * Button to save the vertical speed of the animal chosen.
	 */
	private JButton bSpeedVer;
	
	
	/**
	 * Button to save the color of the animal chosen.
	 */
	private JButton bColor;
	
	
	/**
	 * Button to save all the information about the animal that the user wants to add to the zoo.
	 */
	private JButton b_end;
	
	
	/**
	 * Label next to the above button which saves all the information of the animal.
	 */
	private JLabel l_end;
	
	
	/**
	 * The type of the animal(Lion,Bear,Elephant,Giraffe,Turtle).
	 */
	private String type_animal;
	
	
	/**
	 *The size of the animal in pixels.
	 */
	private int size;
	
	
	/**
	 * The horizontal speed of the animal.
	 */
	private int speedHor;
	
	
	/**
	 * The vertical speed of the animal.
	 */
	private int speedVer;
	
	
	/**
	 * The color of the animal.
	 */
	private String color;
	
	
	/**
	 * Animal object
	 */
	private Animal obj;
	
	
	/**
	 * Counts the number of animals added to the zoo.(only up to 10 animals are allowed to be in the zoo)
	 */
	private static int counter_animal = 0;
	
	
	/**
	 * states if an animal was added to the zoo.
	 */
	private static boolean is_add= false;
	
	
	
	/**
	 * Constructor
	 * @param zooPanel - the area in which the animals are located.
	 */
	public AddAnimalDialog(ZooPanel zooPanel) {
		super();
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(6, 3));
		this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		
		String[] animals = {"Lion", "Bear", "Elephant", "Giraffe", "Turtle"};
		comboBox_Type = new JComboBox(animals);
		bType = new JButton("Save type");
		bType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == bType) {
					JOptionPane.showMessageDialog(null, "Saved");
					type_animal = (String)comboBox_Type.getSelectedItem();
					
				}
			}
			});
		
		textField_size = new JTextField();
		bSize = new JButton("Save size");
		bSize.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(!(Integer.parseInt(textField_size.getText().toString()) >= 50 && Integer.parseInt(textField_size.getText().toString())<= 300))
					JOptionPane.showMessageDialog(null, "Enter size between 50 to 300");
			else {
				JOptionPane.showMessageDialog(null, "Saved");
			    size = Integer.parseInt(textField_size.getText().toString());
			}
			
			}
		});
		textField_speedHor = new JTextField();
		bSpeedHor = new JButton("Save speed");
		bSpeedHor.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==bSpeedHor) {
				if(!(Integer.parseInt(textField_speedHor.getText().toString()) >= 1 && Integer.parseInt(textField_speedHor.getText().toString())<= 10))
					JOptionPane.showMessageDialog(null, "Enter speed between 1 to 10");
				else {
					JOptionPane.showMessageDialog(null, "Saved");
			        speedHor = Integer.parseInt(textField_speedHor.getText().toString());
				}
			}
			
		}
		});
		
		textField_speedVer = new JTextField();
		bSpeedVer = new JButton("Save speed");
		bSpeedVer.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==bSpeedVer) {
				if(!(Integer.parseInt(textField_speedVer.getText().toString()) >= 1 && Integer.parseInt(textField_speedVer.getText().toString())<= 10))
					JOptionPane.showMessageDialog(null, "Enter speed between 1 to 10");
				//if(textField_speedVer.getText().contains("."))
						//JOptionPane.showMessageDialog(null, "Enter integer speed value between 1 to 10");
						
				else {
					JOptionPane.showMessageDialog(null, "Saved");		
			        speedVer = Integer.parseInt(textField_speedVer.getText().toString());
				}
				
			}	
		}
		});
		
		String[] colors = {"Red", "Blue", "Natural"};
		comboBox_Color = new JComboBox(colors);
		bColor = new JButton("Save color");
		bColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Saved");
				color = (String)comboBox_Color.getSelectedItem();
			}
		});
		l_end = new JLabel("Click here to complete the operation:");
		b_end= new JButton("Save all");
		b_end.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == b_end && counter_animal<10) {
					switch(type_animal) {
					case "Lion":
			    		obj = new Lion(size,speedHor,speedVer,color,zooPanel);
			    		is_add = true;
			    		System.out.println(AddAnimalDialog.counter_animal);
			    		obj.set_thread();
			    		ZooPanel.set_animal_array(obj);
			    		ZooPanel.get_animal_array()[counter_animal].get_zoo_panel().repaint();
			    		System.out.println(ZooPanel.get_animal_array()[counter_animal]);
			    		counter_animal++;
			    		ZooPanel.get_animal_array()[counter_animal-1].get_thread().start();
			    		break;
			    	case "Bear":
			    		obj = new Bear(size,speedHor,speedVer,color,zooPanel);
			    		is_add = true;
			    		obj.set_thread();
			    		ZooPanel.set_animal_array(obj);
			    		ZooPanel.get_animal_array()[counter_animal].get_zoo_panel().repaint();
			    		System.out.println(ZooPanel.get_animal_array()[counter_animal]);
			    		counter_animal++;
			    		ZooPanel.get_animal_array()[counter_animal-1].get_thread().start();
			    		break;
			    	case "Elephant":
			    		obj = new Elephant(size,speedHor,speedVer,color,zooPanel);
			    		is_add = true;
			    		obj.set_thread();
			    		ZooPanel.set_animal_array(obj);
			    		ZooPanel.get_animal_array()[counter_animal].get_zoo_panel().repaint();
			    		System.out.println(ZooPanel.get_animal_array()[counter_animal]);
			    		counter_animal++;
			    		ZooPanel.get_animal_array()[counter_animal-1].get_thread().start();
			    		break;
			    	case "Giraffe":
			    		obj = new Giraffe(size,speedHor,speedVer,color,zooPanel);
			    		is_add = true;
			    		obj.set_thread();
			    		ZooPanel.set_animal_array(obj);
			    		ZooPanel.get_animal_array()[counter_animal].get_zoo_panel().repaint();
			    		System.out.println(ZooPanel.get_animal_array()[counter_animal]);
			    		counter_animal++;
			    		ZooPanel.get_animal_array()[counter_animal-1].get_thread().start();
			    		break;
			    	case "Turtle":
			    		obj = new Turtle(size,speedHor,speedVer,color,zooPanel);
			    		is_add = true;
			    		obj.set_thread();
			    		ZooPanel.set_animal_array(obj);
			    		ZooPanel.get_animal_array()[counter_animal].get_zoo_panel().repaint();
			    		System.out.println(ZooPanel.get_animal_array()[counter_animal]);
			    		counter_animal++;
			    		ZooPanel.get_animal_array()[counter_animal-1].get_thread().start();
			    		break;
			    	}
					
					
				}
				else
					JOptionPane.showMessageDialog(null, "You can not add more than 10 animals");
				
			}
			
		});
		this.add(new JLabel("Type of animal: "));
		this.add(comboBox_Type);
		this.add(bType);
		this.add(new JLabel("size of animal(pixels): "));
		this.add(textField_size);
		this.add(bSize);
		this.add(new JLabel("Speed horizontal of animal: "));
		this.add(textField_speedHor);
		this.add(bSpeedHor);
		this.add(new JLabel("Speed vertical of animal: "));
		this.add(textField_speedVer);
		this.add(bSpeedVer);
		this.add(new JLabel("Color of animal: "));
		this.add(comboBox_Color);
		this.add(bColor);
		this.add(l_end);
		this.add(b_end);
		
		this.pack();
		this.setVisible(true);
		
		
	    	
	}
	
	/**
	 * 
	 * @param num - number of animals in the zoo.
	 * @return true if we succeeded to set the number of animals in the zoo,otherwise returns false.
	 */
	public static boolean set_counter(int num) {
		counter_animal = num;
		return true;
	}
	
	/**
	 * 
	 * @return Number of animals in the zoo.
	 */
	public static int get_counter() {return counter_animal;}
	
	
	/**
	 * 
	 * @return true if animal was added to the zoo,else returns false.
	 */
	public static boolean get_isAdd() {return is_add;}
}
