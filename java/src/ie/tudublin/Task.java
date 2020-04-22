// This java file loads the table from tasks.csv file 
package ie.tudublin;

import processing.data.TableRow;

public class Task
{
    public String task;
    public int start;
    public int end;


	public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String toString()
    {
        return task + ", " + start + ", " + end ; 

    }

    public Task(String task, int start, int end) {
        this.task = task;
        this.start = start;
        this.end = end;
    }

    public Task(TableRow tr)
    {
        this(tr.getString("Task"),tr.getInt("Start"),tr.getInt("End"));
    }

    


    
}