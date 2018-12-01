package Business.Product;

/**
 *
 * @author neild
 */
public class ProductIdle implements ProductState {

    @Override
    public void nextState(Product p) {
        p.setState(new ProductStored());
    }

    @Override
    public void previousState(Product p) {
        System.out.println("The product is available in the owners possession.");
    }

    @Override
    public String getProductStatus(Product p) {
        return p.getName() + " is currently idle.";
    }
}
