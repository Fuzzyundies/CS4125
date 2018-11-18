package Business.Discount;

/**
 *
 * @author neild
 */
public class YearlyDiscount extends Discount {

    @Override
    public double applyDiscount() {
        return 15.0;  //15 % discount yearly
    }
}
