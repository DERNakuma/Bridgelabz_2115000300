import java.util.Scanner;
class TaskNode {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;


    public TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}


class TaskScheduler {
    private TaskNode head;
    private TaskNode tail;
    private TaskNode currentTask;

    
    public TaskScheduler() {
        this.head = null;
        this.tail = null;
        this.currentTask = null;
    }

   
    public void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newTask = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) { 
            head = tail = newTask;
            newTask.next = head; 
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head; 
        }
        System.out.println("Task '" + taskName + "' added at the beginning.");
    }

   
    public void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newTask = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) { 
            head = tail = newTask;
            newTask.next = head; 
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head; 
        }
        System.out.println("Task '" + taskName + "' added at the end.");
    }

    public void addAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        if (position < 1) {
            System.out.println("Invalid position. Position must be >= 1.");
            return;
        }
        TaskNode newTask = new TaskNode(taskId, taskName, priority, dueDate);
        if (position == 1) { 
            addAtBeginning(taskId, taskName, priority, dueDate);
        } else {
            TaskNode current = head;
            for (int i = 1; i < position - 1; i++) { 
                if (current.next == head) {
                    System.out.println("Position out of range.");
                    return;
                }
                current = current.next;
            }
            newTask.next = current.next;
            current.next = newTask;
            if (newTask.next == head) { 
                tail = newTask;
            }
            System.out.println("Task '" + taskName + "' added at position " + position + ".");
        }
    }

  
    public void removeByTaskId(int taskId) {
        if (head == null) {
            System.out.println("List is empty. No task to delete.");
            return;
        }
        TaskNode current = head;
        TaskNode prev = tail; 
        do {
            if (current.taskId == taskId) {
                if (current == head) { 
                    head = head.next;
                    tail.next = head; 
                } else if (current == tail) { 
                    tail = prev;
                    tail.next = head; 
                } else { 
                    prev.next = current.next;
                }
                System.out.println("Task with ID " + taskId + " removed.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
        System.out.println("Task with ID " + taskId + " not found.");
    }

    
    public void viewAndMoveToNextTask() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        if (currentTask == null) {
            currentTask = head;
        }
        System.out.println("Current Task: ID: " + currentTask.taskId + ", Name: " + currentTask.taskName +
                ", Priority: " + currentTask.priority + ", Due Date: " + currentTask.dueDate);
        currentTask = currentTask.next;
    }

    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }
        TaskNode current = head;
        System.out.println("Tasks:");
        do {
            System.out.println("ID: " + current.taskId + ", Name: " + current.taskName +
                    ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
            current = current.next;
        } while (current != head);
    }

   
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        TaskNode current = head;
        boolean found = false;
        do {
            if (current.priority == priority) {
                System.out.println("Task found: ID: " + current.taskId + ", Name: " + current.taskName +
                        ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
                found = true;
            }
            current = current.next;
        } while (current != head);
        if (!found) {
            System.out.println("No tasks found with priority " + priority + ".");
        }
    }
}


public class TaskApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskScheduler taskScheduler = new TaskScheduler();
        int choice;

        do {
            
            System.out.println("\n--- Task Scheduler ---");
            System.out.println("1. Add a task at the beginning");
            System.out.println("2. Add a task at the end");
            System.out.println("3. Add a task at a specific position");
            System.out.println("4. Remove a task by Task ID");
            System.out.println("5. View current task and move to the next task");
            System.out.println("6. Display all tasks");
            System.out.println("7. Search for tasks by priority");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID: ");
                    int taskId1 = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Task Name: ");
                    String taskName1 = scanner.nextLine();
                    System.out.print("Enter Priority: ");
                    int priority1 = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Due Date: ");
                    String dueDate1 = scanner.nextLine();
                    taskScheduler.addAtBeginning(taskId1, taskName1, priority1, dueDate1);
                    break;

                case 2:
                    System.out.print("Enter Task ID: ");
                    int taskId2 = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Task Name: ");
                    String taskName2 = scanner.nextLine();
                    System.out.print("Enter Priority: ");
                    int priority2 = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Due Date: ");
                    String dueDate2 = scanner.nextLine();
                    taskScheduler.addAtEnd(taskId2, taskName2, priority2, dueDate2);
                    break;

                case 3:
                    System.out.print("Enter Task ID: ");
                    int taskId3 = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Task Name: ");
                    String taskName3 = scanner.nextLine();
                    System.out.print("Enter Priority: ");
                    int priority3 = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Due Date: ");
                    String dueDate3 = scanner.nextLine();
                    System.out.print("Enter Position: ");
                    int position = scanner.nextInt();
                    taskScheduler.addAtPosition(taskId3, taskName3, priority3, dueDate3, position);
                    break;

                case 4:
                    System.out.print("Enter Task ID to remove: ");
                    int taskId4 = scanner.nextInt();
                    taskScheduler.removeByTaskId(taskId4);
                    break;

                case 5:
                    taskScheduler.viewAndMoveToNextTask();
                    break;

                case 6:
                    taskScheduler.displayAllTasks();
                    break;

                case 7:
                    System.out.print("Enter Priority to search: ");
                    int priority7 = scanner.nextInt();
                    taskScheduler.searchByPriority(priority7);
                    break;

                case 8:
                    System.out.println("Exiting the program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);

        scanner.close();
    }
}