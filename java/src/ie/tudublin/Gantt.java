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

			System.out.println(m);
						
		}
		
	}

	// Write a method called displayTasks() that displays the tasks as in the video. 
	// Each task should have a separate colour. 
	// You can use HSB colour mode to achieve this. 
	// To get full marks you should use the Processing map function in your solution
	public void displayTasks()
	{
		drawGrid();
		drawPhase();
		colorMode(HSB);
		

	}

	public void drawGrid() {

		float border = width * 0.05f;
		
        // stroke(0, 0, 255); // set the colour used to draw lines and borders around shapes
		for(int i = 1; i <= 30; i++) 
		{
			// noFill();
			float l = map(i, 1, 30, border *4, width - border);
			// String name = i.task;
			noStroke();
			if( i%2 == 0 )
			{
				
				fill(180);
				rect(l, border, 1, height - (border*2) );
				

			}
			else 
			{
				fill(255);
				rect(l, border, 1, height - (border*2) );
			}

			
			// text(numbers, x, y)
			fill(255);
			text(i, l, border / 2); 


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
	
	public void drawPhase() 
	{
		// for(Task m:tasks)
		// colorMode(HSB);
		float border = width * 0.05f;
		
        // stroke(0, 0, 255); // set the colour used to draw lines and borders around shapes
		int i=0;
		
		for(Task w:tasks) 
		{
			// Task w = tasks.get(i);
			// int phaseSize = tasks.size() - 1;
			// float l = map(i, 1, 30, border *4, width - border);

			// float daySize = 20.0f;
			
			float x = map (w.getStart(), 1, 30, border * 4, width -border);
			float x1 = map (w.getEnd(), 1, 30, border *4, width - border);
			float phaseSize = x1 - x;
			// float phaseSize = (w.getEnd() - w.getStart() ) * daySize;
			// float taskSize = map(w.getEnd()-w.getStart(), 0, 30, border*4, width - border );
			// float x = map(i, 1, 30, border * 4 + (w.getStart() * daySize), width - border);
			float y = map(i, 0, tasks.size(), border , height - (border*1) );

			noStroke();
			fill(i * w.getEnd(),255,255);
			rect(x, y, phaseSize, 30);
			fill(255);
			textAlign(CENTER, CENTER);
			text(w.getTask(), border*2 , y);
			i++;

			

			// String name = i.task;

			
			// text(numbers, x, y)
			// text(i, x, border / 2); 
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
