package Business.Discount;

/**
 *
 * @author neild
 */
public class ConditionTwo extends DiscountDecorator {

    ConditionTwo(final Discount discount) {
        super(discount);
    }

    @Override
    public double applyDiscount() {
        return super.applyDiscount() + 12.5;
    }

}
