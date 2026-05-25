public interface InventoryOperations {
    void addItem(InventoryItem item);
    void readItems();
    void updateItem(String name, int newQuantity);
    void deleteItem(String name);
}
