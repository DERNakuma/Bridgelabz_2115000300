class AreaCircle {  
    private double radius;  

    public AreaCircle(double radius) {  
        this.radius = radius;  
    }  

    public double calculateArea() {  
        return Math.PI * radius * radius;  
    }  

    public double calculateCircumference() {  
        return 2 * Math.PI * radius;  
    }  

    public void displayDetails() {  
        System.out.println("Radius: " + radius);  
        System.out.println("Area: " + calculateArea());  
        System.out.println("Circumference: " + calculateCircumference());  
    }  

    public static void main(String[] args) {  
        AreaCircle c = new AreaCircle(5);  
        c.displayDetails();  
    }  
}
