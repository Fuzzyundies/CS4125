package Business.Discount;

/**
 *
 * @author neild
 */
public class TwelveDiscount extends DiscountDecorator {

    public TwelveDiscount(final Discount discount) {
        super(discount);
    }

    @Override
    public double applyDiscount() {
        return super.applyDiscount() + 12.5;
    }
}
