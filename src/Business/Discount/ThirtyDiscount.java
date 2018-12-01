package Business.Discount;

/**
 *
 * @author neild
 */
public class ThirtyDiscount extends DiscountDecorator {

    public ThirtyDiscount(final Discount discount) {
        super(discount);
    }

    @Override
    public double applyDiscount() {
        return super.applyDiscount() + 30.0; //30.0 % discount
    }
}
