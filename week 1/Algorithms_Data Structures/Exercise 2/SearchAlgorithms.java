public class SearchAlgorithms {

    /**
     * Linear Search Algorithm
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static Product linearSearch(Product[] products, String targetId) {
        for (Product product : products) {
            if (product.getProductId().equals(targetId)) {
                return product; // Best case: O(1) if found on first iteration
            }
        }
        return null; // Product not found, Worst case: O(n)
    }

    /**
     * Binary Search Algorithm
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * PRE-CONDITION: The products array must be sorted by productId
     */
    public static Product binarySearch(Product[] products, String targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductId().compareTo(targetId);

            if (comparison == 0) {
                return products[mid]; // Target found
            } else if (comparison < 0) {
                left = mid + 1; // Target is in the right half
            } else {
                right = mid - 1; // Target is in the left half
            }
        }
        return null; // Product not found
    }
}
