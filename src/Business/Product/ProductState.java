package Business.Product;

/**
 *
 * @author neild
 */
public interface ProductState {
    void nextState();
    void previousState();
    String getProductStatus();
}
