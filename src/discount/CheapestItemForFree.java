package discount;

import shop.ShoppingCartItem;

import java.math.BigDecimal;
import java.util.ArrayList;

public class CheapestItemForFree implements Discount{


    @Override
    public BigDecimal getDiscount(ArrayList<ShoppingCartItem> cartItems) {
        var sum = BigDecimal.ZERO;
        int quantity = 0;
        var cheapestItem = cartItems.get(0).itemCost();

        for (var item: cartItems) {
            for (int i = 0; i < item.quantity(); i++) {
                quantity++;
                sum = item.itemCost().add(sum);

                if (item.itemCost().intValue() < cheapestItem.intValue()) {
                    cheapestItem = item.itemCost();
                }
            }
        }

        if (quantity > 9) {
            sum = sum.subtract(cheapestItem);
        }

        return sum;
    }
}
