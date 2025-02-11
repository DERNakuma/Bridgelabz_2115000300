import java.util.Scanner;
class ItemNode {
    String itemName;
    int itemId;
    int quantity;
    double price;
    ItemNode next;
    public ItemNode(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class Inventory {
    private ItemNode head;
    public Inventory() {
        this.head = null;
    }

    public void addAtBeginning(String itemName, int itemId, int quantity, double price) {
        ItemNode newItem = new ItemNode(itemName, itemId, quantity, price);
        newItem.next = head;
        head = newItem;
        System.out.println("Item '" + itemName + "' added at the beginning.");
    }

   
    public void addAtEnd(String itemName, int itemId, int quantity, double price) {
        ItemNode newItem = new ItemNode(itemName, itemId, quantity, price);
        if (head == null) { 
            head = newItem;
        } else {
            ItemNode current = head;
            while (current.next != null) { 
                current = current.next;
            }
            current.next = newItem;
        }
        System.out.println("Item '" + itemName + "' added at the end.");
    }

   
    public void addAtPosition(String itemName, int itemId, int quantity, double price, int position) {
        if (position < 1) {
            System.out.println("Invalid position. Position must be >= 1.");
            return;
        }
        ItemNode newItem = new ItemNode(itemName, itemId, quantity, price);
        if (position == 1) { 
            newItem.next = head;
            head = newItem;
        } else {
            ItemNode current = head;
            for (int i = 1; i < position - 1; i++) { 
                if (current == null) {
                    System.out.println("Position out of range.");
                    return;
                }
                current = current.next;
            }
            newItem.next = current.next;
            current.next = newItem;
        }
        System.out.println("Item '" + itemName + "' added at position " + position + ".");
    }

   
    public void removeByItemId(int itemId) {
        if (head == null) {
            System.out.println("Inventory is empty. No item to delete.");
            return;
        }
        if (head.itemId == itemId) { 
            System.out.println("Item with ID " + itemId + " removed.");
            return;
        }
        ItemNode current = head;
        while (current.next != null) {
            if (current.next.itemId == itemId) {
                current.next = current.next.next;
                System.out.println("Item with ID " + itemId + " removed.");
                return;
            }
            current = current.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }


    public void updateQuantity(int itemId, int newQuantity) {
        ItemNode current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                current.quantity = newQuantity;
                System.out.println("Quantity updated for item with ID " + itemId + ". New Quantity: " + newQuantity);
                return;
            }
            current = current.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

   
    public void searchByItemId(int itemId) {
        ItemNode current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                System.out.println("Item found: ID: " + current.itemId + ", Name: " + current.itemName +
                        ", Quantity: " + current.quantity + ", Price: " + current.price);
                return;
            }
            current = current.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

  
    public void searchByItemName(String itemName) {
        ItemNode current = head;
        boolean found = false;
        while (current != null) {
            if (current.itemName.equalsIgnoreCase(itemName)) {
                System.out.println("Item found: ID: " + current.itemId + ", Name: " + current.itemName +
                        ", Quantity: " + current.quantity + ", Price: " + current.price);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("Item with name '" + itemName + "' not found.");
        }
    }

    
    public void calculateTotalValue() {
        double totalValue = 0;
        ItemNode current = head;
        while (current != null) {
            totalValue += current.quantity * current.price;
            current = current.next;
        }
        System.out.println("Total value of inventory: " + totalValue);
    }

   
    public void sortInventory(String sortBy, String order) {
        if (head == null || head.next == null) {
            System.out.println("Inventory is empty or has only one item. No sorting needed.");
            return;
        }
        head = mergeSort(head, sortBy, order);
        System.out.println("Inventory sorted by " + sortBy + " in " + order + " order.");
    }

 
    private ItemNode mergeSort(ItemNode head, String sortBy, String order) {
        if (head == null || head.next == null) {
            return head;
        }
    
        ItemNode middle = getMiddle(head);
        ItemNode nextOfMiddle = middle.next;
        middle.next = null;
      
        ItemNode left = mergeSort(head, sortBy, order);
        ItemNode right = mergeSort(nextOfMiddle, sortBy, order);
      
        return merge(left, right, sortBy, order);
    }

    
    private ItemNode getMiddle(ItemNode head) {
        if (head == null) {
            return head;
        }
        ItemNode slow = head;
        ItemNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    
    private ItemNode merge(ItemNode left, ItemNode right, String sortBy, String order) {
        ItemNode result = null;
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
       
        boolean condition;
        if (sortBy.equalsIgnoreCase("name")) {
            condition = (order.equalsIgnoreCase("asc")) ? left.itemName.compareTo(right.itemName) <= 0 : left.itemName.compareTo(right.itemName) >= 0;
        } else { 
            condition = (order.equalsIgnoreCase("asc")) ? left.price <= right.price : left.price >= right.price;
        }
        if (condition) {
            result = left;
            result.next = merge(left.next, right, sortBy, order);
        } else {
            result = right;
            result.next = merge(left, right.next, sortBy, order);
        }
        return result;
    }

    
    public void displayAllItems() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        ItemNode current = head;
        System.out.println("Inventory Items:");
        while (current != null) {
            System.out.println("ID: " + current.itemId + ", Name: " + current.itemName +
                    ", Quantity: " + current.quantity + ", Price: " + current.price);
            current = current.next;
        }
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();
        int choice;

        do {
          
            System.out.println("\n--- Inventory Management System ---");
            System.out.println("1. Add an item at the beginning");
            System.out.println("2. Add an item at the end");
            System.out.println("3. Add an item at a specific position");
            System.out.println("4. Remove an item by Item ID");
            System.out.println("5. Update the quantity of an item by Item ID");
            System.out.println("6. Search for an item by Item ID");
            System.out.println("7. Search for an item by Item Name");
            System.out.println("8. Calculate and display the total value of inventory");
            System.out.println("9. Sort the inventory by Item Name or Price");
            System.out.println("10. Display all items");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Item Name: ");
                    String itemName1 = scanner.nextLine();
                    System.out.print("Enter Item ID: ");
                    int itemId1 = scanner.nextInt();
                    System.out.print("Enter Quantity: ");
                    int quantity1 = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double price1 = scanner.nextDouble();
                    inventory.addAtBeginning(itemName1, itemId1, quantity1, price1);
                    break;

                case 2:
                    System.out.print("Enter Item Name: ");
                    String itemName2 = scanner.nextLine();
                    System.out.print("Enter Item ID: ");
                    int itemId2 = scanner.nextInt();
                    System.out.print("Enter Quantity: ");
                    int quantity2 = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double price2 = scanner.nextDouble();
                    inventory.addAtEnd(itemName2, itemId2, quantity2, price2);
                    break;

                case 3:
                    System.out.print("Enter Item Name: ");
                    String itemName3 = scanner.nextLine();
                    System.out.print("Enter Item ID: ");
                    int itemId3 = scanner.nextInt();
                    System.out.print("Enter Quantity: ");
                    int quantity3 = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double price3 = scanner.nextDouble();
                    System.out.print("Enter Position: ");
                    int position = scanner.nextInt();
                    inventory.addAtPosition(itemName3, itemId3, quantity3, price3, position);
                    break;

                case 4:
                    System.out.print("Enter Item ID to remove: ");
                    int itemId4 = scanner.nextInt();
                    inventory.removeByItemId(itemId4);
                    break;

                case 5:
                    System.out.print("Enter Item ID to update quantity: ");
                    int itemId5 = scanner.nextInt();
                    System.out.print("Enter New Quantity: ");
                    int newQuantity = scanner.nextInt();
                    inventory.updateQuantity(itemId5, newQuantity);
                    break;

                case 6:
                    System.out.print("Enter Item ID to search: ");
                    int itemId6 = scanner.nextInt();
                    inventory.searchByItemId(itemId6);
                    break;

                case 7:
                    System.out.print("Enter Item Name to search: ");
                    String itemName7 = scanner.nextLine();
                    inventory.searchByItemName(itemName7);
                    break;

                case 8:
                    inventory.calculateTotalValue();
                    break;

                case 9:
                    System.out.print("Sort by (name/price): ");
                    String sortBy = scanner.nextLine();
                    System.out.print("Order (asc/desc): ");
                    String order = scanner.nextLine();
                    inventory.sortInventory(sortBy, order);
                    break;

                case 10:
                    inventory.displayAllItems();
                    break;

                case 11:
                    System.out.println("Exiting the program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 11);

        scanner.close();
    }
}