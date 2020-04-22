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

	// Write a method called displayTasks() that displays the tasks as in the video. 
	// Each task should have a separate colour. 
	// You can use HSB colour mode to achieve this. 
	// To get full marks you should use the Processing map function in your solution
	public void displayTasks()
	{
		drawGrid();

	}

	public void drawGrid() {

		float border = width * 0.05f;
		
        // stroke(0, 0, 255); // set the colour used to draw lines and borders around shapes
        textAlign(CENTER, CENTER);
        for(int i = 1; i <= 30; i++) {

			float x = map(i, 1, 30, border *4, width - border);
			// String name = i.task;

			if( i%2 == 0 )
			{
				stroke(255, 255, 255);
				// line (x1, y1, x2, y2)
				line(x, border, x, height - border);

			}
			else 
			{
				stroke(192, 192, 192);
				line(x, border, x, height - border);
			}

			
			// text(numbers, x, y)
			text(i, x, border / 2); 
			// text(names, x, y)
			// text(name, border / 2, x);

			/*

			for(Task m:tasks)
			{
			
				String task1 = m.task;
				int start1 = m.start;
				int end1 = m.end;
	
				System.out.println(task1 + ", " + start1 + ", " + end1);
							
			}

            map(value, start1, stop1, start2, stop2)
            float x = map(i, -5, 5, border, width - border);
            line(x1, y1, x2, y2)
            line(x, border, x, height - border);
            line(border, x, width - border, x); 

            fill(255); // white colour fill 
            text(i, x, border / 2); // text(c, x, y)
			text(i, border / 2, x);
			*/
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
		displayTasks();
	}
}
