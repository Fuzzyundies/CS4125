package Business.Discount;

/**
 *
 * @author neild
 */
public class MonthlyDiscount extends Discount {

    @Override
    public double applyDiscount() {
        return 5.0;  //5 % discount monthly
    }
}
