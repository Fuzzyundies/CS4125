package Business.Discount;

/**
 *
 * @author neild
 */
public class TwelveOff extends DiscountDecorator {

    public TwelveOff(final Discount discount) {
        super(discount);
    }

    @Override
    public double applyDiscount() {
        return super.applyDiscount() + 12.5;
    }

}
