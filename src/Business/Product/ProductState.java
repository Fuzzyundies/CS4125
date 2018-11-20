package Business.Product;

/**
 *
 * @author neild
 */
public interface ProductState {

    void nextState(Product p);

    void previousState(Product p);

    String getProductStatus(Product p);
}
