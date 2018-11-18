package Business.Discount;

/**
 *
 * @author neild
 */
public class ThirtyOff extends DiscountDecorator {

    public ThirtyOff(final Discount discount) {
        super(discount);
    }

    @Override
    public double applyDiscount() {
        return super.applyDiscount() + 30.0; //30.0 % discount
    }
}
