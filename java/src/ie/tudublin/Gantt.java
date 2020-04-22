package ie.tudublin;

import processing.core.PApplet;
import java.util.ArrayList;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{	
	// Declare an ArrayList to hold instances of the Task class:
	public ArrayList<Task> tasks = new ArrayList<Task>();
	
	
	public void settings()
	{
		size(800, 600);
	}

	// Write a method called loadTasks that populates the ArrayList from the file tasks.csv:
	public void loadTasks()
	{
		Table t = loadTable("tasks.csv", "header");
		for(TableRow row:t.rows())
		{
			Task s = new Task(row);
			tasks.add(s);
		}
		
	}

	// Write a method printTasks that prints the elements of the ArrayList:
	public void printTasks()
	{
		for(Task m:tasks)
		{
		
			String task1 = m.task;
			int start1 = m.start;
			int end1 = m.end;

			System.out.println(task1 + ", " + start1 + ", " + end1);
						
		}
		
	}
	
	public void mousePressed()
	{
		println("Mouse pressed");	
	}

	public void mouseDragged()
	{
		println("Mouse dragged");
	}

	
	
	public void setup() 
	{
		loadTasks();
		printTasks();
	}
	
	public void draw()
	{			
		background(0);
	}
}
