package discount;

import shop.ShoppingCartItem;

import java.math.BigDecimal;
import java.util.ArrayList;

public class TenPercentOfTotal implements Discount{


    @Override
    public BigDecimal getDiscount(ArrayList<ShoppingCartItem> cartItems) {
        var sum = BigDecimal.ZERO;

        for (var item : cartItems) {
            sum = item.itemCost().multiply(BigDecimal.valueOf(item.quantity())).add(sum);
        }
        if (sum.compareTo(BigDecimal.valueOf(999)) > 0) {
            sum = sum.multiply(BigDecimal.valueOf(0.9));
        }

        return sum;
    }
}
