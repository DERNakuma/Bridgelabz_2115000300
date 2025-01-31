class Book {  
    private String title;  
    private String author;  
    private double price;  

    public Book(String title, String author, double price) {  
        this.title = title;  
        this.author = author;  
        this.price = price;  
    }  

    public void displayDetails() {  
        System.out.println("Title: " + title);  
        System.out.println("Author: " + author);  
        System.out.println("Price: " + price);  
    }  

    public static void main(String[] args) {  
        Book b = new Book("The Alchemist", "Paulo Coelho", 399);  
        b.displayDetails();  
    }  
}
