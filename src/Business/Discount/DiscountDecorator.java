package Business.Discount;

/**
 *
 * @author neild
 */
public class DiscountDecorator extends Discount {

    /*
    – Condition 1: 7.5% off for the first order
    – Condition 2: 12.5% off for order €200 or more
    – Condition 3: 30% off for first order and order €200 or more
     */
    private final Discount discount;

    public DiscountDecorator(final Discount discount) {
        this.discount = discount;
    }

    @Override
    public double applyDiscount() {
        return discount.applyDiscount();
    }
}
