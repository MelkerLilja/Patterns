package shop;

import command.Command;
import command.CommandHistory;


import java.math.BigDecimal;

public class ShoppingCartItem {
    private CommandHistory commandHistory;
    private final BigDecimal itemCost;
    private final Product product;
    private int quantity;

    public ShoppingCartItem(Product product, double itemCost, int quantity, CommandHistory commandHistory) {
        this.commandHistory = commandHistory;
        this.itemCost = BigDecimal.valueOf(itemCost);
        this.product = product;
        this.quantity = quantity;
    }

    public void setQuantity(int newQuantity){
        int oldQuantity = quantity;

        Command undoCommand = new Command() {
            @Override
            public void execute() {
                quantity = oldQuantity;
            }

            @Override
            public void redo() {
                quantity = newQuantity;
            }
        };
        this.quantity = newQuantity;
        commandHistory.addToUndo(undoCommand);
    }

    public int quantity(){
        return quantity;
    }

    public Product product() {
        return product;
    }

    public BigDecimal itemCost() {
        return itemCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShoppingCartItem lineItem = (ShoppingCartItem) o;

        if (quantity != lineItem.quantity) return false;
        if (!itemCost.equals(lineItem.itemCost)) return false;
        return product.equals(lineItem.product);
    }

    @Override
    public int hashCode() {
        int result = itemCost.hashCode();
        result = 31 * result + product.hashCode();
        result = 31 * result + quantity;
        return result;
    }
}
