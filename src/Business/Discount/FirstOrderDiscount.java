package Business.Discount;

/**
 *
 * @author neild
 */
public class FirstOrderDiscount extends DiscountDecorator {

    public FirstOrderDiscount(final Discount discount) {
        super(discount);
    }

    @Override
    public double applyDiscount() {
        return super.applyDiscount() + 7.5; //7.5 % discount for the first order
    }
}
