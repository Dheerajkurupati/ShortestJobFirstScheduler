// package k22ug;
//
import java.util.LinkedList;
import java.util.Scanner;
import java.util.*;
//

interface PriorityQueueDeclare
{
    public abstract void insert(ProcessEntity process);
}
class ProcessEntity {
    int processID;
    String processName;
    int executionTime;

    public ProcessEntity(int processID, String processName, int executionTime) {
        this.processID = processID;
        this.processName = processName;
        this.executionTime = executionTime;
    }
}

class PriorityQueue implements PriorityQueueDeclare{
    LinkedList<ProcessEntity> queue = new LinkedList<>();

    public void insert(ProcessEntity process) {
        int index = 0;
        while (index < queue.size() && process.executionTime > queue.get(index).executionTime) {
            index++;
        }
        queue.add(index, process);
    }

    public ProcessEntity getShortestJob() {
        if (!queue.isEmpty()) {
            return queue.removeFirst();
        }
        return null;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}

public class SJFScheduling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            PriorityQueue priorityQueue = new PriorityQueue();


            System.out.print("Enter the number of processes: ");
            int numProcesses = scanner.nextInt();

            for (int i = 0; i < numProcesses; i++) {
//            System.out.print("Enter Process ID for Process " + (i + 1) + ": ");
                int processID = new Random().nextInt(1000);
                System.out.print("Enter Process Name for Process " + (i + 1) + ": ");
                String processName = scanner.next();
                System.out.print("Enter Execution Time for Process " + (i + 1) + ": ");
                int executionTime = scanner.nextInt();

                ProcessEntity process = new ProcessEntity(processID, processName, executionTime);
                priorityQueue.insert(process);
            }

            System.out.println("\nProcess Scheduling Order (Shortest Job First):");
            while (!priorityQueue.isEmpty()) {
                ProcessEntity shortestJob = priorityQueue.getShortestJob();
                System.out.println("Process ID: " + shortestJob.processID +
                        ", Process Name: " + shortestJob.processName +
                        ", Execution Time: " + shortestJob.executionTime);
            }
        }
        catch(Exception ex)
        {
            System.out.println("Exception Occur"+ex);
        }
       finally
        {
            scanner.close();
        }
    }
}
