package discount;

import shop.ShoppingCartItem;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ThreeItemsForPriceOfTwo implements Discount{

    @Override
    public BigDecimal getDiscount(ArrayList<ShoppingCartItem> cartItems) {
        var sum = BigDecimal.ZERO;

        for (var item: cartItems) {
            if (item.quantity() > 2) {
                sum = item.itemCost().multiply(BigDecimal.valueOf(item.quantity())).add(sum).subtract(item.itemCost());
            } else {
                sum = item.itemCost().multiply(BigDecimal.valueOf(item.quantity())).add(sum);
            }
        }
        return sum;

    }
}
