package Business.Product;

/**
 *
 * @author neild
 */
public class ProductReturned implements ProductState {
    
    @Override
    public void nextState(Product p) {
        System.out.println(p.getName() + " is already safely returned to the owner.");
    }
    
    @Override
    public void previousState(Product p) {
        p.setState(new ProductStored());
    }
    
    @Override
    public String getProductStatus(Product p) {
        return p.getName() + " is returned to its owner: " + p.getOwner();
    }
}
