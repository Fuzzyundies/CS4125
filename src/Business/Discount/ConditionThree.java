package Business.Discount;

/**
 *
 * @author neild
 */
public class ConditionThree extends DiscountDecorator {

    ConditionThree(final Discount discount) {
        super(discount);
    }

    @Override
    public double applyDiscount() {
        return super.applyDiscount() + 30.0; //30.0 % discount
    }
}
