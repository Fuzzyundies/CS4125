package Business.Product;

/**
 *
 * @author neild
 */
public class ProductStored implements ProductState {

    @Override
    public void nextState(Product p) {
        p.setState(new ProductReturned());
    }

    @Override
    public void previousState(Product p) {
        p.setState(new ProductTransit());
    }

    @Override
    public String getProductStatus(Product p) {
        return p.getName()+ " is currently stored in a warehouse locker.";
    }
}
