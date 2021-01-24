package discount;

import shop.ShoppingCartItem;

import java.math.BigDecimal;
import java.util.ArrayList;

public interface Discount {

    BigDecimal getDiscount(ArrayList<ShoppingCartItem> cartItems);
}
