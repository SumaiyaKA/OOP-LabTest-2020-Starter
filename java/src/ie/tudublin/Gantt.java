package ie.tudublin;

import processing.core.PApplet;
import java.util.ArrayList;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{	
	// Declare an ArrayList to hold instances of the Task class:
	public ArrayList<Task> tasks = new ArrayList<Task>();

    int selected1 = -1;
    int selected2 = -1;
	
	
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

		float border = width * 0.05f; // border = 40

		for(int i = 1; i <= 30; i++) 
		{
			
			float l = map(i, 1, 30, border *4, width - border);
			
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
		
        } 
	}
	
	public void drawPhase() 
	{

		float border = width * 0.05f;
		
		int i=0;
		for(Task w:tasks) 
		{
			
			float startPoint = map (w.getStart(), 1, 30, border*4, width -border);
			float endPoint = map (w.getEnd(), 1, 30, border*4, width - border);
			float phaseSize = endPoint - startPoint;
			
			float y = map(i, 0, tasks.size(), border , height - (border*1) );

			noStroke();
			fill(i * w.getEnd(),255,255);
			rect(startPoint, y, phaseSize, 30);
			fill(255);
			textAlign(CENTER, CENTER);
			text(w.getTask(), border*2 , y + 10);

			i++;
        } 
        
	}
	
	public void mousePressed()
	{	
		float border = width * 0.05f;

		for(int i = 0; i < tasks.size(); i++)
        {
			Task task = tasks.get(i);

			float leftSide = map(task.getStart(), 1, 30, border*4, width - border);
			float rightSide = map(task.getEnd(), 1, 30, border*4, width - border);

			
            if (mouseX < leftSide  && mouseX > leftSide)
            {
				selected1 = i;
			}
			else if(mouseX > rightSide  && mouseX < rightSide)
			{
				selected2 = i;
			}
			
        }
	}

	public void mouseDragged()
	{
		int size;
		float border = width * 0.05f;

		// Selected left of the box
		if(selected1 != -1)
		{
			Task task = tasks.get(selected1);
			float leftSide = map(task.getStart(), 1, 30, border*4, width - border);

			// check if the left half of the rectangle had been moved to the left but not outside the grid
			if(mouseX < leftSide && mouseX > border)
			{
				// reset the size depends on the mouse 
				size = task.getStart() - 1;
				task.setStart(size);
			}
			
			// check if the left half of the rectangle had been moved to the right 
			else if(task.getEnd() - task.getStart() != 1 && (mouseX > border*4) && mouseX > leftSide + 20)
			{
				// reset the size depends on the mouse movement
				size = task.getStart() + 1;
				task.setStart(size);
			}
		}
		
		else if(selected2 != -1)
		{
			Task task = tasks.get(selected2);

			float rightSide = map(task.getEnd(), 1, 30, border*4, width - border);

			// check if the right half of the rectangle had been moved to the left but not outside the grid
			if( mouseX > rightSide && mouseX < (width - border) )
			{
				size = task.getEnd() + 1;
				task.setEnd(size);
			}
			
			// check if the left half of the rectangle had been moved to the right 
			else if( (task.getEnd() - task.getStart() ) != 1 && mouseX < width - border)
			{
				size = task.getEnd() - 1;
				task.setEnd(size);
			}
		}
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
