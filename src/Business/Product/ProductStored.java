package Business.Product;

/**
 *
 * @author neild
 */
public class ProductStored implements ProductState {

    @Override
    public void nextState(Product p) {
        p.setState(new ProductTaken());
    }

    @Override
    public void previousState(Product p) {
        p.setState(new ProductIdle());
    }

    @Override
    public String getProductStatus(Product p) {
        return p.getName() + " is currently stored in a warehouse locker.";
    }
}
