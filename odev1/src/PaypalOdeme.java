public class PaypalOdeme implements PaymentMethod {

    @Override
    public boolean pay(double amount) {
        System.out.println("Paypal ile ödeme alındı: " + amount + " TL");
        return true;
    }
}