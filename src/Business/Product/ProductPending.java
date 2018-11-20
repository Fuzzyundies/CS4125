package Business.Product;

/**
 *
 * @author neild
 */
public class ProductPending implements ProductState {

    @Override
    public void nextState(Product p) {
        p.setState(new ProductTransit());
    }

    @Override
    public void previousState(Product p) {
        System.out.println("The product is in it's root state.");
    }

    @Override
    public String getProductStatus(Product p) {
        return p.getName()+ " is currently pending.";
    }
}
