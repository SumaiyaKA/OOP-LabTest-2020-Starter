// This java file loads the table from tasks.csv file 
package ie.tudublin;
// import processing.core.PApplet;
import processing.data.TableRow;

public class Task
{
    public String task;
    public int start;
    public int end;
    

    public Task(String task, int start, int end)
    {
        this.task = task;
        this.start = start;
        this.end = end;
     
    }

    public Task(TableRow tr)
    {
        
        this(tr.getString("Task")
        , tr.getInt("Start")
        , tr.getInt("End")
        );
    }

    public String toString()
    {
        return this.task + ", " + this.start + ", " + this.end;
    }
}