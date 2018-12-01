package Business.Product;

/**
 *
 * @author neild
 */
public class ProductTaken implements ProductState {

    @Override
    public void nextState(Product p) {
        p.setState(new ProductReturned());
    }

    @Override
    public void previousState(Product p) {
        p.setState(new ProductStored());
    }

    @Override
    public String getProductStatus(Product p) {
        return p.getName() + " is currently in taken by the renter.";
    }
}
