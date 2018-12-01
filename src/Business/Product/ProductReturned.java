package Business.Product;

/**
 *
 * @author neild
 */
public class ProductReturned implements ProductState {

    @Override
    public void nextState(Product p) {
        System.out.println(new ProductIdle());
    }

    @Override
    public void previousState(Product p) {
        p.setState(new ProductTaken());
    }

    @Override
    public String getProductStatus(Product p) {
        return p.getName() + " is returned to its the warehouse.";
    }
}
