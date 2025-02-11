import java.util.Scanner;

class Process {
    int processID, burstTime, priority;
    Process next;

    public Process(int processID, int burstTime, int priority) {
        this.processID = processID;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head = null, tail = null;
    private int timeQuantum;

    public RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    public void addProcess(int processID, int burstTime, int priority) {
        Process newProcess = new Process(processID, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            tail.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }
    }

    public void removeProcess(int processID) {
        if (head == null) return;

        Process temp = head, prev = null;

        do {
            if (temp.processID == processID) {
                if (temp == head && temp == tail) {
                    head = tail = null;
                } else if (temp == head) {
                    head = head.next;
                    tail.next = head;
                } else if (temp == tail) {
                    prev.next = head;
                    tail = prev;
                } else {
                    prev.next = temp.next;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    public void executeProcesses() {
        if (head == null) {
            System.out.println("No processes to execute.");
            return;
        }

        int totalWaitingTime = 0, totalTurnaroundTime = 0, processCount = 0;
        Process current = head;

        while (current != null) {
            if (current.burstTime > timeQuantum) {
                System.out.println("Process " + current.processID + " executed for " + timeQuantum + " units.");
                current.burstTime -= timeQuantum;
                current = current.next;
            } else {
                System.out.println("Process " + current.processID + " completed execution.");
                totalTurnaroundTime += current.burstTime;
                totalWaitingTime += totalTurnaroundTime - current.burstTime;
                int completedID = current.processID;
                current = current.next;
                removeProcess(completedID);
                processCount++;
            }

            if (head == null) break;
        }

        if (processCount > 0) {
            System.out.println("Average Waiting Time: " + (double) totalWaitingTime / processCount);
            System.out.println("Average Turnaround Time: " + (double) totalTurnaroundTime / processCount);
        }
    }

    public void displayQueue() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        Process temp = head;
        System.out.println("Processes in Queue:");
        do {
            System.out.println("Process ID: " + temp.processID + ", Burst Time: " + temp.burstTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }
}
public class Robin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Time Quantum: ");
        int timeQuantum = sc.nextInt();
        RoundRobinScheduler scheduler = new RoundRobinScheduler(timeQuantum);

        while (true) {
            System.out.println("\n1. Add Process");
            System.out.println("2. Execute Processes");
            System.out.println("3. Display Queue");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Process ID, Burst Time, Priority: ");
                    scheduler.addProcess(sc.nextInt(), sc.nextInt(), sc.nextInt());
                    break;
                case 2:
                    scheduler.executeProcesses();
                    break;
                case 3:
                    scheduler.displayQueue();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}