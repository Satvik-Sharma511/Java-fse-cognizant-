import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 2. Setup: Create some dummy products
        Product p1 = new Product("P005", "Wireless Mouse", "Electronics");
        Product p2 = new Product("P001", "Gaming Laptop", "Computers");
        Product p3 = new Product("P004", "Office Chair", "Furniture");
        Product p4 = new Product("P002", "Mechanical Keyboard", "Accessories");
        Product p5 = new Product("P003", "Noise Cancelling Headphones", "Audio");

        // 3. Implementation: Store products in an array for linear search
        Product[] productsForLinearSearch = {p1, p2, p3, p4, p5};

        // 3. Implementation: Store products in a sorted array for binary search
        Product[] productsForBinarySearch = {p1, p2, p3, p4, p5};
        Arrays.sort(productsForBinarySearch); // Sorting by productId using Comparable

        String targetProductId = "P003";

        System.out.println("E-Commerce Product Search Demonstration\n");
        
        // Linear Search Test
        System.out.println("--- Linear Search ---");
        System.out.println("Searching for Product ID: " + targetProductId);
        Product linearResult = SearchAlgorithms.linearSearch(productsForLinearSearch, targetProductId);
        if (linearResult != null) {
            System.out.println("Found: " + linearResult);
        } else {
            System.out.println("Product not found.");
        }

        System.out.println("\n--- Binary Search ---");
        System.out.println("Searching for Product ID: " + targetProductId + " in sorted array");
        Product binaryResult = SearchAlgorithms.binarySearch(productsForBinarySearch, targetProductId);
        if (binaryResult != null) {
            System.out.println("Found: " + binaryResult);
        } else {
            System.out.println("Product not found.");
        }
    }
}
