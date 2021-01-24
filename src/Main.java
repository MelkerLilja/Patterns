import command.CommandHistory;
import shop.Product;
import shop.ShoppingCart;
import shop.ShoppingCartItem;
import discount.*;

public class Main {
    public static void main(String[] args) {
        CommandHistory history = new CommandHistory();
        ShoppingCart shoppingCart = new ShoppingCart(history);

        shoppingCart.addDiscount(new TenPercentOfTotal());
        shoppingCart.addDiscount(new ThreeItemsForPriceOfTwo());
        shoppingCart.addDiscount(new CheapestItemForFree());

        ShoppingCartItem item1 = new ShoppingCartItem(new Product("TV"), 100, 3, history);
  /*      ShoppingCartItem item2 = new ShoppingCartItem(new Product("Livboj"), 100, 1, history);
        ShoppingCartItem item3 = new ShoppingCartItem(new Product("Bok"), 100, 1, history);
        ShoppingCartItem item4 = new ShoppingCartItem(new Product("Diskmaskin"), 100, 1, history);
        ShoppingCartItem item5 = new ShoppingCartItem(new Product("Kläder"), 100, 1, history);
        ShoppingCartItem item6 = new ShoppingCartItem(new Product("Hjul"), 100, 1, history);
        ShoppingCartItem item7 = new ShoppingCartItem(new Product("Grus"), 100, 1, history);
        ShoppingCartItem item8 = new ShoppingCartItem(new Product("Mössa"), 100, 1, history);
        ShoppingCartItem item9 = new ShoppingCartItem(new Product("Netflix"), 100, 1, history);
        ShoppingCartItem item10 = new ShoppingCartItem(new Product("Smartphone"), 100, 1, history);*/



        shoppingCart.addCartItem(item1);
/*        shoppingCart.addCartItem(item2);
        shoppingCart.addCartItem(item3);
        shoppingCart.addCartItem(item4);
        shoppingCart.addCartItem(item5);
        shoppingCart.addCartItem(item6);
        shoppingCart.addCartItem(item7);
        shoppingCart.addCartItem(item8);
        shoppingCart.addCartItem(item9);
        shoppingCart.addCartItem(item10);*/


        System.out.println(shoppingCart.receipt());
    }
}
