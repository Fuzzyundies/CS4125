package Business.Discount;

/**
 *
 * @author neild
 */
public class FirstOrder extends DiscountDecorator {

    public FirstOrder(final Discount discount) {
        super(discount);
    }

    @Override
    public double applyDiscount() {
        return super.applyDiscount() + 7.5; //7.5 % discount for the first order
    }
}
